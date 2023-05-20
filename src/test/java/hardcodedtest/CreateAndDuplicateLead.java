package hardcodedtest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAndDuplicateLead {

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

		WebElement HomePage=driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if(HomePage.getText().equals("Home"))
			System.out.println("Home page displayed");
		else
			System.out.println("Home page not displayed");
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
		
		WebElement LeadPage=driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if(LeadPage.getText().contains("Lead"))
			System.out.println("lead page displayed");
		else
			System.out.println("lead page not displayed");
		
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		

		WebElement LeadCreatingPage=driver.findElement(By.xpath("//div[@class='small']"));
		if(LeadCreatingPage.getText().contains("Creating New Lead"))
			System.out.println("Creating lead page displayed");
		else
			System.out.println("Creating lead page not displayed");
		
		Random random =new Random();
		String lastname= "Arjun"+random.nextInt(100);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		
		String company= "TCS"+random.nextInt(100);
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(company);
		
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		WebElement LeadInfoPage=driver.findElement(By.xpath("//div[@class=\"small\"]"));
		if(LeadInfoPage.getText().contains(lastname))
			System.out.println("new lead page displayed");
		else
			System.out.println("new lead page not displayed");
		
		driver.findElement(By.name("Duplicate")).click();
		
		WebElement LeadDuplicatePage=driver.findElement(By.xpath("//div[@class='small']"));
		if(LeadDuplicatePage.isDisplayed())
			System.out.println("Duplicating page displayed");
		else
			System.out.println("Duplicating page not displayed");
		
		/*String newlastname= "XYZ"+random.nextInt(100);
		WebElement lastnameTf=driver.findElement(By.xpath("//input[@name='lastname']"));
		lastnameTf.clear();
		lastnameTf.sendKeys(newlastname);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		
		if(LeadInfoPage.getText().contains(newlastname))
			System.out.println("new lead Duplicated displayed");
		else
			System.out.println("New lead Duplicated page not displayed");*/
		
		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
	}

}
