/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Junior
 */
public class SerilizacaoUtil {

    public static void serializar(Map colecao, String localArquivo) throws Exception {
        FileOutputStream fos = new FileOutputStream(localArquivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(colecao);
        oos.close();
        fos.close();
    }

    public static Map deserializar(String localArquivo) throws Exception {
        FileInputStream fis = new FileInputStream(localArquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Map colecaoContas = (HashMap) ois.readObject();
        ois.close();
        fis.close();
        return colecaoContas;
    }
}
