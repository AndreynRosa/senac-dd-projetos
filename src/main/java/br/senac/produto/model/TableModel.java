/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.produto.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class TableModel extends AbstractTableModel {
    private final GrupoProdutoDAO grupProdDAO = new GrupoProdutoDAO();
    private final ArrayList<GrupoProduto>date;// linhas
    
    private final String[] colunas = new String[]{"Código","Produto","Matira Prima","Tipo Produto"};
    //Indice das coluna
    private static final int codigo = 0;
    private static final int descrição = 1;
    private static final int tipo_prod = 2;
    
    
    private GrupoProduto grupProd;
    
    public TableModel(){
    date = new ArrayList<>(grupProdDAO.getGrupoProdArrayList());
    } 
    
    @Override
    public int getRowCount() {
        return this.date.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int line, int colun) {
        GrupoProduto grupPord = date.get(line);
        
        switch(colun){
            case codigo: return grupPord.getIdGrupoProduto();
        
            case descrição: return grupPord.getNomeGrupoProduto();
        
            case tipo_prod: return grupPord.getTipoProduto();   
            
            default: throw new IndexOutOfBoundsException("As colunas estão organizadas de 0 a 2");
        }       
        
    }
    
    @Override
     public void setValueAt(Object o, int line, int colun) {
        GrupoProduto grupPord = date.get(line);
    
        switch(colun){
            case codigo: grupPord.setIdGrupoProduto((Integer) o);break;
        
            case descrição: grupProd.setNomeGrupoProduto((String) o);break;
        
            case tipo_prod: grupProd.setTipoProduto((TipoProduto) o); break;  
            
            default: throw new IndexOutOfBoundsException("As colunas estão organizadas de 0 a 2");
        }       
    }

    
    @Override
   public boolean isCellEditable(int i, int i1) {
       return false;
   }
}


