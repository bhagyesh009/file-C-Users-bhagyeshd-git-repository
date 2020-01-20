package com.bitwise.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitwise.data.Person;
import com.bitwise.util.JDBCConnection;

public class UpdateDao {
	PreparedStatement st = null;
	ResultSet rs = null;
	Connection con = JDBCConnection.jdbcConnection();
	int status;

	public boolean checkID(String ID_String) {
		boolean checkID = false;

		int ID = Integer.parseInt(ID_String);

		String getQuery = "select status from person where id=?";

		try {
			st = con.prepareStatement(getQuery);
			st.setInt(1, ID);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				status = rs.getInt(1);
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("status" + status);

		if (status == 0) {
			return checkID;
		} else {
			checkID=true;
		}

		return checkID;
	}

	public boolean updateName(Person person) {
		boolean updateName = false;
		
		

		return updateName;
	}

	public boolean updateMobno(Person person) {
		boolean updateMobno = false;

		return updateMobno;
	}

	public boolean updateRecord(Person person) {
		boolean updateRecord = false;

		return updateRecord;
	}

}
