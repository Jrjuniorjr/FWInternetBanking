package br.com.fwintbank.model;

import br.com.fwintbank.model.Cliente;

public class ContaPoupanca extends Conta{
   public ContaPoupanca(String numero, double saldo, Cliente cliente, ContasEnum tipo){
       super(numero, saldo, cliente, tipo);
   }

   public void renderJuros(double taxa){
       double saldoAtual = consultarSaldo();
       creditar(saldoAtual * taxa);
   }
}
