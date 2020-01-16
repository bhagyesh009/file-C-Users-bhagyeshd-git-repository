package com.bitwise.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		
		if(name!=null && mobno.length()==10) {
		Person person = new Person(name, mobno);
		AddDao addPerson =new AddDao();
		
		boolean addStatus=addPerson.addPerson(person);
		
		if(addStatus) {
			request.setAttribute("feedback","Person Added SucessFully..!");
		}else {
			request.setAttribute("feedback","Person is Not Added");
			System.out.println("Added succesfully");
		}
		}else {
			
			System.out.println("Not able to add");
		}
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	
}
