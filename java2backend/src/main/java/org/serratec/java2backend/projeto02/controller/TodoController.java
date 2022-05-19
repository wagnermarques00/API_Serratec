package org.serratec.java2backend.projeto02.controller;

import org.serratec.java2backend.projeto02.model.Aluno;
import org.serratec.java2backend.projeto02.model.Todo;
import org.serratec.java2backend.projeto02.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping(value = "/lista")
    public List<Todo> getTodo() {
        return todoService.listaTodo();
    }

    @PostMapping(value = "/adicionar")
    public void adicionar(@RequestBody Todo todo) {
        todoService.adicionar(todo);
    }

    @PutMapping(value = "/atualizar/{posicaoLista}")
    public void atualizar(@PathVariable Integer posicaoLista, @RequestBody Todo todo) {
        todoService.atualizar(posicaoLista, todo);
    }

    @DeleteMapping(value = "/deletar/{posicaoLista}")
    public void deletar(@PathVariable int posicaoLista) {
        todoService.deletar(posicaoLista);
    }

    //CRUDE alunos
    @GetMapping(value = "/get")
    public List<Aluno> getAluno() {
        return todoService.listaAluno();
    }

    @GetMapping(value = "/get/{posicaoLista}")
    public void listaEspecifico(@PathVariable Integer posicaoLista) {
        todoService.consultarAluno(posicaoLista);
    }

    @PostMapping(value = "/post")
    public void adicionar(@RequestBody Aluno aluno) {
        todoService.adicionarAluno(aluno);
    }

    @PutMapping(value = "/put/{posicaoLista}")
    public void atualizeAluno(@PathVariable Integer posicaoLista, @RequestBody Aluno aluno) {
        todoService.atualizarAluno(posicaoLista, aluno);
    }

    @DeleteMapping(value = "/delete/{posicaoLista}")
    public void deleteAluno(@PathVariable int posicaoLista) {
        todoService.deletarAluno(posicaoLista);
    }
}
