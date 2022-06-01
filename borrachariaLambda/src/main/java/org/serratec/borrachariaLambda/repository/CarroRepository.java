package org.serratec.borrachariaLambda.repository;

import org.serratec.borrachariaLambda.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
}
