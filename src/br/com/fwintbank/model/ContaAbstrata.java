package br.com.fwintbank.model;

import br.com.fwintbank.model.Cliente;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "TB_CONTA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO", discriminatorType = DiscriminatorType.INTEGER)
public abstract class ContaAbstrata  extends Gen implements Serializable{

    @Id
    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "SALDO")
    private double saldo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TB_CLIENTE_CPF")
    private Cliente cliente;

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

    public ContaAbstrata() {}


    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
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
