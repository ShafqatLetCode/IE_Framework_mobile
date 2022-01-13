package com.crestech.pages.androidpage;

import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.annotation.values.ElementDescription;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.HandleException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

/**
 * @author Divya
 *
 */
public class ratingPage extends CommonAppiumTest{

	HandleException obj_handleexception = null;
	Asserts Assert = null;
	
	public ratingPage(AppiumDriver<RemoteWebElement> driver) throws Exception {
		super(driver);
		try {
			this.driver = driver;
			obj_handleexception = new HandleException(null, null);
			Assert = new Asserts();
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@ElementDescription(value = "Alert Message")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/tv_star')]")
	private MobileElement postLogoutAlertMessage;
	
	@ElementDescription(value = "Close Btn To Closing Tap To Star Page After Log out.")
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,':id/btn_close')]")
	private MobileElement CloseBtnToClosingTapToStarPage;
	
	@Step("Click On Close Button To Closing Tap To Star Page after logout.")
	public void ClickOnCloseBtnToClosingTapToStarPage() throws Exception {
		try {
			com.crestech.listeners.TestListener.saveScreenshotPNG(driver);
			clickOnElement(CloseBtnToClosingTapToStarPage);
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to Click On Close Button ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to Click On Close Button  ", e);
		}
	}
	
	@Step("verify 'Tap On The Stars To Rate' Message")
	public void verifyTapOnTheStarsToRate(String Ratingmsg) throws Exception {
		try {
			Asserts.assertEquals(getTexOfElement(postLogoutAlertMessage), Ratingmsg, 
					"'Tap on the stars to rate' Text is not matching.");
		} catch (HandleException e) {
			obj_handleexception.throwHandleException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Tap On The Stars To Rate' Message ", e);
		} catch (Exception e) {
			obj_handleexception.throwException("FUNCTIONAL_EXCEPTION", " Failed to verify 'Tap On The Stars To Rate' Message ", e);
		}
	}
}
