/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.dados;

import br.com.fwintbank.exceptions.*;
import br.com.fwintbank.model.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Junior
 */
public class RepositorioContasHashMap implements IRepContas {

    private Map<String,ContaAbstrata> mapa;

    public RepositorioContasHashMap() {
        mapa = new HashMap<String, ContaAbstrata>();
    }

    @Override
    public void inserir(ContaAbstrata conta) throws ContaExistenteException {
        if (!mapa.containsKey(conta.getNumero())) {
            mapa.put(conta.getNumero(), conta);
        } else {
            ContaExistenteException cee = new ContaExistenteException();
            throw cee;
        }
    }

    @Override
    public void atualizar(ContaAbstrata conta) throws ContaNotFoundException {
        if (mapa.containsKey(conta.getNumero())) {
            mapa.remove(conta.getNumero());
            mapa.put(conta.getNumero(), conta);
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
    }

    @Override
    public void remover(ContaAbstrata conta) throws ContaNotFoundException{
        if (mapa.containsKey(conta.getNumero())) {
            mapa.remove(conta.getNumero());
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
    }

    @Override
    public ContaAbstrata procurar(String numConta) throws ContaNotFoundException{
        ContaAbstrata conta = null;
        conta = (ContaAbstrata) mapa.get(numConta);
        if(conta == null){
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
        return conta;
    }

}
