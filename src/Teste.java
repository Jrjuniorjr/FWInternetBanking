import clientes.CadCliente;
import clientes.EnderecoCliente;
import clientes.RepositorioClienteArray;
import clientes.TipoCliente;
import contas.*;

public class Teste {
        private CadCliente  cadCli;
        private CadConta cadCont;
        private ContaAbstrata c;

	public static void main(String[] args) {
        CadConta cadCont = new CadConta(new RepositorioContasArray());
        CadCliente cadCli = new CadCliente(new RepositorioClienteArray());
        System.out.println(""+(cadCli.consultar("22269469482")).getNome());
        
	}	
}
