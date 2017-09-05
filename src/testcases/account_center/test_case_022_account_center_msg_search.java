package testcases.account_center;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.account_center.account_center_msg_center_page;
import pages.base.base_page;
import model.connect_mysql;
import data.com_data.sql_data;

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
	public void test_account_center_msg_search() throws InterruptedException, SQLException{
		base_page basep=new base_page(dr);
		connect_mysql conn=new connect_mysql();
		sql_data sqld=new sql_data();
		account_center_msg_center_page acmcp=new account_center_msg_center_page(dr);
		basep.login();
		acmcp.enter_msg_center();
		int actual_message_num=acmcp.message_number();
		List<String> fullParentIdAnduserId=new ArrayList<String>();
		List<String> account_center_mess_number=new ArrayList<String>();
		fullParentIdAnduserId=conn.connectMySqlM(sqld.fullParentIdAnduserId()[0], sqld.fullParentIdAnduserId()[1]);
		String fullParentId=fullParentIdAnduserId.get(0);
		String userId=fullParentIdAnduserId.get(1);
		account_center_mess_number=conn.connectMySqlM(sqld.account_center_mess_number(fullParentId, userId)[0], sqld.account_center_mess_number(fullParentId, userId)[1]);
		int except_message_num=Integer.parseInt(account_center_mess_number.get(0));
		Assert.assertEquals(actual_message_num, except_message_num, "消息中心消息数量不对");
	}

}
