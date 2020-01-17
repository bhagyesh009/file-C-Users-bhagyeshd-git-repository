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
import com.bitwise.data.Validation;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String mobno = request.getParameter("mobno");

		System.out.println(name);
		System.out.println(mobno);

		Validation valid = new Validation();
		boolean nameValidation;
		boolean mobnoValidation;
		
		nameValidation = valid.nameValidation(name);
		mobnoValidation = valid.mobnoValidation(mobno);
		

		if (nameValidation == true && mobnoValidation == true) {
			Person person = new Person(name, mobno);
			AddDao addPerson = new AddDao();

			boolean addStatus = addPerson.addPerson(person);

			if (addStatus) {
				request.setAttribute("feedback", "Person Added SucessFully..!");
			} else {
				request.setAttribute("feedback", "Person is Not Added");
			}
			String feedback = (String) request.getAttribute("feedback");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else {

			if (nameValidation == false) {
				request.setAttribute("namefeedback", "Please Enter Valid Name");
							} 
			if (mobnoValidation == false) {

				request.setAttribute("mobnofeedback", "Please Enter Valid Mobile Number");
			}
			String namefeedback = (String) request.getAttribute("namefeedback");
			String mobnofeedback = (String) request.getAttribute("mobnofeedback");

			RequestDispatcher rd = request.getRequestDispatcher("AddPerson.jsp");
			rd.forward(request, response);
		}

	}

}
