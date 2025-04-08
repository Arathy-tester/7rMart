package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {
	AdminUsersPage adminusers;
	HomePage homepage;
	
	@Test(description="Whether user can create new Admin user",priority=1,groups= {"smoke"})
	public void verifyUsercanCreateAdminUser() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue=ExcelUtility.getStringData(0,1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue);
		homepage=login.clickOnClick();
		
		homepage.clickonAdminUser();
		adminusers=homepage.clickonManageUser();
		adminusers.clickonNewAdminUser();
		RandomDataUtility random=new RandomDataUtility();
		String newuserName=random.createRandomUsername();
		String newpassWord=random.createRandomPassword();
		adminusers.enterNewUserName(newuserName).enterNewPassword(newpassWord).selectNewUserType();
		adminusers.clickonSaveButton();
		boolean isAlertWindowPresent=adminusers.isAlertWindowPresent();
		Assert.assertTrue(isAlertWindowPresent,Messages.ALERTWINDOWMESSAGE);
	}
	@Test(description="Whether user can search new Admin",priority=2,groups= {"smoke"})
	public void searchCreatedAdminUser() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue=ExcelUtility.getStringData(0,1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue);
		homepage=login.clickOnClick();
		adminusers=homepage.clickonAdminUser().clickonManageUser();
		adminusers.clickonSearch();
		String newusername=ExcelUtility.getStringData(0, 0, "NewAdmin");
		adminusers.enterSearchUserName(newusername);
		adminusers.clickonSearchButtonUserType();
		String actual=adminusers.verifyActiveSearchisWorking();
		String expected=("Active");
		Assert.assertEquals(actual, expected,Messages.NEWADMINPRESENT);
	}
	

}
