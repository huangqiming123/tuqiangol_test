package pages.accountcenter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automatedriver.AutomateDriver;

public class AccountCenterFictitiousAccountManagerPage extends AutomateDriver {

	public AccountCenterFictitiousAccountManagerPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	//进入虚拟账号页
	public void enterFictitiousAccountPage() throws InterruptedException{
		super.clickElement("x,.//*[@id='fictitiousaccount']/a");
		Thread.sleep(2000);
		super.switchToFrame("fictitiousaccountFrame");
		super.explicitWait(".//*[@id='virtualTableContent']");
	}
	//得到所有的虚拟账号数量
	public int getAllFicAccountNum(){
		List<WebElement> getAllFicAccountTr =new ArrayList<WebElement>();
		getAllFicAccountTr=super.getElements("x,.//*[@id='fictitiousAccount_tbody']/tr");
		return getAllFicAccountTr.size();
	}
	//得到所有的虚拟账号
	public List<String> getAllFicAccount(){
		List<String> getText =new ArrayList<String>();
		for(int i=1;i<=this.getAllFicAccountNum();i++){
			String el=super.getText("x,.//*[@id='fictitiousAccount_tbody']/tr["+i+"]/td[2]");
			getText.add(el);
		}
		return getText;
	}
	//得到虚拟账号页面title
	public String getFicAccountTitle(){
		String title=super.getText("x,html/body/div/div[1]/div/b");
		return title;
	}
	//判断有没有虚拟账号
	public boolean ficAccountIsNull(){
		
		if(super.isElementExist("fictitiousAccount_nodata")){
			return true;
		}else{
			return false;
		}
	}
	//点击虚拟账号添加按钮
	public void clickAddFicAccountBtn(){
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div/button");
		super.switchToDefaultContent();
		super.explicitWait(".//*[@id='layui-layer1']/div[1]");
	}
	
