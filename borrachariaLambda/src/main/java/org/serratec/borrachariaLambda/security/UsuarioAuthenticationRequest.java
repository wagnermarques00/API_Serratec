package org.serratec.borrachariaLambda.security;

public class UsuarioAuthenticationRequest {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;


    //Construtor vazio
    public UsuarioAuthenticationRequest() {
    }

    //Construtor com tudo
    public UsuarioAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
