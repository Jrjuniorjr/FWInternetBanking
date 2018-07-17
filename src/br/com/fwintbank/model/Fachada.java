/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

import br.com.fwintbank.dados.RepositorioClienteArray;
import br.com.fwintbank.dados.RepositorioContasArray;

/**
 *
 * @author Maria Eduarda
 */
public class Fachada {
    private static Fachada instancia;
    private CadCliente cadastroCliente;
    private CadConta cadastroContas;
    
    private Fachada(){
        cadastroCliente = new CadCliente(new RepositorioClienteArray());
        cadastroContas = new CadConta(new RepositorioContasArray());
    }
    
    public static Fachada getInstance(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    
    //OPERAÇÕES DE CONTA
    public void inserirConta(ContaAbstrata conta){
        cadastroContas.inserirConta(conta);
    }
    public void removerConta(String numero){
        cadastroContas.removerConta(numero);
    }
    public ContaAbstrata consultarConta(String numero){
        return cadastroContas.consultarConta(numero);
    }
    public void atualizarConta(ContaAbstrata conta){
        cadastroContas.atualizarConta(conta);
   }
    public void debitar(ContaAbstrata c, double valor){
       cadastroContas.debitar(c, valor);
   }
   public void transferir(ContaAbstrata cOrigem, ContaAbstrata cDestino, double valor){
       cadastroContas.transferir(cOrigem, cDestino, valor);
   }
   public void creditar(ContaAbstrata c, double valor){
       cadastroContas.creditar(c, valor);
   }
    
    //OPERAÇÕES DE CLIENTE
    
    
    
     public void inserirCliente(Cliente cliente){
        cadastroCliente.inserir(cliente);
    }
    public void removerliente(String cpf){
        cadastroCliente.remover(cpf);
    }
    public Cliente consultarCliente(String cpf){
        return cadastroCliente.consultar(cpf);
    }
    
    public void atualizarCliente(Cliente cliente){
        cadastroCliente.atualizar(cliente);
    }
    
}
