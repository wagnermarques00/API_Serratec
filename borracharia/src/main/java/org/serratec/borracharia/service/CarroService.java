package org.serratec.borracharia.service;

import org.serratec.borracharia.dto.DTOCarro;
import org.serratec.borracharia.model.Carro;
import org.serratec.borracharia.repository.CarroRepository;
import org.serratec.borracharia.repository.ClienteRepository;
import org.serratec.borracharia.repository.ServicoPrestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarroService {
    //Repositórios
    @Autowired
    CarroRepository carroRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ServicoPrestadoRepository servicoPrestadoRepository;

    //CRUD
    public String salvarCarro(DTOCarro dtoCarro) {
        Carro carro = new Carro();
        CarroDTOParaModel(carro, dtoCarro);
        carroRepository.save(carro);

        return "Carro " + carro.getCarroId() + " cadastrado.";
    }

    public void salvarListaCarros(List<DTOCarro> dtoListaCarro) {
        List<Carro> listaCarro = new ArrayList<>();

        for (DTOCarro dtoCarro : dtoListaCarro) {
            Carro carro = new Carro();
            CarroDTOParaModel(carro, dtoCarro);
            listaCarro.add(carro);
        }
        carroRepository.saveAll(listaCarro);
    }

    public DTOCarro buscarCarroPorID(Integer carroID) {
        Optional<Carro> carro = carroRepository.findById(carroID);
        Carro carroSalvo = new Carro();
        DTOCarro carroDTO = new DTOCarro();

        if (carro.isPresent()) {
            carroSalvo = carro.get();
            CarroModelParaDTO(carroSalvo, carroDTO);
        }
        return carroDTO;
    }

    public List<DTOCarro> buscarTodosCarros() {
        List<Carro> listaCarro = carroRepository.findAll();
        List<DTOCarro> dtoListaCarro = new ArrayList<>();

        for (Carro carro : listaCarro) {
            DTOCarro dtoCarro = new DTOCarro();
            CarroDTOParaModel(carro, dtoCarro);
            dtoListaCarro.add(dtoCarro);
        }
        return dtoListaCarro;
    }

    public String atualizarCarro(Integer carroID, DTOCarro dtoCarro) {
        Optional<Carro> carro = carroRepository.findById(carroID);
        Carro carroSalvo = new Carro();
        if (carro.isPresent()) {
            carroSalvo = carro.get();

            if (dtoCarro.getCarroAno() != null) {
                dtoCarro.setCarroAno(dtoCarro.getCarroAno());
            }
            if (dtoCarro.getCarroMarca() != null) {
                dtoCarro.setCarroMarca(dtoCarro.getCarroMarca());
            }
            if (dtoCarro.getCarroModelo() != null) {
                dtoCarro.setCarroModelo(dtoCarro.getCarroModelo());
            }

            carroRepository.save(carroSalvo);
        }
        return "Carro " + carroSalvo.getCarroId() + " atualizado com sucesso";
    }

    public void excluirCarro(Integer carroID) {
        carroRepository.deleteById(carroID);
    }

    //Conversores
    public DTOCarro CarroModelParaDTO(Carro carro, DTOCarro carroDTO) {
        carroDTO.setCarroId(carro.getCarroId());
        carroDTO.setCarroAno(carro.getCarroAno());
        carroDTO.setCarroMarca(carro.getCarroMarca());
        carroDTO.setCarroModelo(carro.getCarroModelo());

        carroDTO.setClienteID(carro.getClienteID());
        carroDTO.setServicoID(carro.getServicoID());

        return carroDTO;
    }

    public Carro CarroDTOParaModel(Carro carro, DTOCarro carroDTO) {
        carro.setCarroId(carroDTO.getCarroId());
        carro.setCarroAno(carroDTO.getCarroAno());
        carro.setCarroMarca(carroDTO.getCarroMarca());
        carro.setCarroModelo(carroDTO.getCarroModelo());

        carro.setClienteID(carroDTO.getClienteID());
        carro.setServicoID(carroDTO.getServicoID());

        return carro;
    }
}
