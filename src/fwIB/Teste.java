package fwIB;

public class Teste {

	public static void main(String[] args) {

		RepositorioContasArray contas = new RepositorioContasArray();

		contas.inserirConta(new Conta ("1227-7",100));

		contas.inserirConta(new Conta ("1228-7",100));

		contas.inserirConta(new Conta ("1225-7",100));

		contas.inserirConta(new Poupanca ("1224-7",100));

		contas.inserirConta(new Poupanca ("1223-7",100));

		contas.inserirConta(new Poupanca ("1222-7",100));
		
		renderJurosTotal(contas);
		
		
	}
	
	public static void renderJurosTotal(RepositorioContasArray c) {
		String numeros[] = new String[6];
		numeros[0]="1227-7";
		numeros[1]="1228-7";
		numeros[2]="1225-7";
		numeros[3]="1224-7";
		numeros[4]="1223-7";
		numeros[5]="1222-7";
		
		for(int i=0;i<6;i++) {
			Conta a=c.procurarConta(numeros[i]);
			if(a instanceof Poupanca) {
				((Poupanca) a).renderJuros(2);
			}
		}
	}
}
