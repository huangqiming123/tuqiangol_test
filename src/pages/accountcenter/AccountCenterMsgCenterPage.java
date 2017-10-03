package pages.accountcenter;

import org.openqa.selenium.WebDriver;

import automatedriver.AutomateDriver;
import pages.base.BasePage;

public class AccountCenterMsgCenterPage extends AutomateDriver {

	public AccountCenterMsgCenterPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	public void enter_msg_center() throws InterruptedException{
		super.clickElement("x,.//*[@id='usermessage']/a");
		Thread.sleep(15000);
		super.switchToFrame("usermessageFrame");
		super.explicitWait(".//*[@id='remainSearchDeviceInput']");
		}
	public int message_number() throws InterruptedException{
		BasePage basep=new BasePage(dr);
		return basep.page_number("msg_paging", "msg_tbody");
	}
	//输入参数
	public void msg_center_param_input(String imei,String message_type,String status) throws InterruptedException{
		System.out.println(imei);
		if(imei==null||imei.length()==0){
			super.operateInputElement("remainSearchDeviceInput", null);
		}else{
			super.operateInputElement("remainSearchDeviceInput", imei);
		}
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[2]/span[1]/div/span[3]");
		Thread.sleep(1000);
		if(message_type.equals("offline")){
			super.clickElement("x,html/body/div/div[2]/div[1]/form/div[2]/span[1]/div/div/ul/li[2]");
		}else if(message_type.equals("expire")){
			super.clickElement("x,html/body/div/div[2]/div[1]/form/div[2]/span[1]/div/div/ul/li[3]");
		}else if(message_type.equals("guide")){
			super.clickElement("x,html/body/div/div[2]/div[1]/form/div[2]/span[1]/div/div/ul/li[4]");
		}else if(message_type.equals("lowpower")){
			super.clickElement("x,html/body/div/div[2]/div[1]/form/div[2]/span[1]/div/div/ul/li[5]");
		}else{
			
		}
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[2]/span[2]/div/span[3]");
		Thread.sleep(1000);
		if(status.equals("unread")){
			super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[2]/span[2]/div/div/ul/li[2]");
		}else if(status.equals("readed")){
			super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[2]/span[2]/div/div/ul/li[3]");
		}else{
			
		}
		super.clickElement("x,html/body/div/div[2]/div[1]/form/div[2]/button");
		Thread.sleep(15000);
		super.explicitWait(".//*[@id='msg_paging']");
		super.clearOperateInputElement("remainSearchDeviceInput");
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[2]/span[1]/div/span[3]");
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[2]/span[1]/div/div/ul/li[1]");
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[2]/span[2]/div/span[3]");
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[2]/span[2]/div/div/ul/li[1]");
	}
	//得到消息中心未读数量
	public int unread_mess_number(){
		super.switchToDefaultContent();
		super.explicitWait(".//*[@id='unReadTotal']");
		String unread_mess_number= super.getText("unReadTotal");
		int number=Integer.parseInt(unread_mess_number);
		return number;
	}
	//得到消息中心title
	public String mess_center_title(){
		String title=super.getText("x,html/body/div/div[1]/div/b");
		return title;
	}
	//勾选未读设置为已读
	public void clickFirstCheckboxUnreadAndSetRead(){
		super.clickCheckbox("x,.//*[@id='msg_tbody']/tr[1]/td[1]/label/div/input");
		super.checkboxIsSelector("x,.//*[@id='msg_tbody']/tr[1]/td[1]/label/div/input");
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[1]/button[1]");
		super.explicitWait(".//*[@id='msg_paging']");
	}
	//得到设置为已读后的文本内容
	public String getSetReadStatusText(){
		String statusText=super.getText("x,.//*[@id='layui-layer1']/div");
		return statusText;
	}
	//得到第一行是否为已读状态
	public String getStatusListText(){
		String statusListText=super.getText("x,.//*[@id='msg_tbody']/tr[1]/td[2]");
		return statusListText;
	}
	//消息全部设置为已读
	public void clickSetreadedToAll(){
		super.clickElement("x,html/body/div[1]/div[2]/div[1]/form/div[1]/button[2]");
		
	}
	//有消息设置为已读等待
	public void waitWhileMegNumIsNotNull(){
		super.explicitWait(".//*[@id='layui-layer2']/div");
	}
	//得到全部设置为已读后的文本内容
	public String getSetReadToAllStatusText(){
		String statusText=super.getText("x,.//*[@id='layui-layer2']/div");
		return statusText;
		}
	//消息为空 全部设置为已读
	public String getStatusListTextWhileNumIsNull(){
		String satusListTextWhileNumIsNull=this.getText("x,.//*[@id='layui-layer1']/div");
		return satusListTextWhileNumIsNull;
	}
	public void waitWhileMegNumIsNull(){
		super.explicitWait(".//*[@id='layui-layer1']/div");
	}

}
