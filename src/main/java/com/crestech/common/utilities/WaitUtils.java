package com.crestech.common.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crestech.appium.utils.CommandPrompt;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WaitUtils extends CommandPrompt {
	
	public AppiumDriver<RemoteWebElement> driver;

	public WaitUtils(AppiumDriver<RemoteWebElement> driver2) {
		this.driver = driver2;
	}
	
	/**
	 * This method will Wait For Page Load
	 */
	public void waitForPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("return document.readyState").toString().equals("complete");
	}

	/**
	 * This method will wait for element to be InVisible
	 *
	 * @param element
	 */
	public void waitForElementInvisibility(MobileElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * This method will wait element visibility in seconds
	 *
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementInSeconds(MobileElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait until element to be clickable
	 *
	 * @param element
	 */
	public void waitForElementToBeClickable(MobileElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait for page load Timeout
	 *
	 * @param Seconds
	 */
	public void waitForPageLoadTimeout(int Seconds) {
		driver.manage().timeouts().pageLoadTimeout(Seconds, TimeUnit.SECONDS);
	}

	/**
	 * This method will wait for element to be InVisible with particular time
	 *
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForVisibilityOfElementLocated(MobileElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * This method will wait for page load with time
	 * 
	 * @param timeInSeconds
	 */
	public void waitForPageLoadedWithTime(int timeInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	/**
	 * This method will explicitly wait until visibility
	 * 
	 * @param mobileElement
	 * @param timeLimitInSeconds
	 * @param targetResourceId
	 * @return
	 */
	public boolean waitForPresence(MobileElement mobileElement, int timeLimitInSeconds, String targetResourceId) {
		boolean isElementPresent;
		try {
			mobileElement = (MobileElement) driver
					.findElementByCustom("new UiSelector().resourceId(\"" + targetResourceId + "\")");
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			isElementPresent = mobileElement.isDisplayed();
			return isElementPresent;
		} catch (Exception e) {
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}
	}

	/**
	 * Wait for Element
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementInMinutes(MobileElement element, long timeOutInMinutes) {
		long seconds = TimeUnit.MINUTES.toSeconds(timeOutInMinutes);
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
