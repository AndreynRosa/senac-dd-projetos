/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.carro.model;

import br.senac.componentes.db.ConexaoDB;
import br.senac.grupoproduto.model.BaseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class CarroDAO implements BaseDAO<Carro, Integer> {

    public static void main(String[] args) {

    }

    @Override
    public Carro getPorId(Integer id) throws SQLException {

        String sql = "select * from carro where idcarro = " + id;
        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            return getCarro(rs);
        }
        return null;
    }

    public Carro getCarro(ResultSet rs) throws SQLException {
        Carro carro = new Carro();
        carro.setIdCarro(rs.getInt("idcarro"));
        carro.setNmCarro(rs.getString("nmcarro"));
        carro.setDtLancamento(rs.getDate("dtLancamento"));
        carro.setFlSaiuLinha(rs.getBoolean("flSaiuLinha"));
        carro.setTpCambio(rs.getString("tpCambio"));

        return carro;
    }

    @Override
    public boolean excluir(Integer id) throws SQLException {
        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();

        stm.executeUpdate("delete from carro where idcarro = " + id);
        return true;
    }

    @Override
    public boolean alterar(Carro carro) throws SQLException {

        String sql = "UPDATE `projeto`.`carro`\n"
                + "SET\n"
                + "`nmcarro` =?,\n"
                + "`dtlancamento` = ?,\n"
                + "`flsaiulinha` = ?,\n"
                + "`tpcambio` = ?\n"
                + "WHERE `idcarro` =?;";

        Connection conn = ConexaoDB.getInstance().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, carro.getNmCarro());
        pstm.setDate(2, new java.sql.Date(carro.getDtLancamento().getTime()));
        pstm.setBoolean(3, carro.isFlSaiuLinha());
        pstm.setString(4, carro.getTpCambio());
        pstm.setInt(5, carro.getIdCarro());
        pstm.executeUpdate();
        return true;
    }

    @Override
    public Integer inserir(Carro carro) throws SQLException {

        System.out.println(carro.getDtLancamento());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataExp = sdf.format(carro.getDtLancamento());

        String sql = "INSERT INTO `projeto`.`carro`\n"
                + "(\n"
                + "`nmcarro`,\n"
                + "`dtlancamento`,\n"
                + "`flsaiulinha`,\n"
                + "`tpcambio`)\n" +
        "VALUES('"+carro.getNmCarro()+"',"
                + "{d '"+dataExp+"'},"
                + carro.isFlSaiuLinha()+","
                +"'"+carro.getTpCambio()+ ")'";

        System.out.println(sql);
        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();
        int regCriados = stm.executeUpdate(sql,
                Statement.RETURN_GENERATED_KEYS);
        ResultSet rsPK = stm.getGeneratedKeys();   //Obter PK gerada
        if (rsPK.next()) {
            return rsPK.getInt(1);
        }
        throw new RuntimeException("Erro inesperado ao incluir usuário!");

    }

    public List<Carro> listarTodos() {
        List<Carro> lista = new ArrayList<>();
        try {
            String sql = "select * from carro";

            Connection conn = ConexaoDB.getInstance().getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setIdCarro(rs.getInt("idcarro"));
                carro.setNmCarro(rs.getString("nmcarro"));
                carro.setDtLancamento(rs.getDate("dtLancamento"));
                carro.setTpCambio(rs.getString("tpCambio"));
                lista.add(carro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
