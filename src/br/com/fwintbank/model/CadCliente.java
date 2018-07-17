package br.com.fwintbank.model;


public class CadCliente {
   private IRepCliente irep;

   
   public CadCliente(IRepCliente i){
       this.irep= i;
   }
   
   
   public void inserir(Cliente c){
       //inserir um validar CPF
       if(!this.irep.existe(c.getCpf())){
           this.irep.inserir(c);
       }else{
           System.out.println("CPF já cadastrado!");
       }
   }
   
   public void remover(String cpf){
       if(this.irep.existe(cpf)){
           this.irep.remover(cpf);
       }else{
           System.out.println("Cliente não encontrado!");
       }
   }
   
   public void atualizar(Cliente c){
       if(this.irep.existe(c.getCpf())){
           this.irep.atualizar(c);
       }else{
           System.out.println("Cliente não encontrado!");
       }
   }
   public Cliente consultar(String cpf){
       if(this.irep.existe(cpf)){
           return this.irep.procurar(cpf);
       }else{
           System.out.println("Cliente não encontrado!");
           return null;
       }
   }
    
}
