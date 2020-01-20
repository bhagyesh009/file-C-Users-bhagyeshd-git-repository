package com.bitwise.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitwise.Dao.AddDao;
import com.bitwise.Dao.DeleteDao;
import com.bitwise.Dao.UpdateDao;
import com.bitwise.data.Person;
import com.bitwise.data.Validation;

@WebServlet(name = "UpdateServlet", urlPatterns = "/")
public class UpdateServlet extends HttpServlet {

	UpdateDao updatePerson = new UpdateDao();
	Validation valid = new Validation();
	boolean nameValidation;
	boolean mobnoValidation;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {

		case "/updateName":

			break;

		case "/updateMobno":

			break;

		case "/updateRecord":
			updateRecord(request, response);
			break;

		default:
			break;

		}

	}

	public void updateRecord(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String mobno = request.getParameter("mobno");

		String ID_String = request.getParameter("ID");

		System.out.println("ID: " + ID_String);
		if (ID_String == "") {

			request.setAttribute("feedback", "ID cannot be NULL");
			String feedback = (String) request.getAttribute("feedback");
			RequestDispatcher rd = request.getRequestDispatcher("UpdatePerson.jsp");
			rd.forward(request, response);

			System.out.println("ID: " + ID_String);
		} else {

			boolean checkID = updatePerson.checkID(ID_String);
			if (checkID) {
				nameValidation = valid.nameValidation(name);
				mobnoValidation = valid.mobnoValidation(mobno);

				if (nameValidation == true && mobnoValidation == true) {
					Person person = new Person(name, mobno);
					boolean updateRecord = updatePerson.updateRecord(person);
					if (updateRecord) {
						request.setAttribute("feedback", "Person Updated SucessFully..!");
					} else {
						request.setAttribute("feedback", "Person is Not Updated");
					}
					String feedback = (String) request.getAttribute("feedback");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);

				}else {
					if (nameValidation == false) {
						request.setAttribute("namefeedback", "Please Enter Valid Name");
									} 
					if (mobnoValidation == false) {

						request.setAttribute("mobnofeedback", "Please Enter Valid Mobile Number");
					}
					String namefeedback = (String) request.getAttribute("namefeedback");
					String mobnofeedback = (String) request.getAttribute("mobnofeedback");

					RequestDispatcher rd = request.getRequestDispatcher("UpdateRecord.jsp");
					rd.forward(request, response);
				}

			} else {
				request.setAttribute("feedback", "Record is not present ");
				String feedback = (String) request.getAttribute("feedback");
				RequestDispatcher rd = request.getRequestDispatcher("UpdateRecord.jsp");
				rd.forward(request, response);

			}

		}

	}

}
