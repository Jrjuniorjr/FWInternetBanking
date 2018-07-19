package br.com.fwintbank.dados;

import br.com.fwintbank.model.Cliente;
import br.com.fwintbank.model.IRepCliente;
import br.com.fwintbank.exceptions.*;


public class RepositorioClienteArray implements IRepCliente {
	private final static int TAM_CACHE_CLIENTES = 100;
	private Cliente[] clientes;
	private int indice;
	
	public RepositorioClienteArray() {
		this.clientes = new Cliente[TAM_CACHE_CLIENTES];
		this.indice=0;
	}
	public void inserir(Cliente cliente) throws RepositorioCheioException{
		if(indice<RepositorioClienteArray.TAM_CACHE_CLIENTES) {
		 this.clientes[indice]=cliente;
		 this.indice++;
		}else{
                    throw new RepositorioCheioException();
                }
	}
	public void atualizar(Cliente cliente) throws ClienteNotFoundException{
		int index= procurarIndice(cliente.getCpf());
		if(index != -1) {
                    this.clientes[index]=cliente;
		}else{
                    throw new ClienteNotFoundException();
                }
	}
	
	public void remover(String cpfCliente) throws ClienteNotFoundException{
            int i= this.procurarIndice(cpfCliente);
            if(i!=-1){
                this.clientes[i]=this.clientes[this.indice-1];
                this.clientes[indice-1]=null;
                this.indice = this.indice-1;
            }else{
                throw new ClienteNotFoundException();
            }
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
        
	public Cliente procurar(String cpfCliente) throws ClienteNotFoundException {
		int i=procurarIndice(cpfCliente);
		if(i!=-1) {
                    return this.clientes[i];
		}else{
                    throw new ClienteNotFoundException();   
                }
	}
}
