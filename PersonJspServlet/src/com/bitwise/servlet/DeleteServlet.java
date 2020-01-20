package com.bitwise.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.bitwise.Dao.DeleteDao;

@WebServlet("/delete")

public class DeleteServlet extends HttpServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	 
		String ID_String=request.getParameter("ID");
		System.out.println("ID: "+ID_String);
		if (ID_String == "") {
			
			request.setAttribute("feedback", "ID cannot be NULL");
			String feedback = (String) request.getAttribute("feedback");
			RequestDispatcher rd = request.getRequestDispatcher("DeletePerson.jsp");
			rd.forward(request, response);

			System.out.println("ID: "+ID_String);

		}else {
		
		DeleteDao deletePerson = new DeleteDao();
		boolean deleteStatus=deletePerson.deletePerson(ID_String);
		
		if(deleteStatus) {
			request.setAttribute("feedback", "Record deleted succesfully...!");
			String feedback = (String) request.getAttribute("feedback");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("feedback", "Record is not present ");
			String feedback = (String) request.getAttribute("feedback");
			RequestDispatcher rd = request.getRequestDispatcher("DeletePerson.jsp");
			rd.forward(request, response);
			
		}
		
		
		}
		
		
		
		
	}
}
