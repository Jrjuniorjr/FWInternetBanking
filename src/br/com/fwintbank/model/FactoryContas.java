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

    public static ContaAbstrata criarContas(int tipo) {

        switch (tipo) {
            case 0:
                return new ContaPoupanca();
            case 1:
                return new ContaBonificada();
            case 2:
                return new ContaImposto();
        }

        return null;

    }

}
