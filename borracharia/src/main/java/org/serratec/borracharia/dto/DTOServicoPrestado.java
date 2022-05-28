package org.serratec.borracharia.dto;

import java.time.LocalDate;

public class DTOServicoPrestado {
    //Atributos específicos da classe
    private Integer servicoID;
    private String servicoNome;
    private Double servicoValor;
    private LocalDate servicoData;

    //Atributos que se relacionam com outras classes
    private Integer carroID;

    //Construtor
    public DTOServicoPrestado() {
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
