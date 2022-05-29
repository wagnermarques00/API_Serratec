package org.serratec.borracharia.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {

    //ID da classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "carro_id")
    private Integer carroId;

    //Atributos específicos da classe
    @NotNull
    @Column(name = "carro_modelo")
    private String carroModelo;

    @NotNull
    @Column(name = "carro_marca")
    private String carroMarca;

    @NotNull
    @Size(max = 4)
    @Column(name = "carro_ano")
    private String carroAno;

    //Atributos que se relacionam com outras classes
    @OneToMany(mappedBy = "carro")
    private List<ServicoPrestado> listaServico;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    private Cliente cliente;

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

    public List<ServicoPrestado> getListaServico() {
        return listaServico;
    }

    public void setListaServico(List<ServicoPrestado> listaServico) {
        this.listaServico = listaServico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
