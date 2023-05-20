package genericLibraryImplementation;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericLibraries.Excelutility;
import GenericLibraries.IConstantPath;
import GenericLibraries.JavaUtility;
import GenericLibraries.WebDriverutility;
import GenericLibraries.propertiesUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactsWithMandatory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		propertiesUtility property=new propertiesUtility();
		WebDriverutility wd=new WebDriverutility();
		JavaUtility java=new JavaUtility();
		Excelutility excel=new Excelutility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
		
		String browser =property.fetchDataFromProperties("browser");
		String url= property.fetchDataFromProperties("url");
		long time= Long.parseLong(property.fetchDataFromProperties("timeouts"));
		
		WebDriver driver=wd.openApplication(browser, url, time);
		
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php");*/
		
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
		
		driver.findElement(By.xpath("//a[normalize-space()='Contacts']")).click();
		
		WebElement ContactPage=driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if(ContactPage.isDisplayed())
			System.out.println("conatct page is displayed");
		else
			System.out.println("contact page is not displayed");
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		Random r=new Random();
		String  lastname= "msk"+ r.nextInt(10);
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
