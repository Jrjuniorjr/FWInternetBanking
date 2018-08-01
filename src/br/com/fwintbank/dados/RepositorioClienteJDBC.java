
package br.com.fwintbank.dados;

import br.com.fwintbank.model.Cliente;
import br.com.fwintbank.model.EnderecoCliente;
import br.com.fwintbank.model.IRepCliente;
import br.com.fwintbank.model.TipoCliente;
import br.com.fwintbank.model.util.*;
import java.sql.*;


public class RepositorioClienteJDBC implements IRepCliente{

  
    private void inserirEndereco(Cliente e) throws Exception{
        PreparedStatement stmt=null;
        String sql= SQLUtil.getProperties().getProperty("sql.endereco.inserir");
        try{
            stmt= JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getEndereco().getCep());
            stmt.setString(2, e.getEndereco().getNumero());
            stmt.setString(3, e.getEndereco().getComplemento());
            stmt.setString(4, e.getCpf());
            stmt.executeUpdate();
        }catch(SQLException ex){
            throw ex;
        }finally{
            if(stmt!=null){
                stmt.close();
            }
        }
        
    }
    
    @Override
    public void inserir(Cliente e) throws Exception {
        String sql = SQLUtil.getProperties().getProperty("sql.cliente.inserir");
        Integer i = e.getTipo().ordinal();
        try{
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getCpf());
            stmt.setString(2, i.toString());
            stmt.setString(3, e.getNome());                
            stmt.executeUpdate();
            
            if(e.getEndereco()!=null){
             inserirEndereco(e);   
            }
        }catch(SQLException ex){
          throw ex;
        }
    }

    private void atualizarEndereco(Cliente e) throws Exception{
        String sql = SQLUtil.getProperties().getProperty("sql.endereco.atualizar");
        try{
            PreparedStatement stmt1 = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt1.setString(1, e.getEndereco().getCep());
            stmt1.setString(2, e.getEndereco().getNumero());
            stmt1.setString(3, e.getEndereco().getComplemento());
            stmt1.setString(4,e.getCpf());
            stmt1.executeUpdate();
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    public void atualizar(Cliente e) throws Exception {
        String sql = SQLUtil.getProperties().getProperty("jdbc.cliente.atualizar");
        Integer i= e.getTipo().ordinal();
        try{
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getNome());
            stmt.setString(2, i.toString());
            stmt.setString(3, e.getCpf());
            stmt.executeUpdate();
            if(e.getEndereco()!=null){
             atualizarEndereco(e);   
            }
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    private void removerEndereco(Cliente e) throws Exception{
        String sql= SQLUtil.getProperties().getProperty("sql.endereco.remover");
        try{
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1,e.getCpf());
            stmt.executeUpdate();
        }catch(SQLException ex){
            throw ex;
        }
        
    }

    public void remover(Cliente e) throws Exception {
        String sql= SQLUtil.getProperties().getProperty("sql.cliente.remover");
        try{
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getCpf());
            stmt.executeUpdate();
            if(e.getEndereco()!=null){
                removerEndereco(e);
            }
        }catch(SQLException ex){
            throw ex;
        }

    }

    
    public Cliente procurar(String cpf) throws Exception {
        String rsCPF="",rsNOME="";
        TipoCliente tipo= TipoCliente.STANDARD;
        String sql= SQLUtil.getProperties().getProperty("sql.cliente.procurar");
        try{
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                rsCPF = rs.getString("CPF");
                rsNOME = rs.getString("NOME");
                Integer i = Integer.parseInt(rs.getString("TIPO"));
                tipo = TipoCliente.values()[i];
            }
            return new Cliente(rsCPF,rsNOME,tipo,procurarEndereco(cpf));
        }catch(SQLException ex){
            throw ex;
        }finally{

        }
        
    }
    
    private EnderecoCliente procurarEndereco(String cpf){
        String rsCEP="",rsNUMERO="",rsCOMP="";
        String sql= SQLUtil.getProperties().getProperty("sql.endereco.procurar");
        try{

            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                rsCEP=rs.getString("CEP");
                rsNUMERO= rs.getString("NUMERO");
                rsCOMP = rs.getString("COMPLEMENTO");
            }
            return new EnderecoCliente(rsCEP,rsNUMERO,rsCOMP,cpf);
        }catch(SQLException ex){
            throw ex;
        }finally{
            return new EnderecoCliente(rsCEP,rsNUMERO,rsCOMP,cpf);
        }
        
    }
    
}
