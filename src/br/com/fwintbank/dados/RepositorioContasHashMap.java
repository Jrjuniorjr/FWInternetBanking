/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.dados;

import br.com.fwintbank.model.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Junior
 */
public class RepositorioContasHashMap implements IRepContas{

    private Map mapa;

    public RepositorioContasHashMap() {
        mapa = new HashMap<String, ContaAbstrata>();
    }

    @Override
    public void inserir(ContaAbstrata conta) {
        mapa.put(conta.getNumero(), conta);
    }

    @Override
    public void atualizar(ContaAbstrata conta) {
        mapa.replace(conta.getNumero(), conta);
    }

    @Override
    public void remover(String numConta) {
        mapa.remove(numConta);
    }

    @Override
    public boolean existe(String numConta) {
        return mapa.containsKey(numConta);
    }

    @Override
    public ContaAbstrata procurar(String numConta) {
        ContaAbstrata conta;
        conta = (ContaAbstrata) mapa.get(numConta);
        return conta;
    }
    
}
