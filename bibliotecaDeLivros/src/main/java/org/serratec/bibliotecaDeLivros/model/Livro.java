package org.serratec.bibliotecaDeLivros.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "livro")
public class Livro {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livro_id")
    private Integer livroId;

    //Variáveis
    @Size(min = 5, max = 30)
    @NotNull
    @Column(name = "livro_titulo")
    private String livroTitulo;

    @Size(min = 3, max = 30)
    @NotNull
    @Column(name = "livro_tipo")
    private String livroTipo;

    @Size(min = 10, max = 40)
    @NotNull
    @Column(name = "livro_autor")
    private String livroAutor;

    @Past
    @Column(name = "livro_data_publ")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date livroDataPublicacao;

    //Construtores
    public Livro() {

    }

    //Getters e Setters
    public Integer getLivroId() {
        return livroId;
    }

    public void setLivroId(Integer livroId) {
        this.livroId = livroId;
    }

    public String getLivroTitulo() {
        return livroTitulo;
    }

    public void setLivroTitulo(String livroTitulo) {
        this.livroTitulo = livroTitulo;
    }

    public String getLivroTipo() {
        return livroTipo;
    }

    public void setLivroTipo(String livroTipo) {
        this.livroTipo = livroTipo;
    }

    public String getLivroAutor() {
        return livroAutor;
    }

    public void setLivroAutor(String livroAutor) {
        this.livroAutor = livroAutor;
    }

    public Date getLivroDataPublicacao() {
        return livroDataPublicacao;
    }

    public void setLivroDataPublicacao(Date livroDataPublicacao) {
        this.livroDataPublicacao = livroDataPublicacao;
    }
}
