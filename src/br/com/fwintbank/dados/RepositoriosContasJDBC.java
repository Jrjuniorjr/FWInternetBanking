package br.com.fwintbank.dados;

import br.com.fwintbank.exceptions.*;
import br.com.fwintbank.model.*;
import br.com.fwintbank.model.util.JDBCConnectionUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Junior
 */
public class RepositoriosContasJDBC implements IRepContas {

    private Properties getProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream arquivo = new FileInputStream("PropertiesSql.properties");
        properties.load(arquivo);
        return properties;
    }

    private boolean existeConta(String numero) throws Exception {
        boolean existe = false;
        try {
            ContaAbstrata conta = procurar(numero);
            if (conta.getNumero() != null) {
                existe = true;
            }
        } catch (SQLException e) {
            throw e;
        } catch (ContaNotFoundException e) {
            existe = false;
        }
        return existe;
    }

    @Override
    public void inserir(ContaAbstrata e) throws Exception {
        String sql;
        Properties properties;
        Connection conn;
        PreparedStatement stmt;
        if (existeConta(e.getNumero())) {
            throw new ContaExistenteException();
        } else {
            try {
                properties = getProperties();
                sql = properties.getProperty("sql.inserir");
                conn = JDBCConnectionUtil.getConnection();
                stmt = conn.prepareStatement(sql);
                if (e != null) {
                    stmt.setString(1, e.getCliente().getCpf());
                    stmt.setString(2, e.getNumero());
                    stmt.setDouble(3, e.consultarSaldo());
                    stmt.setInt(4, e.getTipo().ordinal());
                    stmt.executeUpdate();
                    stmt.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                throw ex;
            }
        }

    }

    @Override
    public void atualizar(ContaAbstrata e) throws Exception {
        Properties properties;
        Connection conn;
        String sql;
        PreparedStatement stmt;
        try {
            if (e != null) {
                if (existeConta(e.getNumero())) {
                    properties = getProperties();
                    sql = properties.getProperty("sql.atualizar");
                    conn = JDBCConnectionUtil.getConnection();
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, e.getCliente().getCpf());
                    stmt.setString(1, e.getNumero());
                    stmt.setDouble(2, e.consultarSaldo());
                    stmt.setInt(4, e.getTipo().ordinal());
                    stmt.executeUpdate();
                    stmt.close();
                    conn.close();
                }
            } else {
                throw new ContaNotFoundException();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void remover(ContaAbstrata e) throws Exception {
        Properties properties;
        Connection conn;
        String sql;
        PreparedStatement stmt;
        if (e != null) {
            if (existeConta(e.getNumero())) {
                try {
                    properties = getProperties();
                    sql = properties.getProperty("sql.remover");
                    conn = JDBCConnectionUtil.getConnection();
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, e.getNumero());
                    stmt.executeUpdate();
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    throw ex;
                }
            } else {
                throw new ContaNotFoundException();
            }

        }
    }

    @Override
    public ContaAbstrata procurar(String key) throws Exception {
        Properties properties;
        Connection conn;
        String sql;
        PreparedStatement stmt;
        ContaAbstrata conta = null;
        try {
            if (key != null) {
                properties = getProperties();
                sql = properties.getProperty("sql.procurar");
                conn = JDBCConnectionUtil.getConnection();
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, key);
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.getString("NUMERO") != null) {
                    conta = FactoryContas.criarContas(rs.getString("NUMERO"), rs.getDouble("SALDO"), null, rs.getInt("TIPO"));
                } else {
                    throw new ContaNotFoundException();
                }

            }
        } catch (SQLException ex) {
            throw ex;
        }
        return conta;
    }

}
