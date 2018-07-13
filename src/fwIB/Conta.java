



public class Conta {
	private double saldo;
	private String numero;
	
	public Conta(String numero) {
		this.numero = numero;
		this.saldo =0.0;
	}
	public Conta(String numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public void creditar(double n) {
		this.saldo=this.saldo+n;
	}
	public void debitar(double n) {
		this.saldo=this.saldo-n;
	}
	
	public double consultarSaldo() {
		return this.saldo;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void transferir(Conta destino, double quantia) {
		this.debitar(quantia);
		destino.creditar(quantia);
	}
}
