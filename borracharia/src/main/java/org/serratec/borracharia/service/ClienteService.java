package org.serratec.borracharia.service;

import org.serratec.borracharia.dto.DTOCliente;
import org.serratec.borracharia.model.Cliente;
import org.serratec.borracharia.repository.CarroRepository;
import org.serratec.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {
    //Repositórios
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CarroRepository carroRepository;

    //CRUD


    //Conversores
    public DTOCliente ClienteModelParaDTO(Cliente cliente, DTOCliente clienteDTO) {
        clienteDTO.setClienteId(cliente.getClienteId());
        clienteDTO.setClienteEmail(cliente.getClienteEmail());
        clienteDTO.setClienteNumero(cliente.getClienteNumero());

        clienteDTO.setCarroID(cliente.getCarroID());

        return clienteDTO;
    }

    public Cliente ClienteDTOParaModel(Cliente cliente, DTOCliente clienteDTO) {
        cliente.setClienteId(clienteDTO.getClienteId());
        cliente.setClienteEmail(clienteDTO.getClienteEmail());
        cliente.setClienteNumero(clienteDTO.getClienteNumero());

        cliente.setCarroID(clienteDTO.getCarroID());

        return cliente;
    }
}
