package com.mzos.dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mzos.bean.Employee;

public class EmployeeRepo {
	
	Connection con;
	 PreparedStatement ps;
	 Statement st;
	 public EmployeeRepo() {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				  con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/mzos","root","Hemantd@123");
				  st = con.createStatement();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
		public boolean insertEmployee(Employee emp) {


			PreparedStatement ps;
			
			try {
				ps = con.prepareStatement("insert into empDetails(empId,empName,empSal) values(?,?,?)");
				ps.setInt(1,emp.getEmpId());
				 ps.setString(2,emp.getEmpName());
				 ps.setFloat(3,emp.getEmpSal());
				 
				 if(ps.executeUpdate()==1) 
				return true;
				  
			 else 
				 return false;	 
			
			 
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

	}
		
		
		public boolean selectAllEmployees(){
			
			try {
				ResultSet rs = st.executeQuery("select * from empDetails");
				
				while(rs.next()) {
					rs.getInt(1);
					rs.getString(2);
					rs.getString(3);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			
		}
//	
//	public String selectEmployeeById(int empId) {
//		try {
//			Statement stmt=con.createStatement();
//			ResultSet rs= stmt.executeQuery("Select * from Employee Where empId="+empId);
//			while (rs.next()) {
//				rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3);
//				
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		return true;
//	}

}
