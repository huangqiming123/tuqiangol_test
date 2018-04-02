package testcases.AccountCenter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.comdata.assertDate.ComAssertData;
import data.comdata.sqlDate.SqlData;
import model.ConnectMysql;
import model.CsvReader;
import pages.accountcenterPage.AccountCenterMsgCenterPage;
import pages.base.BasePage;

public class TestCase020AccountCenterMsgUnread {
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
	public void test_account_center_msg_unread() throws Exception{
		BasePage basep=new BasePage(dr);
		ComAssertData assertd=new ComAssertData();
		ConnectMysql conn=new ConnectMysql();
		SqlData sqld=new SqlData();
		CsvReader csvr=new CsvReader("D:\\workplace\\tuqiangol_test\\src\\data\\account_center\\message_search_unread.csv");
		List<List<String>> csv_data=csvr.readCSVFile();
		AccountCenterMsgCenterPage acmcp=new AccountCenterMsgCenterPage(dr);
		basep.login();
		acmcp.enterMsgCenter();
		Assert.assertEquals(acmcp.mess_center_title(), assertd.account_center_msg_center_title()[0], "消息中心title错误");
		acmcp.msgCenterParamInput(csv_data.get(0).get(0), csv_data.get(0).get(1), csv_data.get(0).get(2));
		int actual_message_unread_num=acmcp.messageNumber();
		List<String> fullParentIdAnduserId=new ArrayList<String>();
		List<String> account_center_msg_unread_number=new ArrayList<String>();
		fullParentIdAnduserId=conn.connectMySqlM(sqld.fullParentIdAnduserId()[0], sqld.fullParentIdAnduserId()[1]);
		String fullParentId=fullParentIdAnduserId.get(0);
		String userId=fullParentIdAnduserId.get(1);
		account_center_msg_unread_number=conn.connectMySqlM(sqld.account_center_msg_unread(fullParentId, userId)[0], sqld.account_center_msg_unread(fullParentId, userId)[1]);
		int except_message_unread_num=Integer.parseInt(account_center_msg_unread_number.get(0));
		
		int actual_show_unread_num=acmcp.unreadMessNumber();
		Assert.assertEquals(actual_show_unread_num, except_message_unread_num,"未读消息数量不对");
		Assert.assertEquals(actual_message_unread_num, except_message_unread_num,"未读消息数量不对");
	}

}
