package pages.accountcenter;

import org.openqa.selenium.WebDriver;

import automatedriver.AutomateDriver;

public class AccountCenterNaviBarPage extends AutomateDriver {

	public AccountCenterNaviBarPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	public String hello_user_account(){
		String hello_user=super.getElement("c,user-name").getText();
		return hello_user;
	}
	
    public String usr_info_name(){
        String usr_name = super.getElement("userName").getText();
        return usr_name;
    }

    public String usr_info_account(){
        String usr_account = super.getElement("userAccount").getText();
        return usr_account;
    }

    public String usr_info_type(){
        String usr_type = super.getElement("userType").getText();
        return usr_type;
    }

    public String usr_info_phone(){
        String usr_phone = super.getElement("userPhone").getText();
        return usr_phone;
    }
    
    public String sales_usr_service_provider(){
        String service_provider_all = super.getElement(
            "x,/html/body/div[1]/div[5]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/ul/li[1]").getText();
        String service_provider=service_provider_all.split("??")[1];
        return service_provider;
    }

    public String sales_usr_service_provider_connect(){
        String service_provider_connect_all = super.getElement(
            "x,/html/body/div[1]/div[5]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/ul/li[2]").getText();
        String service_provider_connect=service_provider_connect_all.split("??")[1];
        return service_provider_connect;
    }

    public String sales_usr_service_provider_phone(){
        String service_provider_phone_all = super.getElement(
            "x,/html/body/div[1]/div[5]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/ul/li[3]").getText();
        String service_provider_phone=service_provider_phone_all.split("??")[1];
        return service_provider_phone;
    }

    public String ordinary_usr_service_provider(){
        String service_provider = super.getElement(
            "x,/html/body/div[1]/div[4]/div/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[1]").getText();
        return service_provider;
    }

    public String ordinary_usr_service_provider_connect(){
        String service_provider_connect = super.getElement(
            "x,/html/body/div[1]/div[4]/div/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[2]").getText();
        return service_provider_connect;
    }

    public String ordinary_usr_service_provider_phone(){
        String service_provider_phone = super.getElement(
            "x,/html/body/div[1]/div[4]/div/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[3]").getText();
        return service_provider_phone;
    }
    public void usr_logout() throws InterruptedException{
    	super.floatElement("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    	super.clickElement("p,?????");
    	Thread.sleep(1000);
    	String logout_text=super.getText("c,layui-layer-content");
    	System.out.println(logout_text);
    	super.clickElement("c,layui-layer-btn0");
    	Thread.sleep(1000);
    	
    }
    
    public void usr_logout_dismiss() throws InterruptedException{
    	super.floatElement("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    	super.clickElement("p,???");
    	Thread.sleep(1000);
    	super.clickElement("c,layui-layer-btn1");
    }
    public String per_data_account(){
    	return super.getText("edit-modal-account");
    }
    public String per_data_username(){
    	return super.getText("edit-modal-nickName");
    }
    public String per_data_phone(){
    	return super.getText("edit-modal-phone");
    }
    public String per_data_email(){
    	return super.getText("edit-modal-email");
    }
    public void float_to_setting() throws InterruptedException{
    	super.floatElement("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    }
    public void click_mondify_info(){
    	super.clickElement("p,???????");
    }
    public void click_mondify_password(){
    	super.clickElement("p,???????");
    }
    public String modify_usr_info(String user_name,String phone,String email) throws InterruptedException{
    	super.floatElement("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    	super.clickElement("p,??????");
    	Thread.sleep(1000);
    	super.operateInputElement("edit-modal-nickName", user_name);
    	Thread.sleep(1000);
    	super.operateInputElement("edit-modal-phone", phone);
    	Thread.sleep(1000);
    	super.operateInputElement("edit-modal-email", email);
    	Thread.sleep(1000);
    	super.clickElement("c,layui-layer-btn0");
    	Thread.sleep(2000);
    	String save_status=super.getText("c,layui-layer-content");
    	return save_status;
    }
    
    public void mondify_user_passwd(String oldPwd,String newPwd,String renewPwd) throws InterruptedException{
    	super.floatElement("x,/html/body/div[1]/header/div/div[2]/div[2]/div[2]/span/a");
    	Thread.sleep(2000);
    	super.clickElement("p,???????");
    	super.operateInputElement("oldPwd", oldPwd);
    	super.operateInputElement("newPwd", newPwd);
    	super.operateInputElement("renewPwd", renewPwd);
    	
    }
    
    public String get_title_mondify_user_passwd(){
    	return super.getText("x,.//*[@id='layui-layer1']/div[1]");
    }
    public boolean close_mondify_user_passwd(){
    	super.clickElement("c,layui-layer-ico.layui-layer-close.layui-layer-close1");
    	return super.isElementExist("x,.//*[@id='layui-layer1']/div[1]");
    }
    public boolean cancle_mondify_user_passwd(){
    	super.clickElement("c,layui-layer-btn1");
    	return super.isElementExist("x,.//*[@id='layui-layer1']/div[1]");
    }
    public void click_confim_mondify_user_passwd(){
    	super.clickElement("c,layui-layer-btn0");
    }
    public String mondify_user_passwd_content(){
    	return super.getText("c,layui-layer-content");
    }
    public void click_mondify_user_passwded(){
    	super.clickElement("x,.//*[@id='layui-layer10']/div[3]/a");
    }

}
