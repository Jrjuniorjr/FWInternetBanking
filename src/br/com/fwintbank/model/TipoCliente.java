/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model;

/**
 *
 * @author lucas
 */
public enum TipoCliente {
    		VIP,
		CLASS,
		STANDARD;
                
    public int getIntTipo(TipoCliente tipo){
        if(tipo== VIP){
            return 1;
        }else if(tipo==CLASS){
            return 2;
        }else if(tipo==STANDARD){
            return 3;
        }else{
            return -1;
        }
    }
    
    public TipoCliente getTipo(int i){
        if(i==1){
            return VIP;
        }else if(i==2){
            return CLASS;
        }else if(i==3){
            return STANDARD;
        }else{
            return null;
        }
        
    }
                
}
