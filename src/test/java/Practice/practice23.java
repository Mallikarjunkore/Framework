package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutput;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice23 {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement facebookPage=driver.findElement(By.xpath("//img[@class=\"fb_logo _8ilh img\"]"));
		
		File src=facebookPage.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\Mallikarjun\\eclipse-workspace\\SkillRary\\src\\Screenshot/arjun.png");	
		FileUtils.copyFile(src,trg);
		Thread.sleep(2000);
		
		/*StringSelection strc=new StringSelection("C:\\Users\\Mallikarjun\\OneDrive\\Documents\\Resume\\MallikarjunKore.pdf");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strc, null);
		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3999);
		driver.quit(); */
		
		
		
		driver.quit();

	}

}
