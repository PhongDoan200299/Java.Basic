package Test;

import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
//		Sach sach1 = new Sach("LTJV","Lập trình Java", 50000, 2025);
//		Sach sach2 = new Sach("LTC","Lập trình C", 70000, 2035);
//		
//		SachDAO.getInstance().insert(sach2);
		// Test insert
//		for (int i = 0; i < 25; i++) {
//			Sach sach = new Sach("LT"+i,"Lập trình i:  " + i,50000, 2025 );
//			SachDAO.getInstance().insert(sach);
//		}

		// Test update
//		Sach sach2 = new Sach("LT1"," Lập trình C", 10000, 2060);
//		SachDAO.getInstance().update(sach2);

		// TEst Delete

//		for (int i = 0; i < 25;i++) {
//			Sach sach = new Sach("LT"+i," Lập trình i: " + i, 50000, 2025);
//			SachDAO.getInstance().delete(sach);
//		}

		// Test Arraylist
//		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
//		for (Sach sach : list) {
//			System.out.println(sach.toString());
//		}
		// Test select Sach by ID
		System.out.println("-------------");
		Sach find = new Sach();
		find.setId("LTC");
		Sach sach2 = SachDAO.getInstance().selectById(find);
		System.out.println(sach2);
		
		//Test select by condition
		ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition("giaBan>= 70000");
		for (Sach sach : list2) {
			System.out.println(sach.toString());
		}
		
	}
}
