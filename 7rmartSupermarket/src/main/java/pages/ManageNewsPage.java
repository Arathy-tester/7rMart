package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	WaitUtility wait= new WaitUtility();
	public WebDriver driver1;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver1=driver;
		PageFactory.initElements(driver,this);
	}
	//@FindBy(xpath="//a[p[text()='Manage News']]")private WebElement manageNews;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newManageNews;
	@FindBy(xpath="//textarea[@id='news']")private WebElement enterNews;
	@FindBy(xpath="//button[text()='Save']")private WebElement saveNews;
	@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement searchNews;
	@FindBy(xpath="//input[@placeholder='Title']")private WebElement titlesearchNews;
	@FindBy(xpath="//button[@name='Search']")private WebElement searchButton;
	@FindBy(xpath="//button[@class='close']")private WebElement newsSuccess;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']")private WebElement searchedNewsPresent;
	
	public ManageNewsPage clickonNewManageNews() {
		newManageNews.click();
		return this;

	}
	
	public ManageNewsPage textonEnternews(String newstoenter) {
		enterNews.sendKeys(newstoenter);
		return this;

	}
	public ManageNewsPage saveNewsText() {
		wait.waitUntilElementtobeClickable(driver1, saveNews);
		saveNews.click();
		return this;

	}
	public ManageNewsPage clickonSearchNews() {
		searchNews.click();
		return this;

	}
	public ManageNewsPage textonTitleSearchNews(String newstoenter) {
		titlesearchNews.sendKeys(newstoenter);
		return this;

	}
	public ManageNewsPage clickonsearchButton() {
		//wait.waitUntilAlertisPresent(driver1, searchButton);
		searchButton.click();
		return this;

	}
	public boolean verifyNewsSuccessWindow() {
		return newsSuccess.isDisplayed();
	}
	public boolean verifySearchedNewsPresent() {
		return searchedNewsPresent.isDisplayed();
	}
}
