package contas;

import clientes.Cliente;

public abstract class ContaAbstrata {
    private String numero;
    private double saldo;
    private Cliente cliente;

    public ContaAbstrata(String numero, double saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public ContaAbstrata(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        saldo = 0.0;
    }

    public String getNumero() {
        return numero;
    }

    public double consultarSaldo() {
        return saldo;
    }
    protected void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    public Cliente getCliente() {
        return cliente;
    }
   
    public void transferir(ContaAbstrata destino, double quantia) {
        this.debitar(quantia);
        destino.creditar(quantia);
    }
    public abstract void debitar(double quantia);
    
   
    
}
