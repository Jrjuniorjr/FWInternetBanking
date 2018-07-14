package contas;

public class RepositorioContasArray {
   private int tamCacheContas;
   private Conta contas[];
   private int indice;
   
   public RepositorioContasArray(){
       tamCacheContas = 100;
       contas = new Conta[tamCacheContas];
       indice = 0;
   }
   public void inserirConta(Conta conta){
       if(indice < tamCacheContas){
       	 this.contas[indice] = conta;
            indice++;
       }
       else {
       System.out.println("Vetor cheio");
       }
   }
   public void atualizarConta(Conta conta){
	if(existeConta(conta.getNumero())) {
	int indice = procurarIndice(conta.getNumero());
	if(indice != -1){
		contas[indice] = conta;
	}
	}
	else {
		System.out.println("contas.Conta n�o existe.");
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

   public void removerConta(String numeroConta) {
	   if(existeConta(numeroConta)) {
		   int i = procurarIndice(numeroConta);
		   contas[i] = contas[indice-1];
		   contas[indice-1] = null;
		   indice = indice - 1;
	   }
	   else {
		   System.out.println("contas.Conta n�o existe.");

	   }

   }
   public boolean existeConta(String numeroConta) {
   	for(int i=0;i<tamCacheContas;i++) {
   		if(numeroConta.equals(contas[i].getNumero())) {
   			return true;
   		}
   	}
   	return false;  	
   }
   
   public Conta procurarConta(String numeroConta) {
   	for(int i=0;i<tamCacheContas;i++) {
   		if(numeroConta.equals(contas[i].getNumero())) {
   			return contas[i];
   		}
   	}
   	return null; 
   }
   
   
}
   