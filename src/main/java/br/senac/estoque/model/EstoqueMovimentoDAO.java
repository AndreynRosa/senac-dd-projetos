/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.estoque.model;

import br.senac.componentes.db.ConexaoDB;
import br.senac.componentes.db.UtilSQL;
import static br.senac.componentes.db.UtilSQL.executarQuery;
import br.senac.grupoproduto.model.BaseDAO;
import br.senac.produto.model.GrupoProduto;
import br.senac.produto.model.Mercadoria;
import br.senac.produto.model.Produto;
import br.senac.produto.model.TipoProduto;
import com.mysql.fabric.xmlrpc.base.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author andre
 */
public class EstoqueMovimentoDAO implements BaseDAO<EstoqueMovimento, Long> {
    
    public static void main(String[] args) throws SQLException {
        EstoqueMovimentoDAO estoqueMovimentodao = new EstoqueMovimentoDAO();
        Produto produto = new Mercadoria();
        GrupoProduto grupoProd = new GrupoProduto();
        
        grupoProd.setIdGrupoProduto(1);
        //produto.setNomeProduto("Feijao");
        produto.setDataCriacao(new Date());
        produto.setPerclICMS(3.5f);
        produto.setTipoPruduto(TipoProduto.MERCADORIA);
        produto.setGrupoProduto(grupoProd);
        //Long id = estoqueMovimentodao.inserir(produto);
      }
        
    /**
     * A partir de um ResultSet passado como parâmetro, cujo cursor está
     * posicionado em alguma linha da tabela estoquemovto, faça o DataBinding
     * dos dados do ResultSet para um objeto do tipo EstoqueMovimento.
     *
     * @param rs
     */
    private EstoqueMovimento getEstoqueMovimento(ResultSet rs) throws SQLException {
        EstoqueMovimento estoqueMovimento = new EstoqueMovimento();
        Long idEstoqueMovimento = rs.getLong("idMovtoEstoque");

        estoqueMovimento.setIdMovtoEstoque(idEstoqueMovimento);
        estoqueMovimento.setQuantidade(rs.getDouble("quantidade"));
        estoqueMovimento.setTipoMovto(TipoMovimentoEstoque.getTipoPorCodigo(rs.getString("tipoMovto")));
        estoqueMovimento.setDataMovto(rs.getDate("dataMovto"));
        //estoqueMovimento.setProduto(rs.getInt("idProduto"));
        estoqueMovimento.setIdUsuario(rs.getInt("idUsuario"));
        estoqueMovimento.setObservacoes(rs.getString("observacoes"));

        return estoqueMovimento;

    }

    /**
     * A partir do idMovtoEstoque, utilizando Statement ou PreparedStatement,
     * retorne o objeto do tipo EstoqueMovimento. Utilize o método
     * getEstoqueMovimento para fazer o DataBinding.
     *
     * @param idMovtoEstoque
     */
    @Override
    public EstoqueMovimento getPorId(Long idMovtoEstoque) throws SQLException {

        String sql = "SELECT * FROM estoquemovto where idMovtoEstoque = " + idMovtoEstoque;
        ResultSet rs = UtilSQL.executarQuery(sql);

        if (!rs.next()) {
            throw new UnsupportedOperationException("Não Erro ao consultar o produto");
        }
        return getEstoqueMovimento(rs);
    }

    /**
     * Utilizando Statement ou PreparedStatement atualize o Saldo de Estoque. Se
     * o produto não existir na tabela estoquesaldo, é necessário incluir um
     * registro na tabela estoquesaldo desse mesmo produto. Se o produto existir
     * na tabela estoquesaldo, é necessário apenas somar a quantidade (se o
     * parâmetro "quantidade" tiver valor positivo, vai aumentar a quantidade no
     * estoque, se for negativo, vai diminuir a quantidade no estoque).
     *
     * @param idMovtoEstoque
     */
    private void atualizarSaldoEstoque(Long idProduto, Double quantidade) throws SQLException {
        EstoqueMovimento estoqueMovimento = new EstoqueMovimento();
                
        String sql = "select * from estoquemovto where idProduto = " + idProduto;
        ResultSet rs = UtilSQL.executarQuery(sql);

        if (!rs.next()) {
            String sqlInsert = "INSERT INTO `projeto`.`estoquesaldo`\n"
                    + "(`idProduto` ,\n"
                    + "`saldo`)\n"
                    + "VALUES\n"
                    + "(?,\n"
                    + "?);";

            Connection conn = ConexaoDB.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setObject(1, estoqueMovimento.getProduto().getIdProduto());
            ps.setObject(2, estoqueMovimento.getQuantidade());
        }

    }

