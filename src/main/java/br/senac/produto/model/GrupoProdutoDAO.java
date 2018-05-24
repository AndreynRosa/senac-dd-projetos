/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.produto.model;

import br.senac.componentes.db.UtilSQL;
import br.senac.componentes.db.ConexaoDB;
import br.senac.grupoproduto.model.BaseDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GrupoProdutoDAO implements BaseDAO<GrupoProduto, Integer> {

    public GrupoProdutoDAO() {

    }

    public Integer inserir(GrupoProduto grupoProduto) throws SQLException {
        Integer pk = 0;
        grupoProduto.setDataInsclusao(new Date());
        String sql = "INSERT INTO GRUPOPRODUTO"
                + "(NOMEGRUPOPRODUTO, TIPO, DATAINCLUSAO, PERCDESCONTO)"
                + "VALUES (";
        sql += "'" + grupoProduto.getNomeGrupoProduto() + "', ";

        if (grupoProduto.getTipoProduto() == null) {
            throw new RuntimeException("Tipo grupo não pode ser nulo");
        } else {
            sql += grupoProduto.getTipoProduto().getId() + ",";
        }

        sql += UtilSQL.getDataTempoToSQL(grupoProduto.getDataInsclusao()) + ",";
        sql += grupoProduto.getPercDesconto() + ")";
        System.out.println(sql);
        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();

        int regCriados = stm.executeUpdate(sql,
                Statement.RETURN_GENERATED_KEYS);
        ResultSet rsPK = stm.getGeneratedKeys();   
        if (rsPK.next()) {
            pk = rsPK.getInt(1);
            return pk;
        }
        throw new RuntimeException("Erro inesperado ao incluir grupo produto!");
    }

    public boolean alterar(GrupoProduto grupoProduto) throws SQLException {
        String sql = "UPDATE GRUPOPRODUTO SET"
                + "nomeGRUPOPRODUTO ='" + grupoProduto.getNomeGrupoProduto() + "',"
                + "tipo = '" + grupoProduto.getTipoProduto().getId() + "',"
                + "percDesconto ='" + grupoProduto.getPercDesconto() + "' "
                + "WHERE IDGRUPOPRODUTO ='" + grupoProduto.getIdGrupoProduto()+";'";
        System.out.println(sql);
        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();
        int regAlterados = stm.executeUpdate(sql);
        
                
                
        return (regAlterados == 1);
                
    }

    public boolean excluir(Integer id) throws SQLException {
        String sqlExcluir = "DELETE FROM GRUPO GRUPOPRODUTO"
                + "WERE IDGRUPOPRODUTO =" + id;
        Connection conn = ConexaoDB.getInstance().getConnection();

        try {
            Statement stm = conn.createStatement();
            int regAfetados = stm.executeUpdate(sqlExcluir);
            return (regAfetados == 1);
       
        } catch (SQLException e) {
            String sqlAtualizar = "UPDATE GRUPOPRODUTO SET dataExclusao "
                    + "= CURDATE() WHERE IDGRUPOPRODUTO =" + id;
            Statement stm = conn.createStatement();
            int regAfetados = stm.executeUpdate(sqlAtualizar);
            return (regAfetados == 1);
        }

    }

    @Override
    public GrupoProduto getPorId(Integer id) throws SQLException {

       
        String sql = "Select * from grupoproduto"
                + " where idgrupoproduto =" + id;
       ResultSet rs = UtilSQL.executarQuery(sql);

        if (rs.next() == false) {
            throw new RuntimeException("Registro não encontrado");
        }
        return getGrupoPorduto(rs);

    }

    public GrupoProduto getGrupoPorduto(ResultSet rs) throws SQLException {
        GrupoProduto gp = new GrupoProduto();
        gp.setNomeGrupoProduto(rs.getString("nomeGrupoProduto"));
        gp.setIdGrupoProduto(rs.getInt("idgrupoproduto"));

        switch (rs.getInt("tipo")) {

            case 1:
                gp.setTipoProduto(TipoProduto.MERCADORIA);
                break;

            case 2:
                gp.setTipoProduto(TipoProduto.SERVICO);
                break;

            case 3:
                gp.setTipoProduto(TipoProduto.MATERIA_PRIMA);
                break;
        }

        gp.setDataInsclusao(rs.getDate("dataInclusao"));
        gp.setDataExclusao(rs.getDate("dataExclusao"));

        return gp;
    }

    public List<GrupoProduto> listartoPorNome(String nome) throws SQLException {
        if (nome == null && nome.trim().equals("")) {
            return listarTodos();
        }
        List<GrupoProduto> lista = new ArrayList<>();
        String sql = "SELECT * FROM grupoproduto\n"
                + "WHERE UPPER(nomegrupoproduto) LIKE UPPER('%" + nome + "%')";

         ResultSet rs = UtilSQL.executarQuery(sql);
        GrupoProduto grupProd;
        while (rs.next()) {
            grupProd = getGrupoPorduto(rs);
            lista.add(grupProd);
            }
        return lista;
    }

    public List<GrupoProduto> ordenarPorNome(boolean crescente) throws SQLException {
        List<GrupoProduto> lista = new ArrayList();
        String sql = "SELECT * FROM GRUPOPRODUTO"
                + "ORDER BY NOMEGRUPOPRODUTO";

        if (crescente) {
            sql += " ASC";
        } else {
            sql += " DESC";
        }
        
       ResultSet rs = UtilSQL.executarQuery(sql);

        GrupoProduto grupProd;
        while (rs.next()) {
            grupProd = getGrupoPorduto(rs);
            lista.add(grupProd);
        }
        return lista;
    }

    public List<GrupoProduto> listarTodos() throws SQLException {
        LinkedList<GrupoProduto> listaTodos
                = new LinkedList<>(ordenarPorNome(true));
        return listaTodos;
    }

    public HashMap<TipoProduto, List<GrupoProduto>> obterMapId() {
        HashMap<TipoProduto, List<GrupoProduto>> hashMap = new HashMap<>();
        hashMap.put(TipoProduto.SERVICO, new ArrayList<>());
        hashMap.put(TipoProduto.MATERIA_PRIMA, new ArrayList<>());
        hashMap.put(TipoProduto.MERCADORIA, new ArrayList<>());

        for (List<GrupoProduto> listaGrupProd : hashMap.values()) {
            for (GrupoProduto grupProd : listaGrupProd) {
                System.out.println(grupProd);
            }
        }

        for (TipoProduto tipo : hashMap.keySet()) {
            System.out.println("Tipo: " + tipo);
        }

        return hashMap;
    }
    
  
    
    }

