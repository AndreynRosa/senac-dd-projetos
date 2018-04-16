/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.produto.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author andre
 */
public abstract class ProdutoProva {
    
    private Long idProduto;
    private String nomeProduto;
    private TipoProduto tipoProduto;
    private String descricao;
    private Date dataCriacao;
    private Date dataAlteracao;
    private Float percICMS;
    private GrupoProduto grupoProduto;

    public ProdutoProva(Long idProduto) {
        this.idProduto = idProduto;
    }

    public ProdutoProva(Long idProduto, String nomeProduto, TipoProduto tipoProduto, Date dataCriacao, Float percICMS, GrupoProduto grupoProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
        this.dataCriacao = dataCriacao;
        this.percICMS = percICMS;
        this.grupoProduto = grupoProduto;
    }

    public ProdutoProva() {
    }
    
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Float getPercICMS() {
        return percICMS;
    }

    public void setPercICMS(Float percICMS) {
        this.percICMS = percICMS;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }
    
    public abstract Float getTotalPercImposto();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idProduto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProdutoProva other = (ProdutoProva) obj;
        if (!Objects.equals(this.idProduto, other.idProduto)) {
            return false;
        }
        return true;
    }
    
    
    
}