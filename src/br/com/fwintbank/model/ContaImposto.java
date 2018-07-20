package br.com.fwintbank.model;

import br.com.fwintbank.exceptions.SaldoInsuficienteException;
import br.com.fwintbank.model.Cliente;

public class ContaImposto extends ContaAbstrata {

    public static final double TAXA = 0.01;

    public ContaImposto(String numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }

    public ContaImposto(String numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public void debitar(double quantia) throws Exception {
        double imposto;
        if (quantia <= consultarSaldo()) {
            imposto = quantia * TAXA;
            this.setSaldo(consultarSaldo() - (quantia + imposto));
        }
        else{
            SaldoInsuficienteException sie = new SaldoInsuficienteException();
            throw sie;
        }
    }

}
