package pages.account_center;

import org.openqa.selenium.WebDriver;

import automate_driver.automateDriver;

public class account_center_msg_center_page extends automateDriver {

	public account_center_msg_center_page(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	public void enter_msg_center() throws InterruptedException{
		super.click_element("x,.//*[@id='usermessage']/a");
		Thread.sleep(10000);
		super.switch_to_frame("usermessageFrame");
		super.explicit_wait(".//*[@id='remainSearchDeviceInput']");
		}

}
