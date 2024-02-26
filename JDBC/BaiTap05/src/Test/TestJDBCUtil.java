package Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		try {
			// Bước 1 : Tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			//System.out.println(connection);
			
			// Bước 2 : Tạo ra đối tượng statement
			Statement st = connection.createStatement(); 
			
			// Bước 3 : Thực thi một câu lệnh SQL
			String sql = "INSERT INTO persons(last_name, first_name, gender, dob, income)"
					+ "VALUES (\"Quang \",\"Van C\",\"M\",\"2000-05-10\",45000000)";

			int check = st.executeUpdate(sql);
			//System.out.println("Số dòng thay đổi: " + check);
			
			// Bước 4 : XỬ lý kết quả
			System.out.println("Số dòng thay đổi: " + check);
			if (check > 0) {
				System.out.println("Thêm dữ liệu thành công!");
			} else {
				System.out.println("Thêm dữ liệu thất bại!");
			}
			
			// Bước 5 : Ngắt kết nối
			JDBCUtil.printInfo(connection);
			JDBCUtil.closeConnection(connection);
			//System.out.println(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}


