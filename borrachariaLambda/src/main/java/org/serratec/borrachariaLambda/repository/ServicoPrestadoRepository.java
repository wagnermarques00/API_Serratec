package org.serratec.borrachariaLambda.repository;

import org.serratec.borrachariaLambda.dto.DTORelatorio;
import org.serratec.borrachariaLambda.model.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
    @Query(value =
            "SELECT\n" +
                    "cli.cliente_nome AS clienteNome,\n" +
                    "car.carro_modelo AS carroModelo,\n" +
                    "ser.servico_nome AS servicoNome,\n" +
                    "ser.servico_valor AS servicoValor\n" +
                    "FROM servico ser\n" +
                    "JOIN carro car ON (ser.carro_id = car.carro_id)\n" +
                    "JOIN cliente cli ON (cli.cliente_ID = car.cliente_id)\n" +
                    "ORDER BY ser.servico_id DESC\n" +
                    "LIMIT 5"
            , nativeQuery = true)
    List<DTORelatorio> relatorio5UltimosServicos();
}
