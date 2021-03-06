package org.serratec.bibliotecaDeLivros.service;

import org.serratec.bibliotecaDeLivros.dto.LivroDTO;
import org.serratec.bibliotecaDeLivros.exception.LivroException;
import org.serratec.bibliotecaDeLivros.model.Livro;
import org.serratec.bibliotecaDeLivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    //Métodos CRUD
    public String salvarLivro(LivroDTO livroDTO) {
        Livro livro = new Livro();
        converterDTOemModel(livro, livroDTO);
        livroRepository.save(livro);
        return "Livro (" + livro.getLivroId() + ") criado com sucesso.";
    }

    public void salvarTodosLivros(List<LivroDTO> listaLivroDTO) {
        List<Livro> listaLivro = new ArrayList<>();

        for (LivroDTO livroDTO : listaLivroDTO) {
            Livro livro = new Livro();
            converterDTOemModel(livro, livroDTO);
            listaLivro.add(livro);
        }
        livroRepository.saveAll(listaLivro);
    }

    public LivroDTO buscarLivroPorId(Integer livroId) throws LivroException {
        Optional<Livro> livro = livroRepository.findById(livroId);
        Livro livroSalvo = new Livro();
        LivroDTO livroDTO = new LivroDTO();

        if (livro.isPresent()) {
            livroSalvo = livro.get();
            converterModelEmDTO(livroSalvo, livroDTO);
            return livroDTO;
        } else {
            throw new LivroException("Não foi possível localizar o livro com o ID informado");
        }
    }

    public List<LivroDTO> buscarTodosLivros() {
        List<Livro> listaLivroModel = livroRepository.findAll();
        List<LivroDTO> listaLivroDTO = new ArrayList<>();

        for (Livro livro : listaLivroModel) {
            LivroDTO livroDTO = new LivroDTO();
            listaLivroDTO.add(livroDTO);
        }
        return listaLivroDTO;
    }

    public String atualizarLivro(Integer livroId, LivroDTO livroDTO) throws LivroException {
        Optional<Livro> livro = livroRepository.findById(livroId);
        Livro livroSalvo = new Livro();

        if (livro.isPresent()) {
            livroSalvo = livro.get();
            if (livroDTO.getLivroAutor() != null) {
                livroDTO.setLivroAutor(livroDTO.getLivroAutor());
            }
            if (livroDTO.getLivroTipo() != null) {
                livroDTO.setLivroTipo(livroDTO.getLivroTipo());
            }
            if (livroDTO.getLivroTitulo() != null) {
                livroDTO.setLivroTitulo(livroDTO.getLivroTitulo());
            }
            if (livroDTO.getLivroDataPublicacao() != null) {
                livroDTO.setLivroDataPublicacao(livroDTO.getLivroDataPublicacao());
            }
            livroRepository.save(livroSalvo);
            return "O livro " + livroDTO.getLivroId() + "foi atualizado com sucesso";
        }
        throw new LivroException("Livro não cadastrado");
    }

    public void excluirLivro(Integer livroId) {
        livroRepository.deleteById(livroId);
    }

    //Conversões
    public LivroDTO converterModelEmDTO(Livro livro, LivroDTO livroDTO) {
        livroDTO.setLivroId(livro.getLivroId());
        livroDTO.setLivroAutor(livro.getLivroAutor());
        livroDTO.setLivroDataPublicacao(livro.getLivroDataPublicacao());
        livroDTO.setLivroTitulo(livro.getLivroTitulo());
        livroDTO.setLivroTipo(livro.getLivroTipo());

        return livroDTO;
    }

    public Livro converterDTOemModel(Livro livro, LivroDTO livroDTO) {
        livro.setLivroId(livroDTO.getLivroId());
        livro.setLivroAutor(livroDTO.getLivroAutor());
        livro.setLivroDataPublicacao(livroDTO.getLivroDataPublicacao());
        livro.setLivroTitulo(livroDTO.getLivroTitulo());
        livro.setLivroTipo(livroDTO.getLivroTipo());

        return livro;
    }
}
