/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

/**
 *
 * @author felix
 */
public enum ContasEnum {
    
    POUPANCA,
    BONIFICADA,
    IMPOSTO;
    
    public static ContasEnum convertIntToEnum(int tipo){
        switch(tipo){
            case 1: return POUPANCA;
            case 2: return BONIFICADA;
            case 3: return IMPOSTO;
            default: return null;
        }
    }
}
