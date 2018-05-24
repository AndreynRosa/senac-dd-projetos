
package br.senac.produto.model;

import java.sql.SQLException;
import java.util.List;


public class GrupoProdutoDAOTeste {
    public static void main (String[] args) throws SQLException{
        
        GrupoProdutoDAO dao = new GrupoProdutoDAO();
        
       
        GrupoProduto gpNovo = new GrupoProduto();
        gpNovo.setNomeGrupoProduto("Roupa");
        gpNovo.setPercDesconto(0.5f);
        gpNovo.setTipoProduto(TipoProduto.SERVICO);
        Integer idNovoGP = dao.inserir(gpNovo);
        System.out.println("Novo id: "+idNovoGP);
      
        /** List<GrupoProduto> lista = dao.listarPorNome("a");
        for(GrupoProduto gp : lista){
            System.out.println(gp.getNomeGrupoProduto());
        }
        **/
        dao.alterar(gpNovo);
        
    }
    
}
