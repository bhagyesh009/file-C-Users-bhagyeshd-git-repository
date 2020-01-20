package com.bitwise.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitwise.util.JDBCConnection;

public class DeleteDao {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	int status;

	public boolean deletePerson(String ID_String) {
		int ID = Integer.parseInt(ID_String);
		boolean deleteRecord = false;
		Connection con = JDBCConnection.jdbcConnection();

		String getQuery = "select status from person where id=?";

		System.out.println("ID: " + ID_String);

		try {
			st = con.prepareStatement(getQuery);
			st.setInt(1, ID);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				status = rs.getInt(1);
				break;
			}

			System.out.println("status" + status);

			if (status == 0) {
				return deleteRecord;
			} else {
				String deleteQuery = "update person SET status=0 where id=?";
				st = con.prepareStatement(deleteQuery);
				st.setInt(1, ID);
				int row = st.executeUpdate();

				if (row > 0) {
					deleteRecord = true;
				}

			}

		} catch (SQLException e2) {

			e2.printStackTrace();
		}

		return deleteRecord;

	}
}