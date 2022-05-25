package org.serratec.bibliotecaDeLivros.dto;

import java.util.Date;

public class LivroDTO {

    private Integer livroId;
    private String livroTitulo;
    private String livroTipo;
    private String livroAutor;
    private Date livroDataPublicacao;

    //Construtor
    public LivroDTO(Integer livroId, String livroTitulo, String livroTipo, String livroAutor, Date livroDataPublicacao) {
        this.livroId = livroId;
        this.livroTitulo = livroTitulo;
        this.livroTipo = livroTipo;
        this.livroAutor = livroAutor;
        this.livroDataPublicacao = livroDataPublicacao;
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
