/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.estoque.model;

/**
 *
 * @author andre
 */
public enum TipoMovimentoEstoque {
    
    ENTRADA('E'), SAIDA('S');
    
    private Character codigo;
    
    private TipoMovimentoEstoque(Character codigo){
        this.codigo = codigo;
    }

    public Character getCodigo() {
        return codigo;
    }
    
    public static TipoMovimentoEstoque getTipoPorCodigo(String codigo){
        if("E".equalsIgnoreCase(codigo) || "ENTRADA".equalsIgnoreCase(codigo))
            return TipoMovimentoEstoque.ENTRADA;
        else if("S".equalsIgnoreCase(codigo) || "SAIDA".equalsIgnoreCase(codigo))
            return TipoMovimentoEstoque.SAIDA;
        else
            return null;
    }
}