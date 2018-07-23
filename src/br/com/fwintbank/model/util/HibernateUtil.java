/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fwintbank.model.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author keyalisth
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    private static Session session;
    static{
         AnnotationConfiguration acfg = new AnnotationConfiguration();
         
         acfg.configure();
         
         sessionFactory = acfg.buildSessionFactory();
   
         session = sessionFactory.openSession();
    }
    
    public static Session GetSession(){
        if(session==null || !session.isOpen()){
            session = sessionFactory.openSession();
        }
        return session;
    }
    
    
    
}
