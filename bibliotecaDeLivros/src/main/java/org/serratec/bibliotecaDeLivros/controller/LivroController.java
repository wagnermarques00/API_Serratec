package org.serratec.bibliotecaDeLivros.controller;

import org.serratec.bibliotecaDeLivros.dto.LivroDTO;
import org.serratec.bibliotecaDeLivros.exception.LivroException;
import org.serratec.bibliotecaDeLivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarLivro(@RequestBody LivroDTO livroDTO) {
        return ResponseEntity.ok(livroService.salvarLivro(livroDTO));
    }

    @PostMapping("/salvarTodos")
    public ResponseEntity<Void> salvarTodosLivros(@RequestBody List<LivroDTO> listaLivroDTO) {
        livroService.salvarTodosLivros(listaLivroDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{livroID}")
    public ResponseEntity<LivroDTO> buscarLivroPorId(@PathVariable Integer livroID) throws LivroException {
        return ResponseEntity.ok(livroService.buscarLivroPorId(livroID));
    }

    @GetMapping("buscar/lista")
    public ResponseEntity<List<LivroDTO>> buscarTodosLivros() {
        return ResponseEntity.ok(livroService.buscarTodosLivros());
    }

    @DeleteMapping("/excluir/{livroId}")
    public ResponseEntity<Void> excluirLivro(@PathVariable Integer livroId) {
        livroService.excluirLivro(livroId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/atualizar/{livroId}")
    public ResponseEntity<String> atualizarLivro(@PathVariable Integer livroId, @RequestBody LivroDTO livroDTO) throws LivroException {
        return ResponseEntity.ok(livroService.atualizarLivro(livroId, livroDTO));
    }
}
