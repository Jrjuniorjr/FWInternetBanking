/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

import br.com.fwintbank.dados.RepositorioContasArray;
import br.com.fwintbank.dados.RepositorioContasHashMap;
import br.com.fwintbank.dados.RepositorioContasHibernate;
import br.com.fwintbank.dados.RepositorioContasJDBC;
import br.com.fwintbank.dados.RepositorioSerializadoContas;
import br.com.fwintbank.exceptions.ParametrosArquivoException;
import br.com.fwintbank.model.util.FactoryRepositoriosUtil;

/**
 *
 * @author Junior
 */
public class FactoryRepositoriosConta {

    public static IRepContas criarRepositorioContas() throws ParametrosArquivoException {
        int repositorio;
        try {
            repositorio = Integer.parseInt(FactoryRepositoriosUtil.getProperties().getProperty("criar.repositorio.contas"));
            switch (repositorio) {
                case 1:
                    return new RepositorioContasArray();
                case 2:
                    return new RepositorioContasHashMap();
                case 3:
                    return new RepositorioContasJDBC();
                case 4:
                    return new RepositorioContasHibernate();
                case 5:
                    return new RepositorioSerializadoContas();
                default:
                    throw new ParametrosArquivoException();
            }
        } catch (NumberFormatException ex) {
            throw new ParametrosArquivoException();
        }
    }
}
