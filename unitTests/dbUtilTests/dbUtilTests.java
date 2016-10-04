package dbUtilTests;
import static org.junit.Assert.*;

import org.junit.Test;

import Tool.DbUser;
import model.User;

public class dbUtilTests {

	@Test
	public void test() {
		
		User user = DbUser.getUser(1);
		//assertTrue("Mackleberry".equalsIgnoreCase(user.getUsername()));
		System.out.println(user.getUseremail());
		System.out.println(user.getUserpassword());
		
		
		User newuser = new User();
		//newuser.setUserid(2);
//		newuser.setUseremail("u2@domain.com");
//		newuser.setUsername("Student1");
//		newuser.setUserpassword("password");
//		newuser.setUserrole("Student");
		
		System.out.println(DbUser.getUser(56));
	}

}
