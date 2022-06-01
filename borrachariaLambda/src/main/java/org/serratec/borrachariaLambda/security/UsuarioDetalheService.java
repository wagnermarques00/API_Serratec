package org.serratec.borrachariaLambda.security;

import org.serratec.borrachariaLambda.model.Usuario;
import org.serratec.borrachariaLambda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioDetalheService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("wagner", "wagner", new ArrayList<>());
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Usuario> usuario = usuarioRepository.buscarPorLogin(username);
//
//        if (usuario.isPresent()) {
//            Usuario u = usuario.get();
//            return new User(u.getLoginUsuario(), u.getSenhaUsuario(), new ArrayList<>());
//        }
//    }
}
