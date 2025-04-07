package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class SubCategoryTest extends Base {
	
	HomePage homepage;
	SubCategoryPage subcategory;
	
	@Test(description = "Add new Category and SubCategory in Sub-Category Menu", priority = 1, groups = { "smoke" })
	public void clickonSubCategory() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		homepage=login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue).clickOnClick();
		
		//RandomDataUtility randomutility = new RandomDataUtility();
		//String selectSubCategoryValue = randomutility.createRandomUsername();
		//String subCategoryValue = randomutility.createRandomPassword();
		
		//SubCategoryPage subcategory = new SubCategoryPage(driver);
		subcategory=homepage.clickSubcategory();
		subcategory.clickNewSubcategory().clickCategoryInput();
		
		String input = ExcelUtility.getStringData(1, 0, "SubCategory");
		subcategory.clickSubCategoryInput(input).clickOnImageInput().clickOnSaveButton();
		Boolean verifyAlertWindowPresent = subcategory.verifyAlertWindowPresent();
		Assert.assertTrue(verifyAlertWindowPresent, Messages.SUBCATEGORYADDED);
	}

	@Test(description = "Search the added item in Sub-Category Menu", priority = 2, groups = { "smoke" })
	public void clickonSeachSubCategory() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		homepage=login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue).clickOnClick();

		//login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue).clickOnClick();
		
		//SubCategoryPage subcategory = new SubCategoryPage(driver);
		//subcategory.clickSubcategory().clickonsearchSubCategory().clickCategoryonsearchSubCategory();
		subcategory=homepage.clickSubcategory();
		subcategory.clickonsearchSubCategory().clickCategoryonsearchSubCategory();
		String input = ExcelUtility.getStringData(1, 0, "SubCategory");
		subcategory.clickonSubCategoryonSearchSubCategory(input).clickonsearchonSearchSubCategory();
		
		String actual = subcategory.verifySearchWindow();
		String expected = "Seb";
		Assert.assertEquals(actual, expected, Messages.SUBCATEGORYSEARCH);

	}

}
