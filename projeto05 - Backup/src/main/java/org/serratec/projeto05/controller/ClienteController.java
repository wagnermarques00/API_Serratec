package org.serratec.projeto05.controller;

import org.serratec.projeto05.model.Cliente;
import org.serratec.projeto05.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/salvarCliente")
    public ResponseEntity<Void> salvarCliente(@RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return new ResponseEntity<>((HttpStatus.CREATED));
    }

    @GetMapping("/buscarCliente/{idCliente}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer idCliente) {
        return ResponseEntity.ok(clienteService.buscarPorId(idCliente));
    }

    @PutMapping("/atualizarCliente/{idCliente}")
    public ResponseEntity<Void> atualizarCliente(@PathVariable Integer idCliente, @RequestBody Cliente cliente) {
        clienteService.atualizarCliente(idCliente, cliente);
        return new ResponseEntity<>((HttpStatus.ACCEPTED));
    }

    @DeleteMapping(value = "/deletarcliente/{idCliente}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer idCliente) {
        clienteService.deletarCliente(idCliente);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/listarclientes")
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @PostMapping(value = "/salvar-lista")
    public ResponseEntity<Void> salvarLista(@RequestBody List<Cliente> listaCliente) {
        clienteService.salvarTodos(listaCliente);
        return new ResponseEntity<>((HttpStatus.CREATED));
    }
}
