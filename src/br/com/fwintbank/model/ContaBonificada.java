package br.com.fwintbank.model;

import br.com.fwintbank.model.Cliente;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("2")
public class ContaBonificada extends Conta{
    private double bonus;
    
    public ContaBonificada(String numero, double saldo, Cliente cliente, ContasEnum tipo){
        super(numero, saldo, cliente, tipo);
        bonus = 0.0;
    }
    public double getBonus(){
        return bonus;
    }

    public ContaBonificada() {
        super();
        bonus = 0.0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
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
