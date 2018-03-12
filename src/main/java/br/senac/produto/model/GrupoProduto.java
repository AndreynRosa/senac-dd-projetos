
package br.senac.produto.model;

import java.util.Objects;


public class GrupoProduto {
    
    private Integer idGrupoPruduto;
    private String nomeGrupoProdut;
    private TipoProduto tipoProduto;

    public GrupoProduto(Integer idGrupoPruduto, String GrupoProdut, TipoProduto tipoProduto) {
        this.idGrupoPruduto = idGrupoPruduto;
        this.nomeGrupoProdut = GrupoProdut;
        this.tipoProduto = tipoProduto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idGrupoPruduto);
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
        final GrupoProduto other = (GrupoProduto) obj;
        if (!Objects.equals(this.idGrupoPruduto, other.idGrupoPruduto)) {
            return false;
        }
        return true;
    }
    
   
    
    
    public GrupoProduto() {
    }
    
    
    public Integer getIdGrupoProduto() {
        return idGrupoPruduto;
    }

    public void setIdGrupoProduto(Integer idGrupoPruduto) {
        this.idGrupoPruduto = idGrupoPruduto;
    }

    public String getNomeGrupoProduto() {
        return nomeGrupoProdut;
    }

    public void setNomeGrupoProduto(String GrupoProdut) {
        this.nomeGrupoProdut = GrupoProdut;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

   
    
}
