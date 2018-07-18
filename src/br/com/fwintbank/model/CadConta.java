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
public class CadConta {

    private IRepContas irep;
    ContaAbstrata a;

    public CadConta(IRepContas i) {
        this.irep = i;
    }

    //------------------------------------- C  R  U  D -----------------------------------------------
    public void inserirConta(ContaAbstrata c) throws ContaExistenteException {
        if (!this.irep.existe(c.getNumero())) {
            irep.inserir(c);
        } else {
            ContaExistenteException cee = new ContaExistenteException();
            throw cee;
        }
    }

    public void removerConta(String numero) throws ContaNotFoundException {
        if (this.irep.existe(numero)) {
            this.irep.remover(numero);
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
    }

    public void atualizarConta(ContaAbstrata c) throws ContaNotFoundException {
        if (this.irep.existe(c.getNumero())) {
            this.irep.atualizar(c);
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
    }

    public ContaAbstrata consultarConta(String numero) throws ContaNotFoundException {
        ContaAbstrata c = null;
        if (this.irep.existe(numero)) {
            c = this.irep.procurar(numero);
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
        return c;
    }

    //----------------------------------  R  N  --------------------------------------------
    public void debitar(ContaAbstrata c, double valor) throws ContaNotFoundException, SaldoInsuficienteException {
        if (this.irep.existe(c.getNumero())) {
            if (valor <= c.consultarSaldo()) {
                c.debitar(valor);
            } else {
                SaldoInsuficienteException sie = new SaldoInsuficienteException();
                throw sie;
            }
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
    }

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

}
