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

    @Override
    public void inserir(ContaAbstrata e) throws Exception {
        Connection conn;
        PreparedStatement stmt;
        String sql = SQLUtil.getProperties().getProperty("sql.conta.inserir");
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

    @Override
    public void atualizar(ContaAbstrata e) throws Exception {
        Connection conn;
        PreparedStatement stmt;
        String sql = SQLUtil.getProperties().getProperty("sql.conta.atualizar");
        try {
            if (e != null) {
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
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void remover(ContaAbstrata e) throws Exception {
        Connection conn;
        String sql = SQLUtil.getProperties().getProperty("sql.conta.remover");
        PreparedStatement stmt;
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
    }

    @Override
    public ContaAbstrata procurar(String key) throws Exception {
        Connection conn;
        String sql = SQLUtil.getProperties().getProperty("sql.conta.procurar");
        PreparedStatement stmt;
        ContaAbstrata conta = null;
        try {
            if (key != null) {
                conn = JDBCConnectionUtil.getConnection();
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, key);
                ResultSet rs = stmt.executeQuery();
                conta = FactoryContas.criarContas(rs.getInt("TIPO"));
                conta.setNumero(rs.getString("NUMERO"));
                conta.creditar(rs.getDouble("SALDO"));
                conta.setCliente(procurarCliente(rs.getString("TB_CLIENTE_CPF")));
                conta.setTipo(ContasEnum.convertIntToEnum(rs.getInt("TIPO")));

            }
        } catch (SQLException ex) {
            throw ex;
        }
        return conta;
    }

    private Cliente procurarCliente(String key) throws Exception {
        Connection conn;
        String sql = SQLUtil.getProperties().getProperty("sql.cliente.procurar");
        PreparedStatement stmt;
        Cliente cliente = null;
        TipoCliente tipo = TipoCliente.STANDARD;
        try {
            if (key != null) {
                conn = JDBCConnectionUtil.getConnection();
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, key);
                ResultSet rs = stmt.executeQuery();
                if (rs.getString("CPF") != null) {
                    tipo = TipoCliente.values()[rs.getInt("TIPO")];
                    cliente = new Cliente(rs.getString("CPF"), rs.getString("NOME"), tipo, procurarEndereco(rs.getString("CPF")));
                }
            } else {
                throw new ClienteNotFoundException();
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return cliente;

    }

    private EnderecoCliente procurarEndereco(String cpf) throws Exception {
        String sql = SQLUtil.getProperties().getProperty("sql.endereco.procurar");
        Connection conn;
        PreparedStatement stmt;
        EnderecoCliente endereco = null;
        try {
            conn = JDBCConnectionUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.getString("CPF") != null) {
                endereco = new EnderecoCliente(rs.getString("CEP"), rs.getString("NUMERO"), rs.getString("COMPLEMENTO"), rs.getString("CPF"));
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return endereco;
    }

}
