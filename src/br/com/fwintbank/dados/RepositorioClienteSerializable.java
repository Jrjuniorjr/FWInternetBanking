/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.dados;

import br.com.fwintbank.exceptions.ClienteExistenteException;
import br.com.fwintbank.exceptions.ClienteNotFoundException;
import br.com.fwintbank.model.Cliente;
import br.com.fwintbank.model.IRepCliente;
import br.com.fwintbank.model.util.SerilizacaoUtil;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author keyalisth
 */
public class RepositorioClienteSerializable implements IRepCliente{
    private final String file = "clientes.ser";

    @Override
    public void inserir(Cliente e) throws Exception {
        Map<String,Cliente> map;
        try{
            map = SerilizacaoUtil.deserializar(file);
            if(!map.containsKey(e.getCpf())){
                map.put(e.getCpf(), e);
                SerilizacaoUtil.serializar(map, file);
            }else{
                throw new ClienteExistenteException();
            }
        }catch(FileNotFoundException ex){
            map = new HashMap<>();
            map.put(e.getCpf(), e);
            SerilizacaoUtil.serializar(map, file);
        }
    }

    @Override
    public void atualizar(Cliente e) throws Exception {
        Map<String,Cliente> map;
        try{
            map=SerilizacaoUtil.deserializar(file);
            if(map.containsKey(e.getCpf())){
                map.remove(e.getCpf());
                map.put(e.getCpf(), e);
                SerilizacaoUtil.serializar(map, file);
            }else{
                throw new ClienteNotFoundException();
            }
        }catch(FileNotFoundException ex){
            throw new ClienteNotFoundException();
        }
    }

    @Override
    public void remover(Cliente e) throws Exception {
        Map<String,Cliente> map;
        try{
            map=SerilizacaoUtil.deserializar(file);
            if(map.containsKey(e.getCpf())){
                map.remove(e.getCpf());
                SerilizacaoUtil.serializar(map, file);
            }else{
                throw new ClienteNotFoundException();
            }
        }catch(FileNotFoundException ex){
            throw new ClienteNotFoundException();
        }
    }

    @Override
    public Cliente procurar(String key) throws Exception {
        Map<String,Cliente> map;
        Cliente c = null;
        try{
            map = SerilizacaoUtil.deserializar(file);
            if(map.containsKey(key)){
                c= map.get(key);
            }else{
                throw new ClienteNotFoundException();
            }
            
        }catch(FileNotFoundException ex){
            throw new ClienteNotFoundException();
        }
        return c;
    }
}
