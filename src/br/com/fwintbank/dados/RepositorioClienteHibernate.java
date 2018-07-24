/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.dados;

import br.com.fwintbank.exceptions.*;
import br.com.fwintbank.model.Cliente;
import br.com.fwintbank.model.IRepCliente;
import br.com.fwintbank.model.util.HibernateUtil;
import org.hibernate.Session;
/**
 *
 * @author keyalisth
 */
public class RepositorioClienteHibernate implements IRepCliente{

    

    public void inserir(Cliente e) throws Exception {
        Session session = HibernateUtil.GetSession();
        session.save(e);
        session.close();

    }

    public void atualizar(Cliente e) throws Exception {
        Session session= HibernateUtil.GetSession();
        Cliente cliente = (Cliente) session.get(Cliente.class, e.getCpf());
        if(cliente!=null){
            session.saveOrUpdate(e);
        }else{
            throw new ClienteNotFoundException();
        }
        session.close();
    }

    public void remover(Cliente e) throws Exception {
        Session session = HibernateUtil.GetSession();
        Cliente cliente= (Cliente) session.get(Cliente.class, e.getCpf());
        if(cliente!=null){
            session.delete(e);
        }else{
            throw new ClienteNotFoundException();
        }
        session.close();
    }

    public Cliente procurar(String key) throws Exception {
        Session session = HibernateUtil.GetSession();
        Cliente cliente= (Cliente) session.get(Cliente.class, key);
        if(cliente!=null){
            return cliente;
        }else{
            throw new ClienteNotFoundException();
        }

    }
    
}
