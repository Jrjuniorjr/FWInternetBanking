/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

/**
 *
 * @author Junior
 */
public class FactoryContas {

    public static ContaAbstrata getTipoConta(String numero, double saldo, Cliente cliente, int tipo) {

        switch (tipo) {
            case 0:
                return new ContaPoupanca(numero, saldo, cliente, ContasEnum.POUPANCA);
            case 1:
                return new ContaBonificada(numero, saldo, cliente, ContasEnum.BONIFICADA);
            case 2:
                return new ContaImposto(numero, saldo, cliente, ContasEnum.IMPOSTO);
        }

        return null;

    }

}
