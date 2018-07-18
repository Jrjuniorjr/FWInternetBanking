/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

import br.com.fwintbank.dados.RepositorioClienteArray;
import br.com.fwintbank.dados.RepositorioContasArray;
import br.com.fwintbank.exceptions.*;

/**
 *
 * @author Maria Eduarda
 */
public class Fachada {

    private static Fachada instancia;
    private CadCliente cadastroCliente;
    private CadConta cadastroContas;

    private Fachada() {
        cadastroCliente = new CadCliente(new RepositorioClienteArray());
        cadastroContas = new CadConta(new RepositorioContasArray());
    }

    public static Fachada getInstance() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    //OPERAÇÕES DE CONTA
    public void inserirConta(ContaAbstrata conta) {
        try {
            cadastroContas.inserirConta(conta);
        } catch (ContaExistenteException cee) {
            System.out.println(cee.getMessage());
        }
    }

    public void removerConta(String numero) {
        try {
            cadastroContas.removerConta(numero);
        } catch (ContaNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    }

    public ContaAbstrata consultarConta(String numero) {
        ContaAbstrata conta = null;
        try {
            conta = cadastroContas.consultarConta(numero);
        } catch (ContaNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
        return conta;
    }

    public void atualizarConta(ContaAbstrata conta) {
        try {
            cadastroContas.atualizarConta(conta);
        } catch (ContaNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    }

    public void debitar(ContaAbstrata c, double valor) {
        try {
            cadastroContas.debitar(c, valor);
        } catch (ContaNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (SaldoInsuficienteException sie) {
            System.out.println(sie.getMessage());
        }
    }

    public void transferir(ContaAbstrata cOrigem, ContaAbstrata cDestino, double valor) {
        try {
            cadastroContas.transferir(cOrigem, cDestino, valor);
        } catch (ContaNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (SaldoInsuficienteException sie) {
            System.out.println(sie.getMessage());
        }
    }

    public void creditar(ContaAbstrata c, double valor) {
        try {
            cadastroContas.creditar(c, valor);
        } catch (ContaNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (SaldoInsuficienteException sie) {
            System.out.println(sie.getMessage());
        }
    }

    //OPERAÇÕES DE CLIENTE
    public void inserirCliente(Cliente cliente) {
        try {
            cadastroCliente.inserir(cliente);
        } catch (ClienteExistenteException cee) {
            System.out.println(cee.getMessage());
        }
    }

    public void removerliente(String cpf) {
        try {
            cadastroCliente.remover(cpf);
        } catch (ClienteNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    }

    public Cliente consultarCliente(String cpf) {
        try {
            return cadastroCliente.consultar(cpf);
        } catch (ClienteNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
            return null; // revisar aqui depois
        }
    }

    public void atualizarCliente(Cliente cliente) {
        try {
            cadastroCliente.atualizar(cliente);
        } catch (ClienteNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    }

}
