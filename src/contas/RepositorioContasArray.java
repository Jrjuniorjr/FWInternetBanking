package contas;

public class RepositorioContasArray implements IRepContas {
   private int tamCacheContas;
   private ContaAbstrata contas[];
   private int indice;
   
   public RepositorioContasArray(){
       tamCacheContas = 100;
       contas = new ContaAbstrata[tamCacheContas];
       indice = 0;
   }
   public void inserir(ContaAbstrata conta){
       if(indice < tamCacheContas){
       	 this.contas[indice] = conta;
            indice++;
       }
       else {
       System.out.println("Vetor cheio");
       }
   }
   public void atualizar(ContaAbstrata conta){
	if(existe(conta.getNumero())) {
	int indice = procurarIndice(conta.getNumero());
	if(indice != -1){
		contas[indice] = conta;
	}
	}
	else {
		System.out.println("contas.Conta nao existe.");
	}
       
   }
   private int procurarIndice(String numeroConta) {
       for (int i = 0; i < tamCacheContas; i++) {
           if (contas[i] == null) {
               break;
           } else if (contas[i].getNumero().equals(numeroConta)) {
               return i;
           }
       }
       return -1;
   }

   public void remover(String numeroConta) {
	   if(existe(numeroConta)) {
		   int i = procurarIndice(numeroConta);
		   contas[i] = contas[indice-1];
		   contas[indice-1] = null;
		   indice = indice - 1;
	   }
	   else {
		   System.out.println("contas.Conta nao existe.");

	   }

   }
   public boolean existe(String numeroConta) {
   	for(int i=0;i<tamCacheContas;i++) {
   		if(numeroConta.equals(contas[i].getNumero())) {
   			return true;
   		}
   	}
   	return false;  	
   }
   
   public ContaAbstrata procurar(String numeroConta) {
   	for(int i=0;i<tamCacheContas;i++) {
   		if(numeroConta.equals(contas[i].getNumero())) {
   			return contas[i];
   		}
   	}
   	return null; 
   }
   
   
}
   