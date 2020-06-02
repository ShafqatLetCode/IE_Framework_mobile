package com.crestech.common.utilities;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class GestureUtils {

	public AppiumDriver<RemoteWebElement> driver;

	public GestureUtils(AppiumDriver<RemoteWebElement> driver2) {
		this.driver = driver2;
	}

	/**
	 * 
	 * @param srcElement
	 * @param destElement
	 * @throws InterruptedException
	 */
	public void horizontalSwipeToElement(MobileElement srcElement, MobileElement destElement)
			throws InterruptedException {

		try {
			MobileElement firstElement = srcElement;
			MobileElement secondElement = destElement;

			Point source = firstElement.getLocation();
			int width = secondElement.getLocation().x;
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence dragNDrop = new Sequence(finger, 1);
			dragNDrop.addAction(
					finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), source.x, source.y));
			dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
			dragNDrop.addAction(new Pause(finger, Duration.ofMillis(600)));
			dragNDrop.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), width, source.y));
			dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
			driver.perform(Arrays.asList(dragNDrop));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author sneha aggarwal
	 * @implNote swipe up
	 */
	public void swipeFromUpToBottom() {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "up");
			js.executeScript("mobile: scroll", scrollObject);
			System.out.println("Swipe up was Successfully done.");
		} catch (Exception e) {
			System.out.println("swipe up was not successfull");
		}
	}
	
	
	/**
	 * 
	 * @author sneha aggarwal
	 * @implNote swipe down
	 */
	public void swipeFromBottomToUp() 
    {       
      try  {
              JavascriptExecutor js = (JavascriptExecutor) driver;
              HashMap<String, String> scrollObject = new HashMap<String,String>();
              scrollObject.put("direction", "down");
              js.executeScript("mobile: scroll", scrollObject);
              System.out.println("Swipe down was Successfully done");
        }
           catch (Exception e) 
            {
                System.out.println("swipe down was not successfull");
            }   
    }
	
	/**
	 * 
	 * @author sneha aggarwal
	 * @implNote carousel images swipe
	 */
	public void swipeImages(WebElement ele) 
    {       
      try   {
                  String pageString= ele.getAttribute("value");
                  int length = pageString.length();
                  String count_string= pageString.substring(length-2, length).trim();
                  int count = Integer.parseInt(count_string);
                  System.out.println("Number of Image available to Swipe: "+count);
                  for (int i=0; i<=count; i++){          
                          JavascriptExecutor js = (JavascriptExecutor) driver;
                          HashMap<String, String> scrollObject = new HashMap<String, String>();
                          scrollObject.put("direction", "right");
                          js.executeScript("mobile: scroll", scrollObject);       
           }
           System.out.println("Swipe Successfully");
        }
           catch (Exception e) 
            {
                System.out.println("Image swipe was not successfull");
            }   
    }
	
	/**
	 * 
	 * @author sneha aggarwal
	 * @implNote Long press android
	 */
	public void longPressAndroid(WebElement ele) {
		AndroidTouchAction touch = new AndroidTouchAction (driver);
		touch.longPress(LongPressOptions.longPressOptions()
		                .withElement (ElementOption.element (ele)))
		              .perform ();
	}
	
	/**
	 * 
	 * @author sneha aggarwal
	 * @implNote Long press ios
	 */
	public void longPressIOS(WebElement ele) {
		TouchActions action = new TouchActions(driver);
		action.longPress(ele);
		action.perform();
	}
	
}
