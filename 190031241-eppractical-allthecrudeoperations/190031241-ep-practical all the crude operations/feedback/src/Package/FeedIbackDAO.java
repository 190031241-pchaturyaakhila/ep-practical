package Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedIbackDAO {

	public int feedback_insert(FeedbackBean fb) throws ClassNotFoundException, SQLException{
	
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement("insert into feedback values(?,?,?,?,?,?,?)");  
		ps.setInt(1, fb.getRegno());
		ps.setString(2, fb.getStdName());
		ps.setString(3,fb.getQ1());
		ps.setString(4,fb.getQ2());
		ps.setString(5,fb.getQ3());
		ps.setString(6,fb.getQ4());
		ps.setString(7,fb.getQ5());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}
	
	public int searchRegno(String e) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.DBConnection();
		String q = "select regno from register where emailid=?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, e);
		ResultSet rs = ps.executeQuery();
		int s=0;
		while(rs.next()) {
			s = rs.getInt(1);
		}
		
		return s;
	}
	
	public String searchName(String e) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.DBConnection();
		String q = "select StdName from register where emailid=?";
		PreparedStatement ps = con.prepareStatement(q);
		ps.setString(1, e);
		ResultSet rs = ps.executeQuery();
		String s="";
		while(rs.next()) {
			s = rs.getString(1);
		}
		
		return s;
	}
}
