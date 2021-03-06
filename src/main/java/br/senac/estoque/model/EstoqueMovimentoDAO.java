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
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        EstoqueMovimentoDAO estoqueDao = new EstoqueMovimentoDAO();
        EstoqueMovimento estoque = new EstoqueMovimento();

        Produto mercadoria = new Mercadoria();
        Date date = new Date();
        estoque.setIdMovtoEstoque(6L);
        estoque.setProduto(mercadoria);
        estoque.setQuantidade(33.0);
        estoque.setTipoMovto(TipoMovimentoEstoque.SAIDA);
        estoque.setDataMovto(new Date());
        mercadoria.setIdProduto(10L);
        estoque.setIdUsuario(6);
        estoque.setProduto(mercadoria);
        estoque.setObservacoes("Vai dar certo pelo amor!!!!");

        Long id = estoqueDao.inserir(estoque);
        estoque.setTipoMovto(TipoMovimentoEstoque.ENTRADA);
        //estoque.setIdMovtoEstoque(id);
        //estoqueDao.alterar(estoque);
        //estoqueDao.excluir(10L);
        //for (EstoqueMovimento estoq : estoqueDao.listarPorProduto(9L, date)) {
         //   System.out.println("O id movimento é:"+estoq.getIdMovtoEstoque());
        //}
        
        

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

            ps.setLong(1, idProduto);
            ps.setDouble(2, quantidade);

            int regAlterados = ps.executeUpdate();

        } else {
            double saldo = rs.getDouble("saldo");
            if (saldo >= 0) {
                String sqlAdd = "UPDATE `projeto`.`estoquesaldo` SET"
                        + "`saldo` = ?"
                        + "WHERE `idProduto` = ?;";

                Connection conn = ConexaoDB.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlAdd);

                ps.setDouble(1, (quantidade + saldo));
                ps.setLong(2, idProduto);
                ps.executeUpdate();
            } else {
                String sqlSub = "UPDATE `projeto`.`estoquesaldo` SET"
                        + "`saldo` = " + (quantidade - saldo) + ""
                        + "WHERE `idProduto` = " + idProduto + ";";

                Connection conn = ConexaoDB.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlSub);

                ps.setObject(1, (quantidade + saldo));
                ps.setObject(2, idProduto);
                ps.executeUpdate();
            }
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
     * @return
     * @throws java.sql.SQLException
     */
    @Override
    public Long inserir(EstoqueMovimento movtoEstoque) throws SQLException {
        //Produto prod = new Mercadoria();
        //prod.setIdProduto(7L);

        String sql = "INSERT INTO `projeto`.`estoquemovto`"
                + "(`quantidade`, `tipoMovto`,"
                + "`dataMovto`, `idProduto`, `idUsuario`, `observacoes`) "
                + "VALUES (?,?,?,?,?,?);";
        Connection conn = ConexaoDB.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setDouble(1, movtoEstoque.getQuantidade());
        ps.setString(2, movtoEstoque.getTipoMovto().getCodigo().toString());
        ps.setTimestamp(3, new java.sql.Timestamp(movtoEstoque.getDataMovto().getTime()));
        ps.setLong(4, movtoEstoque.getProduto().getIdProduto());
        ps.setInt(5, movtoEstoque.getIdUsuario());
        ps.setString(6, movtoEstoque.getObservacoes());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        Long idChave;
        if (!rs.next()) {
            throw new UnsupportedOperationException("Erro ao tentar inserir um novo registro");
        }
//        atualizarSaldoEstoque(movtoEstoque.getProduto().getIdProduto(), movtoEstoque.getQuantidade());
        return rs.getLong(1);

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
     * @throws java.sql.SQLException
     */
    @Override
    public boolean excluir(Long idMovtoEstoque) throws SQLException {

        String sql = "DELETE FROM estoquemovto WHERE idMovtoEstoque =" + idMovtoEstoque;
        Connection conn = ConexaoDB.getInstance().getConnection();
        try {
            Statement stm = conn.createStatement();
            int regAfetados = stm.executeUpdate(sql);

            if (regAfetados != 1) {
                return false;
            }
            conn.commit();

        } catch (SQLException e) {
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

        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Connection conn = ConexaoDB.getInstance().getConnection();
        String sql = "UPDATE estoquemovto SET quantidade = ? , tipoMovto = ? ,dataMovto = ? , idProduto = ?, idUsuario = ?, observacoes = ? WHERE idMovtoEstoque = ?";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setDouble(1, movtoEstoque.getQuantidade());
        ps.setString(2, movtoEstoque.getTipoMovto().getCodigo().toString());
        ps.setTimestamp(3, new java.sql.Timestamp(movtoEstoque.getDataMovto().getTime()));
        ps.setLong(4, movtoEstoque.getProduto().getIdProduto());
        ps.setLong(5, movtoEstoque.getIdUsuario());
        ps.setString(6, movtoEstoque.getObservacoes());
        ps.setLong(7, movtoEstoque.getIdMovtoEstoque());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return true;
        }
        return false;

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
     * @param dataInicioMovto
     * @return
     * @throws java.sql.SQLException
     */
    public List<EstoqueMovimento> listarPorProduto(Long idProduto, Date dataInicioMovto) throws SQLException {

      ArrayList<EstoqueMovimento> estoque = new ArrayList<>();;
        Connection conn = ConexaoDB.getInstance().getConnection();
        String sql = "SELECT * FROM estoquemovto WHERE idProduto = ? AND dataMovto >= ? ";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setLong(1, idProduto);
        stm.setDate(2, new java.sql.Date(dataInicioMovto.getTime()));
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            estoque.add(getEstoqueMovimento(rs));
        }
        return estoque;

    }

}
