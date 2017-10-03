package testcases.AccountCenter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.comdata.AssertData;
import data.comdata.SqlData;
import model.ConnectMysql;
import model.CsvReader;
import pages.accountcenter.AccountCenterMsgCenterPage;
import pages.base.BasePage;


public class TestCase021AccountCenterMsgSetRead {
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
     public void test_account_center_msg_set_read() throws Exception{
    	BasePage basep=new BasePage(dr);
 		AssertData assertd=new AssertData();
 		ConnectMysql conn=new ConnectMysql();
 		SqlData sqld=new SqlData();
 		CsvReader csvr=new CsvReader("D:\\workplace\\tuqiangol_test\\src\\data\\account_center\\message_search_unread.csv");
 		List<List<String>> csv_data=csvr.readCSVFile();
 		AccountCenterMsgCenterPage acmcp=new AccountCenterMsgCenterPage(dr);
 		basep.login();
 		acmcp.enter_msg_center();
 		Assert.assertEquals(acmcp.mess_center_title(), assertd.account_center_msg_center_title()[0], "消息中心title错误");
 		acmcp.msg_center_param_input(csv_data.get(0).get(0), csv_data.get(0).get(1), csv_data.get(0).get(2));
 		int actual_message_unread_num=acmcp.message_number();
 		if(actual_message_unread_num>0){
 			acmcp.clickFirstCheckboxUnreadAndSetRead();
 			Assert.assertEquals(acmcp.getSetReadStatusText(),assertd.accountCenterMsgCenterGetSetReadStatusText()[0],"设置已读操作失败");
 			Assert.assertEquals(acmcp.getStatusListText(), assertd.accountCenterMsgCenterGetFirstReadStatus()[0],"消息没有设置为已读");
 			List<String> fullParentIdAnduserId=new ArrayList<String>();
 			List<String> accountCenterMsgFirstReadStatus=new ArrayList<String>();
 			fullParentIdAnduserId=conn.connectMySqlM(sqld.fullParentIdAnduserId()[0], sqld.fullParentIdAnduserId()[1]);
 			String fullParentId=fullParentIdAnduserId.get(0);
 			String userId=fullParentIdAnduserId.get(1);
 			accountCenterMsgFirstReadStatus=conn.connectMySqlM(sqld.accountCenterMsgReadStatus(fullParentId, userId)[0], sqld.accountCenterMsgReadStatus(fullParentId, userId)[1]);
 			Assert.assertTrue(accountCenterMsgFirstReadStatus.get(0).equals("1"), "数据库没有标记为已读");
 			
 		}else{
 			System.out.println("没有未读消息");
 		}
 		acmcp.clickSetreadedToAll();
 		if(actual_message_unread_num>0){
 			acmcp.waitWhileMegNumIsNotNull();
 			Assert.assertEquals(acmcp.getSetReadToAllStatusText(),assertd.accountCenterMsgCenterGetSetReadStatusText()[0],"全部标记已读失败");
 		}else{
 			acmcp.waitWhileMegNumIsNull();
 			Assert.assertEquals(acmcp.getStatusListTextWhileNumIsNull(),assertd.accountCenterMsgSetReadStatusTextWhileNumIsNull()[0],"全部标记已读失败");
 		}
     }

}
