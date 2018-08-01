package br.com.fwintbank.dados;

import br.com.fwintbank.exceptions.*;
import br.com.fwintbank.model.*;
import br.com.fwintbank.model.util.JDBCConnectionUtil;
import br.com.fwintbank.model.util.SQLUtil;
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
public class RepositorioContasJDBC implements IRepContas {


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
        Connection conn;
        PreparedStatement stmt;
        String sql = SQLUtil.getProperties().getProperty("sql.conta.inserir");
        if (existeConta(e.getNumero())) {
            throw new ContaExistenteException();
        } else {
            try {
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
        Connection conn;
        PreparedStatement stmt;
        String sql = SQLUtil.getProperties().getProperty("sql.conta.atualizar");
        try {
            if (e != null) {
                if (existeConta(e.getNumero())) {
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
        Connection conn;
        String sql = SQLUtil.getProperties().getProperty("sql.conta.remover");
        PreparedStatement stmt;
        if (e != null) {
            if (existeConta(e.getNumero())) {
                try {
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
        Connection conn;
        String sql= SQLUtil.getProperties().getProperty("sql.conta.procurar");
        PreparedStatement stmt;
        ContaAbstrata conta = null;
        try {
            if (key != null) {
                conn = JDBCConnectionUtil.getConnection();
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, key);
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.getString("NUMERO") != null) {
                    conta = FactoryContas.criarContas(rs.getInt("TIPO"));
                    conta.setNumero(rs.getString("NUMERO"));
                    conta.creditar(rs.getDouble("SALDO"));
                    conta.setCliente(null); 
                    conta.setTipo(ContasEnum.convertIntToEnum(rs.getInt("TIPO")));
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
