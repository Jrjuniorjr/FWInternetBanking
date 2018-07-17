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
public interface IRepContas {
    public abstract void inserir(ContaAbstrata conta);
    public abstract void atualizar(ContaAbstrata conta);
    public abstract void remover(String numConta);
    public abstract boolean existe(String numConta);
    public abstract ContaAbstrata procurar(String numConta);

}  

