
package br.com.fwintbank.dados;

import br.com.fwintbank.model.Cliente;
import br.com.fwintbank.model.EnderecoCliente;
import br.com.fwintbank.model.IRepCliente;
import br.com.fwintbank.model.TipoCliente;
import br.com.fwintbank.model.util.*;
import java.sql.*;


public class RepositorioClienteJDBC implements IRepCliente{

  
    private void inserirEndereco(Cliente e){
        try{
            String sql = "INSERT INTO TB_ENDERECO VALUES ( ? , ? , ? )";
            PreparedStatement stmt= JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getEndereco().getCep());
            stmt.setString(2, e.getEndereco().getNumero());
            stmt.setString(3, e.getEndereco().getComplemento());
            stmt.executeUpdate();
        }catch(SQLException ex){
            //Erro na execução do comando SQL;
        }
        
    }
    
    public void inserir(Cliente e) throws Exception {
        try{
            String sql = "INSERT INTO TB_CLIENTE VALUES( ? , ? )";
        //  String sql = "INSERT INTO TB_CLIENE VALUES(? , ? , ? ");
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getCpf());
            stmt.setString(2, e.getNome());    
        /*
            if(e.getTipo()==TipoCliente.CLASS){
                stmt.setString(3, "1");
            }else if(e.getTipo()==TipoCliente.STANDARD){
                stmt2.setString(3, "2");
            }else{
                stmt2.setString(3, "3");
            }
        */
            
            stmt.executeUpdate();
            
            if(e.getEndereco()!=null){
             inserirEndereco(e);   
            }
        }catch(SQLException ex){
            //Erro na execução do comando SQL;
        }
    }

    private void atualizarEndereco(Cliente e) throws Exception{
        try{
            String sql1 = "UPDATE TB_ENDERECO SET CEP = ? WHERE TB_CLIENTE_CPF = ?";
            String sql2 = "UPDATE TB_ENDERECO SET NUMERO = ? WHERE TB_CLIENTE_CPF = ?";
            String sql3 = "UPDATE TB_ENDERECO SET COMPLEMENTO = ? WHERE TB_CLIENTE_CPF = ?";
            PreparedStatement stmt1 = JDBCConnectionUtil.getConnection().prepareStatement(sql1);
            PreparedStatement stmt2 = JDBCConnectionUtil.getConnection().prepareStatement(sql2);
            PreparedStatement stmt3 = JDBCConnectionUtil.getConnection().prepareStatement(sql3);
            stmt1.setString(1, e.getEndereco().getCep());
            stmt1.setString(2, e.getCpf());
            stmt2.setString(1, e.getEndereco().getNumero());
            stmt2.setString(2, e.getCpf());
            stmt3.setString(1, e.getEndereco().getComplemento());
            stmt3.setString(2, e.getCpf());
            stmt1.executeUpdate();
            stmt2.executeUpdate();
            stmt3.executeUpdate();
        }catch(SQLException ex){
            //Erro na execução do SQL
        }
    }
    
    public void atualizar(Cliente e) throws Exception {
        //Tentar depois fazer o atualizar removendo e adicionando outra vez o cliente;
        
        try{
            String sql = "UPDATE TB_CLIENTE SET NOME = ? WHERE CPF = ?";
        //    String sql2 = "UPDATE TB_CLIENTE SET TIPOCLIENTE = ? WHERE CPF = ? ";
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
        //    PreparedStatement stmt2 = JDBCConnectionUtil.getConnection().prepareStatement(sql2);
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getCpf());
         /*
            if(e.getTipo()==TipoCliente.CLASS){
                stmt2.setString(1, "1");
            }else if(e.getTipo()==TipoCliente.STANDARD){
                stmt2.setString(1, "2");
            }else{
                stmt2.setString(1, "3");
            }
        */
            stmt.executeUpdate();
        //  stmt2.executeUpdate();
            if(e.getEndereco()!=null){
             atualizarEndereco(e);   
            }
        }catch(SQLException ex){
            //erro na execucao do SQL
        }
    }

    
    public void remover(Cliente e) throws Exception {
        try{
            String sql= "DELETE FROM TB_CLIENTE WHERE CPF = ?";
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, e.getCpf());
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            
        }

    }

    
    public Cliente procurar(String cpf) throws Exception {
        String rsCPF="",rsNOME="";
        TipoCliente tipo= TipoCliente.STANDARD;
        try{
            String sql = "SELECT * FROM TB_CLIENTE WHERE CPF = ?";
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                rsCPF = rs.getString("CPF");
                rsNOME = rs.getString("NOME");
                /*
                if(rs.getString("TIPOCLIENTE")=="1"){
                    tipo = TipoCliente.CLASS;
                }else if(rs.getString("TIPOCLIENTE")=="2"){
                    tipo = TipoCliente.STANDARD;
                }else{
                    tipo = TipoCliente.VIP;
                }
                */
                
            }
           
        }catch(SQLException ex){
            
        }finally{
            return new Cliente(rsCPF,rsNOME,tipo,procurarEndereco(cpf));
        }
        
    }
    
    private EnderecoCliente procurarEndereco(String cpf){
        String rsCEP="",rsNUMERO="",rsCOMP="";
        try{
            String sql ="SELECT * FROM TB_ENDERECO WHERE TB_CLIENTE_CPF = ?";
            PreparedStatement stmt = JDBCConnectionUtil.getConnection().prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                rsCEP=rs.getString("CEP");
                rsNUMERO= rs.getString("NUMERO");
                rsCOMP = rs.getString("COMPLEMENTO");
            }
        }catch(SQLException ex){
            
        }finally{
            return new EnderecoCliente(rsCEP,rsNUMERO,rsCOMP);
        }
        
    }
    
}
