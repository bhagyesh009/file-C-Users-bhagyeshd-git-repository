package com.bitwise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.bitwise.Dao.AddDao;
import com.bitwise.data.Person;
@WebServlet("/add")
public class AddServlet extends HttpServlet{

	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String mobno=request.getParameter("mobno"); 
		
		System.out.println(name);
		System.out.println(mobno);
		
		
		Person person = new Person(name, mobno);
		AddDao addPerson =new AddDao();
		
		addPerson.addPerson(person);
		
		
		
	}
	
}
