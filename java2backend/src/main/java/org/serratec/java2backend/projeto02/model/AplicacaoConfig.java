package org.serratec.java2backend.projeto02.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("aplicacao")
public class AplicacaoConfig {
    private int valor1;
    private String valor2;
    private String[] array1;
    private int[] array2;
    private List<Integer> lista;
    private List<Todo> todos;

    //Construtor
    public AplicacaoConfig() {
    }

    //Getters e Setters

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    public String[] getArray1() {
        return array1;
    }

    public void setArray1(String[] array1) {
        this.array1 = array1;
    }

    public int[] getArray2() {
        return array2;
    }

    public void setArray2(int[] array2) {
        this.array2 = array2;
    }

    public List<Integer> getLista() {
        return lista;
    }

    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
