package com.javacode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ExcelImport.DataBaseConnection;

class MainMethodTesting1 {
	
	public static void main(String[] args) {
		
		
		System.out.println("Main");
	}
	
	public void updateData()
	{
		Connection connection=DataBaseConnection.getDefaultConnection();
		try {
			Statement st=connection.createStatement();
			String query="select * from promotion";
			ResultSet ss=st.executeQuery(query);
			while(ss.next())
			{
				String qu="";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

