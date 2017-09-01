package testcases.account_center;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.account_center.account_center_msg_center_page;
import pages.base.base_page;

public class test_case_022_account_center_msg_search  {
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
	public void test_account_center_msg_search() throws InterruptedException{
		base_page basep=new base_page(dr);
		account_center_msg_center_page acmcp=new account_center_msg_center_page(dr);
		basep.login();
		acmcp.enter_msg_center();
		System.out.println(basep.page_number());
	}

}
