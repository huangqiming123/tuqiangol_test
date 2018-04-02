package pages.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automatedriver.AutomateDriver;
import data.comdata.ComData;

public class BasePage extends AutomateDriver {
	//WebDriver dr1;
	ComData comd=new ComData();
	public BasePage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	//登录
	public void login(){
		super.navigateToPage(comd.baseUrl());
		super.explicitWait(".//*[@id='logins']");
		super.operateInputElement("account", comd.baseUser()[2]);
		super.operateInputElement("password", comd.baseUser()[3]);
		super.clickElement("x,//*[@id='checkbox']");
		super.clickElement("logins");
		super.explicitWait(".//*[@id='navMenu']");
	}
	
	/*
	 得到倒数第三个li标签的页码数 
	 */
	public int thirdLastPageNum(){
		String ThirdLastPageNum="return $('#msg_paging ul').find('li').eq(-3).find('span').text()";
		JavascriptExecutor js=(JavascriptExecutor)dr;
		Object rs=js.executeScript(ThirdLastPageNum);
		int i=Integer.parseInt(String.valueOf(rs));
		System.out.println("ThirdLastPageNum :"+i);
		return i;
	}
	/**
	 * 点击现有的最后一页
	 * @throws InterruptedException
	 */
	public void clickLastPage() throws InterruptedException{
		String ThirdLastPageClick="return $('#msg_paging ul').find('li').eq(-3).find('a').click()";
		JavascriptExecutor js=(JavascriptExecutor)dr;
		js.executeScript(ThirdLastPageClick);
	
	}
	/**
	 * 获取倒数第五个li标签的class属性
	 * @return
	 */
	public String fiveLastPageStatus(){
		String FiveLastPageStatus="return $('#msg_paging ul').find('li').eq(-5).attr('class)";
		JavascriptExecutor js=(JavascriptExecutor)dr;
		String rs=(String)js.executeScript(FiveLastPageStatus);
		//String i=String.valueOf(rs);
		System.out.println("FiveLastPageStatus :"+rs);
		return rs;
		
	}
	/**
	 * 获取最后一页tr数量
	 * @return
	 */
	public int lastPageListNum(){
		String LastPageListNum="return $('#msg_tbody tr').length";
		JavascriptExecutor js=(JavascriptExecutor)dr;
		Long rs=(Long)js.executeScript(LastPageListNum);
		int i=Integer.parseInt(String.valueOf(rs));
		System.out.println("LastPageListNum:"+i);
		return i;
	}
	//计算总条数
	public int pageNumber(String selector_ul,String selector_tr) throws InterruptedException{
		if(super.isElementExist("msg_nodata")){
			return 0;
		}else{
			if(this.thirdLastPageNum1(selector_ul)<10){
				this.clickLastPage1(selector_ul);
				super.explicitWait(".//*[@id='"+selector_ul+"']/ul");
				int pageNumber=(this.thirdLastPageNum1(selector_ul)-1)*10+this.lastPageListNum1(selector_tr);
				return pageNumber;
			}else{
				for(int j=0;j<10000;j++){
					if(!this.fiveLastPageStatus().equals("disabled")){
						break;
						}else{
							this.clickLastPage1(selector_ul);
							}
					
					super.explicitWait(".//*[@id='"+selector_ul+"']/ul");
		}
				int pageNumber=(this.thirdLastPageNum1(selector_ul)-1)*10+this.lastPageListNum1(selector_tr);
				return pageNumber;
			}
		}

	}
	/**
	 * 获取倒数第三个li数据（页面数量）
	 * @param selector_ul
	 * @return
	 */
	public int thirdLastPageNum1(String selector_ul){
		List<WebElement> ThirdLastPageLi=new ArrayList<WebElement>();
		ThirdLastPageLi=super.getElements("x,.//*[@id='"+selector_ul+"']/ul/li");
		String ThirdLastPageText=ThirdLastPageLi.get(ThirdLastPageLi.size()-3).getText();
		int i=Integer.parseInt(ThirdLastPageText);
		return i;
	}
	/**
	 * 点击最后一页
	 * @param selector_ul
	 */
	public void clickLastPage1(String selector_ul){
		List<WebElement> ThirdLastPageLi=new ArrayList<WebElement>();
		ThirdLastPageLi=super.getElements("x,.//*[@id='"+selector_ul+"']/ul/li");
		ThirdLastPageLi.get(ThirdLastPageLi.size()-3).click();
	}
	/**
	 * 获取最后一页列表的数量
	 * @param selector_tr
	 * @return
	 */
	public int lastPageListNum1(String selector_tr){
		List<WebElement> LastPageListTr=new ArrayList<WebElement>();
		LastPageListTr=super.getElements("x,.//*[@id='"+selector_tr+"']/tr");
		int LastPageListNum=LastPageListTr.size();
		return LastPageListNum;
		
	}

	

}
