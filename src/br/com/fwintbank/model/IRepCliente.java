
package br.com.fwintbank.model;

public interface IRepCliente {
    public abstract void inserir(Cliente cliente);
    public abstract void atualizar(Cliente cliente);
    public abstract void remover(String cpfCliente);
    public abstract boolean existe(String cpfCliente);
    public abstract Cliente procurar(String cpfCliente);

}
