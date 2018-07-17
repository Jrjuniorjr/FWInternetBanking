package br.com.fwintbank.model;


public class CadCliente {
   private IRepCliente irep;

   
   public CadCliente(IRepCliente i){
       this.irep= i;
   }
   
   private Cliente criarCliente(String cpf,String nome,TipoCliente tipo,EnderecoCliente endereco){
       return new Cliente(cpf,nome,tipo,endereco);
   }
   
   public void inserir(String cpf,String nome,TipoCliente tipo,EnderecoCliente endereco){
       //inserir um validar CPF
       if(!this.irep.existe(cpf)){
           this.irep.inserir(criarCliente(cpf, nome, tipo, endereco));
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
   
   public void atualizar(String cpf,String nome,TipoCliente tipo,EnderecoCliente endereco){
       if(this.irep.existe(cpf)){
           this.irep.atualizar(criarCliente(cpf, nome, tipo, endereco));
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
