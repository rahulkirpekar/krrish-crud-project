package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.royal.bean.EmployeeBean;
import com.royal.util.DBConnection;

public class EmployeeDao 
{
	public int insert(EmployeeBean bean)
	{
		int rowsAffected=0;
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		String insertQuery = "INSERT INTO emp(name,dsgn,salary,orgname) VALUES('"+bean.getName()+"','"+bean.getDsgn()+"',"+bean.getSalary()+",'"+bean.getOrgname()+"')";
		System.out.println("insertQuery--"+insertQuery);
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
				rowsAffected = stmt.executeUpdate(insertQuery); 
				
				System.out.println("rowsAffected - " + rowsAffected);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Emp - insert() - Db not connected");
		}
		
		return rowsAffected;
	}

	public ArrayList<EmployeeBean> getAllEmployees() 
	{
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		String selectQuery ="SELECT * FROM emp";	
		if (conn!=null) 
		{
			try 
			{
				stmt = conn.createStatement();
				rs = stmt.executeQuery(selectQuery); 
				EmployeeBean ebean = null;
				while(rs.next()) 
				{
					ebean = new EmployeeBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5));
					list.add(ebean);
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Emp - getAllEmployees() - Db not connected");
		}
		return list;
	}	


	public static void main(String[] args) 
	{
		EmployeeDao dao = new EmployeeDao();
		
		ArrayList<EmployeeBean> list = dao.getAllEmployees();

		for (EmployeeBean e : list) 
		{
			System.out.println(e.getId() + " " + e.getName() + " " + e.getOrgname() + " " + e.getSalary());
			
		}
		
	}

}
