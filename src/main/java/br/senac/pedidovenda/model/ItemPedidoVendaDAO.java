package br.senac.pedidovenda.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import br.senac.componentes.db.ConexaoDB;
import br.senac.grupoproduto.model.BaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;


public class ItemPedidoVendaDAO implements BaseDAO<ItemPedidoVenda, Long>{

    /* Utilize Statement ou PreparedStatement */
    @Override
    public ItemPedidoVenda getPorId(Long idItemPedido) throws SQLException {
        throw new UnsupportedOperationException("Ainda não implementado.");
    }

    /** Utilize PreparedStatement */
    @Override
    public Long inserir(ItemPedidoVenda item) throws SQLException {
        String sql = "insert into itempedido (quantidade, valor, valortotal, idproduto, idpedido) "+
                     "values (?,?,?,?,?)";
        Connection conn = ConexaoDB.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
        //Atribua os cinco campos para inserção do itempedido
        
        pstm.executeUpdate();
        
        ResultSet rsPK = pstm.getGeneratedKeys();
        if(rsPK.next()){
            return rsPK.getLong(1); //Retorma a chave primária gerada pelo BD
        }
        throw new SQLException("Erro inesperado, item não incluído no pedido");
    }

    /* Utilize Statement ou PreparedStatement*/
    @Override
    public boolean excluir(Long idItemPedido) throws SQLException {
        throw new UnsupportedOperationException("Ainda não implementado.");         
    }

    /* Utilize Statement */
    @Override
    public boolean alterar(ItemPedidoVenda item) throws SQLException {
        throw new UnsupportedOperationException("Ainda não implementado.");         
    }
    
    
    public List<ItemPedidoVenda> getItensPorPedido(Long idPedido) throws SQLException {
        String sql = "Select * From itempedido Where idpedido = " + idPedido;
        
        /*Ao invés de criar uma variável para cada objeto (Statement e Connection), 
        estou encadeando as chamadas de métodos.*/
        Connection conn = ConexaoDB.getInstance().getConnection();
        ResultSet rs = conn.createStatement().executeQuery(sql);
        List<ItemPedidoVenda> listaItens = new ArrayList<>();
        while(rs.next()){
            listaItens.add(getItemPedidoVenda(rs));
        }
        return listaItens;
    }
    
    /* Converter o ResultSet num objeto do tipo ItemPedidoVenda */
    private ItemPedidoVenda getItemPedidoVenda(ResultSet rs){
        throw new UnsupportedOperationException("Ainda não implementado.");         
    }
}