
package br.senac.produto.mode;

import java.util.List;


public class GrupoProdutoDAOTeste {
    public static void main (String[] args){
        GrupoProdutoDAO dao = new GrupoProdutoDAO();
        
        GrupoProduto gpNovo = new GrupoProduto();
        gpNovo.setNomeGrupoProdut("Roupa");
        gpNovo.setTipoProduto(TipoProduto.SERVICO);
        Integer idNovoGP = dao.inserir(gpNovo);
        System.out.println("Novo id: "+idNovoGP);
        List<GrupoProduto> lista = dao.listaPorNome("a");
        for(GrupoProduto gp : lista){
            System.out.println(gp.getNomeGrupoProdut());
        }
        
    }
    
}
