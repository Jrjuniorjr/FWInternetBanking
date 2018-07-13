package fwIB;


public class Teste {

	public static void main(String[] args) {
		Conta a,b;
		RepositorioContasArray contas = new RepositorioContasArray();
		a=new Conta("1213-7");
		b=new Conta("44418");
		contas.inserirConta(a);
		contas.inserirConta(b);
		a.transferir(b, 20.0);
		Conta conta = contas.procurarConta("1213-7");
		System.out.println("Numero da conta " + conta.getNumero());
		System.out.println("Saldo da conta " + conta.consultarSaldo());
	}
	

}
