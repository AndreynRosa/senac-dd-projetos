/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.usuario.model;

import br.senac.componentes.db.ConexaoDB;
import br.senac.grupoproduto.model.BaseDAO;
import br.senac.pedidovenda.model.PedidoVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class UsuarioDAO implements BaseDAO<Usuario, Integer> {

    @Override
    public Usuario getPorId(Integer id) throws SQLException {
        String sql = "Select * from usuario usu"
                + "left join grupousuario grp on grp.idgrupousuario = usu.idgrupousuario"
                + " where usu.idusuario = " + id;

        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            return getUsuario(rs);

        }
        return null;

    }

    public Usuario getUsuario(ResultSet rs) throws SQLException {

        Usuario usuario = new Usuario();
        usuario.setLogin(rs.getString("login"));
        usuario.setSenha(rs.getString("senha"));
        usuario.setDataExpiracao(rs.getDate("dataExpiracao"));
        usuario.setIdUsuario(rs.getInt("idusuario"));

        GrupoUsuario grupoUsuario = new GrupoUsuario();
        grupoUsuario.setIdGrupoUsuario(rs.getInt("idusuario"));
        grupoUsuario.setNome(rs.getString("nome"));
        usuario.setGrupoUsuario(grupoUsuario);
        return usuario;

    }

    @Override
    public boolean excluir(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean alterar(Usuario usuario) throws SQLException {
        Connection conn = ConexaoDB.getInstance().getConnection();
        String sql = "UPDATE `projeto`.`usuario`\n"
                + "SET\n"
                + "`login` =?,\n"
                + "`senha` = ?,\n"
                + "`dataExpiracao` = ?\n"
                + "WHERE `idUsuario` = ?";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        return true;
    }

    @Override
    public Integer inserir(Usuario usuario) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataExp = sdf.format(usuario.getDataExpiraacao());
        String sql = "INSERT INTO `projeto`.`usuario`(`login`,`senha`,`dataExpiracao`, `idGrupoUsuario`)\n"
                + "VALUES('" + usuario.getLogin() + "','" + usuario.getSenha() + ""
                + "',{d '" + dataExp + "'},"
                + " " + usuario.getGrupoUsuario().getIdGrupoUsuario() + ")";

        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();

        int regCriados = stm.executeUpdate(sql,
                Statement.RETURN_GENERATED_KEYS);
        ResultSet rsPK = stm.getGeneratedKeys();
        if (rsPK.next()) {

            return rsPK.getInt(1);
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Usuario> listarTodos() throws SQLException {
        String sql = "Select * from usuario usu "
                + "left join grupousuario grp on grp.idgrupousuario = usu.idgrupousuario";

        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Usuario> lista = new ArrayList<>();
        while (rs.next()) {

            lista.add(getUsuario(rs));
        }
        return lista;

    }

}
