package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithIndex(WebElement element, int value) {
		Select object = new Select(element);
		object.selectByIndex(value);
		
	}
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}
	public void selectDropdownWithText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}
}


