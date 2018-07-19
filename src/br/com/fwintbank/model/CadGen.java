/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

/**
 *
 * @author keyalisth
 */
public abstract class CadGen<E> {
    private IRepGen<E> repositorio;
    
    
    public void inserir(E e){
        repositorio.inserir(e);   
    }
    public void atualizar(E e) throws Exception{
        repositorio.atualizar(e);
    }
    public void remover(E e)throws Exception{
        repositorio.remover(e);
    }
    public E consultar(String s) throws Exception{
        return repositorio.procurar(s);
    }
    
}
