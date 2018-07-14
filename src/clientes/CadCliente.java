package clientes;


public class CadCliente {
   private IRepCliente irep;

   
   public CadCliente(IRepCliente i){
       this.irep= i;
   }
   
   public void inserir(Cliente c){
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
       Cliente c=null;
       if(this.irep.existe(cpf)){
           c= this.irep.procurar(cpf);
       }else{
           System.out.println("Cliente não encontrado!");
       }
       return c;
   }
    
}
