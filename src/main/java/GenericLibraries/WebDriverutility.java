package GenericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class conntains all the methods to perform opertaions of webdriver
 * @author Mallikarjun
 *
 */

public class WebDriverutility {
	private WebDriver driver;
	private Select s;
	
	/**
	 * This method helps us to open the application 
	 * It opens the browser ,maximizes it, and also fetches the application with the help of url.
	 * @param Browser
	 * @param url
	 * @param time
	 * @return
	 */
	public WebDriver openApplication(String Browser, String url, long time)
	{
		switch(Browser)
		{
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
		case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		default:System.out.println("Enter valid browser");
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return driver;
	}
	
	/**
	 * This method helps us to wait the testScript until the visibility of the element or specified time is over.
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(long time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
		return e;
	}
	
	/**
	 * This method helps us to wait the testScript until the title contains the given string or specified time is over.
	 * @param time
	 * @param String
	 * @return
	 */
	public boolean explicitWait(long time, String string)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		boolean status = wait.until(ExpectedConditions.titleContains(string));
		return status;
	}
	
	
	
	/**
	 * This method perform mouse actions such as mouse hovering, double click, right click and drag and drop.
	 * @param action
	 * @param element
	 * @param source
	 * @param destination
	 */
	public void mouseActions(String action, WebElement element, WebElement source, WebElement destination)
	{
		Actions a = new Actions(driver);
		switch(action)
		{
		case "moveToElement": a.moveToElement(element).perform();
		break;
		case "doubleClick":a.doubleClick(element).perform();
		break;
		case "contextClick":a.contextClick(element).perform();
		break;
		case "dragAndDrop":a.dragAndDrop(source, destination);
		break;
		default: System.out.println("Enter valid Actions");
		}
		
	}
	
	/**
	 * This method selects the dropdown based on index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index)
	{
		s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method selects the dropdown based on value of the value_attribute
	 * @param element
	 * @param value
	 */
	public void dropdown(WebElement element, String value)
	{
		s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method selects the drop down based on inner text of the WebElement
	 * @param text
	 * @param element
	 */
	public void dropdown(String text, WebElement element)
	{
		s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method helps us to switch to the frame with the index value
	 * @param index
	 */
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method helps us to switch to the frame with the name or id attribute
	 * @param nameOrId
	 */
	public void switchToFrame(String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method helps us to switch to the frame with the element present on the frame
	 * @param element
	 */
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method helps us to switch back from the frame to the main webpage
	 */
	public void switchBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method helps us to scroll the Webpage till the element
	 * @param element
	 */
	public void scrollTillElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	/**
	 * This method will take the screenshot of webpage
	 */
	public void takeScreenshot()
	{
		JavaUtility ju = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/ss_"+ju.getCurrentTime()+".png");	
		try 
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will handle the alert popup
	 * @param action
	 * @param text
	 */
	public void handleAlert(String action, String text)
	{
		Alert al=driver.switchTo().alert();
		switch(action)
		{
		case "accept": al.accept();
		break;
		case "dismiss":al.dismiss();
		break;
		case "sendKeys":al.sendKeys(text);
		break;
		case "getText":al.getText();
		break;
		default: System.out.println("Enter valid acion");
		}
	}
	
	/**
	 * This method will handle the child browser popup
	 */
	public void handleChildBrowser()
	{
		Set<String> child = driver.getWindowHandles();
		for(String childBrowser:child)
		{
			driver.switchTo().window(childBrowser);
		}
		
	}
	/**
	 * This method is used to convert dyanamic element to Xpath
	 * @param dynamicPath
	 * @param replaceData
	 * @return
	 */
	
	public WebElement dynamicXpathConversion(String dynamicPath, String replaceData) {
		String requiredpath= String.format(dynamicPath, replaceData);
		
	WebElement element =driver.findElement(By.xpath(requiredpath));
	return element;
	}
	
	/**
	 * This method will switch to the parent window from the current window
	 */
	public void getParentWindow()
	{
		String parent= driver.getWindowHandle();
		driver.switchTo().window(parent);
	}
	
	/**
	 * This method will close the current window
	 */
	public void closeCurrentTab()
	{
		driver.close();
	}
	
	/**
	 * This method will close all the windows and quit the browser
	 */
	public void quitBrowser()
	{
		driver.quit();
	}
		
	
}
	
		

	


