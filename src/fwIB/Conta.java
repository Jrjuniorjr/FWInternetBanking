package fwIB;



public class Conta {
	private float saldo;
	private String numero;
	
	public Conta(String numero) {
		this.numero = numero;
		this.saldo =0.0f;
	}
	
	public void creditar(float n) {
		this.saldo=this.saldo+n;
	}
	public void debitar(float n) {
		this.saldo=this.saldo-n;
	}
	
	public float consultarSaldo() {
		return this.saldo;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void transferir(Conta destino, float quantia) {
		this.debitar(quantia);
		destino.creditar(quantia);
	}
}
