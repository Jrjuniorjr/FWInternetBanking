package cliente;


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
	
	public void remover(String cpfCliente) {
		if(existe(cpfCliente)) {
			int i= this.procurarIndice(cpfCliente);
			this.clientes[i]=this.clientes[this.indice-1];
			this.clientes[indice-1]=null;
			this.indice = this.indice-1;
		}else {
			System.out.println("cliente.Cliente nao encontrado!");
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
