package org.serratec.borracharia.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    //Atributos específicos da classe


    private String clienteCPF; // --> unique = true


    private String clienteNumero;


    private String clienteEmail; // --> @email


    //Atributos que se relacionam com outras classes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "cliente_id")
    private Integer clienteId;

    private Integer carroID;

    //Construtor vazio
    public Cliente() {
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
