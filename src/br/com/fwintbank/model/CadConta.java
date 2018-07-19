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
    public void debitar(String numero, double valor) throws Exception{
        ContaAbstrata conta;
        conta = irep.procurar(numero);
        if(conta.consultarSaldo()-valor>=0){
            conta.debitar(valor);
            irep.atualizar(conta);  
        }else{
            throw new SaldoInsuficienteException();
        }
    }

    public void transferir(String numeroContaOrigem, String numeroContaDestino, double valor) throws Exception {
        ContaAbstrata c1, c2;
        c1 = irep.procurar(numeroContaOrigem);
        if(c1.consultarSaldo()-valor>=0){
            c2 = irep.procurar(numeroContaDestino);
            c1.transferir(c2, valor);
        }else{
            throw new SaldoInsuficienteException();
        }
    }

    public void creditar(String numeroConta, double valor) throws Exception {
        ContaAbstrata c1;
        c1 = irep.procurar(numeroConta);
        c1.creditar(valor);
        irep.atualizar(c1);
    }


}
