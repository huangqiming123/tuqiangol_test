package pages.loginPage;

import automatedriver.AutomateDriver;
import org.openqa.selenium.WebDriver;
import data.comdata.ComData;
public class LoginPage extends AutomateDriver{
	ComData comd=new ComData();
	public LoginPage(WebDriver dr){
		super(dr);
	}
	//打开登录页
	public void openLoginPage(){
		super.navigate(comd.baseUrl(), "/");
	}
}
