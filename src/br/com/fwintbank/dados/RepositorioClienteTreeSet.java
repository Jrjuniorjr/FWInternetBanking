/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.dados;

import br.com.fwintbank.exceptions.*;
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
        this.treeSet = new TreeSet<>();
    }


    public void inserir(Cliente cliente){
        this.treeSet.add(cliente);
    }


    public void atualizar(Cliente cliente) throws ClienteNotFoundException{
       
        if(this.treeSet.contains(cliente)){
           this.treeSet.remove(cliente);
           this.treeSet.add(cliente);
       }else{
           throw new ClienteNotFoundException();
       }       
    }

    public void remover(String cpfCliente) throws ClienteNotFoundException{
        for(Cliente c: this.treeSet){
            if(c.getCpf().equals(cpfCliente)){
                this.treeSet.remove(c);
                return;
            }
        } 
        throw new ClienteNotFoundException();
    }

    public Cliente procurar(String cpfCliente) throws ClienteNotFoundException{
        for(Cliente c : this.treeSet){
           if(c.getCpf().equals(cpfCliente)){
              return c;
           }
       }
       throw new ClienteNotFoundException();
    }
    
}
