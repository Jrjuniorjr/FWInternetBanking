package br.com.fwintbank.dados;

import br.com.fwintbank.model.Conta;
import br.com.fwintbank.model.ContaAbstrata;
import br.com.fwintbank.model.ContaImposto;
import br.com.fwintbank.model.ContasEnum;
import br.com.fwintbank.model.IRepContas;
import br.com.fwintbank.model.util.JDBCConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Junior
 */
public class RepositoriosContasJDBC implements IRepContas {

	@Override
	public void inserir(ContaAbstrata e) throws Exception {
		String sql = "INSERT INTO TB_CONTA " + "(NUMERO, SALDO, TB_CLIENTE_CPF)" + "VALUES(?, ?, ?)";
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (e != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, e.getNumero());
				stmt.setDouble(2, e.consultarSaldo());
				stmt.setString(3, e.getCliente().getCpf());
				stmt.executeUpdate();
			}
		} catch (SQLException ex) {
			throw ex;
		}
	}

	@Override
	public void atualizar(ContaAbstrata e) throws Exception {
		String sql = "UPDATE TB_CONTA SET NUMERO = ?, SALDO = ?,  TIPO = ? WHERE NUMERO = ?";
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (e != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, e.getNumero());
				stmt.setDouble(2, e.consultarSaldo());
				stmt.setInt(3, e.getTipo().ordinal());
				stmt.setString(4, e.getNumero());
				stmt.executeUpdate();
			}
		} catch (SQLException ex) {
			throw ex;
		}
	}

	@Override
	public void remover(ContaAbstrata e) throws Exception {
		String sql = "DELETE FROM TB_CONTA WHERE NUMERO = ?";
		try {
			Connection conn = JDBCConnectionUtil.getConnection();
			if (e != null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, e.getNumero());
				stmt.executeUpdate();

			}
		} catch (SQLException ex) {
			throw ex;
		}
	}

	@Override
	public ContaAbstrata procurar(String key) throws Exception {
		ContaAbstrata conta = null;
                ContasEnum tipo;
		
		String sql = "SELECT * FROM TB_CONTA WHERE NUMERO = ?";
		try{
			Connection conn =  JDBCConnectionUtil.getConnection();
			if(key !=  null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, key);
				ResultSet rs = stmt.executeQuery(sql);
                                tipo = (ContasEnum)rs.getInt("TIPO");
                                if(rs.getInt("TIPO") == 2){
				conta = new ContaImposto(rs.getString("NUMERO"), rs.getDouble("SALDO"), rs.getInt("TIPO"));
                                }
                                else{
				conta = new Conta(rs.getString("NUMERO"), rs.getDouble("SALDO"), rs.getInt("TIPO"));
                                }
				
			}
		}catch(SQLException ex){
			throw ex;
		}
	return conta;
        }
       

}
