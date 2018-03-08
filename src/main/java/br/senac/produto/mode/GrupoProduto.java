
package br.senac.produto.mode;

import java.util.Objects;


public class GrupoProduto {
    
    private Integer idGrupoPruduto;
    private String GrupoProdut;
    private TipoProduto tipoProduto;

    public GrupoProduto(Integer idGrupoPruduto, String GrupoProdut, TipoProduto tipoProduto) {
        this.idGrupoPruduto = idGrupoPruduto;
        this.GrupoProdut = GrupoProdut;
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
    
    
    public Integer getIdGrupoPruduto() {
        return idGrupoPruduto;
    }

    public void setIdGrupoPruduto(Integer idGrupoPruduto) {
        this.idGrupoPruduto = idGrupoPruduto;
    }

    public String getGrupoProdut() {
        return GrupoProdut;
    }

    public void setGrupoProdut(String GrupoProdut) {
        this.GrupoProdut = GrupoProdut;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
}
