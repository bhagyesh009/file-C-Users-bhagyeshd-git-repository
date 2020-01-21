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

	public boolean updateName(String name,String ID_String) {
		boolean updateName = false;
		
		int ID = Integer.parseInt(ID_String);
		String updateRecordQuery="update person set name=? where id=?";
		try {
			st=con.prepareStatement(updateRecordQuery);
			st.setString(1,name);
			st.setInt(2, ID);
			int row = st.executeUpdate();

			if(row>0) {
				updateName=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return updateName;
	}

	public boolean updateMobno(String mobno,String ID_String) {
		boolean updateMobno = false;
		int ID = Integer.parseInt(ID_String);
		String updateMobnoQuery="update person set mobno=? where id=?";
		try {
			st=con.prepareStatement(updateMobnoQuery);
			st.setString(1,mobno);
			st.setInt(2, ID);
			int row = st.executeUpdate();

			if(row>0) {
				updateMobno=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return updateMobno;
	}

	public boolean updateRecord(Person person,String ID_String) {
		boolean updateRecord = false;
		int ID = Integer.parseInt(ID_String);
		String updateRecordQuery="update person set name=?,mobno=? where id=?";
		try {
			st=con.prepareStatement(updateRecordQuery);
			st.setString(1,person.getName());
			st.setString(2,person.getMobno());
			st.setInt(3, ID);
			int row = st.executeUpdate();

			if(row>0) {
				updateRecord=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return updateRecord;
	}
	
	

}
