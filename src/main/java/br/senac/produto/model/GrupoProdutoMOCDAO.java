
package br.senac.produto.model;


import br.senac.dd.exception.ParamentrosInvalidosException;
import br.senac.grupoproduto.model.BaseDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class GrupoProdutoMOCDAO implements  BaseDAO<GrupoProduto, Integer>{
    
      private static ArrayList<GrupoProduto> listaGrupoProduto = new ArrayList<>();
      
    
       public GrupoProdutoMOCDAO() { //construtor
	if(listaGrupoProduto.size() > 0)
     return;
        	//MOCK: Objetos para testes
        	listaGrupoProduto.add(new GrupoProduto(1, "Alimentos", TipoProduto.MERCADORIA));
        	listaGrupoProduto.add(new GrupoProduto(2, "Estética", TipoProduto.SERVICO));
        	listaGrupoProduto.add(new GrupoProduto(3, "Higiene", TipoProduto.MERCADORIA));
        	listaGrupoProduto.add(new GrupoProduto(4, "Limpeza", TipoProduto.MERCADORIA));
        	listaGrupoProduto.add(new GrupoProduto(5, "Cobre", TipoProduto.MATERIA_PRIMA));
        	listaGrupoProduto.add(new GrupoProduto(6, "Mecânica", TipoProduto.SERVICO));
        	listaGrupoProduto.add(new GrupoProduto(7, "Segurança", TipoProduto.SERVICO));
        	listaGrupoProduto.add(new GrupoProduto(8, "Educação", TipoProduto.SERVICO));
        	listaGrupoProduto.add(new GrupoProduto(9, "Automóveis", TipoProduto.MERCADORIA));
                listaGrupoProduto.add(new GrupoProduto(10, "Lã", TipoProduto.MATERIA_PRIMA));
                listaGrupoProduto.add(new GrupoProduto(11, "Algodão", TipoProduto.MATERIA_PRIMA));
                   }

  
   
    @Override
    public GrupoProduto getPorId(Integer id) {
        for(GrupoProduto grupoProd : listaGrupoProduto){
            if(grupoProd.getIdGrupoProduto().equals(id)){
              return grupoProd;  
            }
        }
        return null;
    }

    @Override
    public boolean excluir(Integer id) {
        int i = 0;
        for(GrupoProduto grupoProd : listaGrupoProduto){
            if(grupoProd.getIdGrupoProduto().equals(id)){
              listaGrupoProduto.remove(i);
              return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean alterar(GrupoProduto object) {
        int i = 0;
        for(GrupoProduto grupoProd : listaGrupoProduto){
            if(grupoProd.equals(object)){
                listaGrupoProduto.set(i,object);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public Integer inserir(GrupoProduto object) {
        
        if(object == null){
            throw new ParamentrosInvalidosException(1,"Grupo prduto invalido");
        }else if(object.getNomeGrupoProduto() == null){
            throw new ParamentrosInvalidosException(2, "Nome do grupo invalido");
            
        }
        int maiorId = 0;
        for(GrupoProduto grupoProd : listaGrupoProduto){
            if(grupoProd.getIdGrupoProduto()>maiorId)
            maiorId = grupoProd.getIdGrupoProduto();
        }
        maiorId++;
        object.setIdGrupoProduto(maiorId);
        listaGrupoProduto.add(object);
        return maiorId;
    }
    
    public List<GrupoProduto> listarPorNome(String nome){
       ArrayList<GrupoProduto> listaNome = new ArrayList<>();
       for(GrupoProduto grupoProd : listaGrupoProduto){
         if(grupoProd.getNomeGrupoProduto().toLowerCase().contains(nome.toLowerCase()))  {
             listaNome.add(grupoProd);
         }
         Collections.sort(listaNome, new Comparator<GrupoProduto>() {
             @Override
             public int compare(GrupoProduto o1, GrupoProduto o2) {
              int compareStr = o1.getNomeGrupoProduto().compareTo(o2.getNomeGrupoProduto());
              if(compareStr == 0){
                  compareStr = o1.getIdGrupoProduto().compareTo(o2.getIdGrupoProduto());
              }
              return compareStr;
             }
         });
       }
       return listaNome;
    }
     public List<GrupoProduto> listarPorTipo(TipoProduto tipoProduto,String nome){
        ArrayList<GrupoProduto> listaTipo = new ArrayList<>();
       for(GrupoProduto grupoProd : listaGrupoProduto){
         if(grupoProd.getTipoProduto().equals(tipoProduto))  {
             listaTipo.add(grupoProd);
         }
         Collections.sort(listaTipo, new Comparator<GrupoProduto>() {
             @Override
             public int compare(GrupoProduto o1, GrupoProduto o2) {
              int compareStr = o1.getNomeGrupoProduto().compareTo(o2.getNomeGrupoProduto());
              if(compareStr == 0){
                  compareStr = o1.getIdGrupoProduto().compareTo(o2.getIdGrupoProduto());
              }
              return compareStr;
             }
         });
       }
       return listaTipo;
    }
    
     public HashMap<TipoProduto, List<GrupoProduto>> getMapPorTipoProduto(){
        HashMap<TipoProduto, List<GrupoProduto> > map = new HashMap<>();
         
         return map;
     }
     
     public GrupoProduto getGrupoProdutoPorId(Integer idGrupoProduto){
         for(GrupoProduto idProd: listaGrupoProduto){
          if (idProd.getIdGrupoProduto().equals(idGrupoProduto)){  
              return idProd;
          } 
         }        
         return null;
     }
     
}

    
     
