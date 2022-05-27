package org.serratec.borracharia.dto;

public class DTOCarro {
    //Atributos específicos da classe
    private Integer carroId;
    private String carroModelo;
    private String carroMarca;
    private String carroAno;

    //Atributos que se relacionam com outras classes
    private Integer clienteID;
    private Integer servicoID;

    //Construtor vazio
    public DTOCarro() {
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
