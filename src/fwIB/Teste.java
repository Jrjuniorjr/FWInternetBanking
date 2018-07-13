


public class Teste {

	public static void main(String[] args) {
		Conta a,b;
		RepositorioContasArray rc;
		rc = new RepositorioContasArray();
		a=new Conta("1213-7");
		b=new Conta("44418");

		System.out.println("TESTE DE SAIDA");	
		
		a.creditar(20);
		b.debitar(15);
		System.out.println("SALDO A"+a.consultarSaldo());	
		System.out.println("SALDO B"+b.consultarSaldo());
		rc.inserirConta(a);
		rc.inserirConta(b);
		
		
		
	}
	
	//teste

}
