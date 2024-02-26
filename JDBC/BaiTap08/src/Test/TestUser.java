package Test;

import java.util.ArrayList;

import dao.SachDAO;
import dao.UserDAO2;
import model.Sach;
import model.User;

public class TestUser {
	public static void main(String[] args) {
//		User u3 = new User("u3","u123","UUU");
//		UserDAO2.getInstance().insert(u3);

		//
		System.out.println("---------------");
//		User u_find = new User("u1","u123","UUU");
//		User u_result = UserDAO2.getInstance().selectById(u_find);
//		System.out.println(u_result);

//		User u_find = new User("x\' or 1=1; -- ","","");
//		User u_result = UserDAO2.getInstance().selectById(u_find);
//		System.out.println(u_result);
		// Test Arraylist
//		ArrayList<User> list = UserDAO2.getInstance().selectAll();
//		for (User user : list) {
//			System.out.println(user.toString());

		// Test select User by ID
//		System.out.println("-------------");
//		User find = new User();
//		find.setUsername("abc");
//		User user1 = UserDAO2.getInstance().selectById(find);
//		System.out.println(user1);
//		
		// Test select by condition
		ArrayList<User> list2 = UserDAO2.getInstance().selectByCondition("username='abc' AND hoVaTen='ABC'");
		for (User user : list2) {
			System.out.println(user.toString());
		}
	}
}
