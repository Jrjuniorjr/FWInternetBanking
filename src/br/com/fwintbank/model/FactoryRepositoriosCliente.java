/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

import br.com.fwintbank.dados.*;
import br.com.fwintbank.exceptions.ParametrosArquivoException;
import br.com.fwintbank.model.util.FactoryRepositoriosUtil;

/**
 *
 * @author Junior
 */
public class FactoryRepositoriosCliente {

    public static IRepCliente criarRepositorioClientes() throws ParametrosArquivoException{
        int repositorio;
        try {
            repositorio = Integer.parseInt(FactoryRepositoriosUtil.getProperties().getProperty("criar.repositorio.clientes"));

            switch (repositorio) {
                case 1:
                    return new RepositorioClienteArray();
                case 2:
                    return new RepositorioClienteTreeSet();
                case 3:
                    return new RepositorioClienteJDBC();
                case 4:
                    return new RepositorioClienteHibernate();
                //case 5:
                 //   return new RepositorioSerializadoCliente();
                default:
                    throw new ParametrosArquivoException();
            }
        } catch (NumberFormatException ex) {
            throw new ParametrosArquivoException();
        }
    }
}
