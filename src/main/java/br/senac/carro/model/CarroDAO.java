/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.carro.model;

import br.senac.componentes.db.ConexaoDB;
import br.senac.grupoproduto.model.BaseDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class CarroDAO implements BaseDAO<Carro, Integer> {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Carro object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer inserir(Carro object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
