package org.serratec.java2backend.projeto02.exceptions;

public class TodoException extends Exception{
    //Atributos
    private static final long serialVersionUID = 1L;
    private Integer id;

    //Construtor
    public TodoException(Integer id) {
        this.id = id;
    }

    //Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
