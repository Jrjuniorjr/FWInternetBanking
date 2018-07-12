package fwIB;



public class RepositorioClienteArray {
	public int TAM_CACHE_CLIENTES = 100;
	private Cliente clientes[];
	private int indice;
	
	public RepositorioClienteArray() {
		this.clientes = new Cliente[TAM_CACHE_CLIENTES];
		this.indice=0;
	}
	public void inserir(Cliente cliente) {
		if(indice<this.TAM_CACHE_CLIENTES) {
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
	
	public void remover(Cliente cliente) {
		boolean removeu=false;
		for(int i=0;i<this.indice;i++) {
			if(removeu==false) {
				if(this.clientes[i].getCpf().equals(cliente.getCpf())) {
					removeu=true;
					if(i==this.TAM_CACHE_CLIENTES-1) {
						this.clientes[i]=null;
					}else {
						this.clientes[i]=this.clientes[i+1];
					}
				}
			}else {
				this.clientes[i]=this.clientes[i+1];
			}
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
	public boolean existe(String cpfCliente) {
		if(procurarIndice(cpfCliente)!=-1) {
			return true;
		}
		return false;
	}
	public Cliente procurar(String numcpf) {
		int i=procurarIndice(numcpf);
		if(i!=-1) {
			return this.clientes[i];
		}
		return null;
	}
}
