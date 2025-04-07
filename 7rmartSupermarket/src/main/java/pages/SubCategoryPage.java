package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;
import utilities.WaitUtility;

	public class SubCategoryPage{
		WaitUtility wait=new WaitUtility();
		public WebDriver driver1;
		public SubCategoryPage(WebDriver driver)
		{
			this.driver1=driver;
			PageFactory.initElements(driver,this);
		}
		//@FindBy(xpath="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-sub-category\"]")private WebElement subcategory;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newSubcategory;
		@FindBy(xpath="//select[@id=\'cat_id\']")private WebElement categoryInput;
		@FindBy(xpath="//input[@id='subcategory']")private WebElement subcategoryInput;
		@FindBy(xpath="//input[@id=\'main_img\']")private WebElement imageInput;
		@FindBy(xpath="//button[text()='Save']")private WebElement saveButton;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement searchSubCategory;
		@FindBy(xpath="//select[@id='un']")private WebElement categoryonSearchSubCategory;
		@FindBy(xpath="//input[@name='ut']")private WebElement subCategoryonSearchSubCategory;
		@FindBy(xpath="//button[@value='sr']")private WebElement searchonSearchSubCategory;
		@FindBy(xpath="//button[@class='close']")private WebElement alertWindow;
		@FindBy(xpath = "//table[@class=\"table table-bordered table-hover table-sm\"]/tbody/tr/td[1]")private WebElement searchWindow;
		
		
		public SubCategoryPage clickNewSubcategory() {
			newSubcategory.click();
			return this;
		}
		public SubCategoryPage clickCategoryInput() {
			
			PageUtility page=new PageUtility();
			page.selectDropdownWithIndex(categoryInput, 3);
			return this;
		}
		public SubCategoryPage clickSubCategoryInput(String input) {
			
			subcategoryInput.sendKeys(input);
			return this;
		}
		public SubCategoryPage clickOnImageInput() {
			
			imageInput.sendKeys(Constants.TESTDATAFILE1);
			return this;
		}
		public SubCategoryPage clickOnSaveButton() {
			wait.waitUntilElementtobeClickable(driver1,saveButton);
			saveButton.click();
			return this;
		}
		
		public SubCategoryPage clickonsearchSubCategory() {
			searchSubCategory.click();
			return this;
		
		}
		public SubCategoryPage clickCategoryonsearchSubCategory() {
			Select select=new Select(categoryonSearchSubCategory);
			select.selectByIndex(3);
			return this;
		}
		public SubCategoryPage clickonSubCategoryonSearchSubCategory(String input) {
			subCategoryonSearchSubCategory.sendKeys(input);
			return this;

		}
		public SubCategoryPage clickonsearchonSearchSubCategory() {
			searchonSearchSubCategory.click();
			return this;

		}
		public boolean verifyAlertWindowPresent() {
			return alertWindow.isDisplayed();
		}
		public String verifySearchWindow() {
			return searchWindow.getText();
		}
	}


