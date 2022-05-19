package org.serratec.java2backend.projeto02.service;

import org.serratec.java2backend.projeto02.model.Aluno;
import org.serratec.java2backend.projeto02.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    // Listas
    List<Todo> lista = new ArrayList<>();
    List<Aluno> aluno = new ArrayList<>();

    //Métodos do Todo
    public void adicionar(Todo todo) {
        lista.add(todo);
    }

    public List<Todo> listaTodo() {
        return this.lista;
    }

    public void atualizar(Integer posicaoLista, Todo todoDaAPI) {
        //posicaoLista é posição
        Todo todoDaListaSalva = lista.get(posicaoLista);

        todoDaListaSalva.setDescricao(todoDaAPI.getDescricao());
        todoDaListaSalva.setId(todoDaAPI.getId());
        todoDaListaSalva.setTitulo(todoDaAPI.getTitulo());
    }

    public void deletar(int posicaoLista) {
        lista.remove(posicaoLista);
    }


    //Métodos do Aluno
    public void adicionarAluno(Aluno nomeAluno) {
        aluno.add(nomeAluno);
    }

    public List<Aluno> listaAluno() {
        return this.aluno;
    }

    public void atualizarAluno(Integer posicaoLista, Aluno AlunoPreenchido) {
        Aluno AlunoSalvo = aluno.get(posicaoLista);

        AlunoSalvo.setIdade(AlunoPreenchido.getIdade());
        AlunoSalvo.setNome(AlunoPreenchido.getNome());
        AlunoSalvo.setId(AlunoPreenchido.getId());
        AlunoSalvo.setSexo(AlunoPreenchido.getSexo());
    }

    public void consultarAluno(Integer posicaoLista) {
        Aluno AlunoSalvo = aluno.get(posicaoLista);
    }

    public void deletarAluno(int posicaoLista) {
        aluno.remove(posicaoLista);
    }

}