package pages;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import genericclasses.Utilities;

public class Hotels {

	Utilities wt = new Utilities();
	ResourceBundle rb = ResourceBundle.getBundle("com.utilities.xpath");
	
	WebDriver driver;
	ExtentTest report;
	String img_loc = rb.getString("image_location");
	
	

	public Hotels(WebDriver driver,ExtentTest report)
	{
		this.driver = driver;
		this.report = report;
	}
	

	public void clickOnButton(String btn_xpath,String stepName, String stepDescription,int timeout)
	{
		WebElement button =  wt.FindElementAndWait(driver, btn_xpath, timeout);
		
		button.click();
		report.log(LogStatus.PASS, stepName,stepDescription);
		

	}
	
	
	
	
	
	
	
	public void clickOnHotelSearchButton(String hotels_search)
	{
		WebElement search_btn =  wt.FindElementAndWait(driver, hotels_search, 3);
		
		search_btn.click();
		report.log(LogStatus.PASS, "Click on Hotel search button","Successfully clicked on Hotel search button");

	}
	
	public void clickOnRoomBooking(String room_btn)
	{
		WebElement bookings_btn = wt.FindElementAndWait(driver, room_btn, 3);
		bookings_btn.click();
	
	}
	
	public void SearchHotel(String hotel_xpath)
	{
		/*WebElement hotel = driver.findElement(By.xpath(hotel_xpath));
		System.out.println(hotel.getText());
	*/
		List<WebElement> hotels = wt.FindElementsAndWait(driver, hotel_xpath, 5);
		
		for(WebElement hotel : hotels){
			
			System.out.println(hotel.getText());
			if(hotel.getText().contains("Marinha")){
				hotel.click();
				report.log(LogStatus.PASS, "Click on the Hotel to be searched","Successfully navigated to hotel Marinha");

			}
		 }
	 }	
	

	public void addAdults(String adult_count) {
		
WebElement adults_counter = driver.findElement(By.xpath(adult_count));	
	

	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(adults_counter));
	adults_counter.click();
	
	driver.findElement(By.xpath("//*[@id='js-adult_counter']/li[4]")).click();
	/*	List<WebElement> adults = adults_counter.findElements(By.tagName("li"));
		
		for(WebElement adult : adults){
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(adult));*/
			
			
/*			System.out.println(adult.getText());
			String person = adult.getText();
			if(person=="6"){
				System.out.println("Here");
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", adult);
				//adult.click();
			}*/
		}
	}

