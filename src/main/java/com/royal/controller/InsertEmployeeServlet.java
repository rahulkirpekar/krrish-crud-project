package com.royal.controller;

import java.io.IOException;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertEmployeeServlet
 */
public class InsertEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String dsgn = request.getParameter("dsgn");
		float salary = Float.parseFloat(request.getParameter("salary"));
		String orgname = request.getParameter("orgname");

		EmployeeBean bean = new EmployeeBean(0, name, dsgn, salary, orgname);
	
		EmployeeDao dao = new EmployeeDao();
		RequestDispatcher rd = null;
		int rowsAffected = dao.insert(bean);
		if (rowsAffected > 0) 
		{
			System.out.println("if....block");
			rd = request.getRequestDispatcher("ListEmployeeServlet");
		} else 
		{
			System.out.println("else....block");
			rd = request.getRequestDispatcher("employeeregistration.html");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
