package org.serratec.borracharia.service;

import org.jetbrains.annotations.NotNull;
import org.serratec.borracharia.dto.DTOServicoPrestado;
import org.serratec.borracharia.model.ServicoPrestado;
import org.serratec.borracharia.repository.CarroRepository;
import org.serratec.borracharia.repository.ServicoPrestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicoPrestadoService {
    //Repositórios
    @Autowired
    ServicoPrestadoRepository servicoPrestadoRepository;

    @Autowired
    CarroRepository carroRepository;

    //CRUD
    public String salvarServicoPrestado(DTOServicoPrestado dtoServicoPrestado) {
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        ServicoDTOParaModel(servicoPrestado, dtoServicoPrestado);
        servicoPrestadoRepository.save(servicoPrestado);

        return "Serviço " + servicoPrestado.getServicoID() + " cadastrado.";
    }

    public void salvarListaServicosPrestados(List<DTOServicoPrestado> dtoListaServico) {
        List<ServicoPrestado> listaServico = new ArrayList<>();

        for (DTOServicoPrestado dtoServicoPrestado : dtoListaServico) {
            ServicoPrestado servicoPrestado = new ServicoPrestado();
            ServicoDTOParaModel(servicoPrestado, dtoServicoPrestado);
            listaServico.add(servicoPrestado);
        }
        servicoPrestadoRepository.saveAll(listaServico);
    }

    public DTOServicoPrestado buscarServicoPorID(Integer servicoID) {
        Optional<ServicoPrestado> servicoPrestado = servicoPrestadoRepository.findById(servicoID);
        ServicoPrestado servicoPrestadoSalvo = new ServicoPrestado();
        DTOServicoPrestado servicoPrestadoDTO = new DTOServicoPrestado();

        if (servicoPrestado.isPresent()) {
            servicoPrestadoSalvo = servicoPrestado.get();
            ServicoModelParaDTO(servicoPrestadoSalvo, servicoPrestadoDTO);
        }
        return servicoPrestadoDTO;
    }

    public List<DTOServicoPrestado> buscarTodosServicos() {
        List<ServicoPrestado> listaServico = servicoPrestadoRepository.findAll();
        List<DTOServicoPrestado> dtoListaServico = new ArrayList<>();

        for (ServicoPrestado servicoPrestado : listaServico) {
            DTOServicoPrestado dtoServicoPrestado = new DTOServicoPrestado();
            ServicoDTOParaModel(servicoPrestado, dtoServicoPrestado);
            dtoListaServico.add(dtoServicoPrestado);
        }
        return dtoListaServico;
    }

    public String atualizarServicoPrestado(Integer servicoPrestadoID, DTOServicoPrestado dtoServicoPrestado) {
        Optional<ServicoPrestado> servicoPrestado = servicoPrestadoRepository.findById(servicoPrestadoID);
        ServicoPrestado servicoSalvo = new ServicoPrestado();
        if (servicoPrestado.isPresent()) {
            servicoSalvo = servicoPrestado.get();

            if (dtoServicoPrestado.getServicoData() != null) {
                dtoServicoPrestado.setServicoData(dtoServicoPrestado.getServicoData());
            }
            if (dtoServicoPrestado.getServicoNome() != null) {
                dtoServicoPrestado.setServicoNome(dtoServicoPrestado.getServicoNome());
            }
            if (dtoServicoPrestado.getServicoValor() != null) {
                dtoServicoPrestado.setServicoValor(dtoServicoPrestado.getServicoValor());
            }
            servicoPrestadoRepository.save(servicoSalvo);
        }
        return "Serviço " + servicoSalvo.getServicoID() + " atualizado com sucesso";
    }

    public void excluirServico(Integer servicoPrestadoID) {
        servicoPrestadoRepository.deleteById(servicoPrestadoID);
    }

    //Métodos auxiliares


    //Conversores
    public DTOServicoPrestado ServicoModelParaDTO(ServicoPrestado servicoPrestado, DTOServicoPrestado servicoPrestadoDTO) {
        servicoPrestadoDTO.setServicoID(servicoPrestado.getServicoID());
        servicoPrestadoDTO.setServicoData(servicoPrestado.getServicoData());
        servicoPrestadoDTO.setServicoNome(servicoPrestado.getServicoNome());
        servicoPrestadoDTO.setServicoValor(servicoPrestado.getServicoValor());

        servicoPrestadoDTO.setCarro(servicoPrestado.getCarro());

        return servicoPrestadoDTO;
    }

    public ServicoPrestado ServicoDTOParaModel(ServicoPrestado servicoPrestado, DTOServicoPrestado servicoPrestadoDTO) {
        servicoPrestado.setServicoID(servicoPrestadoDTO.getServicoID());
        servicoPrestado.setServicoData(servicoPrestadoDTO.getServicoData());
        servicoPrestado.setServicoNome(servicoPrestadoDTO.getServicoNome());
        servicoPrestado.setServicoValor(servicoPrestadoDTO.getServicoValor());

        servicoPrestado.setCarro(servicoPrestadoDTO.getCarro());

        return servicoPrestado;
    }
}
