package br.com.fwintbank.model;

public class EnderecoCliente {
	private String complemento;
	private String numero;
	private String cep;

	public EnderecoCliente(String cep, String numero, String complemento) {
		super();
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
	}

	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
	
}
