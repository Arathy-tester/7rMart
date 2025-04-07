package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public int EXPLICIWAITDuration = 15;
	public int IMPLICITWAITDuration = 15;
	public int FluentWAITDuration = 15;

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAITDuration)); //duration is a predefined class

	}

	public void waitUntilElementtobeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIWAITDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementtobeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIWAITDuration));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void waitUntilElementtobeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIWAITDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilAlertisPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIWAITDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void fluentWaitElements(WebDriver driver,WebElement element, String attribute, String attributeValue,
				int total) 
		{
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
					.pollingEvery(Duration.ofSeconds(FluentWAITDuration)).ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
		}

	}


