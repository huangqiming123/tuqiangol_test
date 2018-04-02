package testcases.AccountCenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.comdata.assertDate.ComAssertData;
import pages.accountcenterPage.AccountCenterFictitiousAccountManagerPage;
import pages.base.BasePage;

public class TestCase027DeleteFictionsAccount {
WebDriver dr;
	
	@BeforeMethod
	public void setUp() throws Exception{
		dr=new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		
	}
     @AfterMethod
	public void tearDown() throws Exception{
		dr.quit();
	}
     @Test
     public void testDeleteFictionsAccount() throws Exception{
    	 BasePage basep=new BasePage(dr);
    	 AccountCenterFictitiousAccountManagerPage acfam=new AccountCenterFictitiousAccountManagerPage(dr);
    	 ComAssertData assertd = new ComAssertData();
    	 basep.login();
 		 acfam.enterFictitiousAccountPage();
 		 String ficAccount=acfam.getFicAccountAccount();
 		 acfam.clickFicAccountDelBtn();
 		 acfam.canlceDelFicAccount();
 		 acfam.canlceDelFicAccountBtn();
 		 acfam.clickDelFicAccountBtn();
     }

}
