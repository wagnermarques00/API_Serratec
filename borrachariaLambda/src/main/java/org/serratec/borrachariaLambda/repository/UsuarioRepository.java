package org.serratec.borrachariaLambda.repository;

import org.serratec.borrachariaLambda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
