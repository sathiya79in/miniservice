package com.cts.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cts.poc.model.Company;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Table;


@Entity
@Table( name = "employee")
public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="EMP_ID")
	    private long id;
	    
	    @Column(name="FIRST_NAME")
	    private String firstName;
	    
	    @Column(name="LAST_NAME")
	    private String lastName;

	    @ManyToOne
	    @JoinColumn(name="ID",  insertable=false, updatable = false)    
	    private Company company;

	    @Column(name="ID")
		private long companyId;
	    
	    protected Employee(){}

	    public Employee(String firstName, String lastName){

	        this.firstName = firstName;
	        this.lastName = lastName;
	    }

	    public long getId() {
	        return id;
	    }

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setId(long id) {
			this.id = id;
		}

		/**
		 * @return the company
		 */
		public Company getCompany() {
			return company;
		}

		/**
		 * @param company the company to set
		 */
		public void setCompany(Company company) {
			this.company = company;
		}
	
		public void setCompanyId(long companyId) {
			this.companyId= companyId;
		}

		 public long getCompanyId() {
		        return companyId;
		    }
}
