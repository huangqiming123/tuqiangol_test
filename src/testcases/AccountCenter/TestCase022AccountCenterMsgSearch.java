package testcases.AccountCenter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.comdata.sqlDate.SqlData;
import pages.accountcenterPage.AccountCenterMsgCenterPage;
import pages.base.BasePage;
import model.ConnectMysql;
import model.CsvReader;

public class TestCase022AccountCenterMsgSearch  {
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
	public void test_account_center_msg_search() throws Exception{
		BasePage basep=new BasePage(dr);
		ConnectMysql conn=new ConnectMysql();
		SqlData sqld=new SqlData();
		CsvReader csvr=new CsvReader("D:\\workplace\\tuqiangol_test\\src\\data\\account_center\\message_search_data.csv");
		List<List<String>> csv_data=csvr.readCSVFile();
		AccountCenterMsgCenterPage acmcp=new AccountCenterMsgCenterPage(dr);
		basep.login();
		acmcp.enterMsgCenter();
		for(int i=0;i<csv_data.size();i++){
			acmcp.msgCenterParamInput(csv_data.get(i).get(0), csv_data.get(i).get(1), csv_data.get(i).get(2));
			int actual_message_num=acmcp.messageNumber();
			List<String> fullParentIdAnduserId=new ArrayList<String>();
			List<String> account_center_mess_number=new ArrayList<String>();
			fullParentIdAnduserId=conn.connectMySqlM(sqld.fullParentIdAnduserId()[0], sqld.fullParentIdAnduserId()[1]);
			String fullParentId=fullParentIdAnduserId.get(0);
			String userId=fullParentIdAnduserId.get(1);
			account_center_mess_number=conn.connectMySqlM(sqld.account_center_mess_number(fullParentId, userId)[i][0], sqld.account_center_mess_number(fullParentId, userId)[i][1]);
			int except_message_num=Integer.parseInt(account_center_mess_number.get(0));
			Assert.assertEquals(actual_message_num, except_message_num, "消息中心消息数量错误");
		}
	}

}
