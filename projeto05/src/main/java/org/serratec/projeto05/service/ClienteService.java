package org.serratec.projeto05.service;

import org.serratec.projeto05.dto.ClienteDTO;
import org.serratec.projeto05.model.Cliente;
import org.serratec.projeto05.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente transformarClienteEmClienteDTO(Cliente clienteDTO, Cliente cliente) {

//      clienteDTO.setIdCliente(cliente.getIdCliente()); --> não setamos o ID pois o mesmo é automático na classe


        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setNome(clienteDTO.getNome());
        cliente.setNumeroTelefone(clienteDTO.getNumeroTelefone());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());

        return cliente;

    }

    public void salvarCliente(ClienteDTO clienteDTO) {
        //clienteDTO possui os dados
        Cliente cliente = new Cliente();
        Cliente clienteSalvar = transformarClienteEmClienteDTO(clienteDTO, cliente);
        clienteRepository.save(clienteSalvar);
    }

    public ClienteDTO buscarPorId(Integer idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        //Cliente vazio
        Cliente clienteNoBanco = new Cliente();
        //Cliente DTO vazio
        Cliente clienteDTO = new Cliente();

        if (cliente.isPresent()) {
            //Cliente vazio recebe cliente do banco
            clienteNoBanco = cliente.get();
            clienteDTO = transformarClienteEmClienteDTO(clienteDTO, clienteNoBanco);
        }
        return clienteDTO;
    }

    public void atualizarCliente(Integer idCliente, ClienteDTO clienteDTO) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        Cliente clienteNoBanco = new Cliente();

        if (cliente.isPresent()) {
            clienteNoBanco = cliente.get();
            if (cliente.getCpf() != null) {
                clienteNoBanco.setCpf(cliente.getCpf());
            }
            if (cliente.getDataNascimento() != null) {
                clienteNoBanco.setDataNascimento(cliente.getDataNascimento());
            }
            if (cliente.getEmail() != null) {
                clienteNoBanco.setEmail(cliente.getEmail());
            }
            if (cliente.getNome() != null) {
                clienteNoBanco.setNome(cliente.getNome());
            }
            if (cliente.getNumeroTelefone() != null) {
                clienteNoBanco.setNumeroTelefone(cliente.getNumeroTelefone());
            }
        }
    }

    public void deletarCliente(Integer idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public void salvarTodos(List<Cliente> listaCliente) {
        clienteRepository.saveAll(listaCliente);
    }
}
