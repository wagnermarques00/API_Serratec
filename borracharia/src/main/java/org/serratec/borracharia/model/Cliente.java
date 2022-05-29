package org.serratec.borracharia.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    //ID da classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "cliente_id")
    private Integer clienteId;

    //Atributos específicos da classe
    @NotNull
    @Column(name = "cliente_cpf", unique = true)
    private String clienteCPF; // --> unique = true

    @NotNull
    @Column(name = "cliente_numero")
    private String clienteNumero;

    @NotNull
    @Email
    @Column(name = "cliente_email")
    private String clienteEmail; // --> @email

    //Atributos que se relacionam com outras classes
    @OneToMany(mappedBy = "cliente")
    private List<Carro> listaCarro;

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

    public List<Carro> getListaCarro() {
        return listaCarro;
    }

    public void setListaCarro(List<Carro> listaCarro) {
        this.listaCarro = listaCarro;
    }
}
