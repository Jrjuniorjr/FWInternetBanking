package contas;

import clientes.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felix
 */
public class CadConta {
   private IRepContas irep;
   ContaAbstrata a; 

   
   public CadConta (IRepContas i){
       this.irep= i;
   }
   
   public void inserirConta(String numero, double saldo, Cliente cliente, ContasEnum tipo){
       if(!this.irep.existe(numero)){
           irep.inserir(defineConta(numero,saldo,cliente,tipo));       
       }else{
           System.out.println("conta já cadastrada");
       }
   }
   
   public void removerConta(String numero){
       if(this.irep.existe(numero)){
           this.irep.remover(numero);
       }else{
           System.out.println("Conta não encontrada");
       }
   }
   
   public void atualizarConta(String numero, double saldo, Cliente cliente, ContasEnum tipo){
       if(this.irep.existe(numero)){
           this.irep.atualizar(defineConta(numero,saldo,cliente,tipo));
       }else{
           System.out.println("conta não encontrada!");
       }
   }
   public ContaAbstrata consultarConta(String numero){
       ContaAbstrata c=null;
       if(this.irep.existe(numero)){
           c= this.irep.procurar(numero);
       }else{
           System.out.println("conta não encontrada");
       }
       return c;
   }
   
   private ContaAbstrata defineConta(String numero, double saldo, Cliente cliente, ContasEnum tipo){
       
       if(tipo == ContasEnum.BONIFICADA){
           return new ContaBonificada(numero, saldo, cliente);
       }
       if(tipo == ContasEnum.IMPOSTO){
           return new ContaImposto(numero, saldo, cliente);
       }
       if(tipo == ContasEnum.POLPANCA){
           return new ContaPoupanca(numero, saldo, cliente);
       }
       return null;
   }
    
}

