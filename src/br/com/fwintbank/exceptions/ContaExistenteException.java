/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.exceptions;

/**
 *
 * @author lucas
 */
public class ContaExistenteException extends Exception{

    public ContaExistenteException(){
        super("Conta já existe!");
    }
    
}
