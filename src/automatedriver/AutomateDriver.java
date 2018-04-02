package automatedriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateDriver {
	public WebDriver dr;

	public AutomateDriver(WebDriver dr) {
		this.dr = dr;
	}
	
	public String getCurrentUrl() {
		return dr.getCurrentUrl();
	}

	public void navigate(String base_url, String url) {
		dr.get(base_url + url);
	}

	public void navigateToPage(String url) {
		dr.get(url);
	}
	//clear cookie
	public void clearCookies() {
		dr.manage().deleteAllCookies();
	}
	//clear inputBox
	public void clearElementInfo(String selector){
		this.getElement(selector).clear();
	}
	
	public void operateInputElement(String selector, String value) {
		this.getElement(selector).clear();
		this.getElement(selector).sendKeys(value);
	}

	public void clearOperateInputElement(String selector) {
		this.getElement(selector).clear();
	}

	public WebElement getElement(String selector) {
		if (selector.equals(null)) {
			WebElement element = null;
			return element;
		} else {
			if (!selector.contains(",")) {
				WebElement element = dr.findElement(By.id(selector));
				return element;
			} else {
				String selectBy = selector.split(",")[0];
				String selectValue = selector.split(",")[1];
				if (selectBy.equals("s")) {
					WebElement element = dr.findElement(By.cssSelector(selectValue));
					return element;
				} else if (selectBy.equals("x")) {
					WebElement element = dr.findElement(By.xpath(selectValue));
					return element;
				} else if (selectBy.equals("l")) {
					WebElement element = dr.findElement(By.linkText(selectValue));
					return element;
				} else if (selectBy.equals("c")) {
					WebElement element = dr.findElement(By.className(selectValue));
					return element;
				} else if (selectBy.equals("p")) {
					WebElement element = dr.findElement(By.partialLinkText(selectValue));
					return element;
				}
			}
		}
		return null;

	}

	public List<WebElement> getElements(String selector) {
		List<WebElement> elements = new ArrayList<WebElement>();
		if (selector.equals(null)) {
			// WebElement elements=null;
			return null;
		} else {
			if (!selector.contains(",")) {
				elements = dr.findElements(By.id(selector));
				return elements;
			} else {
				String selectBy = selector.split(",")[0];
				String selectValue = selector.split(",")[1];
				if (selectBy.equals("s")) {
					elements = dr.findElements(By.cssSelector(selectValue));
					return elements;
				} else if (selectBy.equals("x")) {
					elements = dr.findElements(By.xpath(selectValue));
					return elements;
				} else if (selectBy.equals("l")) {
					elements = dr.findElements(By.linkText(selectValue));
					return elements;
				} else if (selectBy.equals("c")) {
					elements = dr.findElements(By.className(selectValue));
					return elements;
				} else if (selectBy.equals("p")) {
					elements = dr.findElements(By.partialLinkText(selectValue));
					return elements;
				}
			}
		}
		return null;

	}

	public void clickElement(String selector) {
		WebElement element = this.getElement(selector);
		element.click();
	}

	public String getText(String selector) {
		WebElement element = this.getElement(selector);
		String text = element.getText();
		return text;
	}

	// 浮动元素方法
	public void floatElement(String selector) {
		Actions ac = new Actions(dr);
		ac.moveToElement(this.getElement(selector)).perform();

	}

	public String getCurrentWindowHandle() {
		String handle = dr.getWindowHandle();
		return handle;
	}

	public Set<String> getAllWindowHandles() {
		Set<String> handles = new HashSet<String>();
		handles = dr.getWindowHandles();
		return handles;
	}

	public void switchToWindow(String handle) {
		dr.switchTo().window(handle);
	}

	public boolean isElementExist(String selector) {
		if (this.getElement(selector).isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public void switchToFrame(String selector) {
		dr.switchTo().frame(selector);
	}

	public void switchToDefaultContent() {
		dr.switchTo().defaultContent();
	}

	public void explicitWait(String selector) {
		WebDriverWait wait = (new WebDriverWait(dr, 10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
	}

	public Set<Cookie> getCookies() {
		Set<Cookie> cookies = dr.manage().getCookies();
		return cookies;
	}

	public Cookie addCookie(Cookie cookie) {
		dr.manage().addCookie(cookie);
		return cookie;
	}

	public void close() {
		dr.close();
	}

	public void selectGetElement(String selector, String value) {
		Select sel = new Select(this.getElement(selector));
		sel.selectByValue(value);
		;
	}

	public void dissSelectGetElement(String selector, String value) {
		Select sel = new Select(this.getElement(selector));
		sel.deselectByValue(value);

	}

	public void clickCheckbox(String selector) {
		this.getElement(selector).sendKeys(Keys.SPACE);
	}

	public boolean checkboxIsSelector(String selector) {
		if(this.getElement(selector).isSelected()){
			return true;
		}else{
			return false;
		}
	}

}
