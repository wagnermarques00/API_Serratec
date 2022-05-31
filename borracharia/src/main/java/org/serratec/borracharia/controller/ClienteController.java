package org.serratec.borracharia.controller;

import org.serratec.borracharia.dto.DTOCarro;
import org.serratec.borracharia.dto.DTOCliente;
import org.serratec.borracharia.service.CarroService;
import org.serratec.borracharia.service.ClienteService;
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

    //CRUD
    @PostMapping("/salvar")
    public ResponseEntity<String> salvarCliente(@RequestBody DTOCliente clienteDTO) {
        return ResponseEntity.ok(clienteService.salvarCliente(clienteDTO));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DTOCliente>> listarTodosCliente() {
        return ResponseEntity.ok(clienteService.buscarTodosClientes());
    }

    @GetMapping("/buscar/{clienteID}")
    public ResponseEntity<DTOCliente> buscarClientePorID(@PathVariable Integer clienteID) {
        return ResponseEntity.ok(clienteService.buscarClientePorID(clienteID));
    }

    @PutMapping("/atualizar/{clienteID}")
    public ResponseEntity<String> atualizarCliente(@PathVariable Integer clienteID, @RequestBody DTOCliente dtoCliente) {
        return ResponseEntity.ok(clienteService.atualizarCliente(clienteID, dtoCliente));
    }

    @DeleteMapping("/deletar/{clienteID}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer clienteID) {
        clienteService.excluirCliente(clienteID);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //Relatórios


}
