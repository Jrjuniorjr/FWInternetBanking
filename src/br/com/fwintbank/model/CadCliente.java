package br.com.fwintbank.model;

import br.com.fwintbank.exceptions.*;


public class CadCliente {
   private IRepCliente irep;

   
   public CadCliente(IRepCliente i){
       this.irep= i;
   }
   
   
   public void inserir(Cliente c) throws ClienteExistenteException{
       //inserir um validar CPF
       if(!this.irep.existe(c.getCpf())){
           this.irep.inserir(c);
       }else{
           ClienteExistenteException cee = new ClienteExistenteException();
           throw cee;
       }
   }
   
   public void remover(String cpf) throws ClienteNotFoundException{
       if(this.irep.existe(cpf)){
           this.irep.remover(cpf);
       }else{
           ClienteNotFoundException cnfe = new ClienteNotFoundException();
           throw cnfe;
       }
   }
   
   public void atualizar(Cliente c) throws ClienteNotFoundException{
       if(this.irep.existe(c.getCpf())){
           this.irep.atualizar(c);
       }else{
           ClienteNotFoundException cnfe = new ClienteNotFoundException();
           throw cnfe;
       }
   }
   public Cliente consultar(String cpf) throws ClienteNotFoundException{
       if(this.irep.existe(cpf)){
           return this.irep.procurar(cpf);
       }else{
           ClienteNotFoundException cnfe = new ClienteNotFoundException();
           throw cnfe;
       }
   }
    
}
