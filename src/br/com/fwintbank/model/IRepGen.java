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
    
    
    public abstract void inserir(E e) throws Exception;

    public abstract void atualizar(E e) throws Exception;

    public abstract void remover(E e) throws Exception;

    public abstract E procurar(String key) throws Exception;

}
