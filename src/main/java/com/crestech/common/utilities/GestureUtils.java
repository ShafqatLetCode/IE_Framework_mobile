package com.crestech.common.utilities;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class GestureUtils {

	public  AppiumDriver<RemoteWebElement> driver;
	public  WaitUtils wait = null;
	public  TouchAction touch =null;
	HandleException obj_handleexception=null;
	public GestureUtils(AppiumDriver<RemoteWebElement> driver2) {
		this.driver = driver2;
		wait = new WaitUtils(this.driver);
		touch = new TouchAction(this.driver);
		obj_handleexception=new HandleException(null, null);
	}
	//Working methods starts
	public void DragAndDropElementToElement(MobileElement Element1, MobileElement Element2) throws Exception {
		
		try {
			if(Element1.isDisplayed()&&Element2.isDisplayed())
				touch.longPress(longPressOptions().withElement(element(Element1))).moveTo(element(Element2)).release()
					.perform();
		} 
		catch (Exception e) {	
			obj_handleexception.throwException("DRAGDROP_EXCEPTION", " Failed to perform drag and drop   ",e);
		}
	}
	
	/**Author Shafqat
	 * @param Element
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public void DragAndDropElementToCoordinate(MobileElement Element, int x, int y) throws Exception {
		try {
			if(Element.isDisplayed())
				touch.longPress(longPressOptions().withElement(element(Element))).moveTo(point(x, y)).release().perform();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void longPressOnAndroidElement(WebElement ele) throws Exception {
		try {
			AndroidTouchAction touch = new AndroidTouchAction(driver);
			touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ele))).perform().release();
		} catch (Exception e) {
			throw e;
		} 
	}
	public void longPressOnMiddleOfScreen(int durationInSecond) throws Exception {
		try {
			AndroidTouchAction touch = new AndroidTouchAction(driver);
			Dimension windowSize1 = driver.manage().window().getSize();
			int y =(int)((windowSize1.getHeight())/2);
			int x =(int)((windowSize1.getWidth())/2);
			touch.longPress(LongPressOptions.longPressOptions().withPosition(point(x, y)).withDuration(ofSeconds(durationInSecond))).perform();
		} catch (Exception e) {
			throw e;
		} 
	}
	public void longPressOnMobileElementSpecficLocation(MobileElement Element, int dur, int x, int y) throws Exception {
		try {
			wait.waitForElementToBeClickable(Element);
			touch.longPress(longPressOptions().withElement(element(Element)).withPosition(point(x, y))
					.withDuration(ofSeconds(dur))).release().perform();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void tapAtSpecificPosition(int x, int y) throws Exception {
		try {
			touch.tap(tapOptions().withPosition(point(x, y))).perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void DoubleTaponMobileElement(MobileElement Element) throws Exception {
		try {
			touch.tap(tapOptions().withElement(element(Element))).release()
					.tap(tapOptions().withElement(element(Element))).release().perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void DoubleTaponMobileElementSpecific(MobileElement Element, int x, int y) throws Exception {
		try {
			touch.tap(tapOptions().withElement(element(Element)).withPosition(point(x, y))).release()
					.tap(tapOptions().withElement(element(Element)).withPosition(point(x, y))).release().perform();
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 
	 * @param srcElement
	 * @param destElement
	 * @throws Exception 
	 */
	public void horizontalSwipeToElement(MobileElement srcElement, MobileElement destElement)
			throws Exception {

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
		} catch (Exception e) {
			throw e;
		}
	} 

	/**
	 * 
	 * @author sneha aggarwal
	 * @throws Exception 
	 * @implNote swipe up
	 */
	public void swipeFromUpToBottom() throws Exception {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "up");
			js.executeScript("mobile: scroll", scrollObject);
			System.out.println("Swipe up was Successfully done.");
		} catch (Exception e) {
			System.out.println("swipe up was not successfull");
			throw e;
		}
	}

	/**
	 * 
	 * @author sneha aggarwal
	 * @throws Exception 
	 * @implNote swipe down
	 */
	public void swipeFromBottomToUp() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			System.out.println("Swipe down was Successfully done");
		} catch (Exception e) {
			System.out.println("swipe down was not successfull");
			throw e;
		}
	}

	/**
	 * 
	 * @author sneha aggarwal
	 * @throws Exception 
	 * @implNote carousel images swipe
	 */
	public void swipeImages(WebElement ele) throws Exception { 
		try {
			String pageString = ele.getAttribute("value");
			int length = pageString.length();
			String count_string = pageString.substring(length - 2, length).trim();
			int count = Integer.parseInt(count_string);
			System.out.println("Number of Image available to Swipe: " + count);
			for (int i = 0; i <= count; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "right");
				js.executeScript("mobile: scroll", scrollObject);
			}
			System.out.println("Swipe Successfully");
		} catch (Exception e) {
			System.out.println("Image swipe was not successfull");
			throw e;
		}
	}

	/**
	 * 
	 * @author sneha aggarwal
	 * @throws Exception 
	 * @implNote Long press android
	 */
	

	/**
	 * 
	 * @author sneha aggarwal
	 * @throws Exception 
	 * @implNote Long press ios
	 */
	public void longPressIOS(WebElement ele) throws Exception {
		try {
			TouchActions action = new TouchActions(driver);
			action.longPress(ele);
			action.perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void ZoomINAndZoomOUT() throws Exception {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("start", "20%,40%");
			params.put("end", "15%,60%");
			params.put("operation", "zoom");
			params.put("duration", "3");
			driver.executeScript("mobile:touch:gesture", params);
		} catch (Exception e) {
			throw e;
		}
	}

//	public void tapOnMobileElement(MobileElement Element) throws Exception {
//		try {
//			wait.waitForElementToBeClickable(Element);
//			touch.tap(tapOptions().withElement(element(Element))).perform();
//		} catch (Exception e) {
//			throw e;
//		}
//	}

	public void tapAtSpecificPosionOnMobileElement(MobileElement Element, int x, int y) throws Exception {
		try {
			wait.waitForElementToBeClickable(Element);
			touch.tap(tapOptions().withElement(element(Element)).withPosition(point(x, y))).perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void MultipleTapWithTwoFinger(MobileElement Element1, MobileElement Element2) throws Exception {
		try {
			new MultiTouchAction(driver).add(touch.tap(tapOptions().withElement(element(Element1))))
					.add(touch.tap(tapOptions().withElement(element(Element2)))).perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void MultipleTaponElementsSpecificPosition(MobileElement Element1, MobileElement Element2, int x1, int y1,
			int x2, int y2) throws Exception {
		try {
			new MultiTouchAction(driver)
					.add(touch.tap(tapOptions().withElement(element(Element1)).withPosition(point(x1, y1))))
					.add(touch.tap(tapOptions().withElement(element(Element2)).withPosition(point(x2, y2)))).perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void ManytapOnMobileElement(MobileElement Element, int count) throws Exception {
		try {
			for (int i = 0; i < count; i++) {
				touch.tap(tapOptions().withElement(element(Element))).perform();
				Duration.ofMillis(50);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void ManytabSpecificPosionOnMobileElement(MobileElement Element, int x, int y) throws Exception {
		try {
			touch.tap(tapOptions().withElement(element(Element)).withPosition(point(x, y))).perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void ManytapSpecificPosion(int x, int y, int count) throws Exception {
		try {
			for (int i = 0; i < count; i++) {
				touch.tap(tapOptions().withPosition(point(x, y))).perform();
				Duration.ofMillis(50);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void longPressonSpecificLocation(int x, int y, int dur) throws Exception {
		try {
			
			touch.longPress(longPressOptions().withPosition(point(x, y)).withDuration(ofSeconds(dur))).release()
					.perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void MultipleTaponSpecificPositions(int x1, int y1, int x2, int y2) throws Exception {
		try {
			
			new MultiTouchAction(driver).add(touch.tap(tapOptions().withPosition(point(x1, y1))))
					.add(touch.tap(tapOptions().withPosition(point(x2, y2)))).perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void swipeElementtoElement(MobileElement Element1, MobileElement Element2) throws Exception {
		try {
			wait.waitForElementVisibility(Element1);
			wait.waitForElementVisibility(Element2);
			touch.longPress(longPressOptions().withElement(element(Element1)).withDuration(ofSeconds(2)))
					.moveTo(element(Element2)).release().perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void swipeElementtoCoordinate(MobileElement Element, int x, int y) throws Exception {
		try {
			wait.waitForElementVisibility(Element);
			touch.longPress(longPressOptions().withElement(element(Element)).withDuration(ofSeconds(2)))
					.moveTo(point(x, y)).release().perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void swipeCoordinatetoElement(MobileElement Element, int x, int y) throws Exception {
		try {
			wait.waitForElementVisibility(Element);
			touch.longPress(longPressOptions().withPosition(point(x, y)).withDuration(ofSeconds(2)))
					.moveTo(element(Element)).release().perform();

		} catch (Exception e) {
			throw e;
		}
	}

	public void swipeCoordinatetoCoordinate(int x1, int y1, int x2, int y2) throws Exception {
		try {
			
			touch.longPress(longPressOptions().withPosition(point(x1, y1)).withDuration(ofSeconds(2)))
					.moveTo(point(x1, y1)).release().perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void scrollUPtoObject(String attribute, String value, MobileElement element) throws Exception {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			System.out.println("getSessionId :"+driver.getSessionId());
			int h = windowSize.getHeight();
			int y1 = (int) (h * 0.2);
			int y2 = (int) (h - y1);
			int x = (int) ((windowSize.getWidth()) / 2);
			String str = attribute + "=" + "\"" + value + "\"";

			String s1 = driver.getPageSource();
			int count = 0;
		
			while ((driver.getPageSource().contains(str) != true) && count == 0) {
				touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
						.moveTo(point(x, y1)).release().perform();
				String s2 = driver.getPageSource();
				if (s1.equals(s2) != true) {
					s1 = s2;
				} else
					count = 1;
			}
			if(element !=null)
				Asserts.assertTrue(element.isDisplayed(), "Element not found");

		} catch (HandleException e) {	
			throw new HandleException ("SCROLL_EXCEPTION", "Failed to scroll to the element ::",e);	
		}catch (Exception e) {		
			obj_handleexception.throwException("SCROLL_EXCEPTION", " Failed to scroll to the element  ",e);
		}

	}
	public void scrollUPtoObjectIos(String attribute, String value, MobileElement element) throws Exception {
		try {
			HashMap<String,Object>ScrollObject=new HashMap<>();
			ScrollObject.put("direction", "down");
			ScrollObject.put(attribute, value);
			
			driver.executeScript("mobile:scroll",ScrollObject);

			if(element !=null)
				Asserts.assertTrue(element.isDisplayed(), "Element not found");

		} catch (Exception e) {
			throw e;
		}
	}
	
	public void scrollUPIos() throws Exception {
		try {
			HashMap<String, Object> ScrollObject = new HashMap<>();
			ScrollObject.put("direction", "down");
			

			driver.executeScript("mobile:scroll", ScrollObject);


		} catch (Exception e) {
			obj_handleexception.throwException("SCROLL_EXCEPTION", " Failed to perform scroll  ", e);
		}
	}

	public void scrollDownIos() throws Exception {
		try {
			HashMap<String, Object> ScrollObject = new HashMap<>();
			ScrollObject.put("direction", "up");
			

			driver.executeScript("mobile:scroll", ScrollObject);

		} catch (Exception e) {
			obj_handleexception.throwException("SCROLL_EXCEPTION", " Failed to perform scroll  ", e);
		}
	}
	
	
	public void scrollDOWNtoObject(String attribute, String value, MobileElement element) throws Exception {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			int h = windowSize.getHeight();
			int y1 = (int) (h * 0.2);
			int y2 = (int) (h - y1);
			int x = (int) ((windowSize.getWidth()) / 2);
			String str = attribute + "=" + "\"" + value + "\"";

			String s1 = driver.getPageSource();
			int count = 0;
			
			while ((driver.getPageSource().contains(str) != true) && count == 0) {
				touch.longPress(longPressOptions().withPosition(point(x, y1)).withDuration(ofSeconds(2)))
						.moveTo(point(x, y2)).release().perform();
				String s2 = driver.getPageSource();
				if (s1.equals(s2) != true) {
					s1 = s2;
				} else
					count = 1;
			}

			if(element !=null)
				Asserts.assertTrue(element.isDisplayed(), "Element not found");
		} catch (HandleException e) {	
			obj_handleexception.throwHandleException("SCROLL_EXCEPTION", " Failed to perform scroll ",e);
		}
		catch (Exception e) {		
			obj_handleexception.throwException("SCROLL_EXCEPTION", " Failed to perform scroll  ",e);
		}
	}

	public boolean scrollUPwithinCoordinatetoObject(String attribute, String value, int leftabove_x1, int leftabove_y1,
			int rightbelow_x2, int rightbelow_y2) throws Exception {
		try {
			
			int y1 = (int) (leftabove_y1 * 0.05);
			int y2 = (int) (rightbelow_y2 - y1);
			int x = (int) (leftabove_x1 + ((rightbelow_x2) / 2));
			String str = attribute + "=" + "\"" + value + "\"";
			String s1 = driver.getPageSource();
			int count = 0;
			
			while ((driver.getPageSource().contains(str) != true) && count == 0) {
				touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
						.moveTo(point(x, y1)).release().perform();
				String s2 = driver.getPageSource();
				if (s1.equals(s2) != true) {
					s1 = s2;
				} else
					count = 1;
			}
			if (count == 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean scrollDOWNwithinCoordinatetoObject(String attribute, String value, int leftabove_x1,
			int leftabove_y1, int rightbelow_x2, int rightbelow_y2) throws Exception {
		try {
			int y1 = (int) (leftabove_y1 * 0.05);
			int y2 = (int) (rightbelow_y2 - y1);
			int x = (int) (leftabove_x1 + ((rightbelow_x2) / 2));
			String str = attribute + "=" + "\"" + value + "\"";
			String s1 = driver.getPageSource();
			int count = 0;

			while ((driver.getPageSource().contains(str) != true) && count == 0) {
				touch.longPress(longPressOptions().withPosition(point(x, y1)).withDuration(ofSeconds(2)))
						.moveTo(point(x, y2)).release().perform();
				String s2 = driver.getPageSource();
				if (s1.equals(s2) != true) {
					s1 = s2;
				} else
					count = 1;
			}
			if (count == 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			throw e;
		}
	}

	

	

	public void AllTypeSwipeOperation(String SwipeTypeDirection, int Percentage) throws Exception {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			int y = (int) ((windowSize.getHeight()) / 2);
			int x = (int) ((windowSize.getWidth()) / 2);
			int x1=0; int y1=0;
			switch (SwipeTypeDirection) {
	        case "DOWN":
	        	 y1 = (int) (y + (y * 0.01 * Percentage));
				touch.press(PointOption.point(x, y)).waitAction(waitOptions(Duration.ofMillis(300)))
						.moveTo(PointOption.point(x, y1)).release().perform();
	            break;
	        case "UP": 
	        	 y1 = (int) (y - (y * 0.01 * Percentage));
				touch.press(PointOption.point(x, y)).waitAction(waitOptions(Duration.ofMillis(300)))
						.moveTo(PointOption.point(x, y1)).release().perform();
	            break;
	        case "LEFT": 
	        	 x1 = (int) (x - (x * 0.01 * Percentage));
				touch.press(PointOption.point(x, y)).waitAction(waitOptions(Duration.ofMillis(300)))
						.moveTo(PointOption.point(x1, y)).release().perform();
	            break;
	        case "RIGHT": 
	        	 x1 = (int) (x + (x * 0.01 * Percentage));
	        	 touch.press(PointOption.point(x, y)).waitAction(waitOptions(Duration.ofMillis(300)))
						.moveTo(PointOption.point(x1, y)).release().perform();
	            break;
	        default:
	            throw new IllegalArgumentException("GestureUtils:: AllTypeSwipeOperation(): '" + SwipeTypeDirection + "' NOT supported");
	    }

		} catch (Exception e) {
			throw e;
		}
	}
	
	public void SwipeScreen(String dir) {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			int y = (int) ((windowSize.getHeight()) / 2);
			int x = (int) ((windowSize.getWidth()) / 2);
			int x1 = 0;
			int y1 = 0;
			if (dir.equalsIgnoreCase("DOWN")) {
				x1 = x;
				y1 = y - 10;
			} else if (dir.equalsIgnoreCase("UP")) {
				x1 = x;
				y1 = 10;
			} else if (dir.equalsIgnoreCase("LEFT")) {
				x1 = 10;
				y1 = y;
			} else if (dir.equalsIgnoreCase("RIGHT")) {
				x1 = x - 10;
				y1 = y;
			} else
				throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		
			touch.press(PointOption.point(x, y)).waitAction(waitOptions(Duration.ofMillis(300)))
					.moveTo(PointOption.point(x1, y1)).release().perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());

		}

	}

	public void SwipePartialScreen(String dir) {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			int y = (int) ((windowSize.getHeight()) / 2);
			int x = (int) ((windowSize.getWidth()) / 2);
			int x1 = 0;
			int y1 = 0;
			if (dir.equalsIgnoreCase("DOWN")) {
				x1 = x;
				y1 = (int) (y * 1.1);
			} else if (dir.equalsIgnoreCase("UP")) {
				x1 = x;
				y1 = (int) (y * 0.9);
			} else if (dir.equalsIgnoreCase("LEFT")) {
				x1 = (int) (x * 0.9);
				y1 = y;
			} else if (dir.equalsIgnoreCase("RIGHT")) {
				x1 = (int) (x * 1.1);
				y1 = y;
			} else
				throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
			
			touch.press(PointOption.point(x, y)).waitAction(waitOptions(Duration.ofMillis(300)))
					.moveTo(PointOption.point(x1, y1)).release().perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());

		}

	}

	public void ZoomOut(int percentage) throws Exception {
		try {
			Dimension windowSize1 = driver.manage().window().getSize();
			int y = (int) ((windowSize1.getHeight()) / 2);
			int x = (int) ((windowSize1.getWidth()) / 2);
			int y1 = y - 50;
			int y11 = (int) (y1 - (y * 0.01 * percentage));
			int y2 = y + 50;
			int y22 = (int) (y2 + (y * 0.01 * percentage));
			new MultiTouchAction(driver)
					.add(touch.longPress(longPressOptions().withPosition(point(x, y1))).moveTo(point(x, y11)))
					.add(touch.longPress(longPressOptions().withPosition(point(x, y2))).moveTo(point(x, y22)))
					.perform();
		} catch (Exception e) {
			throw e;
		}
	}

	public void ZoomIN(int percentage) throws Exception {
		try {
			Dimension windowSize1 = driver.manage().window().getSize();
			int y = (int) ((windowSize1.getHeight()) / 2);
			int x = (int) ((windowSize1.getWidth()));//// 2
			int x1 = 50;
			int x11 = (int) (x1 + (x * 0.005 * percentage));
			int x2 = x - 50;
			int x22 = (int) (x2 - (x * 0.005 * percentage));
			new MultiTouchAction(driver)
					.add(touch.longPress(longPressOptions().withPosition(point(x1, y))).moveTo(point(x11, y)))
					.add(touch.longPress(longPressOptions().withPosition(point(x1, y))).moveTo(point(x22, y)))
					.perform();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void scrollUPtoObjectBelowSpecificElement(String attribute, String value, MobileElement element,MobileElement specificPosition) throws Exception {
		try {
			Dimension windowSize = driver.manage().window().getSize();
			System.out.println("getSessionId :"+driver.getSessionId());
			
			int h = windowSize.getHeight();
			int y1 = (int) (h * 0.2);
			int y2 = (int) (h - y1);
			int x = (int) ((windowSize.getWidth()) / 2);
			String str = attribute + "=" + "\"" + value + "\"";

			String s1 = driver.getPageSource();
			int count = 0;
			WaitUtils wait = new WaitUtils(driver);
			
			while ((driver.getPageSource().contains(str) != true) && count == 0) {
				touch.longPress(longPressOptions().withPosition(point(x, y2)).withDuration(ofSeconds(2)))
						.moveTo(element(specificPosition)).release().perform();
				String s2 = driver.getPageSource();
				if (s1.equals(s2) != true) {
					s1 = s2;
				} else
					count = 1;
			}
			if(element !=null)
				Asserts.assertTrue(element.isDisplayed(), "Element not found");

		} catch (HandleException e) {	
			throw new HandleException ("SCROLL_EXCEPTION", "Failed to scroll to the element ::",e);	
		}catch (Exception e) {		
			obj_handleexception.throwException("SCROLL_EXCEPTION", " Failed to scroll to the element  ",e);
		}
	}
}
