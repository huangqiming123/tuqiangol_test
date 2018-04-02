package testcases.AccountCenter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import model.CsvReader;
import pages.accountcenterPage.AccountCenterFictitiousAccountManagerPage;
import pages.base.BasePage;
import model.ConnectMysql;
import data.comdata.assertDate.ComAssertData;
import data.comdata.sqlDate.SqlData;

public class TestCase025AddFictiousAccount {
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
     public void testAddFictiousAccount() throws Exception{
    	 BasePage basep=new BasePage(dr);
    		
    	 AccountCenterFictitiousAccountManagerPage acfam=new AccountCenterFictitiousAccountManagerPage(dr);
    	 ComAssertData assertd=new ComAssertData();
    	 SqlData sqld=new SqlData();
    	 CsvReader csvr=new CsvReader("D:\\workplace\\tuqiangol_test\\src\\data\\accountcenter\\addFicAccountData.csv");
    	 List<List<String>> CsvData=csvr.readCSVFile();
    	 ConnectMysql conn=new ConnectMysql();
    	 List<String> getEditFicAccountAcc=new ArrayList<String>();
    	 basep.login();
    	 acfam.enterFictitiousAccountPage();
    	 acfam.clickAddFicAccountBtn();
    	 acfam.clickCancelAddFicAccount();
    	 Assert.assertTrue(acfam.ficAccountManagerIsExist(), "点击取消添加虚拟账号失败");
    	 acfam.clickCancelAddFicAccountBtn();
    	 Assert.assertTrue(acfam.ficAccountManagerIsExist(), "点击取消按钮添加虚拟账号失败");
    	 acfam.thirdClickAddAccountBtn();
    	 for(int i=0;i<CsvData.size();i++){
    		 acfam.addFicAccount(CsvData.get(i).get(0), CsvData.get(i).get(1), CsvData.get(i).get(2), CsvData.get(i).get(3), CsvData.get(i).get(4));
    		 if(CsvData.get(i).get(0).contains("#")){
    			 Assert.assertEquals(acfam.getFicAccountAccountTip(), assertd.accountCenterFictitiousAccountTip()[0],"错误虚拟账号账号断言失败");
    		 }else if(CsvData.get(i).get(1).equals("888888")){
    			 Assert.assertEquals(acfam.getFicAccountPasswordTip(), assertd.accountCenterFictitiousPaawordTip()[0],"错误虚拟账号密码断言失败");
    		 }else if(CsvData.get(i).get(1).equals("jimi1234")){
    			 Assert.assertEquals(acfam.getFicAccountRePasswordTip(), assertd.accountCenterFictitiousRePaawordTip()[0],"错误虚拟账号验证密码断言失败");
    		 }else{
    			 //Assert.assertEquals(acfam.getAddFicAccountSuccessLayui(), assertd.accountCenterMsgCenterGetSetReadStatusText()[0],"添加虚拟账号失败");
    			 for(String account:acfam.getAllFicAccount()){
    				 if(account.equals("910hm")){
    					 break;
    				 }else{
    					 Assert.fail("添加虚拟账号没找到");
    				 }
    			 }
    		 }
    		 
    	 }
    	 acfam.switchToFicFrame();
    	 acfam.clickEditBtn("910hm");
    	 String id=acfam.getFicAccountId1();
    	 System.out.println(id);
    	 getEditFicAccountAcc=conn.connectMySqlM(sqld.accountCenterFicAccountGetAccount(acfam.getFicAccountId1())[0], sqld.accountCenterFicAccountGetAccount(acfam.getFicAccountId1())[1]);
    	 Assert.assertEquals(getEditFicAccountAcc.get(0), "910hm", "虚拟账号登陆名称错误");
    	 Assert.assertTrue(acfam.getEditFicAccountEditDateSelectStatus(), "修改数据勾选状态错误");
    	 Assert.assertTrue(acfam.getEditFicAccountSendInsSelectStatus(),"下发指令勾选状态错误");
		 }
}

     


