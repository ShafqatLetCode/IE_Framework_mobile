package com.crestech.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.base.UserBaseTest;
import com.crestech.pageobjects.pCloudyHomePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

public class PcloudyHomePage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(PcloudyHomePage.class.getName());
	public pCloudyHomePageObject homePageObject = new pCloudyHomePageObject();
	public UserBaseTest baseTest=new UserBaseTest();
	
	public PcloudyHomePage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), homePageObject);
	}

	/**
	 * This method is to click "Allow" Button
	 */
	public void clickOnAllowButton() {
// wait.waitForElementInSeconds(homePageObject.allowButton(), 20);
		if (homePageObject.allowButton().isDisplayed())
			clickOnElement(homePageObject.allowButton());
	}

	/**
	 * This method is to click "Flight button"
	 */
	public void clickOnflightButton() {
		wait.waitForElementInSeconds(homePageObject.getFlightButton(), 60);
		clickOnElement(homePageObject.getFlightButton());

	}

	/**
	 * Method return is Flight Button is displayed or not
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isFlightButtonDisplayed() throws InterruptedException {
		try {
			isElementVisible(homePageObject.getFlightButton());
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Method to tap on spinner from
	 * 
	 * @throws InterruptedException
	 */
	public void tapOnspinnerfrom() throws InterruptedException {
		clickOnElement(homePageObject.spinnerfrom());
	}

	/**
	 * method to click on Downlaod Button For select the city
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnselectCity() throws InterruptedException {

		clickOnElement(homePageObject.getSelectCity());
	}

	/******************************
	 * API DEMOS APPLICATION METHODS_STARTS
	 *********************************************************/

	/**
	 * This method is to click Views
	 */
	@Step("Clicked on Views Link")
	public void clickOnViews() {
		clickOnElement(homePageObject.Views());
		baseTest.addAttachment(driver);
		System.out.println("Screenshot added");
	}

	/**
	 * This method is to click on AutoComplete
	 */
	@Step("Clicked on Auto Complete Link")
	public void clickOnAutoComplete() {
		clickOnElement(homePageObject.AutoComplete());
		baseTest.addAttachment(driver);
	}

	/**
	 * This method is to click MultipleItems
	 */
	@Step("Clicked on Multiple Items Link")
	public void clickOnMultipleItems() {
		clickOnElement(homePageObject.MultipleItems());
	}

	/**
	 * This method is to click on textfield
	 */
	@Step("Clicked on Edit Field TextBox")
	public void clickOnEditBox() {
		clickOnElement(homePageObject.getSelectEditField());
	}

	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter data in Edit box")
	public void sendDataInEditBox(String text) {
		sendkeys(homePageObject.getSelectEditField(), text);
	}

	/**
	 * This method will click on Views
	 */
	@Step("Clicked on Text Link")
	public void clickOnText() {
		clickOnElement(homePageObject.Text());
	}

	/**
	 * This method is to click Views
	 */
	@Step("Clicked on Marquee Link")
	public void clickOnMarquee() {
		clickOnElement(homePageObject.getSelectMarquee());
	}

	/**
	 * This method is to click Views
	 */
	@Step("Get Text from Marquee Button")
	public String getTextFromMarqueeButton() {
		return getTexOfElement(homePageObject.getSelectMarqueeButton());
	}

	/**
	 * This method will click on Animation
	 */
	@Step("Animation Started")
	public void clickOnAnimation() {
		clickOnElement(homePageObject.Animation());
	}

	/**
	 * This method will click on Seeking
	 */
	@Step("Clicked on Seeking Link")
	public void clickOnSeeking() {
		clickOnElement(homePageObject.Seeking());
	}

	/**
	 * This method will click on Seeking
	 */
	@Step("Clicked on Seekbar")
	public WebElement getSeekbarWebElement() {
		return (homePageObject.getSelectSeekbar());
	}

	/**
	 * This method will perform task on seekbar
	 */
	@Step("Perform task on seekbar")
	public void performSeekBar() {
		WebElement element = getSeekbarWebElement();
		Point point = element.getLocation();
		Dimension eleSize = element.getSize();
		int startX = point.getX();
		int startY = point.getY() + (eleSize.getHeight() / 2);
		int moveToX = point.getX() + (eleSize.getWidth() * 50 / 100);
		int moveToY = point.getY() + (eleSize.getHeight() / 2);
		new AndroidTouchAction(driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(moveToX, moveToY)).release().perform();
	}

	/**
	 * This method will click on run button
	 */
	@Step("Click on Run Button")
	public void clickOnRunButton() {
		clickOnElement(homePageObject.RunButton());
	}

	/******************************
	 * API DEMOS APPLICATION METHODS_ENDS
	 *********************************************************/
	/**
	 * This method will navigate To HomePage From Edit Field in Multiple Items
	 */
	@Step("Navigate to Home Page from MI")
	public void navigateToHomePageFromMI() {
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	}

	/**
	 * This method will navigate To HomePage From Marquee Button
	 */
	@Step("Navigate to Home Page from Marquee")
	public void navigateToHomePageFromMarquee() {
		driver.navigate().back();
		driver.navigate().back();
	}

}
