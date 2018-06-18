package br.senac.pedidovenda.model;

import br.senac.componentes.db.ConexaoDB;
import br.senac.grupoproduto.model.BaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;


public class PedidoVendaDAO implements BaseDAO<PedidoVenda, Long> {

    
    public static void main(String[] args) throws SQLException {
        PedidoVendaDAO dao = new PedidoVendaDAO();
        PedidoVenda pedidoVenda = new PedidoVenda();
        pedidoVenda.setDtPedido(new Date());
        pedidoVenda.setFormaPagamento(FormaPagamento.CARTAO_CREDITO);
        pedidoVenda.setIdPessoa(638L);
        pedidoVenda.setFreteGratis(true);
        pedidoVenda.setTelemarketing(true);
        pedidoVenda.setObservacoes("fdssfrsd");
        pedidoVenda.setTipoPedidoVenda(TipoPedidoVenda.PEDIDO);
        pedidoVenda.setVlTotal(0.0);

       

        Long id = dao.inserir(pedidoVenda);
        System.out.println(dao.getNomeCliente(id));
        pedidoVenda.setTipoPedidoVenda(TipoPedidoVenda.ORCAMENTO);
        dao.alterar(pedidoVenda);
        //dao.excluir(id);
    }
    
    

    @Override
    public PedidoVenda getPorId(Long idPedido) throws SQLException {
        String sql = "Select * from pedido where idpedido = " + idPedido;

        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        if (rs.next() == false) {
            throw new RuntimeException("Pedido de venda não encontrado: " + idPedido + ".");
        }
        System.out.println(rs);
        PedidoVenda pedidoVenda = getPedidoVenda(rs);
        return pedidoVenda;
    }

    /* Utilize PreparedStatement */
    @Override
    public Long inserir(PedidoVenda pedidoVenda) throws SQLException {
        String sql = "select * from Pedido where IdPedido is null";
        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stm.executeQuery(sql);
        rs.moveToInsertRow();
        rs.updateObject("dtPedido", pedidoVenda.getDtPedido());
        rs.updateObject("tipo", pedidoVenda.getTipoPedidoVenda().getId());
        rs.updateObject("vlFrete", pedidoVenda.getVlFrete());
        rs.updateObject("telemarketing", pedidoVenda.getTelemarketing());
        rs.updateObject("freteGratis", pedidoVenda.getFreteGratis());
        rs.updateObject("idFormaPagto", pedidoVenda.getFormaPagamento().getId());
        rs.updateObject("observacoes", pedidoVenda.getObservacoes());
        rs.updateObject("idPessoa", pedidoVenda.getIdPessoa());
        rs.insertRow();
        rs.last();
        Long id = rs.getLong(1);
        pedidoVenda.setIdPedido(id);
        return id;
    }

    @Override
    public boolean excluir(Long idPedido) throws SQLException {
        Connection conn = ConexaoDB.getInstance().getConnection();
        try {
            conn.setAutoCommit(false); //Inicia transação
            String sql = "delete from pedido where idpedido = ? ";

            /*Primeiro exclui os itens para depois excluir os pedidos
            List<ItemPedidoVenda> listaItens = itemPedVendaDAO.getItensPorPedido(idPedido);
            if(listaItens != null){
                for(ItemPedidoVenda item : listaItens){
                    itemPedVendaDAO.excluir(item.getIdItemPedido());
                }
            }*/
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, idPedido);

            int nuPedExcluidos = pstm.executeUpdate();
            if (nuPedExcluidos == 0) {
                return false;
            }

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.setAutoCommit(true);

            throw new RuntimeException("Erro ao excluir pedido de venda: " + e.getMessage() + ".", e);
        }
        return true;
    }

    /* Concluir utilizando Statement. Se tiver um ItemPedido novo, inclua o mesmo.
     Utilize transação*/
    @Override
    public boolean alterar(PedidoVenda pedidoVenda) throws SQLException {
        if (pedidoVenda == null || pedidoVenda.getIdPedido() == null) {
            throw new RuntimeException("Pedido de venda com idPedido igual a nulo.");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (pedidoVenda.getDtPedido() == null) {
            pedidoVenda.setDtPedido(new Date());
        }

        String sql = "update pedido set "
                + "dtPedido = {d '" + sdf.format(pedidoVenda.getDtPedido()) + "'}, "
                + "tipo = " + pedidoVenda.getTipoPedidoVenda().getId() + ", "
                + "vlFrete = " + pedidoVenda.getVlFrete() + ", "
                + "telemarketing = " + pedidoVenda.getTelemarketing() + ", "
                + "fretegratis = " + pedidoVenda.getFreteGratis() + ", "
                + "idformapagto = " + (pedidoVenda.getFormaPagamento() == null ? "null" : pedidoVenda.getFormaPagamento().getId()) + ", "
                + "observacoes = " + (pedidoVenda.getObservacoes() == null ? "null" : "'" + pedidoVenda.getObservacoes() + "'") + ", "
                + "idPessoa = " + pedidoVenda.getIdPessoa() + " "
                + "Where idPedido = " + pedidoVenda.getIdPedido();
        System.out.println(sql);
        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();
        int regAlterados = stm.executeUpdate(sql);
        return (regAlterados == 1);
    }

    private PedidoVenda getPedidoVenda(ResultSet rs) throws SQLException {
        PedidoVenda pedidoVenda = new PedidoVenda();
        Long idPedido = rs.getLong("idpedido");

        pedidoVenda.setIdPedido(idPedido);
        pedidoVenda.setDtPedido(rs.getDate("dtpedido"));
        pedidoVenda.setTipoPedidoVenda(TipoPedidoVenda.getPorId(rs.getInt("tipo")));
        if (rs.getObject("vlfrete") != null) {
            pedidoVenda.setVlFrete(rs.getDouble("vlFrete"));
        }
        if (rs.getObject("telemarketing") != null) {
            pedidoVenda.setTelemarketing((rs.getInt("telemarketing") == 1 ? true : false));
        }
        if (rs.getObject("freteGratis") != null) {
            pedidoVenda.setFreteGratis((rs.getInt("freteGratis") == 1 ? true : false));
        }
        if (rs.getObject("idformapagto") != null) {
            pedidoVenda.setFormaPagamento(FormaPagamento.getPorId(rs.getInt("idformapagto")));
        }
        pedidoVenda.setObservacoes(rs.getString("observacoes"));
        pedidoVenda.setIdPessoa(rs.getLong("idpessoa"));

        

        return pedidoVenda;
    }
    
    public String getNomeCliente(Long idPedido){
        
        String sql = "SELECT pes.nomePessoa FROM pedido ped\n" +
                     "inner join pessoa pes on pes.idPessoa = ped.idPessoa\n" +
                     "where ped.idPedido = " + idPedido;
        Connection conn = ConexaoDB.getInstance().getConnection();
        try{
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if(rs.next()){
                return rs.getString("nomePessoa");
            }
        }catch(Exception e){
            throw new RuntimeException("Erro ao buscar nome cliente " + e.getMessage());
        }   
         throw new RuntimeException("Id do cliente inválido " + idPedido+ " ao buscar nome cliente.");
    }

}