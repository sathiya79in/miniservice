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

import com.cts.poc.repository.AwardDao;
import com.cts.poc.model.Award;

    @RestController
	@RequestMapping("/award")
	public class AwardController {
	
	    @Autowired
	    private AwardDao awardDao;

	    /*public AwardController(AwardDao awardDao){
	        this.awardDao = awardDao;
	    }*/

	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public Award find(@ApiPathParam(name = "id") @PathVariable long id){
	    	Award award = null;
	    	try{
	    		award = awardDao.findById(id);
	    	}catch(Exception ex){
	    		
	    	}
	        return award;
	    }
	    
	    @RequestMapping(value = "/all", method = RequestMethod.GET)
	    public List<Award> all(){
	    	List list = new ArrayList();
	    	try{
	    		list = awardDao.getAllAwards();
	    	}catch(Exception ex){
	    		
	    	}
	    	return list;
	    }
	
	   // Post methods uses the postman app 
	    @RequestMapping(method = RequestMethod.POST)
	    @ApiMethod(description = "Create a award and save it to the database")
	    public List<Award> create(@RequestBody Award award){
	    	List list = new ArrayList();
	    	try{
	    		award = awardDao.save(award);
	    		list.add(award);
	    	}catch(Exception e){
	    		
	    	}
	        return list;
	    }

	   
	    @RequestMapping(method = RequestMethod.PUT)
	    @ApiMethod(description = "update a award and save it to the database")
	    public List<Award> update(@RequestBody Award award){
	    	List list = new ArrayList();
	    	try{
	    		award = awardDao.update(award);
	    		list.add(award);
	    	}catch(Exception e){
	    		
	    	}
	        return list;
	    }
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	    @ApiMethod(description = "Remove the award with the provided ID from the database")
	    public List<Award> remove(@ApiPathParam(name = "id") @PathVariable long id){
	    	//awardDao.deleteById(id);

	        return null;//awardDao.findAll();
	    }
}