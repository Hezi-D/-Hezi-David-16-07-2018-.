package pack;

public class Main {

	
	
	public static void main(String[] args) throws Exception 
	{
		//Here we run the relevant functions for our tests
		Functions myFunctions = new Functions();
		
		//Login to the main page
		myFunctions.OpenSite();
		//myFunctions.FillTheEmailForm();
		//myFunctions.FillContactUsForm();
		
		//myFunctions.FirstFormValidation();
		myFunctions.FirstFormValidationPart2();
		
		//Cross Browsers Test
		//myFunctions.CrossBrowserTest();
		

		//Popup Form 
		//myFunctions.popUpFormValidation();

	}

}
