package org.serratec.borracharia.controller;

import org.serratec.borracharia.dto.DTOCarro;
import org.serratec.borracharia.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroService carroService;

    //CRUD
    @PostMapping("/salvar")
    public ResponseEntity<String> salvarCarro(@RequestBody DTOCarro carroDTO) {
        return ResponseEntity.ok(carroService.salvarCarro(carroDTO));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DTOCarro>> listarTodosCarros() {
        return ResponseEntity.ok(carroService.buscarTodosCarros());
    }

    @GetMapping("/buscar/{carroID}")
    public ResponseEntity<DTOCarro> buscarCarroPorID(@PathVariable Integer carroID) {
        return ResponseEntity.ok(carroService.buscarCarroPorID(carroID));
    }

    @PutMapping("/atualizar/{carroID}")
    public ResponseEntity<String> atualizarCarro(@PathVariable Integer carroID, @RequestBody DTOCarro dtoCarro) {
        return ResponseEntity.ok(carroService.atualizarCarro(carroID, dtoCarro));
    }

    @DeleteMapping("/deletar/{carroID}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Integer carroID) {
        carroService.excluirCarro(carroID);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //Relatórios


}
