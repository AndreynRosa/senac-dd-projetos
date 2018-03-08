package br.senac.produto.mode;

import br.senac.grupoproduto.model.BaseDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GrupoProdutoDAO implements BaseDAO<GrupoProduto, Integer> {
    
    private static ArrayList<GrupoProduto> listaGrupoProduto = new ArrayList<>();
    
    public GrupoProdutoDAO() { //construtor
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


    
    public List<GrupoProduto> listaPorNome (String nome){
        return null;        
    }
    
    public List<GrupoProduto> listaPorTipo (TipoProduto tipoPreduto){
        return null;
    }

    @Override
    public GrupoProduto getPorId(Integer id) {
        int cont = 0;
        for(GrupoProduto grupProd : listaGrupoProduto){
            if(grupProd.getIdGrupoPruduto().equals(id)){
                return grupProd;                  
            }
        }
       return null;
    }

    @Override
    public boolean exluir(Integer id) {
        int cont = 0;
        for(GrupoProduto grupProd : listaGrupoProduto){
            if(grupProd.getIdGrupoPruduto().equals(id)){
            listaGrupoProduto.remove(cont);
            return true;
            }
            cont ++;
        }
        return false;
    }    
  

    @Override
    public boolean alterar(GrupoProduto object) {
        int cont = 0;
        for(GrupoProduto grupoProd : listaGrupoProduto ){
            if(grupoProd.equals(object)){  
                listaGrupoProduto.set(cont, object);  
                return true;
            }
            cont ++;
        }
        return false;
    }

    @Override
    public Integer inserir(GrupoProduto object) {
        int maiorId = 0;
        for(GrupoProduto groupProd: listaGrupoProduto){
            if(groupProd.getIdGrupoPruduto() > maiorId){
                maiorId = groupProd.getIdGrupoPruduto();
                
            }
        } 
        maiorId = +1 ;
        object.setIdGrupoPruduto(maiorId);
        listaGrupoProduto.add(object);
        return maiorId;
    }
    
}
