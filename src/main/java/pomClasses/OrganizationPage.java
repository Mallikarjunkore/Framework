package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement plusButton;
	
	@FindBy(xpath="//table[@class='lvt small']/descendant::tr[last()/td[3]/a")
	private WebElement newOrganization;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickPlusButtoon() {
		plusButton.click();
	}
	
	public String getNewOrganization() {
		return newOrganization.getText();
		
	}

}
