package org.serratec.projetoBanco.repository;

import org.serratec.projetoBanco.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository {
    List<Conta> findById(Integer idConta);
}
