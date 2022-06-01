package org.serratec.borrachariaLambda.controller;

import org.serratec.borrachariaLambda.dto.DTOUsuario;
import org.serratec.borrachariaLambda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    //CRUD
    @PostMapping("/salvar")
    public ResponseEntity<String> salvarUsuario(@RequestBody DTOUsuario dtoUsuario) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(dtoUsuario));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DTOUsuario>> listarTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.buscarTodosUsuarios());
    }

    @GetMapping("/buscar/{usuarioID}")
    public ResponseEntity<DTOUsuario> buscarUsuarioPorID(@PathVariable Integer usuarioID) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorID(usuarioID));
    }

    @PutMapping("/atualizar/{usuarioID}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Integer usuarioID, @RequestBody DTOUsuario dtoUsuario) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioID, dtoUsuario));
    }

    @DeleteMapping("/deletar/{usuarioID}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer usuarioID) {
        usuarioService.excluirUsuario(usuarioID);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //Relatórios
}
