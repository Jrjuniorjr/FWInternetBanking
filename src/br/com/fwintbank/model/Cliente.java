package br.com.fwintbank.model;


public class Cliente {

	
	private String cpf;
	private String nome;
	private TipoCliente tipo;
	private EnderecoCliente endereco;
	
	
	public Cliente(String cpf,String nome,TipoCliente tipo,EnderecoCliente endereco) {
		this.cpf=cpf;
		this.nome=nome;
		this.tipo = tipo;
                this.endereco = endereco;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	public String getNome() {
		return this.nome;
	}
	public void setTipo(TipoCliente tipo) {
		this.tipo=tipo;
	}
	public TipoCliente getTipo() {
		return this.tipo;
	}
	
	public void setEndereco(EnderecoCliente end) {
		this.endereco=end;
	}
	public EnderecoCliente getEndereco() {
		return this.endereco;
	}
	
	

}
