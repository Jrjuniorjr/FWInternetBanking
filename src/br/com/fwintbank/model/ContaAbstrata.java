package br.com.fwintbank.model;

import br.com.fwintbank.model.Cliente;

@Entity
@Table(name = "TB_CONTA")
public abstract class ContaAbstrata {

    @Id
    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "SALDO")
    private double saldo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TB_CLIENTE_CPF")
    private Cliente cliente;

    //@Column (name = "TIPO")
    private ContasEnum tipo;

    public ContaAbstrata(String numero, double saldo, Cliente cliente, ContasEnum tipo) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.tipo = tipo;
    }

    public ContaAbstrata(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        saldo = 0.0;
    }

    public ContaAbstrata() {

    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public double consultarSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ContasEnum getTipo() {
        return tipo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTipo(ContasEnum tipo) {
        this.tipo = tipo;
    }

    public void transferir(ContaAbstrata destino, double quantia) throws Exception {
        this.debitar(quantia);
        destino.creditar(quantia);
    }

    public abstract void debitar(double quantia) throws Exception;

}
