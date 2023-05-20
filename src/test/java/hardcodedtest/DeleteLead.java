package hardcodedtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		WebElement loginPage=driver.findElement(By.xpath("//a[normalize-space()='vtiger']"));
		
		if(loginPage.getText().equals("vtiger"))
			System.out.println("loginpage displayed");
		else
			System.out.println("loginpage not displayed");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
		
		WebElement LeadPage=driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if(LeadPage.getText().contains("Lead"))
			System.out.println("lead page displayed");
		else
			System.out.println("lead page not displayed");
		

		driver.findElement(By.xpath("//input[@type=\"checkbox\"][2]")).click();
		Alert a=driver.switchTo().alert();
		a.accept();
		
		
		driver.findElement(By.xpath("//input[@class=\"crmbutton small delete\"]")).click();
		
		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a1=new Actions(driver);
		a1.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		

	}

}
