package br.com.fwintbank.model;

import br.com.fwintbank.model.Cliente;

public class ContaBonificada extends Conta{
    private double bonus;
    
    public ContaBonificada(String numero, double saldo, Cliente cliente, ContasEnum tipo){
        super(numero, saldo, cliente, tipo);
        bonus = 0.0;
    }
    public double getBonus(){
        return bonus;
    }
    
    @Override
    public void creditar(double valor){
        bonus = 0.1 * valor;
        super.creditar(valor);
    }
    
    public void renderBonus(){
        super.creditar(bonus);
        bonus = 0.0;
    }
}
