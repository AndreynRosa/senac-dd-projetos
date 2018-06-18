package br.senac.pedidovenda.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PedidoVenda {
    
    private Long idPedido;
    private Date dtPedido;
    private TipoPedidoVenda tipoPedidoVenda;
    private Double vlFrete = 0.0;
    private boolean telemarketing = false;
    private boolean freteGratis = false;
    private FormaPagamento formaPagamento;
    private String observacoes;
    private Long idPessoa;
    private Double vlTotal;
   

    public PedidoVenda() {
    }

    public PedidoVenda(Long idPedido) {
        this.idPedido = idPedido;
    }
    
    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public TipoPedidoVenda getTipoPedidoVenda() {
        return tipoPedidoVenda;
    }

    public void setTipoPedidoVenda(TipoPedidoVenda tipoPedidoVenda) {
        this.tipoPedidoVenda = tipoPedidoVenda;
    }

    public Double getVlFrete() {
        return vlFrete;
    }

    public void setVlFrete(Double vlFrete) {
        this.vlFrete = vlFrete;
    }

    public boolean getTelemarketing() {
        return telemarketing;
    }

    public void setTelemarketing(boolean telemarketing) {
        this.telemarketing = telemarketing;
    }

    public boolean getFreteGratis() {
        return freteGratis;
    }

    public void setFreteGratis(boolean freteGratis) {
        this.freteGratis = freteGratis;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idPedido);
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
        final PedidoVenda other = (PedidoVenda) obj;
        if (!Objects.equals(this.idPedido, other.idPedido)) {
            return false;
        }
        return true;
    }
}