
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
    public void inserirConta(ContaAbstrata conta) throws Exception{
        cadastroContas.inserir(conta); 
    }

    public void removerConta(ContaAbstrata conta) throws Exception {
        cadastroContas.remover(conta);
    }

    public ContaAbstrata consultarConta(String numero)throws Exception {
        return cadastroContas.consultar(numero);
    }

    public void atualizarConta(ContaAbstrata conta) throws Exception {
        cadastroContas.atualizar(conta);
    }

    public void debitar(String numeroConta, double valor) throws Exception {
        cadastroContas.debitar(numeroConta, valor);
    }

    public void transferir(String NumeroContaOrigem, String  NumeroContaDestino, double valor) throws Exception {
        cadastroContas.transferir(NumeroContaOrigem, NumeroContaDestino, valor);
    }

    public void creditar(String numeroConta, double valor) throws Exception{
        cadastroContas.creditar(numeroConta, valor);
    }

    //OPERAÇÕES DE CLIENTE
    public void inserirCliente(Cliente cliente) throws Exception{
        cadastroCliente.inserir(cliente);
    }

    public void removerliente(Cliente cliente) throws Exception {
        cadastroCliente.remover(cliente);      
    }

    public Cliente consultarCliente(String cpf) throws Exception {
        return cadastroCliente.consultar(cpf);  
    }

    public void atualizarCliente(Cliente cliente) throws Exception{
        cadastroCliente.atualizar(cliente);
    }

}
