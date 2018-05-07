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

import com.cts.poc.repository.VestTemplateDao;
import com.cts.poc.model.VestTemplate;

    @RestController
	@RequestMapping("/vesttemplate")
	public class VestTemplateController {
	
	    @Autowired
	    private VestTemplateDao vestTemplateDao;

	    /*public VestTemplateController(VestTemplateDao vestTemplateDao){
	        this.vestTemplateDao = vestTemplateDao;
	    }*/

	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public VestTemplate find(@ApiPathParam(name = "id") @PathVariable long id){
	    	VestTemplate vestTemplate = null;
	    	try{
	    		vestTemplate = vestTemplateDao.findById(id);
	    	}catch(Exception ex){
	    		
	    	}
	        return vestTemplate;
	    }
	    
	    @RequestMapping(value = "/all", method = RequestMethod.GET)
	    public List<VestTemplate> all(){
	    	List list = new ArrayList();
	    	try{
	    		list = vestTemplateDao.getAllVestTemplates();
	    	}catch(Exception ex){
	    		
	    	}
	    	return list;
	    }
	/*
	   // Post methods uses the postman app 
	    @RequestMapping(method = RequestMethod.POST)
	    @ApiMethod(description = "Create a vestTemplate and save it to the database")
	    public List<VestTemplate> create(@RequestBody VestTemplate vestTemplate){
	    	List list = new ArrayList();
	    	try{
	    		vestTemplate = vestTemplateDao.save(vestTemplate);
	    		list.add(vestTemplate);
	    	}catch(Exception e){
	    		
	    	}
	        return list;
	    }

	   
	    @RequestMapping(method = RequestMethod.PUT)
	    @ApiMethod(description = "update a vestTemplate and save it to the database")
	    public List<VestTemplate> update(@RequestBody VestTemplate vestTemplate){
	    	List list = new ArrayList();
	    	try{
	    		vestTemplate = vestTemplateDao.update(vestTemplate);
	    		list.add(vestTemplate);
	    	}catch(Exception e){
	    		
	    	}
	        return list;
	    }
	    
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	    @ApiMethod(description = "Remove the vestTemplate with the provided ID from the database")
	    public List<VestTemplate> remove(@ApiPathParam(name = "id") @PathVariable long id){
	    	//vestTemplateDao.deleteById(id);

	        return null;//vestTemplateDao.findAll();
	    }
	    */
}