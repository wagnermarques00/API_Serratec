package org.serratec.borrachariaLambda.controller;

import org.serratec.borrachariaLambda.dto.DTOUsuario;
import org.serratec.borrachariaLambda.security.JwtUtil;
import org.serratec.borrachariaLambda.security.UsuarioAuthenticationRequest;
import org.serratec.borrachariaLambda.security.UsuarioAuthenticationResponse;
import org.serratec.borrachariaLambda.security.UsuarioDetalheService;
import org.serratec.borrachariaLambda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioDetalheService usuarioDetalheService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


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

    @GetMapping("/buscarLogin/{usuarioLogin}")
    public ResponseEntity<DTOUsuario> buscarPorLogin(@PathVariable String usuarioLogin) {
        return ResponseEntity.ok(usuarioService.buscarPorLogin(usuarioLogin));
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

    //Segurança


    @PostMapping("/authenticate")
    public ResponseEntity<?> criarAutenticacao(@RequestBody UsuarioAuthenticationRequest usuario) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
        } catch (Exception e) {
            throw new Exception("Senha incorreta", e);
        }
        UserDetails usuarioDetalhe = usuarioDetalheService.loadUserByUsername(usuario.getUsername());
        String token = jwtUtil.generateToken(usuarioDetalhe);
        return ResponseEntity.ok(new UsuarioAuthenticationResponse(token));
    }

    //Relatórios
}
