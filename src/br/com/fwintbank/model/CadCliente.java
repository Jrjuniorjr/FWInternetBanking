package br.com.fwintbank.model;

public class CadCliente extends CadGen<Cliente>{
   private IRepCliente irep;
   public CadCliente(IRepCliente i){
       this.irep= i;
   }    
}
