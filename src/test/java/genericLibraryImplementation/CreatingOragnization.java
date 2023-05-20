package genericLibraryImplementation;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingOragnization {

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
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\" and @type=\"button\"]")).click();
		
		WebElement OraganizationPageCreated=driver.findElement(By.xpath("//div[@class='small']"));
		if(OraganizationPageCreated.isDisplayed())
			System.out.println("organization  is created");
		else
			System.out.println("organization is not created");
		
		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		Thread.sleep(3000);
		driver.quit();
		
			

	}

}
