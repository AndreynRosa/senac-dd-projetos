/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.produto.model;

import br.senac.componentes.db.ConexaoDB;
import br.senac.grupoproduto.model.BaseDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;




public class GrupoProdutoJDBCDAO  implements BaseDAO<GrupoProduto, Integer> {
     public GrupoProdutoJDBCDAO() {
     }

     
    public Integer inserir(GrupoProduto grupoProduto) {
        Integer pk = 0;
        String sqlInsert = "INSERT INTO GRUPOPRODUTO"
                + "(NOMEGRUPOPRODUTO, TIPO, DATAINCLUSAO, PERCDESCONTO)"
                + "VALUE (";
        sqlInsert +="'"+grupoProduto.getNomeGrupoProduto()+"', ";
        if(grupoProduto.getTipoProduto()== null)
            throw new RuntimeException("Tipo grupo não pode ser nulo");
        else
            sqlInsert += grupoProduto.getTipoProduto().getId() + ",";
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd:mm:ss");
        sqlInsert +="{ts' "+sdf.format(grupoProduto.getDataInsclusao()) + "'},";
        sqlInsert += grupoProduto.getPercDesconto() + ")";
        System.out.println(sqlInsert);
        return pk;
    }

    public boolean alterar(GrupoProduto grupoProduto) {
        return false;
    }

    public boolean excluir(Integer id) {
        return false;
    }
    
    @Override
    public GrupoProduto getPorId(Integer id) throws SQLException{
       
        Connection conn = ConexaoDB.getInstance().getConnection();
        Statement stm = conn.createStatement();
        String sql ="Select * from grupoproduto"
                + " where idgrupoproduto =" + id;
        ResultSet rs = stm.executeQuery(sql);
        
        if(rs.next()==false){
            throw new RuntimeException("Registro não encontrado");
        }
        return getGrupoPorduto(rs);
         
    }
        
        //getGrupoProduto
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

        
        
    

    /**
     * Faça um foreach na lista e para os grupos de contiverem apenas parte da string do nome passada como parâmetro,
     * adicione o mesmo em outra lista que será retornada para o usuário. Esse método deverá ser case insensitive;
     * método contains serve para ver se dentro de uma string tem determinado conjunjto de caracteres.
     * @param nome
     * @return 
     */
    public List<GrupoProduto> listarGrupoProdutoPorNome(String nome) {
        if(nome==null){
            return listarTodos();
        }
        List<GrupoProduto> lista = new ArrayList<>();
        //implemente aqui
        return lista;
    }

    /**
     * se for para ordenar de forma crescente, utilize Comparator; 
     * se for para ordenar de forma descrente, utilize Comparable.
     * @param crescente
     * @param lista
     * @return 
     */
    public List<GrupoProduto> ordenarPorNome(boolean crescente) {
        List<GrupoProduto> lista = listarTodos();
        //Implemente aqui
        return lista;
    }

    /**
     * converta o ArrayList para um LinkedList retorne a lista ordenada por idGrupoProduto, 
     * utilize Comparator e Collections.sort;
     * @return 
     */
    public List<GrupoProduto> listarTodos() {
        LinkedList<GrupoProduto> listaTodos = new LinkedList<>();
        //Implemente aqui
        return listaTodos;
    }

    /**
     * Use um HashMap e separe a lista de Grupos de Produtos em duas, 
     * uma contendo apenas o TipoProduto.PRODUTO e outra TipoProduto.SERVICO. 
     * Depois imprimiva os chaves e na sequência imprima os valores.
     * @return 
     */
    public HashMap<TipoProduto, List<GrupoProduto>> obterMapId() {
        HashMap<TipoProduto, List<GrupoProduto>> hashMap = new HashMap<>();
        hashMap.put(TipoProduto.SERVICO, new ArrayList<>());
        hashMap.put(TipoProduto.MATERIA_PRIMA, new ArrayList<>());
        hashMap.put(TipoProduto.MERCADORIA, new ArrayList<>());
        
        //Implemente aqui
        
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



    