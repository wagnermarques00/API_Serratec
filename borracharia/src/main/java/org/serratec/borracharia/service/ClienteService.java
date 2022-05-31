package org.serratec.borracharia.service;

import org.serratec.borracharia.dto.DTOCliente;
import org.serratec.borracharia.model.Cliente;
import org.serratec.borracharia.repository.CarroRepository;
import org.serratec.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    //Repositórios
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CarroRepository carroRepository;

    //CRUD
    public String salvarCliente(DTOCliente dtoCliente) {
        Cliente cliente = new Cliente();
        ClienteDTOParaModel(cliente, dtoCliente);
        clienteRepository.save(cliente);

        return "Cliente " + cliente.getClienteId() + " cadastrado.";
    }

    public void salvarListaClientes(List<DTOCliente> dtoListaCliente) {
        List<Cliente> listaCliente = new ArrayList<>();

        for (DTOCliente dtoCliente : dtoListaCliente) {
            Cliente cliente = new Cliente();
            ClienteDTOParaModel(cliente, dtoCliente);
            listaCliente.add(cliente);
        }
        clienteRepository.saveAll(listaCliente);
    }

    public DTOCliente buscarClientePorID(Integer clienteID) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteID);
        Cliente clienteSalvo = new Cliente();
        DTOCliente clienteDTO = new DTOCliente();

        if (cliente.isPresent()) {
            clienteSalvo = cliente.get();
            ClienteModelParaDTO(clienteSalvo, clienteDTO);
        }
        return clienteDTO;
    }

    public List<DTOCliente> buscarTodosClientes() {
        List<Cliente> listaCliente = clienteRepository.findAll();
        List<DTOCliente> dtoListaCliente = new ArrayList<>();

        for (Cliente cliente : listaCliente) {
            DTOCliente dtoCliente = new DTOCliente();
            ClienteDTOParaModel(cliente, dtoCliente);
            dtoListaCliente.add(dtoCliente);
        }
        return dtoListaCliente;
    }

    public String atualizarCliente(Integer clienteID, DTOCliente dtoCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteID);
        Cliente clienteSalvo = new Cliente();
        if (cliente.isPresent()) {
            clienteSalvo = cliente.get();

            if(dtoCliente.getClienteNome() != null) {
                clienteSalvo.setClienteNome(dtoCliente.getClienteNome());
            }
            if (dtoCliente.getClienteCPF() != null) {
                clienteSalvo.setClienteCPF(dtoCliente.getClienteCPF());
            }
            if (dtoCliente.getClienteEmail() != null) {
                clienteSalvo.setClienteEmail(dtoCliente.getClienteEmail());
            }
            if (dtoCliente.getClienteNumero() != null) {
                clienteSalvo.setClienteNumero(dtoCliente.getClienteNumero());
            }

            clienteRepository.save(clienteSalvo);
        }
        return "Cliente " + clienteSalvo.getClienteId() + " atualizado com sucesso";
    }

    public void excluirCliente(Integer clienteID) {
        clienteRepository.deleteById(clienteID);
    }

    //Conversores
    public DTOCliente ClienteModelParaDTO(Cliente cliente, DTOCliente clienteDTO) {
        clienteDTO.setClienteId(cliente.getClienteId());
        clienteDTO.setClienteCPF(cliente.getClienteCPF());
        clienteDTO.setClienteNome(cliente.getClienteNome());
        clienteDTO.setClienteEmail(cliente.getClienteEmail());
        clienteDTO.setClienteNumero(cliente.getClienteNumero());

        return clienteDTO;
    }

    public Cliente ClienteDTOParaModel(Cliente cliente, DTOCliente clienteDTO) {
        cliente.setClienteId(clienteDTO.getClienteId());
        cliente.setClienteCPF(clienteDTO.getClienteCPF());
        cliente.setClienteNome(clienteDTO.getClienteNome());
        cliente.setClienteEmail(clienteDTO.getClienteEmail());
        cliente.setClienteNumero(clienteDTO.getClienteNumero());

        return cliente;
    }
}
