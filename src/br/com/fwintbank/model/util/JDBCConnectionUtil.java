/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 *
 * @author keyalisth
 */
public class JDBCConnectionUtil {

    private static String url = "jdbc:hsqldb:hsql://localhost:9090/qib";
    private static String driver = "org.hsqldb.jdbcDriver";
    private static String user = "sa";
    private static String pass = "";
    private static Connection connection;

    static {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver JDBC do HSQLDB.");
            System.exit(-1);
        }catch (SQLException e) {
            System.out.println("Exceção de conexão.");
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
