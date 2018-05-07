package com.cts.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table( name = "company")
public class Company {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID")
	    private long companyId;
	    
	    @Column(name="NAME")
	    private String name;
	    
	    @Column(name="SYMBOL")
	    private String symbol;
	   

		protected Company() {
			
		}

		public Company(String name, String symbol) {
			super();
			this.name = name;
			this.symbol = symbol;
		}

		public long getCompanyId() {
			return companyId;
		}

		public void setCompanyId(long companyId) {
			this.companyId = companyId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		
	    
}