	public void thirdClickAddAccountBtn(){
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div/button");
		super.switchToDefaultContent();
		super.explicitWait(".//*[@id='layui-layer3']/div[1]");
	
	}
	//得到添加虚拟账号页title
	public String getAddFicAccountLayuiTitle(){
		String title=super.getText("x,.//*[@id='layui-layer1']/div[1]");
		return title;
	}
	//点击取消添加虚拟账号
	public void clickCancelAddFicAccount() throws InterruptedException{
		super.clickElement("x,.//*[@id='layui-layer1']/span[1]/a");
		Thread.sleep(2000);
		super.switchToFrame("fictitiousaccountFrame");
		super.explicitWait("html/body/div/div[1]/div/b");
	}
	//点击取消添加虚拟账号按钮
	public void clickCancelAddFicAccountBtn() throws InterruptedException{
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div/button");
		Thread.sleep(2000);
		super.switchToDefaultContent();
		super.explicitWait(".//*[@id='layui-layer2']/div[1]");
		super.clickElement("x,.//*[@id='layui-layer2']/div[3]/a[2]");
		Thread.sleep(2000);
		super.switchToFrame("fictitiousaccountFrame");
		super.explicitWait("html/body/div[1]/div[1]/div/b");
	}
	//判断虚拟账号是否存在
	public boolean ficAccountManagerIsExist(){
		if(super.isElementExist("x,html/body/div/div[1]/div/b")){
			return true;
		}else{
			return false;
		}
	}
	//添加虚拟账号功能
	public void addFicAccount(String FicAccount,String FicAccountPassword,String ReFicAccountPassword,String EditData,String SendIns){
		super.operateInputElement("x,.//*[@id='fictitiousAccountForm']/div[1]/div/input", FicAccount);
		super.operateInputElement("fictitious_password", FicAccountPassword);
		super.operateInputElement("password", ReFicAccountPassword);
		if(EditData.equals("enableEditData")){
			super.clickCheckbox("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[1]/label/div/input");
		}else{
			
		}
		if(SendIns.equals("enableSendIns")){
			super.clickCheckbox("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[2]/label/div/input");
		}else{
			
		}
		super.clickElement("x,.//*[@id='layui-layer3']/div[3]/a[1]");
		}
	public void addFicAccountSuccess(String FicAccount,String FicAccountPassword,String ReFicAccountPassword,String EditData,String SendIns){
		this.addFicAccount(FicAccount, FicAccountPassword, ReFicAccountPassword, EditData, SendIns);
	}
	//清除添加框信息
	public void clearFicAccountInfo(){
		super.clearElementInfo("x,.//*[@id='fictitiousAccountForm']/div[1]/div/input");
		super.clearElementInfo("fictitious_password");
		super.clearElementInfo("password");
	}
	//得到添加虚拟账号提示账号信息
	public String getFicAccountAccountTip(){
		String tip=super.getText("x,.//*[@id='fictitiousAccountForm']/div[1]/div/label");
		return tip;
	}
	//得到添加虚拟账号提示密码信息
	public String getFicAccountPasswordTip(){
		String tip=super.getText("x,.//*[@id='fictitiousAccountForm']/div[2]/div/label");
		return tip;
	}
	//得到添加虚拟账号提示再次输入密码信息
	public String getFicAccountRePasswordTip(){
		String tip=super.getText("x,.//*[@id='fictitiousAccountForm']/div[3]/div/label");
		return tip;
	}
	//得到添加虚拟账号成功信息
	public String getAddFicAccountSuccessLayui(){
		super.switchToFrame("fictitiousaccountFrame");
		String AddFicAccountSuccessLayui=super.getText("x,.//*[@id='layui-layer4']/div");
		return AddFicAccountSuccessLayui;
	}
	//得到账号编辑按钮元素
	public WebElement getFicAccountElementEditBtn(String FicAccount){
		List<String> AllFicAccount =new ArrayList<String>();
		AllFicAccount=this.getAllFicAccount();
		for(int i=0;i<AllFicAccount.size();i++){
			if(AllFicAccount.get(i).equals(FicAccount)){
				return super.getElement("x,.//*[@id='fictitiousAccount_tbody']/tr["+i+"]/td[4]/a[1]");
			}
		}
		return null;
	}
	//点击虚拟账号编辑按钮
	public void clickEditBtn(String FicAccount){
		this.getFicAccountElementEditBtn(FicAccount);
		super.switchToDefaultContent();
		super.explicitWait(".//*[@id='fictitiousAccountForm']");
	}
	//得到虚拟账号id
	public String getFicAccountId(){
		JavascriptExecutor js=(JavascriptExecutor)dr;
		js.executeScript("$('#fictitiousAccountForm').find('input').prop('type','yy');");
		Object o=js.executeScript("return $('#fictitiousAccountForm').find('input').attr('value');");
		return String.valueOf(o);
	}
	public String getFicAccountId1(){
		JavascriptExecutor js=(JavascriptExecutor)dr;
		js.executeScript("return $('#fictitiousAccountForm').find('input').prop('type','yy');");
		String getId=super.getElement("x,.//*[@id='fictitiousAccountForm']/input").getAttribute("value");
		return getId;
	}
	//得到虚拟账号修改数据勾选框是否勾选
	public boolean getEditFicAccountEditDateSelectStatus(){
		if(super.checkboxIsSelector("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[1]/label/div/input")==true){
			return true;
		}else{
			return false;
		}
	}
	//得到虚拟账号下发指令框是否勾选
	public boolean getEditFicAccountSendInsSelectStatus(){
		if(super.checkboxIsSelector("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[2]/label/div/input")==true){
			return true;
		}else{
			return false;
		}
	}
	public void switchToFicFrame(){
		super.switchToFrame("fictitiousaccountFrame");
		super.explicitWait("html/body/div/div[1]/div/b");
	}
	//得到当前虚拟账号
	public String getFicAccountAccount(){
		String getFicAccountAccount=super.getText("x,.//*[@id='fictitiousAccount_tbody']/tr[1]/td[2]");
		return getFicAccountAccount;
	}
	//点击编辑虚拟账号
	public void clickEditFicAccountBtn(){
		
		super.clickElement("x,.//*[@id='fictitiousAccount_tbody']/tr[1]/td[4]/a[1]");
		super.switchToDefaultContent();
		//super.explicitWait(".//*[@id='layui-layer1']");
	}
	//编辑虚拟账号
	public void editFicAccount(String FicAccountPassword,String ReFicAccountPassword,String EditData,String SendIns){
		
		super.operateInputElement("fictitious_password", FicAccountPassword);
		super.operateInputElement("password", ReFicAccountPassword);
		if(EditData.equals("enableEditData")){
			if(super.checkboxIsSelector("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[1]/label/div/input")==true){
				
			}else{
				super.clickCheckbox("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[1]/label/div/input");
			}
		}else{
			if(super.checkboxIsSelector("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[1]/label/div/input")==true){
				super.clickCheckbox("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[1]/label/div/input");
				}else{
					
				}
			
		}
		if(SendIns.equals("enableSendIns")){
			if(super.checkboxIsSelector("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[2]/label/div/input")==true){
				
			}else{
				super.clickCheckbox("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[2]/label/div/input");
			}
		}else{
			if(super.checkboxIsSelector("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[2]/label/div/input")==true){
				super.clickCheckbox("x,.//*[@id='fictitiousAccountForm']/div[4]/div/ul/li[2]/label/div/input");
				}else{
					
			}
			
		}
		super.clickElement("x,.//*[@id='layui-layer1']/div[3]/a[1]");
		}
	//得到编辑虚拟账号成功layui
	public String getEditFicAccountOperateSuccTitle(){
		super.explicitWait(".//*[@id='layui-layer2']");
		return super.getText("x,.//*[@id='layui-layer2']/div");
		
	}
	//切换到虚拟账号页面frame
	public void switchToFicAccountPage(){
		super.switchToFrame("fictitiousaccountFrame");
	}
	public void clickFicAccountDelBtn(){
		super.clickElement("x,.//*[@id='fictitiousAccount_tbody']/tr[1]/td[2]");
		super.explicitWait(".//*[@id='layui-layer1']");
	}
	
	public void canlceDelFicAccount(){
		super.clickElement("x,.//*[@id='layui-layer1']/span[1]/a");
		super.explicitWait("html/body/div[1]/div[1]/div/b");
	}
	public void canlceDelFicAccountBtn(){
		super.clickElement("x,.//*[@id='layui-layer2']/div[3]/a[2]");
		super.explicitWait("html/body/div[1]/div[1]/div/b");
	}
	public void clickDelFicAccountBtn(){
		super.clickElement("x,.//*[@id='layui-layer3']/div[3]/a[1]");
		super.explicitWait("html/body/div[1]/div[1]/div/b");
	}
	
}



