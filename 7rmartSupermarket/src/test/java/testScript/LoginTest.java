package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(description="verify whether user is successfully login with valid credentials",priority=1,groups={"smoke"})
	public void verifyWetherUserCanLoginwithValidCredentials() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue=ExcelUtility.getStringData(0,1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue).clickOnClick();
		boolean isDashBoardDisplayed=login.isDashBoardDisplayed();
		Assert.assertTrue(isDashBoardDisplayed,Messages.VALIDCREDENTIALERROR);
	}
	
	@Test(description="verify whether user is successfully login with invalid username and valid password a credentials",priority=2,groups={"smoke"})
	public void verifyWetherUserCanLoginwithInvalidUsernameandValidpasswordCredentials1() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(1,0,"LoginPage");
		String passwordValue=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue).clickOnClick();
		boolean isinValidMessageDisplayed=login.isinValidMessageDisplayed();
		Assert.assertTrue(isinValidMessageDisplayed,Messages.VALIDCREDENTIALERROR);
		//Assert.assertTrue(isInvalidCredentialMessageDisplayed, "User was unable to Login with invalid credentials");
		
	}
	@Test(description="verify whether user is successfully login with valid username and invalid password a credentials",priority=3,retryAnalyzer=retry.Retry.class)
	public void verifyWetherUserCanLoginwithValidalidUsernameandInvalidpasswordCredentials1() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(2,0,"LoginPage");
		String passwordValue=ExcelUtility.getStringData(2,1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue).clickOnClick();
		boolean isinValidMessageDisplayed=login.isinValidMessageDisplayed();
		Assert.assertTrue(isinValidMessageDisplayed, Messages.VALIDCREDENTIALERROR);
		}
	@Test(description="verify whether user is successfully login with invalid username and invalid password a credentials",priority=1,dataProvider="loginProvider")
	public void verifyWetherUserCanLoginwithInValidalidUsernameandInvalidpasswordCredentials1(String usernamevalue,String passwordValue) throws IOException {
		//String usernamevalue=ExcelUtility.getStringData(3,0,"LoginPage");
		//String passwordValue=ExcelUtility.getStringData(3,1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue).clickOnClick();
		boolean isinValidMessageDisplayed=login.isinValidMessageDisplayed();
		Assert.assertTrue(isinValidMessageDisplayed, Messages.VALIDCREDENTIALERROR);
		}
	@DataProvider(name="loginProvider")

	public Object[][] getDataFromDataProvider() throws IOException

	{

		return new Object[][] { new Object[] {"admin","admin12"},

			new Object[] {"123","123"},

			//new Object[] {ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}

		};

	}
}
