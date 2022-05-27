package org.serratec.borracharia.dto;

public class DTOCliente {

    //Atributos específicos da classe
    private Integer clienteId;
    private String clienteCPF;
    private String clienteNumero;
    private String clienteEmail;

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
