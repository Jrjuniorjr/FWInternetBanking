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
    
    public void inserirConta(ContaAbstrata conta){
        cadastroContas.inserirConta(conta);
    }
    public void removerConta(String numero){
        cadastroContas.removerConta(numero);
    }
    public ContaAbstrata consultarConta(String numero){
        cadastroContas.consultarConta(numero);
        cadastroContas.
    }
    public void atualizarConta()
}
