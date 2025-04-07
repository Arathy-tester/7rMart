package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage{
	
	
	WaitUtility wait=new WaitUtility();
	public WebDriver driver1;
	public HomePage(WebDriver driver)
	{
		this.driver1=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement logoutadmin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")private WebElement logoutclick;
	@FindBy(xpath="//b[text()='7rmart supermarket']")private WebElement maintitle;
	@FindBy(xpath="//i[@class=\"nav-icon fas fa-users\"]")private WebElement adminUserSelect;
	@FindBy(xpath="//p[text()='Manage Users']")private WebElement manageUser;
	@FindBy(xpath="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-sub-category\"]")private WebElement subcategory;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newManageNews;
	@FindBy(xpath="//a[p[text()='Manage News']]")private WebElement manageNews;


	
	public HomePage clickonadmin() {
		logoutadmin.click();
		return this;
	}
	public LoginPage logoutclick() {
		wait.waitUntilElementtobeVisible(driver1, logoutclick);
		logoutclick.click();
		return new LoginPage(driver1);
	}
	public String getTextFromTitle() {
		return maintitle.getText();
	}
	public SubCategoryPage clickSubcategory() {
		subcategory.click();
		return new SubCategoryPage(driver1);
	}
	public HomePage clickonAdminUser() {

		adminUserSelect.click();
		return new HomePage(driver1);
	}
	public AdminUsersPage clickonManageUser() {
		manageUser.click();
		return new AdminUsersPage(driver1);
	}
	
	public ManageNewsPage clickonManageNews() {
		manageNews.click();
		return new ManageNewsPage(driver1);
	}
	
}

