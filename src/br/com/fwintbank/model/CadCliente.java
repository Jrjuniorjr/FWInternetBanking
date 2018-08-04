package br.com.fwintbank.model;

public class CadCliente extends CadGen<Cliente>{
   private IRepCliente repositorio;
   public CadCliente(IRepCliente i){
       super(i);
       this.repositorio= i;
   }    
}
