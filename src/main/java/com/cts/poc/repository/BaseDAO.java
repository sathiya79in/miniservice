/**
 * 
 */
package com.cts.poc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 136922
 *
 */
@Component
public class BaseDAO{
    
	@Autowired
	private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }
	
}