    /**
     * Utilize PreparedStatement. Após inserir (INSERT) um registro na tabela
     * estoquemovto, atualize também a tabela estoquesaldo através do método
     * atualizarSaldoEstoque. Utilize transação, pois iremos atualizar dois
     * registros de tabelas diferentes, caso ocorra qualquer exceção, faça o
     * rollback. Todos os campos são obrigatórios, com exceção dos campos
     * idUsuario e observacoes que podem ou não ser nulos (null).
     *
     * @param movtoEstoque
     */
    @Override
    public Long inserir(EstoqueMovimento movtoEstoque) throws SQLException {
        EstoqueMovimento estoqueMovimento = new EstoqueMovimento();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "INSERT INTO `projeto`.`estoquemovto`\n"
                + "(`idMovtoEstoque`,\n"
                + "`quantidade`,\n"
                + "`tipoMovto`,\n"
                + "`dataMovto`,\n"
                + "`idProduto`,\n"
                + "`idUsuario`,\n"
                + "`observacoes`)\n"
                + "VALUES\n"
                + "(?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?);";
        Connection conn = ConexaoDB.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setDouble(1, estoqueMovimento.getQuantidade());
        ps.setObject(2, estoqueMovimento.getTipoMovto());
        ps.setTimestamp(3, new java.sql.Timestamp(estoqueMovimento.getDataMovto().getTime()));
        ps.setObject(4, estoqueMovimento.getProduto().getIdProduto());
        ps.setObject(5, estoqueMovimento.getIdUsuario());
        ps.setObject(6, estoqueMovimento.getObservacoes());

        ps.executeUpdate();

        ResultSet rsChaveGerada = ps.getGeneratedKeys();
        Long idChave;
        if (rsChaveGerada.next()) {
            idChave = rsChaveGerada.getLong(1);
        } else {
            throw new UnsupportedOperationException("Erro ao tentar inserir um novo registro");
        }
//Primeira linha
        return rsChaveGerada.getLong(1);

    }

    /**
     * Utilize PreparedStatement. Será necessário buscar a quantidade do
     * movimento que está sendo excluído, depois atualizar o estoquesaldo
     * através do método atualizarSaldoEstoque, por último, faça a exclusão
     * (DELETE) do registro em estoquemovto conforme idMovtoEstoque passado.
     * Transacione essa operação, caso ocorra alguma exceção, faça rollback.
     *
     * @param idMovtoEstoque
     * @return
     */
    @Override
    public boolean excluir(Long idMovtoEstoque) throws SQLException {

        String sql = "DELETE FROM estoquemovto WHERE idMovtoEstoque =" + idMovtoEstoque;
        Connection conn = ConexaoDB.getInstance().getConnection();
        try {
            Statement stm = conn.createStatement();
            int regAfetados = stm.executeUpdate(sql);
            return (regAfetados == 1);
        } catch (Exception e) {
            conn.rollback();
            conn.setAutoCommit(true);
        }
        return true;

    }

    /**
     * Utilize Statement. Será necessário buscar a quantidade do movimento que
     * está sendo alterado, caso a quantidade que está no banco de dados for
     * diferente da quantidade passada no atributo movtoEstoque.getQuantidade(),
     * é necessário atualizar a tabela estoquesaldo através do método
     * atualizarSaldoEstoque. Após atualização do saldo, alterar (UPDATE) o
     * registro na tabela estoquemovto. Utilize transação, se qualquer exceção
     * ocorrer, faça o rollback. Todos os campos são obrigatórios, com exceção
     * dos campos idUsuario e observacoes que podem ou não ser nulos (null).
     *
     * @param movtoEstoque
     * @return
     * @throws java.sql.SQLException
     */
    @Override
    public boolean alterar(EstoqueMovimento movtoEstoque) throws SQLException {
        EstoqueMovimento estoqueMovimento = new EstoqueMovimento();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "UPDATE `projeto`.`estoquemovto` "
                + "SET"
                + "`quantidade` = " + estoqueMovimento.getQuantidade() + ","
                + "`tipoMovto` = '" + estoqueMovimento.getTipoMovto() + "',"
                + "`dataMovto` =" + dateFormat.format(estoqueMovimento.getDataMovto()) + ","
                + "`idProduto` =" + estoqueMovimento.getProduto().getIdProduto() + ","
                + "`idUsuario` =" + estoqueMovimento.getIdUsuario() + ","
                + "`observacoes` =" + estoqueMovimento.getObservacoes() + " "
                + "WHERE `idMovtoEstoque` =" + estoqueMovimento.getIdMovtoEstoque() + ";";

        System.out.println(sql);
        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();
        int regAlterados = stm.executeUpdate(sql);

        return (regAlterados == 1);

    }

    /**
     * Utilizando Statement ou PreparedStatement, a partir do idProduto
     * informado e dataInicioMovto (considere como DATE apenas), retorne a lista
     * de objetos do tipo EstoqueMovimento. Utilize a função getEstoqueMovimento
     * para fazer o DataBinding dos dados de cada uma das linhas do ResultSet
     * para o objeto EstoqueMovimento. Retorne apenas os registro cujo dataMovto
     * seja maior ou igual a dataInicioMovto.
     *
     * @param idProduto
     */
    public List<EstoqueMovimento> listarPorProduto(Long idProduto, Date dataInicioMovto) throws SQLException {
        EstoqueMovimento estoqueMovimento = new EstoqueMovimento();

        List<EstoqueMovimento> lista = new ArrayList<>();
        String sql = "select * from estoquemovto where idMovtoEstoque =" + idProduto + "and dataMovto  <=" + dataInicioMovto + ";";

        ResultSet rs = UtilSQL.executarQuery(sql);
        while (rs.next()) {
            estoqueMovimento = getEstoqueMovimento(rs);
            lista.add(estoqueMovimento);
        }
        return lista;
    }

}
