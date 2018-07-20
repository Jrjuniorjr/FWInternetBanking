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
    public void inserir(ContaAbstrata conta) throws RepositorioCheioException,ContaExistenteException {
        if(procurarIndice(conta.getNumero())==-1){
          if(indice<tamCacheContas){
            this.contas[indice] = conta;
            indice++;
          }else{
              throw new RepositorioCheioException();
          }
        }
        else{
            throw new ContaExistenteException();
        }
        
    }

    @Override
    public void atualizar(ContaAbstrata conta) throws ContaNotFoundException{
        int indice = procurarIndice(conta.getNumero());
        if (indice != -1) {
            contas[indice] = conta;
        }else{
            throw new ContaNotFoundException();
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

    public void remover(ContaAbstrata conta) throws ContaNotFoundException{
            int i = procurarIndice(conta.getNumero());
            if(i!=-1){
                contas[i] = contas[indice - 1];
                contas[indice - 1] = null;
                indice = indice - 1;
            }else{
                throw new ContaNotFoundException();
            }
    }


    @Override
    public ContaAbstrata procurar(String numeroConta) throws Exception{
        int i = procurarIndice(numeroConta);
        if(i!=-1){
            return contas[i];
        }else{
            throw new ContaNotFoundException();
        }
    }

}
