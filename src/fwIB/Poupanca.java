package fwIB;

/**
*
* @author Jrjuniorjr
*/
public class Poupanca extends Conta{
   public Poupanca(String numero, double saldo){
       super(numero, saldo);
   }

   public void renderJuros(double taxa){
       double saldoAtual = consultarSaldo();
       creditar(saldoAtual * taxa);
   }
}
