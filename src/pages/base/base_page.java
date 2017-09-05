package pages.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automate_driver.automateDriver;
import data.com_data.comdata;

public class base_page extends automateDriver {
	//WebDriver dr1;
	comdata comd=new comdata();
	public base_page(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	public void login(){
		super.navigate_to_page(comd.base_url());
		super.explicit_wait(".//*[@id='logins']");
		super.operate_input_element("account", comd.base_user()[0]);
		super.operate_input_element("password", comd.base_user()[1]);
		super.click_element("x,//*[@id='checkbox']");
		super.click_element("logins");
		super.explicit_wait(".//*[@id='navMenu']");
	}
	public int third_last_pageNum(){
		String third_last_pageNum="return $('#msg_paging ul').find('li').eq(-3).find('span').text()";
		JavascriptExecutor js=(JavascriptExecutor)dr;
		Object rs=js.executeScript(third_last_pageNum);
		int i=Integer.parseInt(String.valueOf(rs));
		System.out.println("third_last_pageNum :"+i);
		return i;
	}
	public void click_last_page() throws InterruptedException{
		String third_last_page_click="return $('#msg_paging ul').find('li').eq(-3).find('a').click()";
		JavascriptExecutor js=(JavascriptExecutor)dr;
		js.executeScript(third_last_page_click);
	
	}
	public String five_last_page_status(){
		String five_last_page_status="return $('#msg_paging ul').find('li').eq(-5).attr('class)";
		JavascriptExecutor js=(JavascriptExecutor)dr;
		String rs=(String)js.executeScript(five_last_page_status);
		//String i=String.valueOf(rs);
		System.out.println("five_last_page_status :"+rs);
		return rs;
		
	}
	public int last_page_listNum(){
		String last_page_listNum="return $('#msg_tbody tr').length";
		JavascriptExecutor js=(JavascriptExecutor)dr;
		Long rs=(Long)js.executeScript(last_page_listNum);
		int i=Integer.parseInt(String.valueOf(rs));
		System.out.println("last_page_listNum:"+i);
		return i;
	}
	public int page_number(String selector_ul,String selector_tr) throws InterruptedException{
		if(super.is_element_exist("msg_nodata")){
			return 0;
		}else{
			if(this.third_last_pageNum1(selector_ul)<10){
				this.click_last_page1(selector_ul);
				super.explicit_wait(".//*[@id='"+selector_ul+"']/ul");
				int page_number=(this.third_last_pageNum1(selector_ul)-1)*10+this.last_page_listNum1(selector_tr);
				return page_number;
			}else{
				for(int j=0;j<10000;j++){
					if(!this.five_last_page_status().equals("disabled")){
						break;
						}else{
							this.click_last_page1(selector_ul);
							}
					
					super.explicit_wait(".//*[@id='"+selector_ul+"']/ul");
		}
				int page_number=(this.third_last_pageNum1(selector_ul)-1)*10+this.last_page_listNum1(selector_tr);
				return page_number;
			}
		}

	}
	public int third_last_pageNum1(String selector_ul){
		List<WebElement> third_last_page_li=new ArrayList<WebElement>();
		third_last_page_li=super.get_elements("x,.//*[@id='"+selector_ul+"']/ul/li");
		String third_last_page_text=third_last_page_li.get(third_last_page_li.size()-3).getText();
		int i=Integer.parseInt(third_last_page_text);
		return i;
	}
	public void click_last_page1(String selector_ul){
		List<WebElement> third_last_page_li=new ArrayList<WebElement>();
		third_last_page_li=super.get_elements("x,.//*[@id='"+selector_ul+"']/ul/li");
		third_last_page_li.get(third_last_page_li.size()-3).click();
	}
	public int last_page_listNum1(String selector_tr){
		List<WebElement> last_page_list_tr=new ArrayList<WebElement>();
		last_page_list_tr=super.get_elements("x,.//*[@id='"+selector_tr+"']/tr");
		int last_page_listNum=last_page_list_tr.size();
		return last_page_listNum;
		
	}

	

}
