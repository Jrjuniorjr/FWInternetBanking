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
   
   //------------------------------------- C  R  U  D -----------------------------------------------
   public void inserirConta(ContaAbstrata c){
       if(!this.irep.existe(c.getNumero())){
           irep.inserir(c);       
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
   
   public void atualizarConta(ContaAbstrata c){
       if(this.irep.existe(c.getNumero())){
           this.irep.atualizar(c);
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
   
   //----------------------------------  R  N  --------------------------------------------
   
   public void debitar(ContaAbstrata c, double valor){
       c.debitar(valor);
   }
   public void transferir(ContaAbstrata cOrigem, ContaAbstrata cDestino, double valor){
       cOrigem.transferir(cDestino, valor);
   }
   public void creditar(ContaAbstrata c, double valor){
       c.creditar(valor);
   }
   
    
}

