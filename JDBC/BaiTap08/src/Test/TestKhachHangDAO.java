package Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import dao.KhachHangDAO;
import model.khachHang;

public class TestKhachHangDAO {
	public static void main(String[] args) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		KhachHangDAO dao = new KhachHangDAO();
		// test insert
		// khachHang kh = new khachHang(1,"Dang Minh
		// Phong","2015-03-31","DongDaStreet");

//		String str1 = "'1995-01-01'";
//		Date date1 = Date.valueOf(str1);
//		khachHang khachHang1 = new khachHang(1, "Nguyễn Văn A", date1, "Hà Nội");
//		
//		KhachHangDAO.getInstance().insert(khachHang1);

//		String str2 = "2000-01-01";
//		Date date2 = Date.valueOf(str2);

//		for(int i = 0;i < 30; i ++) {
//			khachHang kh = new khachHang(i,"Trần Văn i: " + i,date2,"Đà Nẵng");
//			KhachHangDAO.getInstance().insert(kh);
//		}

		// Test update

//		try {
//			khachHang khachHang1 = new khachHang(0, "HoChiMinh", dateFormat.parse("1-1-2000"), "Hà Nội");
//			//dao.update(khachHang1);
//			if(KhachHangDAO.getInstance().insert(khachHang1) > 0 ) {
//				System.out.print("update thanh cong");
//			}else {
//				System.out.print("update that bai");
//			}
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			System.out.print("error" + e.toString());
//		}
		// KhachHangDAO.getInstance().update(khachHang1);

		// Test update
//		khachHang khachHang1 = new khachHang(15, "Nguyệt", Date.valueOf("2000-10-14"), "Hà Nội1234");
//		if (KhachHangDAO.getInstance().update(khachHang1) > 0) {
//			System.out.print("update thanh cong");
//		} else {
//			System.out.print("update that bai");
//		}

		// Test delete

//		khachHang kh1 = new khachHang(15, "Nguyệt", Date.valueOf("2000-10-14"), "Hà Nội1234");
//		KhachHangDAO.getInstance().delete(kh1);

//		for (int i = 0; i < 25; i++) {
//			khachHang kh = new khachHang(i, "Trần Văn i: " + i, Date.valueOf("2000-01-01"), "Đà Nẵng");
//			KhachHangDAO.getInstance().delete(kh);
//		}
		
		//Test ArrayList
		ArrayList<khachHang> list = KhachHangDAO.getInstance().selectAll();
		for (khachHang khachHang : list) {
			System.out.println(khachHang.toString());
		}
		
		//test select KhachHang by ID
		System.out.println("--------------------");
		khachHang find2 = new khachHang();
		find2.setId(25);
		khachHang kh2 = KhachHangDAO.getInstance().selectById(find2);
		System.out.println(kh2);
		
		//Test select by condition
		System.out.println("-------------------------");
		ArrayList<khachHang> list2 = KhachHangDAO.getInstance().selectByCondition("hoVaTen = 'Trần Văn i: 25' AND ngaySinh='2000-01-01'");
		for (khachHang khachHang : list2) {
			System.out.println(khachHang.toString());
		}
	}
}
