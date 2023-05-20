package genericLibraryImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import GenericLibraries.Excelutility;
import GenericLibraries.IConstantPath;
import GenericLibraries.JavaUtility;
import GenericLibraries.WebDriverutility;
import GenericLibraries.propertiesUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewEvent {

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
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");*/
		
		WebElement loginPage=driver.findElement(By.xpath("//a[normalize-space()='vtiger']"));
		
		if(loginPage.getText().equals("vtiger"))
			System.out.println("loginpage displayed");
		else
			System.out.println("loginpage not displayed");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		WebElement CreatDropDown=driver.findElement(By.xpath("//select[@id='qccombo']"));
		
		
		Select s=new Select(CreatDropDown);
		System.out.println(s.isMultiple());
		
		s.selectByIndex(8);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("UVCE Fest");
		
WebElement statusDropdown=driver.findElement(By.xpath("//select[@name='eventstatus']"));
		
		Select s1=new Select(statusDropdown);
		System.out.println(s1.isMultiple());
		
		driver.findElement(By.xpath("//select[@name='eventstatus'][1]")).click();
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement EventCreated=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(EventCreated.isDisplayed())
			System.out.println("event created");
		else
			System.out.println("event not created");
		
		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a1=new Actions(driver);
		a1.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
