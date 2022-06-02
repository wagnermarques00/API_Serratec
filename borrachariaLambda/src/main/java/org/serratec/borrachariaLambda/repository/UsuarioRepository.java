package org.serratec.borrachariaLambda.repository;

import org.serratec.borrachariaLambda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value="FROM Usuario u WHERE u.loginUsuario = ?1")
    Optional<Usuario> buscarPorLogin(String login);
}
