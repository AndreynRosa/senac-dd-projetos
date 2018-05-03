
package br.senac.produto.model;

import java.util.List;


public class GrupoProdutoDAOTeste {
    public static void main (String[] args){
        
        GrupoProdutoDAO dao = new GrupoProdutoDAO();
         /**
        GrupoProduto gpNovo = new GrupoProduto();
        gpNovo.setNomeGrupoProduto("Roupa");
        gpNovo.setTipoProduto(TipoProduto.SERVICO);
        Integer idNovoGP = dao.inserir(gpNovo);
        System.out.println("Novo id: "+idNovoGP);
        List<GrupoProduto> lista = dao.listarPorNome("a");
        for(GrupoProduto gp : lista){
            System.out.println(gp.getNomeGrupoProduto());
        }
        **/
        dao.inserir(null);
        
    }
    
}
