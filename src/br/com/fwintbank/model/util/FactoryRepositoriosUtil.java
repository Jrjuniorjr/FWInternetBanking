/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior
 */
public class FactoryRepositoriosUtil {
    
    private static Properties p;
    
    static{
        p= new Properties();
        try {
            p.load(new FileInputStream("System.properties"));
        } catch (FileNotFoundException ex) {
           System.out.println("Arquivo System.properties nao encontrado!");
        } catch (IOException ex) {
           System.out.println("Erro ao ler arquivo System.properties");
        }
    }
    
    public static Properties getProperties(){ 
        if(p==null){
            p=new Properties();
            try {
                p.load(new FileInputStream("System.properties"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }
    
}
