package hardcodedtest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OraganisationWithIndustryandType {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php");
		
WebElement loginPage=driver.findElement(By.xpath("//a[normalize-space()='vtiger']"));
		
		if(loginPage.getText().equals("vtiger"))
			System.out.println("loginpage displayed");
		else
			System.out.println("loginpage not displayed");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		WebElement HomePage=driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if(HomePage.getText().equals("Home"))
			System.out.println("Home page displayed");
		else
			System.out.println("Home page not displayed");
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
		WebElement organizationPage=driver.findElement(By.xpath("//a[@class=\"hdrLink\"]"));
		if(organizationPage.isDisplayed())
		System.out.println("organization page is displayed");
		else
			System.out.println("organization page is not displayed");
		Random random =new Random();
		String Orgname= "Arjun"+random.nextInt(100);
		
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(Orgname);
		
		WebElement Industry=driver.findElement(By.xpath("//select[@name='industry']"));
		
		Select s=new Select (Industry);
		System.out.println(s.isMultiple());
		s.selectByIndex(2);
		
		WebElement Type=driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select s1=new Select(Type);
		s1.selectByIndex(3);
		

		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		Thread.sleep(3000);
		driver.quit();
		

	}

}
