package br.com.fwintbank.model;

import br.com.fwintbank.exceptions.*;


public class CadCliente extends CadGen<Cliente>{
   private IRepCliente irep;
   public CadCliente(IRepCliente i){
       this.irep= i;
   }    
}
