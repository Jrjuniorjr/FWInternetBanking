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
public class RepositorioCheioException extends Exception {
    public RepositorioCheioException(){
        super("Sem espaço para inserir no repositório!");
    }
}
