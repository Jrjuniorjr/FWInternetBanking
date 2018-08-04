/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.dados;

import org.hibernate.Session;
import br.com.fwintbank.exceptions.*;
import br.com.fwintbank.model.ContaAbstrata;
import br.com.fwintbank.model.IRepContas;
import br.com.fwintbank.model.util.*;

public class RepositorioContasHibernate implements IRepContas {

	@Override
	public void inserir(ContaAbstrata g) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.GetSession();
		if ((ContaAbstrata) session.get(ContaAbstrata.class, g.getNumero()) == null) {
			session.save(g);
			session.close();
		} else {
			ContaExistenteException e = new ContaExistenteException();
			throw e;
		}
	}

	@Override
	public void atualizar(ContaAbstrata g) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.GetSession();
		if ((ContaAbstrata) session.get(ContaAbstrata.class, g.getNumero()) != null) {
			session.saveOrUpdate(g);
			session.close();
		} else {
			ContaNotFoundException e = new ContaNotFoundException();
			throw e;
		}
	}

	@Override
	public void remover(ContaAbstrata g) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.GetSession();
		if ((ContaAbstrata) session.get(ContaAbstrata.class, g.getNumero()) != null) {
			session.delete(g);
			session.close();
		} else {
			ContaNotFoundException e = new ContaNotFoundException();
			throw e;
		}
	}

	@Override
	public ContaAbstrata procurar(String chave) throws Exception {
		// TODO Auto-generated method stub
		ContaAbstrata contaAbs = null;
		Session session = HibernateUtil.GetSession();
		contaAbs = (ContaAbstrata) session.get(ContaAbstrata.class, chave);
		if (contaAbs == null) {
			ContaNotFoundException e = new ContaNotFoundException();
			throw e;
		}

		return contaAbs;
	}

}

