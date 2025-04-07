package testScript;

import java.io.IOException;

import org.apache.logging.log4j.message.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage homepage;
	
	@Test(description="verify whether logout",retryAnalyzer=retry.Retry.class)
	public void whetherUserisAbletoLogout() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue=ExcelUtility.getStringData(0,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue);
		//HomePage home=new HomePage(driver);
		homepage=loginpage.clickOnClick();
		homepage.clickonadmin();
		loginpage=homepage.logoutclick();
		String actual=homepage.getTextFromTitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Messages.LOGOUTMESSAGE);
	}

}
