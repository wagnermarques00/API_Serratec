package org.serratec.backend.projeto06.service;

import org.serratec.backend.projeto06.dto.CartaoDTO;
import org.serratec.backend.projeto06.exception.CartaoException;
import org.serratec.backend.projeto06.model.Cartao;
import org.serratec.backend.projeto06.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository cartaoRepository;

    public CartaoDTO transformarModelEmDTO(Cartao cartao, CartaoDTO cartaoDTO) {
        cartaoDTO.setIdCartao(cartao.getIdCartao());
        cartaoDTO.setDataValidade(cartao.getDataValidade());
        cartaoDTO.setLimiteCartao(cartao.getLimiteCartao());
        cartaoDTO.setNomeTitularCartao(cartao.getNomeTitularCartao());
        cartaoDTO.setNumeroCartao(cartao.getNumeroCartao());

        return cartaoDTO;
    }

    public Cartao transformarDTOEmModel(Cartao cartao, CartaoDTO cartaoDTO) {
        cartao.setIdCartao(cartaoDTO.getIdCartao());
        cartao.setDataValidade(cartaoDTO.getDataValidade());
        cartao.setLimiteCartao(cartaoDTO.getLimiteCartao());
        cartao.setNomeTitularCartao(cartaoDTO.getNomeTitularCartao());
        cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());

        return cartao;
    }

    public String salvarCartao(CartaoDTO cartaoDTO) {
        Cartao cartao = new Cartao();
        transformarDTOEmModel(cartao, cartaoDTO);
        cartaoRepository.save(cartao);
        return "O cartão foi criado com o id: " + cartao.getIdCartao();
    }

    public CartaoDTO buscarPorId(Integer idCartao) throws CartaoException {
        Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
        Cartao cartaoNoBanco = new Cartao();

        CartaoDTO cartaoDTO = new CartaoDTO();
        if (cartao.isPresent()) {
            cartaoNoBanco = cartao.get();
            transformarModelEmDTO(cartaoNoBanco, cartaoDTO);
            return cartaoDTO;
        }
        throw new CartaoException("Cartão com id informado não encontrado");
    }

    public void deletarCartao(Integer idCartao) {
        cartaoRepository.deleteById(idCartao);
    }

    public String atualizarCartao(Integer idCartao, CartaoDTO cartaoDTO) throws CartaoException {
        Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
        Cartao cartaoBanco = new Cartao();
        if (cartao.isPresent()) {
            cartaoBanco = cartao.get();
            if (cartaoDTO.getDataValidade() != null) {
                cartaoDTO.setDataValidade(cartaoDTO.getDataValidade());
            }
            if (cartaoDTO.getLimiteCartao() != null) {
                cartaoDTO.setLimiteCartao(cartaoDTO.getLimiteCartao());
            }
            if (cartaoDTO.getNomeTitularCartao() != null) {
                cartaoDTO.setNomeTitularCartao(cartaoDTO.getNomeTitularCartao());
            }
            if (cartaoDTO.getNumeroCartao() != null) {
                cartaoDTO.setNumeroCartao(cartaoDTO.getNumeroCartao());
            }
            cartaoRepository.save(cartaoBanco);
            return "O cartão com id " + cartaoBanco.getIdCartao() + "foi atualizado";
        }
        throw new CartaoException("O cartão não foi atualizado");
    }

    public List<CartaoDTO> buscarTodosCartoes() {
        List<Cartao> listaCartaoModel = cartaoRepository.findAll();
        List<CartaoDTO> listaCartaoDTO = new ArrayList<>();
        for (Cartao cartao : listaCartaoModel) {
            CartaoDTO cartaoDTO = new CartaoDTO();
            transformarModelEmDTO(cartao, cartaoDTO);
            listaCartaoDTO.add(cartaoDTO);
        }
        return listaCartaoDTO;
    }

    public void salvarListaCartao(List<CartaoDTO> listaCartaoDTO) {
        List<Cartao> listaCartao = new ArrayList<>();

        for (CartaoDTO cartaoDTO : listaCartaoDTO) {
            Cartao cartao = new Cartao();
            transformarDTOEmModel(cartao, cartaoDTO);
            listaCartao.add(cartao);
        }
        cartaoRepository.saveAll(listaCartao);
    }
}
