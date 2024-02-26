package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.ResultSet;

import java.sql.Statement;

import database.JDBCUtil;
import model.User;

public class UserDAO2 implements DAOInterface<User> {

	public static UserDAO2 getInstance() {
		return new UserDAO2();
	}

	public int insert(User t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: Thực thi câu lệnh SQL
			String sql = "INSERT INTO User (username, password, hoVaTen) VALUES (?,?,?)";

			// Bước 3: Tạo ra dối tượng PreparedStatement
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getHoVaTen());

			System.out.println("Bạn đã thực thi: " + sql);
			ketQua = pst.executeUpdate();

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

			// Bước 2: Thực thi câu lệnh SQL
			String sql = "UPDATE User SET " + "password = ?" + ", hoVaTen = ?" + " WHERE username =?";

			// Bước 3: Tạo ra dối tượng PreparedStatement
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getPassword());
			pst.setString(2, t.getHoVaTen());
			pst.setString(3, t.getUsername());

			System.out.println("Bạn đã thực thi: " + sql);
			ketQua = pst.executeUpdate();

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

			// Bước 2: Thực thi câu lệnh SQL
			String sql = "DELETE User WHERE username=?";

			// Bước 3: Tạo ra dối tượng PreparedStatement
			PreparedStatement pst = con.prepareStatement(sql);
	
			pst.setString(1, t.getUsername());

			System.out.println("Bạn đã thực thi: " + sql);
			ketQua = pst.executeUpdate();

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

			// Bước 2: Tạo câu lệnh SQL
			String sql = "SELECT * FROM User";
			// Bước 3: Tạo ra dối tượng Preparedstatement
			PreparedStatement st = con.prepareStatement(sql);

			
			// Bước.. thực thi câu lệnh SQL
			//System.out.println(sql);
			ResultSet rs = st.executeQuery();
			System.out.println("Bạn đã thực thi: " + sql);

			// Bước 4:
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");

				User user = new User(username, password, hoVaTen);
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
			String sql = "SELECT * FROM User WHERE username=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			// Bước 3: Thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();
			// System.out.println("Bạn đã thực thi: " + sql);

			// Bước 4:
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");

				ketQua = new User(username, password, hoVaTen);
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
		try {
			// Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: Tạo câu truy vấn SQL
			String sql = "SELECT * FROM User WHERE " + condition;
			// Bước 3: Tạo ra dối tượng statement
			PreparedStatement pst = con.prepareStatement(sql);
			
			// Bước 4: Thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();
			// System.out.println("Bạn đã thực thi: " + sql);

			// Bước 5 Xử lý kết quả truy vấn:
			while (rs.next()) {
				//Đọc các giá trị từ ResultSet và tạo đối tượng User
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setHoVaTen(rs.getString("hoVaTen"));
				// Thêm đối tượng User vào danh sách kết quả
				ketQua.add(user);
			}
			// Bước 6 Đóng kết nối và giải phóng tài nguyên
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

}
