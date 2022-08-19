package POs;

import org.bouncycastle.jcajce.provider.keystore.BC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPO extends BasePagePO {

	//Locators
	//Register Email
	By loginButton = By.cssSelector("*[data-test=\"user-space\"]");
	By emailInput = By.id("identification_email");
	By continueButton = By.cssSelector(".css-4nwwco");
	
	
	//Create Account
	By firstNameInput  =  By.name("firstName");
	By lastNameInput  = By.name("lastName");
	By phoneNumberInput  = By.name("phoneNumber.nationalNumber");
    By userPasswordInput  =By.name("password");
    By registerButton = By.cssSelector(".css-4nwwco > span");

    		
    WebDriver driver;
    
	String url = "https://www.thefork.com/";
	public SignUpPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driver.get(url);
	}
	
	
	public void RegEmail(String email)
	{
		click(loginButton);
		click(emailInput);
		type(emailInput, email);
		click(continueButton);
		
	}
	
	public PersonalInfoPO CreateAccount(User user) {
		
		type(firstNameInput , user.firstName);
		type(lastNameInput , user.lastName);
		type(phoneNumberInput , user.phoneNumber);
		type(userPasswordInput , user.password);
		
		click(registerButton);
		
		return new PersonalInfoPO(driver);
	}
	

}

