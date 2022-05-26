package org.serratec.backend.projeto08.repository;

import org.serratec.backend.projeto08.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

}
