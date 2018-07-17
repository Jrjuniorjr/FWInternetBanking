package br.com.fwintbank.dados;

import br.com.fwintbank.model.Cliente;
import br.com.fwintbank.model.IRepCliente;


public class RepositorioClienteArray implements IRepCliente {
	private final static int TAM_CACHE_CLIENTES = 100;
	private Cliente[] clientes;
	private int indice;
	
	public RepositorioClienteArray() {
		this.clientes = new Cliente[TAM_CACHE_CLIENTES];
		this.indice=0;
	}
	public void inserir(Cliente cliente) {
		if(indice<RepositorioClienteArray.TAM_CACHE_CLIENTES) {
		 this.clientes[indice]=cliente;
		 this.indice++;
		}
	}
	public void atualizar(Cliente cliente) {
		int index= procurarIndice(cliente.getCpf());
		if(index != -1) {
                    this.clientes[index]=cliente;
		}
	}
	
	public void remover(String cpfCliente) {
            int i= this.procurarIndice(cpfCliente);
            this.clientes[i]=this.clientes[this.indice-1];
            this.clientes[indice-1]=null;
            this.indice = this.indice-1;

	}
	
	
	private int procurarIndice(String cpfCliente) {
		for(int i=0;i<indice;i++) {
			if(this.clientes[i]!=null) {
				if(this.clientes[i].getCpf().equals(cpfCliente)) {
					return i;
				}
			}
		}
		return -1;
	}
        
	public boolean existe(String cpfCliente) {
		if(procurarIndice(cpfCliente)!=-1) {
			return true;
		}
		return false;
	}
        
	public Cliente procurar(String cpfCliente) {
		int i=procurarIndice(cpfCliente);
		if(i!=-1) {
			return this.clientes[i];
		}
		return null;
	}
}
