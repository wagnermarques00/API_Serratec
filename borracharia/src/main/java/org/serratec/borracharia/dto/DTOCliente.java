package org.serratec.borracharia.dto;

import org.serratec.borracharia.model.Carro;

import java.util.List;

public class DTOCliente {
    //ID da classe
    private Integer clienteId;

    //Atributos específicos da classe
    private String clienteCPF; // --> unique = true
    private String clienteNumero;
    private String clienteEmail; // --> @email

    //Atributos que se relacionam com outras classes
    private List<Carro> listaCarro;

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

    public List<Carro> getListaCarro() {
        return listaCarro;
    }

    public void setListaCarro(List<Carro> listaCarro) {
        this.listaCarro = listaCarro;
    }
}
