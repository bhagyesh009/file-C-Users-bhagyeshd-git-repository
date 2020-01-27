package com.bitwise.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitwise.Dao.UserDao;
import com.bitwise.data.User;
import com.bitwise.data.*;
import com.bitwise.util.JsonUtil;

@WebServlet(name = "UserServlet", urlPatterns = "/insertUser")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserDao userDao = null;
	List<String> jsonString = new ArrayList<String>();
	String userJsonString;
	User user = new User();

	public UserServlet() {
		System.out.println("******From UserServlet***********");
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
//		int id = 0;
//		String id_string = req.getReader().lines().collect(Collectors.joining());
//		
//		System.out.println("id"+id_string);
//		user=JsonUtil.convertJsonToJava(id_string,User.class);
//		
//		 id = user.getId();
//		System.out.println("id:"+id);
//		
//		user = userDao.getUser(id);
//
//		String jsonString = JsonUtil.convertJavaToJsonString(user);
//		System.out.println("Json:"+jsonString);
//
//		resp.getWriter().write(jsonString);
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userDao = new UserDao();
		user = JsonUtil.convertJsonToJava(req.getReader().lines().collect(Collectors.joining()), User.class);
		Validation validation = new Validation();

		boolean NameValid=validation.isNameValid(user.getName());
		boolean MobileNumberValid=validation.mobnoValidation(user.getMobNo());
		
		if (NameValid &&MobileNumberValid ) {

			if (userDao.insertUser(user)) {
				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(1, 200, "Succefully Inserted")));
			} else {

				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(0, 400, "Not Inserted")));
			}
		} else {
			if (false == validation.isNameValid(user.getName())) {
				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(0, 600, "Name is not Valid Format")));
			}
			if (false == validation.mobnoValidation(user.getMobNo())) {
				resp.getWriter()
						.write(JsonUtil.convertJavaToJson(new Output(0, 700, "Mobile Number is not Valid Format")));

			}
		}

	}

}
