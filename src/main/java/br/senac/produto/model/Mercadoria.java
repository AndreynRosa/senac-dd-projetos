/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.produto.model;


public class Mercadoria extends Produto{   
    
    private Long idMercadoria;
    private byte[] imagem;

    public Mercadoria() {
    }
    

    public Long getIdMercadoria() {
        return idMercadoria;
    }

    public void setIdMercadoria(Long idMercadoria) {
        this.idMercadoria = idMercadoria;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
    
}
