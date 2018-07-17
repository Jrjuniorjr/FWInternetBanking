package contas;

import clientes.Cliente;

public class Conta extends ContaAbstrata {

    public Conta(String numero, Cliente cliente) {
        super(numero, cliente);
    }

    public Conta(String numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }

    @Override
    public void debitar(double quantia) {
        this.setSaldo(consultarSaldo() - quantia);
    }

   
}
