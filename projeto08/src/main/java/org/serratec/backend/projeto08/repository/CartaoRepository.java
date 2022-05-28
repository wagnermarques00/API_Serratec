package org.serratec.backend.projeto08.repository;

import org.serratec.backend.projeto08.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

    //Modelo de query da forma nativa (igual a que escrevemos no SQL)
    @Query(value = "SELECT * FROM cartao ORDER BY cartao_id DESC", nativeQuery = true)
    List<Cartao> buscarTodosCartoesDesc();

    //Contagem de itens dentro da Query --> Não serve no H2
    @Query(value = "SELECT COUNT(x) FROM cartao x", nativeQuery = true)
    Integer contagemTabela();

    //Contagem de itens dentro da Query --> Serve no H2
    @Query(value = "SELECT COUNT(*) FROM cartao", nativeQuery = true)
    Integer contagemTabelaH2();

    //Modelo HQL (sem usar native Query)
    @Query(value = "SELECT C FROM Cartao C Order By idCartao DESC")
    //                     ⬆ Foi colocado esse C apenas para chamar o Objeto. Pode ser outra coisa
    List<Cartao> buscarTodosCartoesDescHQL();

    //Select que ordena por valor de limite de cartão
    @Query(value = "SELECT * FROM cartao ORDER BY cartao_limite", nativeQuery = true)
    List<Cartao> findByLimiteCartao(Double limiteCartao);


}
