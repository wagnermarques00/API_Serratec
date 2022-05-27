package org.serratec.borracharia.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CARRO")
public class Carro {

    //Atributos específicos da classe

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "carro_id")
    private Integer carroId;


    private String carroModelo;


    private String carroMarca;

    private String carroAno;


    //Atributos que se relacionam com outras classes

    private Integer clienteID;


    private Integer servicoID;


    //Construtor vazio
    public Carro() {
    }


    //Getters e Setters
    public Integer getCarroId() {
        return carroId;
    }

    public void setCarroId(Integer carroId) {
        this.carroId = carroId;
    }

    public String getCarroModelo() {
        return carroModelo;
    }

    public void setCarroModelo(String carroModelo) {
        this.carroModelo = carroModelo;
    }

    public String getCarroMarca() {
        return carroMarca;
    }

    public void setCarroMarca(String carroMarca) {
        this.carroMarca = carroMarca;
    }

    public String getCarroAno() {
        return carroAno;
    }

    public void setCarroAno(String carroAno) {
        this.carroAno = carroAno;
    }

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public Integer getServicoID() {
        return servicoID;
    }

    public void setServicoID(Integer servicoID) {
        this.servicoID = servicoID;
    }
}
