package org.serratec.borrachariaLambda.dto;

public class DTOUsuario {
    //ID da classe
    private Integer usuarioId;

    //Atributos específicos da classe
    private String loginUsuario;
    private String senhaUsuario;


    //Atributos que se relacionam com outras classes

    //Construtor vazio
    public DTOUsuario() {
    }


    //Getters e Setters
    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
}
