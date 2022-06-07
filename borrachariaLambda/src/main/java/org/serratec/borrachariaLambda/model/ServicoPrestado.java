package org.serratec.borrachariaLambda.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "servico")
public class ServicoPrestado {

    //ID da classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servico_id")
    private Integer servicoID;

    //Atributos específicos da classe
    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "servico_nome")
    private String servicoNome;

    @NotNull
    @Column(name = "servico_valor")
    private Double servicoValor;

    @NotNull
    @Column(name = "servico_data")
    private LocalDate servicoData;

    //Atributos que se relacionam com outras classes
    @ManyToOne
    @JoinColumn(name = "carro_id", referencedColumnName = "carro_id", nullable = false)
    private Carro carro;

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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
