
package br.com.fwintbank;

import br.com.fwintbank.dados.RepositorioClienteArray;
import br.com.fwintbank.dados.RepositorioContasArray;
import br.com.fwintbank.model.CadCliente;
import br.com.fwintbank.model.CadConta;
import br.com.fwintbank.model.Conta;
import br.com.fwintbank.model.ContaAbstrata;

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
