package org.serratec.borracharia.dto;

import org.serratec.borracharia.model.Carro;

import java.util.List;

public class DTOCliente {
    //ID da classe
    private Integer clienteId;

    //Atributos específicos da classe
    private String clienteNome;
    private String clienteCPF; // --> unique = true
    private String clienteNumero;
    private String clienteEmail; // --> @email

    //Atributos que se relacionam com outras classes
    private Integer carroID;


    //Construtor vazio
    public DTOCliente() {
    }

    //Getters e Setters
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteCPF() {
        return clienteCPF;
    }

    public void setClienteCPF(String clienteCPF) {
        this.clienteCPF = clienteCPF;
    }

    public String getClienteNumero() {
        return clienteNumero;
    }

    public void setClienteNumero(String clienteNumero) {
        this.clienteNumero = clienteNumero;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public Integer getCarroID() {
        return carroID;
    }

    public void setCarroID(Integer carroID) {
        this.carroID = carroID;
    }
}
