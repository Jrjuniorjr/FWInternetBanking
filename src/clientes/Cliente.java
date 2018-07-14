package clientes;


public class Cliente {

	public enum tipoCliente{
		VIP,
		CLASS,
		STANDARD,
	}
	
	private String cpf;
	private String nome;
	private tipoCliente tipo;
	private EnderecoCliente endereco;
	
	
	public Cliente(String cpf,String nome,tipoCliente tipo) {
		this.cpf=cpf;
		this.nome=nome;
		this.tipo = tipo;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	public String getNome() {
		return this.nome;
	}
	public void setTipo(tipoCliente tipo) {
		this.tipo=tipo;
	}
	public tipoCliente getTipo() {
		return this.tipo;
	}
	
	public void setEndereco(EnderecoCliente end) {
		this.endereco=end;
	}
	public EnderecoCliente getEndereco() {
		return this.endereco;
	}
	
	

}
