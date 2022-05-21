package org.serratec.projeto05.service;

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

    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Integer idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        //Cliente vazio
        Cliente clienteNoBanco = new Cliente();
        if (cliente.isPresent()) {
            //Cliente vazio recebe cliente do banco
            clienteNoBanco = cliente.get();
        }
        return clienteNoBanco;
    }

    public void atualizarCliente(Integer idCliente, Cliente cliente) {
        Cliente clienteNoBanco = buscarPorId(idCliente);

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
