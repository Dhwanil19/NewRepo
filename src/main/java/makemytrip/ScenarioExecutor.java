package makemytrip;

import java.io.File;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pages.HomePage;
import pages.Hotels;

public class ScenarioExecutor {
	
	ResourceBundle rb = ResourceBundle.getBundle("com.utilities.xpath");
	
	Logger log = Logger.getLogger(ScenarioExecutor.class); 
	
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest report;	
	
	String all_hotels = rb.getString("all_hotels");
	String hotels_button = rb.getString("HOTELS_btn");
	String search_hotels = rb.getString("hotel_search_btn");
	String adult_counter = rb.getString("rooms_adultcounter");
	String rooms_box = rb.getString("rooms_booking");
	
	String uname = rb.getString("username");
	String pword = rb.getString("password");
	String login_icon = rb.getString("LOGIN_icon");
	String login_btn = rb.getString("LOGIN_btn");
	
	@BeforeTest
	public void Setup(){
		
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setBrowserName("chrome");
		String baseURL = "https://www.makemytrip.com/";  
		
		extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\MakeMyTrip Reports\\Scenarios.html",true);
		extent.loadConfig(new File("Config.xml"));
		report = extent.startTest("MakeMyTrip Test", "This is an automated suite to test some scenarios related to MakeMyTrip website");
		
		
		driver = new ChromeDriver(caps);
		driver.manage().window().maximize();
		driver.get(baseURL);
		log.info("Started Chrome");
	}

	
	public void LoginToMakeMyTrip() throws InterruptedException
	{
		
		HomePage.EnterUsernameAndPassword(uname, pword);
		HomePage.clickOnLoginButton(login_btn);
	}
	
	@Test
	public void SearchHotel() 
	{
		Hotels searchHotels = new Hotels(driver,report);
		log.info("Searching Hotels");
		
		HomePage.clickOnHotelsButton(hotels_button);
		
		/*searchHotels.clickOnButton(search_hotels, adult_counter, adult_counter, 0);

		searchHotels.SearchHotel(all_hotels);
		*/
	}
	
	
	@AfterTest
	public void endTest(){
		extent.endTest(report);
		extent.flush();
	}
	
	
}
