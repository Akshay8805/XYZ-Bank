package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	WebDriver driver;
	public  CustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Customer Login']")
	 WebElement customer;
	
	@FindBy(xpath="//select[@id='userSelect']")
	 WebElement name;
	
	@FindBy(xpath="//button[text()='Login']")
    WebElement login;
	
	@FindBy(xpath="(//button[@class='btn btn-lg tab'])[2]")
	WebElement deposite;
	
	@FindBy(xpath="//input[@type='number']")
	WebElement amountDep;
	
	@FindBy (xpath="(//button[@class='btn btn-lg tab'])[2]")
	WebElement withdraw;
	
	@FindBy (xpath="//input[@type='number']")
	WebElement withdrawAmount;
	
	public void customer(){
		customer.click();
	}
	
	public WebElement name() {
		 return name;
	}
	
	public WebElement login() {
		return login;
	}
	public void deposite() {
		deposite.click();
	}
	public void amountDeposit(String amount) {
		amountDep.sendKeys(amount);
	}
	public void withdraw() {
		withdraw.click();
	}
	public void withdrawamount(String amount) {
		withdraw.sendKeys(amount);
	}

}
