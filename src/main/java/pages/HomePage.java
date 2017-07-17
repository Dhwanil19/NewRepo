package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import genericclasses.Utilities;

public class HomePage {

	static Utilities wt = new Utilities();
	
	static WebDriver driver;

	static ExtentTest report;
	
	
	public static void clickOnHotelsButton(String HOTELS_btn_xpath)
	{
		WebElement hotel_tab = wt.FindElementAndWait(driver, HOTELS_btn_xpath, 3);
		hotel_tab.click();
		report.log(LogStatus.PASS, "Click on Hotels button","Successfully clicked on Hotels button");
	}
	
	public static void clickOnLoginButton(String login_btn_xpath)
	{
		WebElement login_bn = wt.FindElementAndWait(driver, login_btn_xpath, 3);
		login_bn.click();
		report.log(LogStatus.PASS, "Click on Login button","Successfully clicked on Login button");
	}
	
	public static void clickOnLoginIcon(String login_btn_xpath)
	{
		WebElement login_bn = wt.FindElementAndWait(driver, login_btn_xpath, 3);
		login_bn.click();
		report.log(LogStatus.PASS, "Click on Login button","Successfully clicked on Login button");
	}
	
	public static void EnterUsernameAndPassword(String uname, String pword){
		
		report.log(LogStatus.PASS, "Enter Username and Password","Successfully entered Username and Password");
	}
	
}
