package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement GooglePage= driver.findElement(By.xpath("//img[@alt='Facebook']"));
		if(GooglePage.isDisplayed())
			System.out.println("pass");
		else
			System.out.println("fail");
		
		
		/*if(GooglePage.getText().contains("Google"))
			System.out.println("Google page is opened successfully");
		else
			System.out.println("Google page is not opened");*/
		
		driver.quit();
		

	
		
	}

}
