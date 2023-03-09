package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		EmployeeDao dao = new EmployeeDao();
		
		ArrayList<EmployeeBean> list = dao.getAllEmployees();
		
		PrintWriter out = response.getWriter();
		out.print("<h1>Employee Records</h1>");
		out.print("<table border=1>");
		out.print("<tr>");
		out.print("<th>Id</th>");
		out.print("<th>Name</th>");
		out.print("<th>Dsgn</th>");
		out.print("<th>salary</th>");
		out.print("<th>OrgName</th>");
		out.print("<th>ACTIONS</th>");
		out.print("</tr>");
		
		for(int i=0;i<list.size();i++) 
		{
			EmployeeBean e = list.get(i);
			out.print("<tr>");
			out.print("<td>"+e.getId()+"</td>");
			out.print("<td>"+e.getName()+"</td>");
			out.print("<td>"+e.getDsgn()+"</td>");
			out.print("<td>"+e.getSalary()+"</td>");
			out.print("<td>"+e.getOrgname()+"</td>");
			out.print("<td>EDIT | DELETE </td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
