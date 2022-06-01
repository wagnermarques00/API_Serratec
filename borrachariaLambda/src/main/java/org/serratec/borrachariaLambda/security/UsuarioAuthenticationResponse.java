package org.serratec.borrachariaLambda.security;

public class UsuarioAuthenticationResponse {

    private final String token;

    //Construtor cheio
    public UsuarioAuthenticationResponse(String token) {
        this.token = token;
    }

    //Getters e Setters
    public String getToken() {
        return token;
    }
}
