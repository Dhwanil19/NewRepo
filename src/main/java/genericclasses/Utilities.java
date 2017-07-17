package genericclasses;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	WebDriver driver;
	
	public void waitfortime(WebDriver driver,  int time)
	{
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public WebElement FindElementAndWait(WebDriver driver,String locator,long timeout){
		this.driver = driver;
		//driver.findElement(By.xpath(locator));
		WebDriverWait wt = new WebDriverWait(driver,timeout);
		WebElement el = wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	
		return el;
		
	}
	
	public List<WebElement> FindElementsAndWait(WebDriver driver,String locator,long timeout){
		this.driver = driver;
		//driver.findElement(By.xpath(locator));
		WebDriverWait wt = new WebDriverWait(driver,timeout);
		List<WebElement> el = wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	
		return el;
		
	}
	
	public String createScreenShot(WebDriver driver, String screenshot_loc) throws IOException{
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File(screenshot_loc));
		
		return null;
		
	}
	
	
}
