/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

/**
 *
 * @author Maria Eduarda
 */
public interface IRepGen<E> {
    
    
    public abstract void inserir(E e);

    public abstract void atualizar(E e);

    public abstract void remover(String key);
    
    public abstract ContaAbstrata procurar(String key);

}
