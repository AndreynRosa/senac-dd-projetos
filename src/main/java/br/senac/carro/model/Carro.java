/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.carro.model;

import java.util.Date;

/**
 *
 * @author andre
 */
public class Carro {
    private Integer idCarro;
    private String nmCarro;
    private Date dtLancamento;
    private boolean flSaiuLinha;
    private String tpCambio;

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public String getNmCarro() {
        return nmCarro;
    }

    public void setNmCarro(String nmCarro) {
        this.nmCarro = nmCarro;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public boolean isFlSaiuLinha() {
        return flSaiuLinha;
    }

    public void setFlSaiuLinha(boolean flSaiuLinha) {
        this.flSaiuLinha = flSaiuLinha;
    }

    public String getTpCambio() {
        return tpCambio;
    }

    public void setTpCambio(String tpCambio) {
        this.tpCambio = tpCambio;
    }
    
}
