/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.dados;

import br.com.fwintbank.model.Cliente;
import br.com.fwintbank.model.IRepCliente;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author lucas
 */
public class RepositorioClienteTreeSet implements IRepCliente {
    private Set<Cliente> treeSet;
    
    public RepositorioClienteTreeSet(){
        this.treeSet = new TreeSet<Cliente>();
    }


    public void inserir(Cliente cliente) {
        this.treeSet.add(cliente);
    }


    public void atualizar(Cliente cliente) {
       this.treeSet.remove(cliente);
       this.treeSet.add(cliente);
    }


    public void remover(String cpfCliente) {
       for(Cliente c : this.treeSet){
           if(c.getCpf().equals(cpfCliente)){
               this.treeSet.remove(c);
           }
       }          
    }


    public boolean existe(String cpfCliente) {
       for(Cliente c : this.treeSet){
           if(c.getCpf().equals(cpfCliente)){
               return true;
           }
       }
       return false;
    }


    public Cliente procurar(String cpfCliente) {
       Cliente cl=null;
        for(Cliente c : this.treeSet){
           if(c.getCpf().equals(cpfCliente)){
               cl=c;
           }
       }
       return cl;
    }
    
}
