
package br.senac.produto.mode;


public class Servico extends Produto{
    
    private Long idServico;
    private Float prclISS;

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Float getPrclISS() {
        return prclISS;
    }

    public void setPrclISS(Float prclISS) {
        this.prclISS = prclISS;
    }
    
    
}