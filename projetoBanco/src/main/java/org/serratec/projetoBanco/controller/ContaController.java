package org.serratec.projetoBanco.controller;

import org.serratec.projetoBanco.exceptions.ContaException;
import org.serratec.projetoBanco.model.Conta;
import org.serratec.projetoBanco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    //Listar todas as contas
    @GetMapping(value = "")
    public List<Conta> listaCliente() {
        return contaService.listarTodasContas();
    }

    //Listar somente uma conta
    @GetMapping("/{idConta}")
    public ResponseEntity<Conta> buscarClientePorId(@PathVariable Integer idConta) {
        return ResponseEntity.ok(contaService.listarContaPorId(idConta));
    }

    //Insere uma nova conta
    @PostMapping(value = "")
    public ResponseEntity<Void> adicionarConta(@RequestBody Conta conta) {
        contaService.adicionarConta(conta);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Remove uma conta existente
    @DeleteMapping(value = "/{idConta}")
    public ResponseEntity<Void> deletarConta(@PathVariable int idConta) {
        contaService.deletarConta(idConta);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    //Atualiza uma conta
    @PutMapping(value = "/{idConta}")
    public ResponseEntity<Void> atualizarConta(@PathVariable Integer idConta, @RequestBody Conta conta) {
        contaService.atualizarConta(idConta, conta);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //Credita um valor na conta
    @PutMapping(value = "/{idConta}/credito/{valorOperacao}")
    public ResponseEntity<Void> creditarConta(@PathVariable Integer idConta, @PathVariable Double valorOperacao) {
        contaService.creditarConta(idConta, valorOperacao);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //Debita um valor na conta
    @PutMapping(value = "/{idConta}/debito/{valorOperacao}")
    public ResponseEntity<Void> debitarConta(@PathVariable Integer idConta, @PathVariable Double valorOperacao) throws ContaException {
        contaService.debitarConta(idConta, valorOperacao);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
