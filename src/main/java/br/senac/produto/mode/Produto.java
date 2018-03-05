
package br.senac.produto.mode;
import java.util.Date;

public abstract class Produto {
    
    private Long idProduto;
    private String nomeProduto;
    private String descicao;
    private Date dataCriacao;
    private Date dataAlteracao;
    private Float perclICMS;
    private GrupoProduto grupoProduto;
    private TipoProduto tipoPruduto;

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

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
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

    public Float getPerclICMS() {
        return perclICMS;
    }

    public void setPerclICMS(Float perclICMS) {
        this.perclICMS = perclICMS;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public TipoProduto getTipoPruduto() {
        return tipoPruduto;
    }

    public void setTipoPruduto(TipoProduto tipoPruduto) {
        this.tipoPruduto = tipoPruduto;
    }
    
}