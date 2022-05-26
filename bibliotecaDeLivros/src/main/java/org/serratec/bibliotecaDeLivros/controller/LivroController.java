package org.serratec.bibliotecaDeLivros.controller;

import org.serratec.bibliotecaDeLivros.dto.LivroDTO;
import org.serratec.bibliotecaDeLivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarLivro(@RequestBody LivroDTO livroDTO) {
        return ResponseEntity.ok(livroService.salvarLivro(livroDTO));
    }

}
