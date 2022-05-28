package org.serratec.borracharia.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "SERVICO")
public class ServicoPrestado {

    //Atributos específicos da classe


    private String servicoNome;


    private Double servicoValor;


    private LocalDate servicoData;


    //Atributos que se relacionam com outras classes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "servico_id")
    private Integer servicoID;

    private Integer carroID;


    //Construtor vazio
    public ServicoPrestado() {
    }

    //Getters e Setters
    public Integer getServicoID() {
        return servicoID;
    }

    public void setServicoID(Integer servicoID) {
        this.servicoID = servicoID;
    }

    public String getServicoNome() {
        return servicoNome;
    }

    public void setServicoNome(String servicoNome) {
        this.servicoNome = servicoNome;
    }

    public Double getServicoValor() {
        return servicoValor;
    }

    public void setServicoValor(Double servicoValor) {
        this.servicoValor = servicoValor;
    }

    public LocalDate getServicoData() {
        return servicoData;
    }

    public void setServicoData(LocalDate servicoData) {
        this.servicoData = servicoData;
    }

    public Integer getCarroID() {
        return carroID;
    }

    public void setCarroID(Integer carroID) {
        this.carroID = carroID;
    }
}
