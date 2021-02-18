package Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

	public int student_insert(StudentBean sb) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("insert into student_crud values(?,?,?,?)");
		ps.setInt(1, sb.getId());
		ps.setString(2, sb.getName());
		ps.setString(3, sb.getEmail());
		ps.setString(4, sb.getDept());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}

	public int student_delete(int id) throws ClassNotFoundException, SQLException {

		Connection con = DBUtil.DBConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM student_crud where id = ?");
		ps.setInt(1, id);
		int row = ps.executeUpdate();
		System.out.println("Number of deleted records: " + row);
		con.close();
		return row;
	}

	public int student_update(StudentBean sb) throws ClassNotFoundException, SQLException {

		Connection con = DBUtil.DBConnection();
		PreparedStatement ps = con
				.prepareStatement("update student_crud set name = ?,email= ?, department =? where id = ?");
		ps.setString(1, sb.getName());
		ps.setString(2, sb.getEmail());
		ps.setString(3, sb.getDept());
		ps.setInt(4, sb.getId());
		int row = ps.executeUpdate();
		System.out.println("Number of Updated records: " + row);
		con.close();
		return row;
	}

}
