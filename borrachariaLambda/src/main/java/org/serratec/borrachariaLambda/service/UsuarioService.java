package org.serratec.borrachariaLambda.service;

import org.serratec.borrachariaLambda.dto.DTOUsuario;
import org.serratec.borrachariaLambda.model.Usuario;
import org.serratec.borrachariaLambda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    //CRUD
    public String salvarUsuario(DTOUsuario dtoUsuario) {
        Usuario usuario = new Usuario();
        UsuarioDTOParaModel(usuario, dtoUsuario);

        usuarioRepository.save(usuario);

        return "Usuario " + usuario.getUsuarioId() + " cadastrado.";
    }

    public void salvarListaUsuarios(List<DTOUsuario> dtoListaUsuario) {
        List<Usuario> listaUsuario = new ArrayList<>();

        for (DTOUsuario dtoUsuario : dtoListaUsuario) {
            Usuario usuario = new Usuario();
            UsuarioDTOParaModel(usuario, dtoUsuario);
            listaUsuario.add(usuario);

        }
        usuarioRepository.saveAll(listaUsuario);
    }

    public DTOUsuario buscarUsuarioPorID(Integer usuarioID) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioID);
        Usuario usuarioSalvo = new Usuario();
        DTOUsuario usuarioDTO = new DTOUsuario();

        if (usuario.isPresent()) {
            usuarioSalvo = usuario.get();
            UsuarioModelParaDTO(usuarioSalvo, usuarioDTO);

        }
        return usuarioDTO;
    }

    public DTOUsuario buscarPorLogin(String login) {
        return usuarioRepository.findAll()
                .stream()
                .filter(usuario -> usuario.getLoginUsuario().equals(login))
                .map(usuario -> UsuarioModelParaDTO(usuario, new DTOUsuario()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<DTOUsuario> buscarTodosUsuarios() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        List<DTOUsuario> dtoListaUsuario = new ArrayList<>();

        for (Usuario usuario : listaUsuario) {
            DTOUsuario dtoUsuario = new DTOUsuario();
            UsuarioDTOParaModel(usuario, dtoUsuario);
            dtoListaUsuario.add(dtoUsuario);

        }
        return dtoListaUsuario;
    }

    public String atualizarUsuario(Integer usuarioID, DTOUsuario dtoUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioID);
        Usuario usuarioSalvo = new Usuario();

        if (usuario.isPresent()) {
            usuarioSalvo = usuario.get();

            if (dtoUsuario.getUsuarioId() != null) {
                usuarioSalvo.setUsuarioId(dtoUsuario.getUsuarioId());
            }
            if (dtoUsuario.getLoginUsuario() != null) {
                usuarioSalvo.setLoginUsuario(dtoUsuario.getLoginUsuario());
            }
            if (dtoUsuario.getSenhaUsuario() != null) {
                usuarioSalvo.setSenhaUsuario(dtoUsuario.getSenhaUsuario());
            }
            usuarioRepository.save(usuarioSalvo);
        }
        return "Usuario " + usuarioSalvo.getUsuarioId() + " atualizado com sucesso";
    }

    public void excluirUsuario(Integer usuarioID) {
        usuarioRepository.deleteById(usuarioID);
    }

    //Conversores
    public DTOUsuario UsuarioModelParaDTO(Usuario usuario, DTOUsuario dtoUsuario) {
        dtoUsuario.setUsuarioId(usuario.getUsuarioId());
        dtoUsuario.setLoginUsuario(usuario.getLoginUsuario());
        dtoUsuario.setSenhaUsuario(usuario.getSenhaUsuario());

        return dtoUsuario;
    }

    public Usuario UsuarioDTOParaModel(Usuario usuario, DTOUsuario dtoUsuario) {
        usuario.setUsuarioId(dtoUsuario.getUsuarioId());
        usuario.setLoginUsuario(dtoUsuario.getLoginUsuario());
        usuario.setSenhaUsuario(encoder.encode(dtoUsuario.getSenhaUsuario()));

        return usuario;
    }
}
