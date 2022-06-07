package org.serratec.borrachariaLambda.service;

import org.serratec.borrachariaLambda.dto.DTOCarro;
import org.serratec.borrachariaLambda.dto.DTORelatorio;
import org.serratec.borrachariaLambda.dto.DTOServicoPrestado;
import org.serratec.borrachariaLambda.exception.EmailException;
import org.serratec.borrachariaLambda.model.ServicoPrestado;
import org.serratec.borrachariaLambda.repository.CarroRepository;
import org.serratec.borrachariaLambda.repository.ServicoPrestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoPrestadoService {
    //Repositórios
    @Autowired
    ServicoPrestadoRepository servicoPrestadoRepository;

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    EmailService emailService;

    //CRUD
    public String salvarServicoPrestado(DTOServicoPrestado dtoServicoPrestado) throws MessagingException, EmailException {
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        ServicoDTOParaModel(servicoPrestado, dtoServicoPrestado);
        servicoPrestadoRepository.save(servicoPrestado);
        DTOCarro dtoCarro = new DTOCarro();

        emailService.emailServicoPrestado(dtoServicoPrestado.getServicoValor(), dtoServicoPrestado.getServicoNome(), dtoServicoPrestado.getServicoData(), dtoServicoPrestado.getCarroID(), dtoCarro.getCarroModelo(), dtoCarro.getCarroMarca(), dtoCarro.getCarroAno());
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
                servicoSalvo.setServicoData(dtoServicoPrestado.getServicoData());
            }
            if (dtoServicoPrestado.getServicoNome() != null) {
                servicoSalvo.setServicoNome(dtoServicoPrestado.getServicoNome());
            }
            if (dtoServicoPrestado.getServicoValor() != null) {
                servicoSalvo.setServicoValor(dtoServicoPrestado.getServicoValor());
            }
            if (dtoServicoPrestado.getCarroID() != null) {
                servicoSalvo.setCarro(carroRepository.findById(dtoServicoPrestado.getCarroID()).get());
            }
            servicoPrestadoRepository.save(servicoSalvo);
        }
        return "Serviço " + servicoSalvo.getServicoID() + " atualizado com sucesso";
    }

    public void excluirServico(Integer servicoPrestadoID) {
        servicoPrestadoRepository.deleteById(servicoPrestadoID);
    }

    //Relatórios
    public List<DTORelatorio> relatorio5UltimosServicos() {
        return servicoPrestadoRepository.relatorio5UltimosServicos();
    }

    //Conversores
    public DTOServicoPrestado ServicoModelParaDTO(ServicoPrestado servicoPrestado, DTOServicoPrestado servicoPrestadoDTO) {
        servicoPrestadoDTO.setServicoID(servicoPrestado.getServicoID());
        servicoPrestadoDTO.setServicoData(servicoPrestado.getServicoData());
        servicoPrestadoDTO.setServicoNome(servicoPrestado.getServicoNome());
        servicoPrestadoDTO.setServicoValor(servicoPrestado.getServicoValor());

        servicoPrestadoDTO.setCarroID(servicoPrestado.getCarro().getCarroId());

        return servicoPrestadoDTO;
    }

    public ServicoPrestado ServicoDTOParaModel(ServicoPrestado servicoPrestado, DTOServicoPrestado servicoPrestadoDTO) {
        servicoPrestado.setServicoID(servicoPrestadoDTO.getServicoID());
        servicoPrestado.setServicoData(servicoPrestadoDTO.getServicoData());
        servicoPrestado.setServicoNome(servicoPrestadoDTO.getServicoNome());
        servicoPrestado.setServicoValor(servicoPrestadoDTO.getServicoValor());

        servicoPrestado.setCarro(carroRepository.findById(servicoPrestadoDTO.getCarroID()).get());

        return servicoPrestado;
    }
}
