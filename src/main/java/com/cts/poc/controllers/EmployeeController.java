package com.cts.poc.controllers;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.poc.repository.EmployeeDao;
import com.cts.poc.model.Employee;

    @RestController
	@RequestMapping("/employee")
	public class EmployeeController {
	
	    @Autowired
	    private EmployeeDao employeeDao;

	    /*public EmployeeController(EmployeeDao employeeDao){
	        this.employeeDao = employeeDao;
	    }*/

	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public Employee find(@ApiPathParam(name = "id") @PathVariable long id){
	    	Employee employee = null;
	    	try{
	    		employee = employeeDao.findById(id);
	    	}catch(Exception ex){
	    		
	    	}
	        return employee;
	    }
	    
	    @RequestMapping(value = "/all", method = RequestMethod.GET)
	    public List<Employee> all(){
	    	List list = new ArrayList();
	    	try{
	    		list = employeeDao.getAllEmployees();
	    	}catch(Exception ex){
	    		
	    	}
	    	return list;
	    }
	/*
	   // Post methods uses the postman app 
	    @RequestMapping(method = RequestMethod.POST)
	    @ApiMethod(description = "Create a employee and save it to the database")
	    public List<Employee> create(@RequestBody Employee employee){
	    	List list = new ArrayList();
	    	try{
	    		employee = employeeDao.save(employee);
	    		list.add(employee);
	    	}catch(Exception e){
	    		
	    	}
	        return list;
	    }

	   
	    @RequestMapping(method = RequestMethod.PUT)
	    @ApiMethod(description = "update a employee and save it to the database")
	    public List<Employee> update(@RequestBody Employee employee){
	    	List list = new ArrayList();
	    	try{
	    		employee = employeeDao.update(employee);
	    		list.add(employee);
	    	}catch(Exception e){
	    		
	    	}
	        return list;
	    }
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	    @ApiMethod(description = "Remove the employee with the provided ID from the database")
	    public List<Employee> remove(@ApiPathParam(name = "id") @PathVariable long id){
	    	//employeeDao.deleteById(id);

	        return null;//employeeDao.findAll();
	    }
	    */
}