package testcases.AccountCenter;

import java.sql.SQLException;
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
import data.comdata.ComData;
import pages.accountcenter.AccountCenterFictitiousAccountManagerPage;
import pages.base.BasePage;
import model.ConnectMysql;

public class TestCase023FictiousAccountVerify {
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
     public void testFictiousAccountVerify() throws SQLException, InterruptedException{
    	 BasePage basep=new BasePage(dr);
    	 AccountCenterFictitiousAccountManagerPage acfam=new AccountCenterFictitiousAccountManagerPage(dr);
    	 AssertData assertd=new AssertData();
    	 ComData comd=new ComData();
    	 ConnectMysql conn=new ConnectMysql();
    	 SqlData sqld=new SqlData();
    	 basep.login();
    	 acfam.enterFictitiousAccountPage();
    	 Assert.assertEquals(acfam.getFicAccountTitle(), assertd.accountCenterFictitiousAccountTitle()[0], "进入虚拟账号页面失败");
    	 List<String> ficAccountData =new ArrayList<String>();
    	 ficAccountData=conn.connectMySqlM(sqld.accountCenterFictitiousAccountData(comd.base_user()[2])[0], sqld.accountCenterFictitiousAccountData(comd.base_user()[2])[1]);
    	 if(ficAccountData.size()==0){
    		 Assert.assertTrue(acfam.ficAccountIsNull(), "页面数量不为0");
    	 }else{
    		 Assert.assertEquals(acfam.getAllFicAccountNum(),ficAccountData.size(),"虚拟账号数量与实际不符");
    		 for(int i=0;i<acfam.getAllFicAccountNum();i++){
    		
    			 Assert.assertTrue(ficAccountData.contains(acfam.getAllFicAccount().get(i)), "虚拟账号数据错误");
    		 }
    	 }
    	 
     }

}
