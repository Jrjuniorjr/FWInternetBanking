package br.com.fwintbank.model;

import br.com.fwintbank.model.Cliente;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class ContaPoupanca extends Conta{
   public ContaPoupanca(String numero, double saldo, Cliente cliente, ContasEnum tipo){
       super(numero, saldo, cliente, tipo);
   }

    public ContaPoupanca() {
        super();
    }

   public void renderJuros(double taxa){
       double saldoAtual = consultarSaldo();
       creditar(saldoAtual * taxa);
   }
}
