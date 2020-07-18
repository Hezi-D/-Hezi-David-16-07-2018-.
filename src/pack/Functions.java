package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {

	Constants myConstans = new Constants();
	Elements myElements = new Elements();
	static WebDriver driver;

	public void OpenSite() {

		System.out.println("Get into Site function");
		String browserType = "chrome";
		driver = Utilities.DriverFactory.open(browserType);
		driver.manage().window().maximize();
		driver.get("https://automation.herolo.co.il/");
		System.out.println("Login successfully");
	}

	public void FillTheEmailForm() {

		// Fills the contact us fields
		// NAME
		// Wait for the email form shows up
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));

		WebElement firstName = driver.findElement(myElements.firstName);
		firstName.sendKeys(myConstans.firstName);

		// EMAIL
		WebElement firstEmail = driver.findElement(myElements.firstEmail);
		firstEmail.sendKeys(myConstans.firstEmail);

		// PHONE NUMBER
		WebElement firstPhone = driver.findElement(myElements.firstPhone);
		firstPhone.sendKeys(myConstans.firstPhoneNumber);

		// CLICK 'SEND'
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement firstSendFormButton = driver.findElement(myElements.firstSendFormButton);
		firstSendFormButton.click();

		// CLICK 'RETURN' (To the main page)
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement returnButton = driver.findElement(myElements.returnButton);
		returnButton.click();

		// Report
		System.out.println("The first form test passed successfully");
	}

	public void FirstFormValidation() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement firstSendFormButton = driver.findElement(myElements.firstSendFormButton);

		String expectedMandatoryNameFieldMessage = "שדה שם הוא שדה חובה";
		String expectedMandatoryEmailFieldMessage = "שדה אימייל הוא שדה חובה";
		String expectedMandatoryPhoneFieldMessage = "שדה טלפון הוא שדה חובה";

		String actualNameFieldErroeMessage = null;
		String actualEmailFieldErroeMessage = null;
		String actualPhoneFieldErroeMessage = null;

		// Empty fields
		firstSendFormButton.click();
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(myElements.nameFieldErrorMessage));
			wait.until(ExpectedConditions.presenceOfElementLocated(myElements.emailFieldErrorMessage));
			wait.until(ExpectedConditions.presenceOfElementLocated(myElements.phoneFieldErrorMessage));

		} catch (Exception e) {

			System.out.println("The error messages does't appear");
		}

		// Get all the errors message
		actualNameFieldErroeMessage = driver.findElement(myElements.nameFieldErrorMessage).getText();
		actualEmailFieldErroeMessage = driver.findElement(myElements.emailFieldErrorMessage).getText();
		actualPhoneFieldErroeMessage = driver.findElement(myElements.phoneFieldErrorMessage).getText();

		// Name field Error message Text validation
		if (actualNameFieldErroeMessage.equals(expectedMandatoryNameFieldMessage)) {
			System.out.println("Name field Error message is valid");
		} else {
			System.out.println("Error message DOESN'T is valid:");
		}
		System.out.println(actualNameFieldErroeMessage);

		// Email field Error message Text validation
		if (actualEmailFieldErroeMessage.equals(expectedMandatoryEmailFieldMessage)) {
			System.out.println("Email field Error message is valid");
		} else {
			System.out.println("Error message DOESN'T is valid:");
		}
		System.out.println(actualEmailFieldErroeMessage);

		// Phone field Error message Text validation
		if (actualPhoneFieldErroeMessage.equals(expectedMandatoryPhoneFieldMessage)) {
			System.out.println("Phone field Error message is valid");
		} else {
			System.out.println("Error message DOESN'T is valid:");
		}
		System.out.println(actualPhoneFieldErroeMessage);

	}

	public void FirstFormValidationPart2() throws InterruptedException {

		WebElement firstEmail = driver.findElement(myElements.firstEmail);
		WebElement firstName = driver.findElement(myElements.firstName);
		WebElement firstPhone = driver.findElement(myElements.firstPhone);
		WebElement firstSendFormButton = driver.findElement(myElements.firstSendFormButton);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// NAME only
		// ************
		// Wait for the email form shows up
		// Fill only the name field

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));

		clearAllFirstFormFields();
		firstName.sendKeys(myConstans.firstName);
		firstSendFormButton.click();

		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(myElements.emailFieldErrorMessage));
			wait.until(ExpectedConditions.presenceOfElementLocated(myElements.phoneFieldErrorMessage));
			System.out.println("1. NAME only pass");
		}

		catch (Exception e) {
			System.out.println("No error message appear");
		}

		// NAME+EMAIL only
		// ************

		clearAllFirstFormFields();

		firstName.sendKeys(myConstans.firstName);
		firstEmail.sendKeys(myConstans.firstEmail);
		firstSendFormButton.click();

		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.presenceOfElementLocated(myElements.phoneFieldErrorMessage));
			System.out.println("2. NAME+EMAIL only pass");
		}

		catch (Exception e) {
			System.out.println("No error message appear");
		}

		// NAME + Phone only
		// ************
		clearAllFirstFormFields();
		firstName.sendKeys(myConstans.firstName);
		firstPhone.sendKeys(myConstans.firstPhoneNumber);
		firstSendFormButton.click();

		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.presenceOfElementLocated(myElements.emailFieldErrorMessage));
			System.out.println("3. NAME + Phone only pass");

		}

		catch (Exception e) {
			System.out.println("No error message appear");
		}

		// EMAIL only WebElement
		// ************

		clearAllFirstFormFields();
		firstEmail.sendKeys(myConstans.firstEmail);
		firstSendFormButton.click();

		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.presenceOfElementLocated(myElements.nameFieldErrorMessage));
			wait1.until(ExpectedConditions.presenceOfElementLocated(myElements.phoneFieldErrorMessage));
			System.out.println("4. EMAIL only pass");
		}

		catch (Exception e) {
			System.out.println("No error message appear");
		}

		// EMAIL + PHONE only
		// ************
		clearAllFirstFormFields();
		firstPhone.sendKeys(myConstans.firstPhoneNumber);
		firstEmail.sendKeys(myConstans.firstEmail);
		firstSendFormButton.click();

		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.presenceOfElementLocated(myElements.nameFieldErrorMessage));
			System.out.println("5. EMAIL + PHONE only pass");
		}

		catch (Exception e) {
			System.out.println("No error message appear");
		}

		// PHONE only
		clearAllFirstFormFields();
		firstPhone.sendKeys(myConstans.firstPhoneNumber);
		firstSendFormButton.click();

		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 10);
			wait1.until(ExpectedConditions.presenceOfElementLocated(myElements.nameFieldErrorMessage));
			wait1.until(ExpectedConditions.presenceOfElementLocated(myElements.emailFieldErrorMessage));
			System.out.println("6. PHONE only pass");

		}

		catch (Exception e) {
			System.out.println("No error message appear");
		}

	}

	public void FillContactUsForm() {
		// Fills the more details form
		// NAME
		WebElement secondName = driver.findElement(myElements.secondName);
		secondName.sendKeys(myConstans.secondName);

		// COMPANY
		WebElement myCompany = driver.findElement(myElements.company);
		myCompany.sendKeys(myConstans.company);

		// EMAIL
		WebElement myEmail = driver.findElement(myElements.secondEmail);
		myEmail.sendKeys(myConstans.secondEmail);

		// PHONE
		WebElement myPhone = driver.findElement(myElements.secondPhone);
		myPhone.sendKeys(myConstans.secondPhoneNumber);

		// SEND BUTTON
		WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"section-inputs\"]/div[3]/a"));
		sendButton.click();

		// CLICK 'RETURN' (To the main page)
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement returnButton = driver.findElement(myElements.returnButton);
		returnButton.click();

		// Report
		System.out.println("The second form test passed successfully");
	}

	public void CrossBrowserTest() {

		// Login to chrome browser
		System.out.println("Get into Site function");
		String browserType = "chrome";
		driver = Utilities.DriverFactory.open(browserType);
		driver.manage().window().maximize();
		driver.get("https://automation.herolo.co.il/");
		System.out.println("Login CHROME browser successfully");
		driver.close();

		// Login to FF browser
		System.out.println("Get into Site function");
		driver = Utilities.DriverFactory.open("fireFox");
		driver.manage().window().maximize();
		driver.get("https://automation.herolo.co.il/");
		System.out.println("Login FIRE FOX browser successfully");
		driver.close();

		// Login to IE browser
		/*
		 * System.out.println("Get into Site function"); driver =
		 * Utilities.DriverFactory.open("IE"); driver.manage().window().maximize();
		 * driver.get("https://automation.herolo.co.il/");
		 * System.out.println("Login IE browser successfully");
		 */

	}

	public void handlePopUp() {

	}

	public void popUpFormValidation() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(myElements.popUpForm));
		System.out.println("Popup found!");
	}

	public void clearAllFirstFormFields() {

		WebElement nameField = driver.findElement(myElements.firstName);
		WebElement emailField = driver.findElement(myElements.firstEmail);
		WebElement phoneField = driver.findElement(myElements.firstPhone);

		nameField.clear();
		emailField.clear();
		phoneField.clear();

	}

}
