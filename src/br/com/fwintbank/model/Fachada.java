
package br.com.fwintbank.model;

import br.com.fwintbank.dados.*;
import br.com.fwintbank.exceptions.*;


public class Fachada {

    private static Fachada instancia;
    private CadCliente cadastroCliente;
    private CadConta cadastroContas;

    
    private Fachada(){
        cadastroCliente = new CadCliente(new RepositorioClienteTreeSet());
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
        cadastroCliente.inserir(cliente);
    }

    public void removerliente(Cliente c) throws Exception {
        cadastroCliente.remover(c);      
    }

    public Cliente consultarCliente(String cpf) throws Exception {
        return cadastroCliente.consultar(cpf);  
    }

    public void atualizarCliente(Cliente cliente) throws Exception{
        cadastroCliente.atualizar(cliente);
    }

}
