package br.com.fwintbank.model;

import br.com.fwintbank.exceptions.SaldoInsuficienteException;
import br.com.fwintbank.model.Cliente;

public class Conta extends ContaAbstrata {

    public Conta(String numero, Cliente cliente) {
        super(numero, cliente);
    }

    public Conta(String numero, double saldo, Cliente cliente, ContasEnum tipo) {
        super(numero, saldo, cliente, tipo);
    }

    @Override
    public void debitar(double quantia) throws Exception{
        if(quantia <= consultarSaldo()){
        this.setSaldo(consultarSaldo() - quantia);
        }else{
            SaldoInsuficienteException sie = new SaldoInsuficienteException();
            throw sie;
        }
    }

   
}
