package org.serratec.borracharia.dto;

import org.serratec.borracharia.model.Cliente;
import org.serratec.borracharia.model.ServicoPrestado;

import java.util.List;

public class DTOCarro {
    //ID da classe
   private Integer carroId;

    //Atributos específicos da classe
    private String carroModelo;
    private String carroMarca;
    private String carroAno;

    //Atributos que se relacionam com outras classes
    private List<ServicoPrestado> listaServico;
    private Cliente cliente;

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
