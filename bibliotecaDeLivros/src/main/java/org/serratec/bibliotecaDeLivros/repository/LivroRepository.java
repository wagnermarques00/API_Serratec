package org.serratec.bibliotecaDeLivros.repository;

import org.serratec.bibliotecaDeLivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
