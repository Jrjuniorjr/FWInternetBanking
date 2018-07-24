/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author keyalisth
 */

@Entity
@Table(name= "tb_cliente")
public class Gerente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;
    
    @Column( name="nome")
    private String nome;
    
    @Column( name="fone")
    private String fone;
    
    @ManyToMany(
        mappedBy="gerentes",
        targetEntity=Cliente.class
    )
    private Collection<Cliente> clientes;
    
    public Gerente(String nome,String fone){
        this.nome= nome;
        this.fone=fone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
    
    
}
