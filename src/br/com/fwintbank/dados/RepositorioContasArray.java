package br.com.fwintbank.dados;

import br.com.fwintbank.exceptions.*;
import br.com.fwintbank.model.ContaAbstrata;
import br.com.fwintbank.model.IRepContas;

public class RepositorioContasArray implements IRepContas {

    private int tamCacheContas;
    private ContaAbstrata contas[];
    private int indice;

    public RepositorioContasArray() {
        tamCacheContas = 100;
        contas = new ContaAbstrata[tamCacheContas];
        indice = 0;
    }

    @Override
    public void inserir(ContaAbstrata conta) throws Exception {
        if(existe(conta.getNumero())){
        this.contas[indice] = conta;
        indice++;
        }
        else{
            ContaExistenteException cee = new ContaExistenteException();
            throw cee;
        }
        
    }

    @Override
    public void atualizar(ContaAbstrata conta) throws Exception{
        if (existe(conta.getNumero())) {
            int indice = procurarIndice(conta.getNumero());
            if (indice != -1) {
                contas[indice] = conta;
            }
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }

    }

    private int procurarIndice(String numeroConta) {
        for (int i = 0; i < tamCacheContas; i++) {
            if (contas[i] == null) {
                break;
            } else if (contas[i].getNumero().equals(numeroConta)) {
                return i;
            }
        }
        return -1;
    }

    public void remover(String numeroConta) throws Exception{
        if (existe(numeroConta)) {
            int i = procurarIndice(numeroConta);
            contas[i] = contas[indice - 1];
            contas[indice - 1] = null;
            indice = indice - 1;
        } else {
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;

        }

    }

    public boolean existe(String numeroConta) {
        for (int i = 0; i < tamCacheContas; i++) {
            if (this.contas[i] != null) {
                if (numeroConta.equals(contas[i].getNumero())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ContaAbstrata procurar(String numeroConta) throws Exception{
        ContaAbstrata c = null;
        if(existe(numeroConta)){
            int i = procurarIndice(numeroConta);
            c = contas[i];
        }else{
            ContaNotFoundException cnfe = new ContaNotFoundException();
            throw cnfe;
        }
        return c;
    }

}
