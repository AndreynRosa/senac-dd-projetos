/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.estoque.model;

import br.senac.produto.model.Produto;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author andre
 */
public class EstoqueMovimento {
    
    private Long idMovtoEstoque;
    private Double quantidade;
    private TipoMovimentoEstoque tipoMovto;
    private Date dataMovto;
    private Produto produto;
    private Integer idUsuario;
    private String observacoes;

    public EstoqueMovimento() {
    }

    public EstoqueMovimento(Long idMovtoEstoque) {
        this.idMovtoEstoque = idMovtoEstoque;
    }

    public Long getIdMovtoEstoque() {
        return idMovtoEstoque;
    }

    public void setIdMovtoEstoque(Long idMovtoEstoque) {
        this.idMovtoEstoque = idMovtoEstoque;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public TipoMovimentoEstoque getTipoMovto() {
        return tipoMovto;
    }

    public void setTipoMovto(TipoMovimentoEstoque tipoMovto) {
        this.tipoMovto = tipoMovto;
    }

    public Date getDataMovto() {
        return dataMovto;
    }

    public void setDataMovto(Date dataMovto) {
        this.dataMovto = dataMovto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idMovtoEstoque);
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
        final EstoqueMovimento other = (EstoqueMovimento) obj;
        if (!Objects.equals(this.idMovtoEstoque, other.idMovtoEstoque)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EstoqueMovimento{" + "idMovtoEstoque=" + idMovtoEstoque + ", quantidade=" + quantidade + ", tipoMovto=" + tipoMovto + ", dataMovto=" + dataMovto + ", produto=" + produto + ", idUsuario=" + idUsuario + ", observacoes=" + observacoes + '}';
    }
    
    
    
}