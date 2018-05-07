package com.cts.poc.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cts.poc.model.Award;

@Component
public class AwardDao extends BaseDAO{
	
	
	
	public List<Award> getAllAwards() throws Exception {
		List<Award> employeeList = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM Award");
			employeeList= query.list();
			
		}catch(Exception e){
			System.out.println("AwardDAo Exception"+e);
			throw e;
		}finally{
			session.close();
		}
		return employeeList;
	}
	
	public Award findById(long id) throws Exception {
		Award award = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM Award E where E.id =?");
			query.setParameter(0,id);
			
			List list= query.list();
			if(list!=null && list.get(0) != null){
				award = (Award)list.get(0);
			}
		}catch(Exception e){
			System.out.println("AwardDAo Exception"+e);
			throw e;
		}finally{
			session.close();
		}
		return award;
	}
	
	public Award save(Award award) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		
		try{
			long id = (long) session.save(award);
			session.flush();
			award = (Award) session.load(Award.class, id);
		}catch(Exception exception){
			System.out.println("AwardDAo Exception"+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return award;
	}
	
	public Award update(Award award) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		try{
			session.saveOrUpdate(award);
			session.flush();
			award = (Award) session.load(Award.class, award.getId());
		}catch(Exception exception){
			System.out.println("AwardDAo Exception"+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return award;
	}
}