package org.serratec.borrachariaLambda.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {
    //ID da classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer usuarioId;

    //Atributos específicos da classe
    @NotNull
    @Column(name = "login_usuario")
    private String loginUsuario;
    @NotNull
    @Column(name = "senha_usuario")
    private String senhaUsuario;

    //Construtor vazio
    public Usuario() {
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
