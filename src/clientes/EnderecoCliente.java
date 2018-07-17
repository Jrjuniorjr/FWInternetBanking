package clientes;

public class EnderecoCliente {
	private String estado;
	private String rua;
	private String bairro;
	private String cidade;
	private String complemento;
	private String numero;
	private String cep;

	public EnderecoCliente(String estado, String rua, String bairro, String cidade, String numero, String complemento,
			String cep) {
		super();
		this.estado = estado;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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
