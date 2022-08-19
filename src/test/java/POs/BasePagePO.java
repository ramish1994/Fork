package POs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 

public class BasePagePO {

	WebDriver driver;
	
	public String URL = "https://www.thefork.com/"; 
	public BasePagePO(WebDriver driver)
	{
		this.driver = driver;

	}
	
	public WebElement find(By element)
	{
		return driver.findElement(element);
	}
	public List<WebElement> finds(By element)
	{
		return driver.findElements(element);
	}
	public Boolean isEmpty(By element)
	{
		return driver.findElements(element).isEmpty();
	}
	
	public String getText(By element)
	{
		return driver.findElement(element).getAttribute("value");
	}
	public void type(By element, String value)
	{
		find(element).sendKeys(value);
	}
	
	public void clear(By element)
	{
		find(element).clear();
//		while(!find(element).getAttribute("value").equals("")){
//			find(element).sendKeys(Keys.BACK_SPACE);
//	    }
	}
	
	public void click(By element)
	{
		try {
				find(element).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(element));
		  }	
	}
	
}
