package org.serratec.projetoBanco.service;

import org.serratec.projetoBanco.exceptions.ContaException;
import org.serratec.projetoBanco.model.Conta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {
    //Lista
    List<Conta> contaBanco = new ArrayList<>();

    //Métodos de Conta
    public void adicionarConta(Conta numeroConta) {
        contaBanco.add(numeroConta);
    }

    public void deletarConta(int numeroConta) {
        contaBanco.remove(numeroConta);
    }

    public void atualizarConta(Integer numeroConta, Conta contaAPI) {
        Conta attConta = contaBanco.get(numeroConta);

        attConta.setNumero(contaAPI.getNumero());
        attConta.setTitular(contaAPI.getTitular());
    }

    public List<Conta> listarTodasContas() {
        return this.contaBanco;
    }

    public Conta listarContaPorId(Integer idConta) {
        Conta contaAPI = new Conta();
        for (Conta conta : contaBanco) {
            if (conta.getNumero().equals(idConta)) {
                contaAPI = conta;
            }
        }
        return contaAPI;
    }


    //Métodos de Operação
    public void creditarConta(Integer idConta, Double valorCredito) {
        Conta contaUtilizada = contaBanco.get(idConta);
        contaUtilizada.setSaldo(contaUtilizada.getSaldo() + valorCredito);
    }

    public void debitarConta(Integer idConta, Double valorDebito) throws ContaException {
        Conta contaUtilizada = contaBanco.get(idConta);
        if (contaUtilizada.getSaldo() >= valorDebito) {
            contaUtilizada.setSaldo(contaUtilizada.getSaldo() - valorDebito);
            System.out.println("Valor depositado");
        } else {
            throw new ContaException(idConta);
        }
    }
}
