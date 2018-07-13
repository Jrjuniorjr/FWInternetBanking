import contas.Conta;
import contas.Poupanca;
import contas.RepositorioContasArray;

public class Teste {

	public static void main(String[] args) {
		Conta a,b,c;
		Poupanca d,e,f;
		String numeros[] = new String[6];
		RepositorioContasArray contas = new RepositorioContasArray();
		a=new Conta("1213-7");
		b=new Conta("4441-8");
		c=new Conta("2141-9");
		d=new Poupanca("12132-7",10);
		e=new Poupanca("44412-8",10);
		f=new Poupanca("21412-9",10);
		numeros[0] = "1213-7";
		numeros[1] = "4441-8";
		numeros[2] = "2141-9";
		numeros[3] = "12132-7";		
		numeros[4] = "44412-8";
		numeros[5] ="21412-9";
		contas.inserirConta(a);
		contas.inserirConta(b);
		contas.inserirConta(c);
		contas.inserirConta(d);
		contas.inserirConta(e);
		contas.inserirConta(f);
		rendeJuros(numeros,contas);

	}
	
	
	public static void rendeJuros(String numeros[], RepositorioContasArray contas ) {
		Conta aux;
		
		for(int i =0;i<6;i++) {
			aux = contas.procurarConta(numeros[i]);
			if(aux instanceof Poupanca) {
				((Poupanca) aux).renderJuros(0.02);
				System.out.println("valor: "+aux.consultarSaldo());
			}
			
			
		}
		
		
	}
	

}
