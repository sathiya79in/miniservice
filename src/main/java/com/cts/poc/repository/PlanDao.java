package com.cts.poc.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cts.poc.model.Plan;

@Component
public class PlanDao extends BaseDAO{
	
	
	
	public List<Plan> getAllPlans() throws Exception {
		List<Plan> employeeList = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM Plan");
			employeeList= query.list();
			
		}catch(Exception e){
			System.out.println("PlanDAo Exception"+e);
			throw e;
		}finally{
			session.close();
		}
		return employeeList;
	}
	
	public Plan findById(long planId) throws Exception {
		Plan plan = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM Plan E where E.planId =?");
			query.setParameter(0,planId);
			
			List list= query.list();
			if(list!=null && list.get(0) != null){
				plan = (Plan)list.get(0);
			}
		}catch(Exception e){
			System.out.println("PlanDAo Exception"+e);
			throw e;
		}finally{
			session.close();
		}
		return plan;
	}
	
	public Plan save(Plan plan) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		
		try{
			long planId = (long) session.save(plan);
			session.flush();
			plan = (Plan) session.load(Plan.class, planId);
		}catch(Exception exception){
			System.out.println("PlanDAo Exception"+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return plan;
	}
	
	public Plan update(Plan plan) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		try{
			session.saveOrUpdate(plan);
			session.flush();
			plan = (Plan) session.load(Plan.class, plan.getPlanId());
		}catch(Exception exception){
			System.out.println("PlanDAo Exception"+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return plan;
	}
}