package br.com.fwintbank.model;


import javax.persistence.*;


@Entity
@Table (name = "tb_cliente")
public class Cliente  implements Comparable<Cliente> {
    
    @Id
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="nome")
    private String nome;


    @Transient
    private TipoCliente tipo;
    
    @OneToOne(
    cascade= CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private EnderecoCliente endereco;

    public Cliente(){}

    
    public Cliente(String cpf,String nome,TipoCliente tipo,EnderecoCliente endereco) {
            this.cpf=cpf;
            this.nome=nome;
            this.tipo = tipo;
            this.endereco = endereco;
    }

    public String getCpf() {
            return this.cpf;
    }
    public String getNome() {
            return this.nome;
    }
    public void setTipo(TipoCliente tipo) {
            this.tipo=tipo;
    }
    public TipoCliente getTipo() {
            return this.tipo;
    }

    public void setEndereco(EnderecoCliente end) {
            this.endereco=end;
    }
    public EnderecoCliente getEndereco() {
            return this.endereco;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    public int compareTo(Cliente t) {
       return this.getCpf().compareTo(t.getCpf());
    }
     
    
}
