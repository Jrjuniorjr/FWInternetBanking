package fwIB;

/**
*
* @author Jrjuniorjr
*/
public class RepositorioContasArray {
   private int tamCacheContas;
   private Conta contas[];
   private int indice;
   
   public RepositorioContasArray(){
       contas = new Conta[100];
       tamCacheContas = 100;
       indice = 0;
   }
   public void inserir(Conta conta){
       if(indice < tamCacheContas){
       	 this.contas[indice] = conta;
            indice++;
       }
       System.out.println("Vetor cheio");
   }
   public void atualizar(Conta conta){
	int indice = procurarIndice(conta);
	if(indice != -1){
		contas[indice] = conta;
	}
       
   }
   public int procurarIndice(Conta conta) {
       for (int i = 0; i < tamCacheContas; i++) {
           if (contas[i] == null) {
               System.out.println("Não encontrou a conta");
               break;
           } else if (contas[i].getNumero().equals(conta.getNumero())) {
               return i;
           }
       }
       return -1;
   }

   public void remover(Conta conta) {
       boolean removeu = false;
       for (int i = 0; i < indice; i++) {

           if (removeu == false) {
               if (contas[i] == null) {
                   System.out.println("Não encontrou a conta");
                   break;
               } else if (contas[i].getNumero().equals(conta.getNumero())) {
                   removeu = true;
                   if(i == tamCacheContas - 1){
                       contas[i]= null;
                   }
                   else{
                       contas[i] = contas[i+1];
                   }
               }
           }
           else{
               contas[i] = contas[i+1];
           }
       }
   }
}
   