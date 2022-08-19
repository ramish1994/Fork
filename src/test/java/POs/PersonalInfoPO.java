package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInfoPO extends BasePagePO {

    //Personal Info
    By personalInfo = By.xpath("//*[@id=\"USER_SPACE_FIRST_PANEL\"]/ul/li[2]/div/button");
	
    
  //Create Account
  	By firstNameInput =  By.name("firstName");
  	By lastNameInput  = By.name("lastName");
  	By phoneNumberInput  = By.name("phoneNumber.nationalNumber");
      
	public PersonalInfoPO(WebDriver driver) {
		super(driver);
	}

	public User GetPersonalInfo() {
		click(personalInfo);
		
		User user = new User();
		user.firstName = getText(firstNameInput );
		user.lastName = getText(lastNameInput );
		user.phoneNumber = getText(phoneNumberInput );
		
		return user;
	}
}
