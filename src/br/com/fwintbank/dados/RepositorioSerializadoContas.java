/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.dados;

import br.com.fwintbank.exceptions.ContaExistenteException;
import br.com.fwintbank.exceptions.ContaNotFoundException;
import br.com.fwintbank.model.ContaAbstrata;
import br.com.fwintbank.model.IRepContas;
import br.com.fwintbank.model.util.SerilizacaoUtil;
import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Junior
 */
public class RepositorioSerializadoContas implements IRepContas {

    private final String localArquivo = "contas.ser";
    @Override
    public void inserir(ContaAbstrata e) throws Exception {
        Map<String, ContaAbstrata> colecao;
        try {
            colecao = SerilizacaoUtil.deserializar(localArquivo);
            if (!colecao.containsKey(e.getNumero())) {
                colecao.put(e.getNumero(), e);
                SerilizacaoUtil.serializar(colecao, localArquivo);
            } else {
                throw new ContaExistenteException();
            }

        } catch (FileNotFoundException ex) {
            colecao = new HashMap<>();
            colecao.put(e.getNumero(), e);
            SerilizacaoUtil.serializar(colecao, localArquivo);
        }
    }

    @Override
    public void atualizar(ContaAbstrata e) throws Exception {
        Map<String, ContaAbstrata> colecao;
        try {
            colecao = SerilizacaoUtil.deserializar(localArquivo);
            if (colecao.containsKey(e.getNumero())) {
                colecao.remove(e.getNumero());
                colecao.put(e.getNumero(), e);
                SerilizacaoUtil.serializar(colecao, localArquivo);
            } else {
                throw new ContaNotFoundException();
            }
        } catch (FileNotFoundException ex) {
            throw new ContaNotFoundException();
        }
    }

    @Override
    public void remover(ContaAbstrata e) throws Exception {
        Map<String, ContaAbstrata> colecao;
        try {
            colecao = SerilizacaoUtil.deserializar(localArquivo);
            if (colecao.containsKey(e.getNumero())) {
                colecao.remove(e.getNumero());
                SerilizacaoUtil.serializar(colecao, localArquivo);
            } else {
                throw new ContaNotFoundException();
            }
        } catch (FileNotFoundException ex) {
            throw new ContaNotFoundException();
        }

    }

    @Override
    public ContaAbstrata procurar(String key) throws Exception {
        Map<String, ContaAbstrata> colecao;
        ContaAbstrata conta = null;
        try {
            colecao = SerilizacaoUtil.deserializar(localArquivo);
            if (colecao.containsKey(key)) {
                conta = colecao.get(key);
            } else {
                throw new ContaNotFoundException();
            }
        } catch (FileNotFoundException ex) {
            throw new ContaNotFoundException();
        }

        return conta;
    }

}
