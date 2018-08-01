    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author keyalisth
 */
public class JDBCConnectionUtil {

    private static String url;
    private static String driver;
    private static String user;
    private static String pass;
    private static Connection connection;
    private static Properties p;
    
    static {
        p=new Properties();
        try {
            p.load(new FileInputStream("PropertiesJDBC.properties"));
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
        } catch (IOException ex) {
            System.out.println("Erro ao ler PropertiesJDBC.properties");
        }
        driver=p.getProperty("jdbc.driver");
        url= p.getProperty("jdbc.url");
        user=p.getProperty("jdbc.user");
        pass=p.getProperty("jdbc.pass");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver JDBC do HSQLDB.");
            System.exit(-1);
        } catch (SQLException ex){
            System.out.println("Erro de conexão.");
            System.exit(-1);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }

    public static void createTransaction() throws SQLException {
        getConnection();
        connection.setAutoCommit(false);
    }

    public static void createSavePoint() throws SQLException {
        getConnection();
        connection.setSavepoint();
    }

    public static void commitTransacton() throws SQLException {
        getConnection();
        connection.setAutoCommit(true);
    }

    public static void rollbackTransaction() throws SQLException {
        getConnection();
        connection.rollback();
        connection.setAutoCommit(true);
    }

    public static void rollbackTransaction(Savepoint svpt) throws SQLException {
        getConnection();
        connection.rollback(svpt);
        connection.setAutoCommit(true);
    }
}
