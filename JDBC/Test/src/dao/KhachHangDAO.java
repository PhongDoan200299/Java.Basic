package dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import database.JDBCUtil;
import model.khachHang;

public class KhachHangDAO implements DAOInterface<khachHang> {

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	
	
	public int insert(khachHang t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			//Bước 3: thực thi câu lệnh SQL
			String sql = "INSERT INTO khachhang(id,hoVaTen,ngaySinh, diaChi)"
					+ "	VALUES ('"+t.getId()+"','"+t.getHoVaTen()+"','"+t.getNgaySinh()+"','"+t.getDiaChi()+"')";
//			Date date=Date.valueOf(sql);//converting string into sql date 
			ketQua = st.executeUpdate(sql);
			
			
			//Bước 4: 
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có "+ ketQua + "dòng bị thay đổi");
			
			//Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	public int update(khachHang t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			//Bước 3: thực thi câu lệnh SQL
			String sql = 	"UPDATE khachhang "+
					" SET" + 
					" hoVaTen = '"+t.getHoVaTen()+"'"+
					", ngaySinh = '"+t.getNgaySinh()+"'"+
					", diaChi='"+t.getDiaChi()+"'"+
					" WHERE id="+t.getId();
			
			System.out.println(sql);
//			Date date=Date.valueOf(sql);//converting string into sql date 
			ketQua = st.executeUpdate(sql);
					
			//Bước 4: 
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có "+ ketQua + "dòng bị thay đổi");
			
			//Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	public int delete(khachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<khachHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public khachHang selectById(khachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<khachHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
