package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class Elements {

	WebDriver driver;

	 //First Form Elements
	public By firstName  = By.name("name");
	public By firstEmail  = By.name("email");
	public By firstPhone  = By.name("phone");
	public By firstSendFormButton  = By.xpath("//*[@id=\"footer\"]/form/button");
	public By returnButton  = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/div[1]/div[2]/a/span");
	
	 //Second Form Elements
	public By secondName  = By.id("name");
	public By secondEmail  = By.id("email");
	public By secondPhone  = By.id("telephone");
	public By company  = By.id("company");
	public By secondSendFormButton  = By.xpath("//*[@id=\\\"section-inputs\\\"]/div[3]/a");
	
	
	public By successMessage  = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/div[1]/div[2]/p[1]/span");
   
	//Popup Form
	public By popUpForm  = By.xpath("/html/body/div[3]/div/div/div/div[2]");
	
	//Validation
	public By nameFieldErrorMessage  =  By.xpath("//*[@id=\"footer\"]/form/div/div[1]/label/span");
	public By emailFieldErrorMessage  = By.xpath("//*[@id=\"footer\"]/form/div/div[2]/label/span");
	public By phoneFieldErrorMessage  = By.xpath("//*[@id=\"footer\"]/form/div/div[3]/label/span");
	
	
	

    
}
