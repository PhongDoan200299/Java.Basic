package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.ResultSet;

import java.sql.Statement;

import database.JDBCUtil;
import model.User;

public class UserDAO implements DAOInterface<User> {

	public static UserDAO getInstance() {
		return new UserDAO();
	}

	public int insert(User t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: Tạo ra dối tượng statement
			Statement st = con.createStatement();

			// Bước 3: Thực thi câu lệnh SQL
			String sql = "INSERT INTO sach(username, password,hoVaTen)" + "VALUES ('" + t.getUsername() + "' ,' "
					+ t.getPassword() + "' , '" + t.getHoVaTen() +  "')";
			System.out.println("Bạn đã thực thi: " + sql);

			ketQua = st.executeUpdate(sql);

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public int update(User t) {
		int ketQua = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: Tạo ra dối tượng statement
			Statement st = con.createStatement();

			// Bước 3: Thực thi câu lệnh SQL
			String sql = "UPDATE User " + " SET" + " password = '" + t.getPassword() + "'" + ", hoVaTen = " + t.getHoVaTen()
					+ " WHERE id='" + t.getUsername() + "'";

			System.out.println(sql);
			// System.out.println("Bạn đã thực thi: " + sql);

			ketQua = st.executeUpdate(sql);

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public int delete(User t) {
		int ketQua = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: Tạo ra dối tượng statement
			Statement st = con.createStatement();

			// Bước 3: Thực thi câu lệnh SQL
			String sql = "DELETE from User " + " WHERE username='" + t.getUsername() + "'";

			System.out.println(sql);
			// System.out.println("Bạn đã thực thi: " + sql);

			ketQua = st.executeUpdate(sql);

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public ArrayList<User> selectAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: Tạo ra dối tượng Preparedstatement
			PreparedStatement st = con.prepareStatement(null);

			// Bước 3: Thực thi câu lệnh SQL
			String sql = "SELECT * FROM User";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			// System.out.println("Bạn đã thực thi: " + sql);

			// Bước 4:
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");

				User user = new User(username,password,hoVaTen);
				ketQua.add(user);
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public User selectById(User t) {
		User ketQua = null;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: Tạo ra dối tượng statement
			Statement st = con.createStatement();

			// Bước 3: Thực thi câu lệnh SQL
			String sql = "SELECT * FROM User WHERE username='" + t.getUsername() + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			// System.out.println("Bạn đã thực thi: " + sql);

			// Bước 4:
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");

				ketQua = new User(username,password,hoVaTen);
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> ketQua = new ArrayList<User>();
		

		return ketQua;
	}

}
