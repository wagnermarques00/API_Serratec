package org.serratec.backend.projeto06.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cartao")
public class Cartao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "cartao_id")
    private Integer idCartao;

    @NotNull
    @Column(name = "cartao_limite")
    private Double limiteCartao;

    @NotNull
    @Column(name = "cartao_numero")
    private String numeroCartao;

    @NotNull
    @Column(name = "cartao_nome_titular")
    private String nomeTitularCartao;

    @NotNull

    @Column(name = "cartao_data_validade")
    private LocalDate dataValidade;

    //Construtor
    public Cartao() {
    }

    //Getters e Setters
    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
    }

    public Double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(Double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitularCartao() {
        return nomeTitularCartao;
    }

    public void setNomeTitularCartao(String nomeTitularCartao) {
        this.nomeTitularCartao = nomeTitularCartao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
