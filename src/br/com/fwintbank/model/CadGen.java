package br.com.fwintbank.model;

public abstract class CadGen<E> {
    private IRepGen<E> repositorio;
    
    
    public void inserir(E e) throws Exception{
        repositorio.inserir(e);   
    }
    public void atualizar(E e) throws Exception{
        repositorio.atualizar(e);
    }
    public void remover(String s)throws Exception{
        repositorio.remover(s);
    }
    public E consultar(String s) throws Exception{
        return repositorio.procurar(s);
    }
    
}
