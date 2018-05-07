package com.cts.poc.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cts.poc.model.Company;

@Component
public class CompanyDao extends BaseDAO{
	
	
	
	public List<Company> getAllCompanies() throws Exception {
		List<Company> companyList = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM Company");
			companyList= query.list();
			
		}catch(Exception Excep){
			System.out.println("CompanyDAO Exception "+Excep);
			throw Excep;
		}finally{
			session.close();
		}
		return companyList;
	}
	
	public Company findById(long id) throws Exception {
		Company company = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM Company C where C.companyId =?");
			query.setParameter(0,id);
			
			List list= query.list();
			if(list!=null && list.get(0) != null){
				company = (Company)list.get(0);
			}
		}catch(Exception Excep){
			System.out.println("CompanyDAO Exception "+Excep);
			throw Excep;
		}finally{
			session.close();
		}
		return company;
	}
	
	public Company save(Company company) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		
		try{
			long id = (long) session.save(company);
			session.flush();
			company = (Company) session.load(Company.class, id);
		}catch(Exception exception){
			System.out.println("CompanyDAO Exception "+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return company;
	}
	
	public Company update(Company company) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		try{
			session.saveOrUpdate(company);
			session.flush();
			company = (Company) session.load(Company.class, company.getCompanyId());
		}catch(Exception exception){
			System.out.println("CompanyDAO Exception "+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return company;
	}
}