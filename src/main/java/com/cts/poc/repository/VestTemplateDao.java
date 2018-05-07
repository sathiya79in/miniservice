package com.cts.poc.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cts.poc.model.VestTemplate;

@Component
public class VestTemplateDao extends BaseDAO{
	
	
	
	public List<VestTemplate> getAllVestTemplates() throws Exception {
		List<VestTemplate> employeeList = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM VestTemplate");
			employeeList= query.list();
			
		}catch(Exception e){
			System.out.println("VestTemplateDAO Exception"+e);
			throw e;
		}finally{
			session.close();
		}
		return employeeList;
	}
	
	public VestTemplate findById(long templateId) throws Exception {
		VestTemplate template = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM VestTemplate E where E.templateId =?");
			query.setParameter(0,templateId);
			
			List list= query.list();
			if(list!=null && list.get(0) != null){
				template = (VestTemplate)list.get(0);
			}
		}catch(Exception e){
			System.out.println("VestTemplateDAO Exception"+e);
			throw e;
		}finally{
			session.close();
		}
		return template;
	}
	
	public VestTemplate save(VestTemplate template) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		
		try{
			long templateId = (long) session.save(template);
			session.flush();
			template = (VestTemplate) session.load(VestTemplate.class, templateId);
		}catch(Exception exception){
			System.out.println("VestTemplateDAO Exception"+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return template;
	}
	
	public VestTemplate update(VestTemplate template) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		try{
			session.saveOrUpdate(template);
			session.flush();
			template = (VestTemplate) session.load(VestTemplate.class, template.getTemplateId());
		}catch(Exception exception){
			System.out.println(" Exception"+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return template;
	}
}