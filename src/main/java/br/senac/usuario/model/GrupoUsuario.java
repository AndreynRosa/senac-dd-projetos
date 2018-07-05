/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.usuario.model;

/**
 *
 * @author andre
 */
public class GrupoUsuario {
    private Integer idGrupoUsuario;
    private String nome;

    public GrupoUsuario() {
    }

    public Integer getIdGrupoUsuario() {
        return idGrupoUsuario;
    }

    public void setIdGrupoUsuario(Integer idGrupoUsuario) {
        this.idGrupoUsuario = idGrupoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
