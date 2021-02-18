package Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogDAO {

	public String search(String e) throws ClassNotFoundException, SQLException{
		Connection con = DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("select pswd from register where emailid=?");
		ps.setString(1,e);
		ResultSet rs = ps.executeQuery();
		String s="";
		while(rs.next()) {
			s = rs.getString(1);
		}	
		return s;
	}
}
