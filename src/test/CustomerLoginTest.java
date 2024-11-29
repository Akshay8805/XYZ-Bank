package test;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import pages.CustomerPage;

public class CustomerLoginTest {
	WebDriver driver;
	CustomerPage customer;
	@BeforeTest
	public void setup() throws InterruptedException, IOException {
	    driver =new ChromeDriver();
		driver.get("https://globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}
	 @Test
	 public void login() throws InterruptedException {  
		customer= new CustomerPage(driver);
		Thread.sleep(2000);
		customer.customer();
		WebElement name=customer.name();
		Thread.sleep(2000);
		name.click();
		int i=0;
		while (i<2)
		{
		    name.sendKeys(Keys.DOWN);
			i++;
		}
		name.click();
		customer.login().click();
		Thread.sleep(2000);
	 }
	 @Test
	 public void screenshot() throws IOException, InterruptedException {
		TakesScreenshot screen= (TakesScreenshot)driver;
		File source= screen.getScreenshotAs(OutputType.FILE);
		File destination  =new File("C:\\Automation Testing\\Screenshot selenium\\bank.png");
		Files.copy(source, destination);
		String name2 =driver.findElement(By.xpath("//span[@class='fontBig ng-binding']")).getText();
		System.out.println(name2);
	 }
	 @Test(priority=2)
	 public void deposite() throws InterruptedException {
        customer.deposite();
        Thread.sleep(2000);
        customer.amountDeposit("2000");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Deposit Successful']")),"Deposite Successful" );
        Thread.sleep(2000);
	 }
	 @Test(priority=3)
	 public void withdawl() {
        customer.withdraw();
        customer.withdrawamount("10000");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
       // driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
	@AfterTest
	public void m3() {
		driver.quit();
	}

}
