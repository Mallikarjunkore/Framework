package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Whatsapp {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.whatsapp.com/");
		
		WebElement whatsappPage = driver.findElement(By.xpath("//span[@class='_afw1']//img[@alt='WhatsApp Main Page']"));
		if(whatsappPage.isDisplayed())
			System.out.println("pass");
		else
			System.out.println("fail");

	}

}
