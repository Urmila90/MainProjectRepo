package pages;

import org.apache.poi.xdgf.usermodel.section.geometry.InfiniteLine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageDeliveryBoyPage {
@FindBy (xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']")
WebElement manageDeliveryBoyMoreInfo;

@FindBy(xpath="//h1[text()='List Delivery Boy']")
WebElement listDeliveryBoyText;

@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add' and @onclick='click_button(1)']")
WebElement newButton;

@FindBy(xpath="//input[@name='name']")
WebElement deliveryBoyName;

@FindBy(xpath="//input[@id='email']")
WebElement deliveryBoyEmail;

@FindBy(xpath="//input[@id='phone']")
WebElement deliveryBoyPhone;

@FindBy(xpath="//textarea[@id='address']")
WebElement deliveryBoyAddress;

@FindBy(xpath="//input[@id='username']")
WebElement deliveryBoyUsername;

@FindBy(xpath="//input[@id='password']")
WebElement deliveryBoyPassword;

@FindBy(xpath="//button[text()='Save']")
WebElement saveDeliveryBoy;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement alertDeliveryBoyCreatedSuccessfully;

public WebDriver driver;
public ManageDeliveryBoyPage(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);
}

public void clickManageDeliveryBoyMoreInfo()
{
	manageDeliveryBoyMoreInfo.click();
}

public boolean verifyListDeliveryBoyPageIsDisplayed()
{
return listDeliveryBoyText.isDisplayed();
}

public void clickNewButton()
{
	newButton.click();
}
public void enterDeliveryBoyName(String name)
{
	deliveryBoyName.sendKeys(name);
}
public void enterDeliveryBoyEmail(String email)
{
	deliveryBoyEmail.sendKeys(email);
}
public void enterDeliveryBoyPhone(int phone)
{
	deliveryBoyPhone.sendKeys(String.valueOf(phone));
}
public void enterDeliveryBoyAddress(String address)
{
	deliveryBoyAddress.sendKeys(address);
}
public void enterDeliveryBoyUsername(String username)
{
	deliveryBoyUsername.sendKeys(username);
}
public void enterDeliveryBoyPassword(String password)
{
	deliveryBoyPassword.sendKeys(password);
}

public void saveDeliveryBoyDetails()
{
	PageUtility pageutility=new PageUtility();
	pageutility.clickUsingJavaScriptExecutor(driver,saveDeliveryBoy);
	//saveDeliveryBoy.click();
}

  public boolean isSuccessAlertDisplayedOnSuccessfulDeliveryBoyAddition() {
  return alertDeliveryBoyCreatedSuccessfully.isDisplayed(); }
 
}
