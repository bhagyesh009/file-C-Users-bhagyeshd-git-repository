package com.bitwise.Dao;

import com.bitwise.data.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bitwise.util.JDBCConnection;

public class UserDao {

	PreparedStatement st = null;
	ResultSet rs = null;
	Connection con = JDBCConnection.jdbcConnection();

	/*
	 * public List<User> getUser() {
	 * 
	 * String getUserQuery = "select id,name,mobno from user where status != 0";
	 * 
	 * try { st = con.prepareStatement(getUserQuery); rs = st.executeQuery();
	 * 
	 * while (rs.next()) { int id = rs.getInt(1); String name = rs.getString(2);
	 * long mobNo = rs.getLong(3); User user = new User(id, name, mobNo);
	 * userList.add(user); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return userList; }
	 */

	public boolean insertUser(User user) {

		String insertUserQuery = "insert into user(name,mobNo) values(?,?)";
		try {
			st = con.prepareStatement(insertUserQuery);
			st.setString(1, user.getName());
			st.setLong(2, user.getMobNo());

			int row = st.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
