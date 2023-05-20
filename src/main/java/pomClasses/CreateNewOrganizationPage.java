package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {
	
	@FindBy(xpath="xpath(\"//a[@class=\\\"hdrLink\\\"]\"")
	private WebElement element;

	@FindBy(name="accountname")
	private WebElement orgNameTf;
	
	@FindBy(name="industry")
	private WebElement typeDD;
	
	@FindBy(xpath="//input[contains(@value,'Save')]")
	private WebElement saveButton;
	
	public void CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void setOrgName(String orgName) 
	{
		orgNameTf.sendKeys(orgName);
	}
	
}
