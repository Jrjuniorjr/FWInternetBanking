package br.com.fwintbank.model;

import br.com.fwintbank.exceptions.*;
import br.com.fwintbank.model.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author felix
 */
public class CadConta extends CadGen<ContaAbstrata> {

    private IRepContas irep;
    ContaAbstrata a;

    public CadConta(IRepContas i) {
        this.irep = i;
    }

    //----------------------------------  R  N  --------------------------------------------
    public void debitar(String numero, double valor) throws ContaNotFoundException, SaldoInsuficienteException {
        ContaAbstrata conta;
        conta = irep.procurar(numero);
        conta.debitar(valor);
        irep.atualizar(conta);
    }

    public void transferir(String numeroContaOrigem, String numeroContaDestino, double valor) throws ContaNotFoundException, SaldoInsuficienteException {
        ContaAbstrata c1, c2;
        c1 = irep.procurar(numeroContaOrigem);
        c2 = irep.procurar(numeroContaDestino);
        c1.transferir(c2, valor);
    }

    public void creditar(String numeroConta, double valor) throws ContaNotFoundException, SaldoInsuficienteException {
        ContaAbstrata c1;
        c1 = irep.procurar(numeroConta);
        c1.creditar(valor);
        irep.atualizar(c1);

    }

    /*
 public void transferir(ContaAbstrata cOrigem, ContaAbstrata cDestino, double valor) throws ContaNotFoundException, SaldoInsuficienteException {
        if (this.irep.existe(cOrigem.getNumero()) && this.irep.existe(cDestino.getNumero())) {
            if (valor <= cOrigem.consultarSaldo()) {
                cOrigem.transferir(cDestino, valor);
            } else {
                SaldoInsuficienteException sie = new SaldoInsuficienteException();
                throw sie;
            }
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
    }
   public void creditar(ContaAbstrata c, double valor) throws ContaNotFoundException, SaldoInsuficienteException{
        if (this.irep.existe(c.getNumero())) {
            if (valor <= c.consultarSaldo()) {
                c.creditar(valor);
            }
            else{
                SaldoInsuficienteException sie = new SaldoInsuficienteException();
                throw sie;
            }
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
    }
     */
}
