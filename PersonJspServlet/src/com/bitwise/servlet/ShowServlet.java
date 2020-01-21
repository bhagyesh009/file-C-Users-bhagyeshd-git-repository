package com.bitwise.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitwise.Dao.ShowDao;
import com.bitwise.data.Person;

@WebServlet(name = "ShowServlet", urlPatterns = "/")

public class ShowServlet extends HttpServlet {
	ShowDao showDao = new ShowDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {

		case "/allPerson":
		allPerson(request, response);
			break;

		case "/byName":
		//	byName(request, response);
			break;

		case "/byMobno":
		//	byMobno(request, response);
			break;

		case "/byID":
		///	byID(request, response);

			break;
			
		default:
			break;

		}

	}

	public void allPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		List<Person> personData= showDao.showAll();
		request.setAttribute("personData", personData);
	
		RequestDispatcher rd = request.getRequestDispatcher("showAllPerson.jsp");
		rd.forward(request, response);

		
	}

}
