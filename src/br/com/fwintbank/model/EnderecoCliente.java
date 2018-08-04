package br.com.fwintbank.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_endereco")
public class EnderecoCliente implements Serializable{
    
        @Id
        @Column (
            name="tb_cliente_cpf"
        )
        private String clientecpf;
        
        @Column(
            name="complemento"
        )
        private String complemento;
          
        @Column(
            name="numero"
        )
        private String numero;
	
        @Column(
            name="CEP"
        )
        private String cep;
        
        public EnderecoCliente(){};

	public EnderecoCliente(String cep, String numero, String complemento,String clientecpf) {
		super();
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
	}

	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

    public String getClientecpf() {
        return clientecpf;
    }

    public void setClientecpf(String clientecpf) {
        this.clientecpf = clientecpf;
    }
        
	
	
}
