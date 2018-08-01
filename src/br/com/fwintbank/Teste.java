
package br.com.fwintbank;

import br.com.fwintbank.model.Cliente;
import br.com.fwintbank.model.EnderecoCliente;
import br.com.fwintbank.model.Fachada;
import br.com.fwintbank.model.TipoCliente;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Teste {


	public static void main(String[] args) {
            Fachada f = Fachada.getInstance();
            EnderecoCliente e = new EnderecoCliente("1000","12","apt 2","12121");
            Cliente c =new Cliente("12121","lucas",TipoCliente.VIP,e);
            try {
                f.inserirCliente(c);
                c.setTipo(TipoCliente.CLASS);
                f.atualizarCliente(c);
                f.removercliente(c);
                c.setCpf("1021");
                f.inserirCliente(c);
                Cliente cliente = f.consultarCliente("1021");
                System.out.println(cliente);
            } catch (Exception ex) {
                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        
	}	
}
