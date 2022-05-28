package org.serratec.backend.projeto08.controller;

import org.serratec.backend.projeto08.dto.CartaoDTO;
import org.serratec.backend.projeto08.exception.CartaoException;
import org.serratec.backend.projeto08.exception.EmailException;
import org.serratec.backend.projeto08.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    CartaoService cartaoService;

    //CRUD
    @PostMapping("/salvar")
    public ResponseEntity<String> salvarCartao(@RequestBody CartaoDTO cartaoDTO) throws MessagingException, EmailException {
        return ResponseEntity.ok(cartaoService.salvarCartao(cartaoDTO));
    }

    @GetMapping("/leitor")
    public ResponseEntity<Void> leitor() throws IOException {
        cartaoService.leitor();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/contagem")
    public ResponseEntity<Integer> contarQuantidadeCartoes() {
        return ResponseEntity.ok(cartaoService.contarQuantidadeCartoes());
    }

    @GetMapping("/lista")
    public ResponseEntity<List<CartaoDTO>> buscarTodosCartoes() {
        return ResponseEntity.ok(cartaoService.buscarTodosCartoes());
    }

    @GetMapping("/BUSCAR/{idCartao}")
    public ResponseEntity<CartaoDTO> buscarCartaoPorId(@PathVariable Integer idCartao) throws CartaoException {
        return ResponseEntity.ok(cartaoService.buscarPorId(idCartao));
    }

    @PutMapping("/atualizar/{idCartao}")
    public ResponseEntity<String> atualizarCartao(@PathVariable Integer idCartao, @RequestBody CartaoDTO cartaoDTO) throws CartaoException {
        return ResponseEntity.ok(cartaoService.atualizarCartao(idCartao, cartaoDTO));
    }

    @PostMapping("/salvar-lista")
    public ResponseEntity<Void> salvarLista(@RequestBody List<CartaoDTO> listaCartaoDTO) {
        return new ResponseEntity<>((HttpStatus.CREATED));
    }

    @DeleteMapping("/{idCartao}")
    public ResponseEntity<Void> deletarCartao(@PathVariable Integer idCartao) {
        cartaoService.deletarCartao(idCartao);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
