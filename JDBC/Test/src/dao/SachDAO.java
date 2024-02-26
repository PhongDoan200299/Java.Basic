package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;



import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}
	
	public int insert(Sach t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			//Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			
			//Bước 2: Tạo ra dối tượng statement
			Statement st =  con.createStatement();
			
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "INSERT INTO sach(id, tenSach,giaBan, namXuatBan)"
					+ "VALUES ('"+t.getId()+"' ,' "+t.getTenSach()+"' , '"+t.getGiaBan()+"' , '"+t.getNamXuatBan()+"')";
			System.out.println("Bạn đã thực thi: " + sql);
			
			 ketQua = st.executeUpdate(sql);
			
			//Bước 4: 
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");
			
			//Bước 5: 
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return ketQua;
	}

	public int update(Sach t) {
		int ketQua = 0;
		try {
			//Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			
			//Bước 2: Tạo ra dối tượng statement
			Statement st =  con.createStatement();
			

			//Bước 3: Thực thi câu lệnh SQL
			String sql =	"UPDATE sach "+
							" SET" + 
							" tenSach = '"+t.getTenSach()+"'"+
							", giaBan = "+t.getGiaBan()+
							", namXuatBan="+t.getNamXuatBan()+
							" WHERE id='"+t.getId()+"'";
					
			System.out.println(sql);
			//System.out.println("Bạn đã thực thi: " + sql);
			
			 ketQua = st.executeUpdate(sql);
			
			//Bước 4: 
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");
			
			//Bước 5: 
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return ketQua;
	}
	

	public int delete(Sach t) {
		int ketQua = 0;
		try {
			//Bước 1: Tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			
			//Bước 2: Tạo ra dối tượng statement
			Statement st =  con.createStatement();
			

			//Bước 3: Thực thi câu lệnh SQL
			String sql =	"DELETE from sach "+
							" WHERE id='"+t.getId()+"'";
					
			System.out.println(sql);
			//System.out.println("Bạn đã thực thi: " + sql);
			
			 ketQua = st.executeUpdate(sql);
			
			//Bước 4: 
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + "dòng bị thay đổi!");
			
			//Bước 5: 
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		return ketQua;
	}

	public ArrayList<Sach> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sach selectById(Sach t) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Sach> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
