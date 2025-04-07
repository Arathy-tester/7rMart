package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AdminUsersPage {
	
	WaitUtility wait=new WaitUtility();
	public WebDriver driver1;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver1=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//i[@class=\"nav-icon fas fa-users\"]")private WebElement adminUserSelect;
	//@FindBy(xpath="//p[text()='Manage Users']")private WebElement manageUser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newAdminUser;
	@FindBy(xpath="//input[@name='username']")private WebElement newUserName;
	@FindBy(xpath="//input[@id='password']")private WebElement newPassWord;
	@FindBy(xpath="//select[@name='user_type']")private WebElement newUserType;
	@FindBy(xpath="//button[@name=\"Create\"]")private WebElement saveButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement search;
	@FindBy(xpath="//input[@id='un']")private WebElement searchUserName;
	@FindBy(xpath="//button[@class=\"btn btn-block-sm btn-danger\"]")private WebElement searchButtonUserName;
	@FindBy(xpath="//button[@aria-hidden=\"true\"]")private WebElement alertAdminUser;
	@FindBy(xpath ="//span[@class='badge bg-success']")private WebElement activebutton;
	
	
	public AdminUsersPage clickonNewAdminUser() {

		newAdminUser.click();
		return this;
	}
	public AdminUsersPage enterNewUserName(String newuserName) {
		newUserName.clear();
		newUserName.click();
		newUserName.sendKeys(newuserName);
		return this;
	}
	public AdminUsersPage enterNewPassword(String newpassword) {
		newPassWord.sendKeys(newpassword);
		return this;
	}
	public AdminUsersPage selectNewUserType() {
		Select select=new Select(newUserType);
		select.selectByIndex(1);
		return this;

	}
	public AdminUsersPage clickonAdminUser() {

		adminUserSelect.click();
		return this;
	}
	public AdminUsersPage clickonSaveButton() {
		//wait.waitUntilElementtobeSelected(driver1, adminUserSelect);
		saveButton.click();
		return this;
	}
	public AdminUsersPage clickonSearch() {
		search.click();
		return this;
	}
	public AdminUsersPage enterSearchUserName(String newuserName) {
		searchUserName.sendKeys(newuserName);
		return this;
	}
	public AdminUsersPage clickonSearchButtonUserType() {
		searchButtonUserName.click();
		return this;
	}
	public boolean isAlertWindowPresent() {
		return alertAdminUser.isDisplayed();
	}
	public String verifyActiveSearchisWorking() {
		return activebutton.getText();
	}
}
