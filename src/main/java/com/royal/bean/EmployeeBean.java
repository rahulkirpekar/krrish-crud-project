package com.royal.bean;

public class EmployeeBean 
{
	 private int  id ;
     private String name ;
     private String dsgn ;
     private float  salary ;
     private String orgname ;

     public EmployeeBean() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeBean(int id, String name, String dsgn, float salary, String orgname) {
		super();
		this.id = id;
		this.name = name;
		this.dsgn = dsgn;
		this.salary = salary;
		this.orgname = orgname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDsgn() {
		return dsgn;
	}

	public void setDsgn(String dsgn) {
		this.dsgn = dsgn;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
}
