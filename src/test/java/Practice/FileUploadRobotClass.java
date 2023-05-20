package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadRobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		driver.findElement(By.xpath("//a[text()=\"Register\"]")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Upload Resume']")).click();
		
		//select file path to be uploaded
		StringSelection str=new StringSelection("C:\\Users\\Mallikarjun\\OneDrive\\Documents\\Resume\\MallikarjunKore.pdf");
		
		//copy the path to the to system clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		// press ctrl+v
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		//Press enter
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(4000);
		driver.quit();
		
		

	}

}
