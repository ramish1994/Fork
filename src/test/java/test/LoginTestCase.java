package test;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.openqa.selenium.chrome.ChromeDriver;

import POs.BasePagePO;
import POs.PersonalInfoPO;
import POs.SignUpPO;
import POs.User;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SeleniumJupiter.class)
public class LoginTestCase {

	@Test
	public void LoginTest(ChromeDriver driver) throws InterruptedException {
		
		
		try {
			
			User user = new User();
			
			Random random = new Random();
			int value = random.nextInt(600);
			
			user.email = "abc"+value+"@hot.com";
			user.firstName="ramish";
			user.lastName="majeed";
			user.password="Admin123!";
			user.phoneNumber ="2345678901";
			
			SignUpPO signUp = new SignUpPO(driver);
			signUp.RegEmail(user.email);
			
			PersonalInfoPO dashboard = signUp.CreateAccount(user);
			
			User searchUser = dashboard.GetPersonalInfo();

			assertTrue(user.firstName.equals(searchUser.firstName));
			assertTrue(user.lastName.equals(searchUser.lastName));
			assertTrue(user.phoneNumber.equals(searchUser.phoneNumber));
		}
		catch (Exception ex) {
			System.out.println(ex);
			assertTrue(false);
		}
		
	}
	
	

}

