package contas;

import clientes.Cliente;

public class ContaPoupanca extends Conta{
   public ContaPoupanca(String numero, double saldo, Cliente cliente){
       super(numero, saldo, cliente);
   }

   public void renderJuros(double taxa){
       double saldoAtual = consultarSaldo();
       creditar(saldoAtual * taxa);
   }
}
