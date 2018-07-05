/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.usuario.model;

import java.util.Date;


public class Usuario {
    
    private Integer idUsuario;
    private String login;
    private String senha;
    private Date dataExpiraacao;
    private GrupoUsuario grupoProd;

    public Usuario() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataExpiraacao() {
        return dataExpiraacao;
    }

    public void setDataExpiraacao(Date dataExpiraacao) {
        this.dataExpiraacao = dataExpiraacao;
    }

    public GrupoUsuario getGrupoProd() {
        return grupoProd;
    }

    public void setGrupoProd(GrupoUsuario grupoProd) {
        this.grupoProd = grupoProd;
    }
    
}
