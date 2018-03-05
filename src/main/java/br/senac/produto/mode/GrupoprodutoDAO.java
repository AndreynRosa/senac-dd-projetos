package br.senac.produto.mode;

import br.senac.grupoproduto.model.BaseDAO;
import java.util.List;

public class GrupoprodutoDAO implements BaseDAO<GrupoProduto, Integer> {
    
    public List<GrupoProduto> listaPorNome (String nome){
        return null;        
    }
    
    public List<GrupoProduto> listaPorTipo (TipoProduto tipoPreduto){
        return null;
    }

    @Override
    public GrupoProduto getProId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exluir(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(GrupoProduto object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer inserir(GrupoProduto object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
