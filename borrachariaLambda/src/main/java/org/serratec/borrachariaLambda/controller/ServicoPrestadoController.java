package org.serratec.borrachariaLambda.controller;

import org.serratec.borrachariaLambda.dto.DTORelatorio;
import org.serratec.borrachariaLambda.dto.DTOServicoPrestado;
import org.serratec.borrachariaLambda.exception.EmailException;
import org.serratec.borrachariaLambda.repository.ServicoPrestadoRepository;
import org.serratec.borrachariaLambda.service.ServicoPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoPrestadoController {

    @Autowired
    ServicoPrestadoService servicoPrestadoService;

    //CRUD
    @PostMapping("/salvar")
    public ResponseEntity<String> salvarServico(@RequestBody DTOServicoPrestado servicoPrestadoDTO) throws MessagingException, EmailException {
        return ResponseEntity.ok(servicoPrestadoService.salvarServicoPrestado(servicoPrestadoDTO));
    }

    @PostMapping("/salvarLista")
    public ResponseEntity<Void> salvarListaServicos(@RequestBody List<DTOServicoPrestado> listaServicoDTO) {
        servicoPrestadoService.salvarListaServicosPrestados(listaServicoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DTOServicoPrestado>> listarTodosServicosPrestados() {
        return ResponseEntity.ok(servicoPrestadoService.buscarTodosServicos());
    }

    @GetMapping("/buscar/{servicoPrestadoID}")
    public ResponseEntity<DTOServicoPrestado> buscarServicoPorID(@PathVariable Integer servicoPrestadoID) {
        return ResponseEntity.ok(servicoPrestadoService.buscarServicoPorID(servicoPrestadoID));
    }

    @PutMapping("/atualizar/{servicoPrestadoID}")
    public ResponseEntity<String> atualizarServico(@PathVariable Integer servicoPrestadoID, @RequestBody DTOServicoPrestado dtoServicoPrestado) {
        return ResponseEntity.ok(servicoPrestadoService.atualizarServicoPrestado(servicoPrestadoID, dtoServicoPrestado));
    }

    @DeleteMapping("/deletar/{servicoPrestadoID}")
    public ResponseEntity<Void> deletarServico(@PathVariable Integer servicoPrestadoID) {
        servicoPrestadoService.excluirServico(servicoPrestadoID);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //Relatórios
    @GetMapping("/relatorio/5ultimosServicos")
    public List<DTORelatorio> relatorio5UltimosServicos() {
        return servicoPrestadoService.relatorio5UltimosServicos();
    }
}
