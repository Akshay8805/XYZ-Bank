package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.LoginPage;



public class testclass {
	WebDriver driver;
	@Test
	public void login() throws InterruptedException {
		
	    driver = new ChromeDriver();
		driver.get("https://globalsqa.com/angularJs-protractor/BankingProject/#/login");
		driver.manage().window().maximize();
		LoginPage login=new LoginPage(driver);
		login.username("Admin");
		login.password("Admin123");
		
	
		
	}
	@Test
	public void myaccount() throws InterruptedException {
		
		driver.close();
		
	}

}
