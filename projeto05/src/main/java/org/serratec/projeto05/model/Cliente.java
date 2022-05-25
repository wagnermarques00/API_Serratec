package org.serratec.projeto05.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_cd_id")
    private Integer idCliente;

    @Column(name = "cliente_tx_nome")
        private String nome;

    @Size(max = 14)
    @Column(name = "cliente_tx_cpf")
    private String cpf;

    @Column(name = "cliente_tx_numero_telefone")
    private String numeroTelefone;

    @Column(name = "cliente_tx_email")
    private String email;

    @Column(name = "cliente_dt_nascimento")
    @DateTimeFormat(pattern= "yyyy/mm/dd")
    private Date dataNascimento;

    //Getters e Setters
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
