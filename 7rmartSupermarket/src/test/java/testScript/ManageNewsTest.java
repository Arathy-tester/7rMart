package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage manageNews;
	HomePage homepage;
   @Test(description="Verify user can enter new news on Manage_News",priority=1,groups= {"smoke"})
   public void clickonManageNews() throws IOException, InterruptedException {
	String usernamevalue=ExcelUtility.getStringData(0,0,"LoginPage");
	String passwordValue=ExcelUtility.getStringData(0,1,"LoginPage");
	LoginPage login=new LoginPage(driver);
	homepage=login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue).clickOnClick();
	//ManageNewsPage manageNews=new ManageNewsPage(driver);
	manageNews=homepage.clickonManageNews();
	manageNews.clickonNewManageNews();
	String newstoenter=ExcelUtility.getStringData(0, 0, "News");
	manageNews.textonEnternews(newstoenter).saveNewsText();
	//manageNews.saveNewsText();
	boolean verifyNewsSuccessWindow=manageNews.verifyNewsSuccessWindow();
	Assert.assertTrue(verifyNewsSuccessWindow,Messages.NEWNEWSADDED);
}
   @Test(description="Verify user can search the entered news on Manage_News",priority=2,groups= {"smoke"})
   public void clickonSearchManageNews() throws IOException {
	   String usernamevalue=ExcelUtility.getStringData(0,0,"LoginPage");
		String passwordValue=ExcelUtility.getStringData(0,1,"LoginPage");
		LoginPage login=new LoginPage(driver);
		homepage=login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordValue).clickOnClick();
		//ManageNewsPage manageNews=new ManageNewsPage(driver);
		manageNews=homepage.clickonManageNews();
		manageNews.clickonSearchNews();
		String newstoenter=ExcelUtility.getStringData(0, 0, "News");
		manageNews.textonTitleSearchNews(newstoenter).clickonsearchButton();
		boolean verifySearchedNewsPresent=manageNews.verifySearchedNewsPresent();
		Assert.assertTrue(verifySearchedNewsPresent,Messages.NEWSSEARCH);
   }
}
