/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.produto.model;

import java.util.Date;

/**
 *
 * @author andre
 */
public class ServicoProva extends ProdutoProva {
    
    private Long idServico;
    private Float percISS;

    public ServicoProva(Long idServico) {
        super(idServico);
        this.idServico = idServico;
    }

    public ServicoProva() {
    }

    public ServicoProva(Long idProduto, String nomeProduto, TipoProduto tipoProduto, Date dataCriacao, Float percICMS, GrupoProduto grupoProduto,Float percISS) {
        super(idProduto, nomeProduto, tipoProduto, dataCriacao, percICMS, grupoProduto);
        this.percISS = percISS;
    }
    
    public Long getIdServico() {
        return getIdProduto();
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
        setIdProduto(idServico);
    }

    public Float getPercISS() {
        return percISS;
    }

    public void setPercISS(Float percISS) {
        this.percISS = percISS;
    }

    @Override
    public Float getTotalPercImposto() {
        return (percISS == null ? 0F : percISS) + 
                (super.getPercICMS() == null ? 0F : super.getPercICMS());
    }
    
    
    
}