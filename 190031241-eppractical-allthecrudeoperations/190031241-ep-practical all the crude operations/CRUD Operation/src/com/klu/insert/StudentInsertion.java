package com.klu.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.klu.Bean.StudentBean;
import com.klu.Connections.DBUtil;

public class StudentInsertion {
	
	public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException{
		
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");  
		ps.setInt(1,student.getReg_no());
		ps.setString(2,student.getName());
		ps.setString(3,student.getEmail());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}
	
	public void StudentDelete_regno(int number) throws ClassNotFoundException, SQLException{
		
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("DELETE FROM student WHERE reg_no = ?");  
		ps.setInt(1,number);
		int row = ps.executeUpdate();
		System.out.println("Number of deleted records: " + row);
		con.close();
	}
	
	public void StudentDelete_name(String na) throws ClassNotFoundException, SQLException{
		
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("DELETE FROM student WHERE name = ?");  
		ps.setString(1,na);
		int row = ps.executeUpdate();
		System.out.println("Number of deleted records: " + row);
		con.close();
	}
	
	public void StudentDelete_email(String na_1) throws ClassNotFoundException, SQLException{
	
	Connection con=DBUtil.DBConnection();
	PreparedStatement ps=con.prepareStatement("DELETE FROM student WHERE email = ?");  
	ps.setString(1,na_1);
	int row = ps.executeUpdate();
	System.out.println("Number of deleted records: " + row);
	con.close();
	}
	
	public void StudentUpdate_name(int num,String em_1) throws ClassNotFoundException, SQLException{
		
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("update student set name = ? where reg_no = "+num);  
		ps.setString(1,em_1);
		int update = ps.executeUpdate();
		System.out.println("Number of updated records: " + update);
		con.close();
	 }
	
	public void StudentUpdate_email(int num,String em_2) throws ClassNotFoundException, SQLException{
		
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("update student set email = ? where reg_no = "+num);  
		ps.setString(1,em_2);
		int update = ps.executeUpdate();
		System.out.println("Number of updated records: " + update);
		con.close();
	  }
	
	public void Student_Display() throws ClassNotFoundException, SQLException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("select * from student ");
		ResultSet display = (ResultSet) ps.executeQuery();
		System.out.println("Reg_No		Name		Email-Id");
		while(display.next()) {
			System.out.print(display.getInt(1));
			System.out.print("	"+display.getString(2));
			System.out.print("	"+display.getString(3));
			System.out.println();
		}
		con.close();
	}
}