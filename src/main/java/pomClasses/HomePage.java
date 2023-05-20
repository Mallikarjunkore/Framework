package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.Tabnames;
import GenericLibraries.WebDriverutility;

public class HomePage {
	
	
	
	private String commonPath= "//table[@class='hdrTabBg']/descendant::a[text()='%s']";
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(xpath="//a[normalize-space()='Sign Out']")
	private WebElement signOutLink;
	
	@FindBy(id="qccombo")
	private WebElement quickCreateDD;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

public void clickRequiredTab(Tabnames tabname, WebDriverutility wd)
{
	wd.dynamicXpathConversion(commonPath, tabname.getTabName()).click();
}

public void signOutofApp(WebDriverutility wd)
{
	wd.scrollTillElement(adminIcon);
	signOutLink.click();
}
public void selectFromQuickCreate(WebDriverutility wd, String value)
{
	wd.dropdown(quickCreateDD, value);
}
}
