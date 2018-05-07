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

import com.cts.poc.repository.PlanDao;
import com.cts.poc.model.Plan;

    @RestController
	@RequestMapping("/plan")
	public class PlanController {
	
	    @Autowired
	    private PlanDao planDao;

	    /*public PlanController(PlanDao planDao){
	        this.planDao = planDao;
	    }*/

	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public Plan find(@ApiPathParam(name = "id") @PathVariable long id){
	    	Plan plan = null;
	    	try{
	    		plan = planDao.findById(id);
	    	}catch(Exception ex){
	    		
	    	}
	        return plan;
	    }
	    
	    @RequestMapping(value = "/all", method = RequestMethod.GET)
	    public List<Plan> all(){
	    	List list = new ArrayList();
	    	try{
	    		list = planDao.getAllPlans();
	    	}catch(Exception ex){
	    		
	    	}
	    	return list;
	    }
	/*
	   // Post methods uses the postman app 
	    @RequestMapping(method = RequestMethod.POST)
	    @ApiMethod(description = "Create a plan and save it to the database")
	    public List<Plan> create(@RequestBody Plan plan){
	    	List list = new ArrayList();
	    	try{
	    		plan = planDao.save(plan);
	    		list.add(plan);
	    	}catch(Exception e){
	    		
	    	}
	        return list;
	    }

	   
	    @RequestMapping(method = RequestMethod.PUT)
	    @ApiMethod(description = "update a plan and save it to the database")
	    public List<Plan> update(@RequestBody Plan plan){
	    	List list = new ArrayList();
	    	try{
	    		plan = planDao.update(plan);
	    		list.add(plan);
	    	}catch(Exception e){
	    		
	    	}
	        return list;
	    }
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	    @ApiMethod(description = "Remove the plan with the provided ID from the database")
	    public List<Plan> remove(@ApiPathParam(name = "id") @PathVariable long id){
	    	//planDao.deleteById(id);

	        return null;//planDao.findAll();
	    }
*/
}