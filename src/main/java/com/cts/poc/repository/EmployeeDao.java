package com.cts.poc.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cts.poc.model.Employee;

@Component
public class EmployeeDao extends BaseDAO{
	
	
	
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> employeeList = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM Employee");
			employeeList= query.list();
			
		}catch(Exception e){
			System.out.println("EmployeeDAo Exception"+e);
			throw e;
		}finally{
			session.close();
		}
		return employeeList;
	}
	
	public Employee findById(long id) throws Exception {
		Employee employee = null;
		Session session = getSession();		
		try{
			
			Query query = session.createQuery("FROM Employee E where E.id =?");
			query.setParameter(0,id);
			
			List list= query.list();
			if(list!=null && list.get(0) != null){
				employee = (Employee)list.get(0);
			}
		}catch(Exception e){
			System.out.println("EmployeeDAo Exception"+e);
			throw e;
		}finally{
			session.close();
		}
		return employee;
	}
	
	public Employee save(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		
		try{
			long id = (long) session.save(employee);
			session.flush();
			employee = (Employee) session.load(Employee.class, id);
		}catch(Exception exception){
			System.out.println("EmployeeDAo Exception"+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return employee;
	}
	
	public Employee update(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		
		Session session = getSession();
		try{
			session.saveOrUpdate(employee);
			session.flush();
			employee = (Employee) session.load(Employee.class, employee.getId());
		}catch(Exception exception){
			System.out.println("EmployeeDAo Exception"+exception);
			throw exception;
		}finally{
			session.close();
		}
		
		return employee;
	}
}