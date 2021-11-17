package com.crestech.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import com.crestech.appium.utils.CommonAppiumTest;
import com.crestech.common.utilities.Asserts;
import com.crestech.common.utilities.CommonAlertElements;
import com.crestech.common.utilities.WaitUtils;
import com.crestech.pageobjects.DBSAndroidObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;

public class DBSAndroidPage extends CommonAppiumTest {

	static Logger log = Logger.getLogger(DBSAndroidPage.class.getName());
	public DBSAndroidObject DBSappObject = new DBSAndroidObject();
	
	public DBSAndroidPage(AppiumDriver<RemoteWebElement> driver) {
		super(driver);
		try {
			PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), DBSappObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *  @author Shafqat
	 * This method is for Re launching DBS Application 
	 */
	@Step("Relaunching DBS application")
	public void relaunchingDBS() {
	try {
		relanchApplication("com.dbs.sit1.dbsmbanking","com.dbs.sg.digibank.ui.demo.SplashActivity");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	/**
	 *  @author Shafqat
	 * This method is for Re launching POSB Application 
	 */
	@Step("Relaunching POSB application")
	public void relaunchingPOSB() {
	try {
		relanchApplication("com.dbs.sit1.posbmbanking","com.dbs.sg.digibank.ui.demo.SplashActivity");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	/**
	 *  @author Shafqat
	 * This method is for Re launching iWealth Application 
	 */
	@Step("Relaunching iWealth application")
	public void relaunchingIwealth() {
	try {
		relanchApplication("com.dbs.sg.uat.dbsiwealth","com.dbs.sg.digibank.ui.demo.SplashActivity");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION 1st Page Functional Repository.
	 *
	 */
	
	/**
	 * This method is for clicking Login button 
	 */
	@Step("Clicked on Login button")
	public void clickOnLoginButton() {
	try {
		clickOnElement(DBSappObject.loginButton());
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	/**
	 * This method is for clicking Sign Up For Digibank button 
	 */
	@Step("Clicked on Sign Up For Digibank button")
	public void clickOnSignUpForDigibankButton() {
	try {
		clickOnElement(DBSappObject.signUpForDigibankButton());
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	/**
	 * This method is for clicking Pre Login button 
	 */
	@Step("Clicked on Pre Login button")
	public void preLoginButton(){
	try {
		clickOnElement(DBSappObject.loginButton());
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION Login Page Functional Repository.
	 *
	 */
	
	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter data in User EditBox")
    public void sendDataInUserId(String text) {
	try {
		if(isElementEnable(DBSappObject.userIdEditText()))
			enterTextInTextbox(DBSappObject.userIdEditText(), text);
		
		Asserts.assertTrue(isElementEnable(DBSappObject.userIdEditText()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will send data in the editbox
	 */
	@Step("Enter data in Pin EditBox")
    public void sendDataInUserPin(String text) {
	try {
		if(isElementEnable(DBSappObject.userPinEditText()))
			enterTextInTextbox(DBSappObject.userPinEditText(), text);
		
		
		Asserts.assertTrue(isElementEnable(DBSappObject.userPinEditText()), "EditField is not enable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION OneAppPostLogin(Homepage) Functional Repository.
	 *
	 *
	 *
	 	/**
	 * This method will verifying 'wlecome to' field
	 */
	@Step("Verify 'welcome to' field")
    public void verifyTextWelcomeTo(String expectedText) {
	try {
		String actualText=getTexOfElement(DBSappObject.WelcomeToText()).trim();
		Asserts.assertEquals(actualText, expectedText, "'Welcome To' text is not found");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
 	/**
	 * This method will verifying 'wlecome to' field
	 */
	@Step("Verify 'digibank' field")
    public void verifyTextDigibank(String expectedText) {
	try {
		String actualText=getTexOfElement(DBSappObject.DigibankText()).trim();
		Asserts.assertEquals(actualText, expectedText, "'digibank' text is not found");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method will verifying 'Logout button' and perform click action
	 */
	@Step("Verify 'Logout' field and perform click action")
    public void clickOnLogoutAndVerify(String expectedText) {
	try {
		String actualText=getTexOfElement(DBSappObject.logoutButton());
		if(actualText.equalsIgnoreCase(expectedText))
			CommonAppiumTest.clickOnElement(DBSappObject.logoutButton());
		
		Asserts.assertEquals(actualText, expectedText, "'Logout' button is not found");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION post logout Screen-Tap on the stars to rate Functional Repository.
	 *
	 *
	 *
	/**
	 * This method will verifying 'Tap on the stars to rate' field
	 */
	@Step( "Verify 'Tap on the stars to rate' field" )
    public void verifyTextTapOnTheStars(String expectedText) {
	try {
		String actualText=getTexOfElement(DBSappObject.postLogoutAlertMessage());
		
		Asserts.assertEquals(actualText, expectedText, "'Tap on the stars to rate' Text is not found");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @author Shafqat
	 *DBS Android APPLICATION Token Setup Functional Repository.
	 *
	 *
	 *
	/**
	 * This method will click on 'Set up now button' After verifying page header message field
	 */
	@Step("Verifying Page and clicking on 'SET UP NOW' button ")
	public void verifyPageAndClickOnSetUpNowButton(String expectecMessage) throws Exception    
	{
		try {

			String actualMessage = CommonAppiumTest.getTexOfElement(DBSappObject.tokenSetupMessage());
			
				if(actualMessage.equalsIgnoreCase(expectecMessage))
					CommonAppiumTest.clickOnElement(DBSappObject.setUpNowButton());
				   
				
				Asserts.assertEquals(actualMessage, expectecMessage, "Title Message Not matching");
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	/**
	 * This method will Verify Email/SMS OTP Page and Send OTP on TextField button
	 */
	@Step("Verifying Email/SMS OTP Page and Send OTP on TextField button ")
	public void verifyPageAndSendOtpToEditBox(String OTP, String expectecMessage) throws Exception   
	{
		try {

			String actualMessage = CommonAppiumTest.getTexOfElement(DBSappObject.emailSmsOtpMessage());
			
				if(actualMessage.equalsIgnoreCase(expectecMessage))
					if(isElementEnable(DBSappObject.emailSmsOtpEditBox()))
						enterTextInTextbox(DBSappObject.emailSmsOtpEditBox(), OTP);
				Asserts.assertTrue(isElementEnable(DBSappObject.emailSmsOtpEditBox()), "TextField is not enable");
				   
				
				Asserts.assertEquals(actualMessage, expectecMessage, "Title Message Not matching");
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	/**
	 * This method will click on 'Done button' After verifying page header message After token is verified
	 */
	@Step("Verifying Page after Token setup and clicking on 'Done' button")
	public void verifyPageAndClickOnDone(String expectecMessage) throws Exception    
	{
		try {

			String actualMessage = CommonAppiumTest.getTexOfElement(DBSappObject.tokenGetSetupMessage());
			
				if(actualMessage.equalsIgnoreCase(expectecMessage))
					CommonAppiumTest.clickOnElement(DBSappObject.doneButton());
				   
				
				Asserts.assertEquals(actualMessage, expectecMessage, "Title Message Not matching");
					
			
		} catch (Exception e) {
			throw new Exception(CommonAppiumTest.getExceptionMessage(e));
		}
	
	}
	/**
	 *
	 * 
	 *DBS Android APPLICATION payee Add and Remittance  Functional Repository.
	 *
	 *
	 *
	/**
	 * This method will verifying and clicking 'Pay and Transfer' field
	 */@Step("Verifying Pay and Transfer icon and click")
		public void payAndTransferVerifyClick(String expectecText) throws Exception    
		{
			try {

				String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.payAndTransferLabel());
				
					if(actualText.equalsIgnoreCase(expectecText))
						CommonAppiumTest.clickOnElement(DBSappObject.payAndTransferButton());
					   
					
					Asserts.assertEquals(actualText, expectecText, "Label Not matching");
						
				
			} catch (Exception e) {
				throw new Exception(CommonAppiumTest.getExceptionMessage(e));
			}
		
		}
	 /**
		 * This method will verifying and clicking 'Overseas ' field
		 */@Step("Verifying Overseas  icon and click")
			public void overseasVerifyClick(String expectecText) throws Exception    
			{
				try {

					String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.overseasLabel());
					
						if(actualText.equalsIgnoreCase(expectecText))
							CommonAppiumTest.clickOnElement(DBSappObject.overseasButton());
						   
						
						Asserts.assertEquals(actualText, expectecText, "Label Not matching");
							
					
				} catch (Exception e) {
					throw new Exception(CommonAppiumTest.getExceptionMessage(e));
				}
			
			}
		
			 /**
				 * This method will verifying and clicking 'Add Overseas Recipient' field
				 */@Step("Verifying Add Overseas Recipient  Label and click")
					public void addOverseasRecipientVerifyClick(String expectecText) throws Exception    
					{
						try {

							String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.addRecipientNowButton());
							
								if(actualText.equalsIgnoreCase(expectecText))
									CommonAppiumTest.clickOnElement(DBSappObject.addRecipientNowButton());
								   
								
								Asserts.assertEquals(actualText, expectecText, "Label Not matching");
									
							
						} catch (Exception e) {
							throw new Exception(CommonAppiumTest.getExceptionMessage(e));
						}
					
					}
				 /**
					 * This method will country's search dropdown 
					 */@Step("Enter the text in search and select the corresponding value in the dropdown")
					 public void sendDataInSearchBoxAndSelectFromDropDown(String searchBoxData, String valueSelectedFromList) {
							try {
								if(isElementEnable(DBSappObject.locationAutocompleteSearchBox()))
									enterTextInTextbox(DBSappObject.locationAutocompleteSearchBox(), searchBoxData);
								WaitUtils wait = new WaitUtils(driver);
								wait.ImplicitlyWait();
								List<MobileElement> Elementlist = DBSappObject.countryList();
								List<MobileElement> ElementlistClickable = DBSappObject.countryclickableList();
								int l = Elementlist.size();
								int index=0;
								String countryFromList=null;
								for (int i = 0; i < l; i++) {
									countryFromList=Elementlist.get(i).getText();
									if(countryFromList.equalsIgnoreCase(valueSelectedFromList)) {
										index++;
										clickOnElement(ElementlistClickable.get(i));
									
								}
									}
								Asserts.assertTrue(isElementEnable(DBSappObject.locationAutocompleteSearchBox()), "SearchField is not enable");
								Asserts.assertTrue(index>0, "No element found in the lis of corresponding value");
								
								
								
								
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
					 /**
						 * This method will verifying and clicking 'CurrencyType' field
						 */@Step("Verifying AUD CurrencyType Label and click")
							public void CurrencyTypeVerifyClick(String expectecText) throws Exception    
							{
								try {

									String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.currencyLabel());
									
										if(actualText.equalsIgnoreCase(expectecText))
											CommonAppiumTest.clickOnElement(DBSappObject.currencyLabel());
										   
										
										Asserts.assertEquals(actualText, expectecText, "Currency is Not matching");
											
									
								} catch (Exception e) {
									throw new Exception(CommonAppiumTest.getExceptionMessage(e));
								}
							
							}
						 /**
							 * This method will verifying and clicking 'Next' button field
							 */@Step("Verifying AUD CurrencyType Label and click")
								public void nextButtonVerifyClick() throws Exception    
								{
									try {

										String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.nextButton());
										
											if(actualText.equalsIgnoreCase("NEXT"))
												CommonAppiumTest.clickOnElement(DBSappObject.nextButton());
											   
											
											Asserts.assertEquals(actualText, "NEXT", "Button not found");
												
										
									} catch (Exception e) {
										throw new Exception(CommonAppiumTest.getExceptionMessage(e));
									}
								
								}/**
								 * This method will send data in the editbox
								 */
								@Step("Enter data in Bank Code EditBox")
							    public void sendBankCode(String text) {
								try {
									if(isElementEnable(DBSappObject.enterBankcodeTextField()))
										enterTextInTextbox(DBSappObject.enterBankcodeTextField(), text);
									
									Asserts.assertTrue(isElementEnable(DBSappObject.enterBankcodeTextField()), "EditField is not enable");
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								/**
								 * This method will send data in the editbox
								 */
								@Step("Enter Account No EditBox")
							    public void sendAccountNo(String text) {
								try {
									if(isElementEnable(DBSappObject.recipientAccountNoEditBox()))
										enterTextInTextbox(DBSappObject.recipientAccountNoEditBox(), text);
									
									Asserts.assertTrue(isElementEnable(DBSappObject.recipientAccountNoEditBox()), "EditField is not enable");
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								/**
								 * This method will send data in the editbox
								 */
								@Step("Enter Full name EditBox")
							    public void sendFullName(String text) {
								try {
									if(isElementEnable(DBSappObject.recipientNameEditBox()))
										enterTextInTextbox(DBSappObject.recipientNameEditBox(), text);
									
									Asserts.assertTrue(isElementEnable(DBSappObject.recipientNameEditBox()), "EditField is not enable");
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								@Step("Enter Address EditBox")
							    public void sendAddress(String text) {
								try {
									if(isElementEnable(DBSappObject.recipientAddressEditBox()))
										enterTextInTextbox(DBSappObject.recipientAddressEditBox(), text);
									
									Asserts.assertTrue(isElementEnable(DBSappObject.recipientAddressEditBox()), "EditField is not enable");
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								@Step("Enter city EditBox")
							    public void sendcity(String text) {
								try {
									if(isElementEnable(DBSappObject.recipientCityEditBox()))
										enterTextInTextbox(DBSappObject.recipientCityEditBox(), text);
									
									Asserts.assertTrue(isElementEnable(DBSappObject.recipientCityEditBox()), "EditField is not enable");
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								/**
								 * This method will verifying 'Tap on the stars to rate' field
								 */
								@Step( "Verify 'REVIEW RECIPIENT'S DETAILS label' field" )
							    public void verifyRecipientReviewDetailLabel(String expectedText) {
								try {
									String actualText=getTexOfElement(DBSappObject.recipientReviewDetailLabel());
									
									Asserts.assertEquals(actualText, expectedText, "'REVIEW RECIPIENT'S DETAILS label' Text is not found");
									
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								/**
								 * This method will verifying and clicking 'ADD RECIPIENT NOW' button field
								 */@Step("Verifying AUD CurrencyType Label and click")
									public void addRecipientNownVerifyClick(String expectecText) throws Exception    
									{
										try {

											String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.addRecpientNowButton());
											
												if(actualText.equalsIgnoreCase(expectecText))
													CommonAppiumTest.clickOnElement(DBSappObject.addRecpientNowButton());
												   
												
												Asserts.assertEquals(actualText, expectecText, "Button not found");
													
											
										} catch (Exception e) {
											throw new Exception(CommonAppiumTest.getExceptionMessage(e));
										}
									
									}
								 /**
									 * This method will verifying 'You've added a recipient label' field
									 */
									@Step( "Verify 'You've added a recipient label' field" )
								    public void verifyRecipientAddedLabel(String expectedText) {
									try {
										String actualText=getTexOfElement(DBSappObject.recipientaddedLabel());
										
										Asserts.assertEquals(actualText, expectedText, "'You've added a recipient label' Text is not found");
										
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
									@Step("Clicked on expand button")
									public void expandButton() {
									try {
										clickOnElement(DBSappObject.expandButton());
									} catch (Exception e) {
										e.printStackTrace();
									}
									}
									/**
									 * This method will verifying 'You've added a recipient label' field
									 */
									@Step( "Verify 'MAKE A TRANSFER' field" )
								    public void verifymakeTransferButton(String expectedText) {
									try {
										String actualText=getTexOfElement(DBSappObject.makeTransferButton());
										
										Asserts.assertEquals(actualText, expectedText, "'MAKE A TRANSFER' Text is not found");
										
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
									/**
									 * This method will verifying 'You've added a recipient label' field
									 */
									@Step( "Verify 'Reference No. Field and its value' field" )
								    public void verifyReferenceFieldAndItsValue(String expectedText) {
									try {
										String actualText=getTexOfElement(DBSappObject.referenceNoLabel());
										
										Asserts.assertEquals(actualText, expectedText, "'Reference no Field' is not found");
										Asserts.assertTrue(isElementVisible(DBSappObject.referenceNoValue()), "Reference Number not Found");
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
									/**
									 *
									 * @author Shafqat
									 *DBS Android APPLICATION paylah topup Functional Repository.
									 *
									 *
									 *
									/**
									 * This method will verify and click 'TopUp' field
									 */@Step("Verifying TopUp  Label and click")
										public void topUpVerifyClick(String expectecText) throws Exception    
										{
											try {

												String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.topUpLabel());
												
													if(actualText.equalsIgnoreCase(expectecText))
														CommonAppiumTest.clickOnElement(DBSappObject.topUpButton());
													   
													
													Asserts.assertEquals(actualText, expectecText, "Top up Label Not matching");
														
												
											} catch (Exception e) {
												throw new Exception(CommonAppiumTest.getExceptionMessage(e));
											}
										
										}
									 /**
										 * This method will verify and click 'Paylah' field
										 */@Step("Verifying TopUp  Label and click")
											public void payLahVerifyClick(String expectecText) throws Exception    
											{
												try {

													String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.paylahLabel());
													
														if(actualText.equalsIgnoreCase(expectecText))
															CommonAppiumTest.clickOnElement(DBSappObject.paylahButton());
														   
														
														Asserts.assertEquals(actualText, expectecText, "PayLah Label Not matching");
															
													
												} catch (Exception e) {
													throw new Exception(CommonAppiumTest.getExceptionMessage(e));
												}
											
											}
										 /**
											 * This method will verifying 'You've added a recipient label' field
											 */
											@Step( "Verify 'Top Up Paylah Label' field" )
										    public void verifyTopUpPaylahLabel(String expectedText) {
											try {
												String actualText=getTexOfElement(DBSappObject.topUpPaylahLabel());
												
												Asserts.assertEquals(actualText, expectedText, "'Top Up Paylah' Text is not found");
												
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
											/**
											 * This method will send data in the editbox
											 */
											@Step("Enter currency in EditBox")
										    public void sendCurrencyInTextField(String text) {
											try {
												if(isElementEnable(DBSappObject.currencyTextBox()))
													enterTextInTextbox(DBSappObject.currencyTextBox(), text);
												
												Asserts.assertTrue(isElementEnable(DBSappObject.currencyTextBox()), "EditField is not enable");
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
											@Step( "Verify 'Top Up Paylah Label' field" )
										    public void verifyReviewTopUpLabel(String expectedText) {
											try {
												String actualText=getTexOfElement(DBSappObject.reviewTopUpLabel());
												
												Asserts.assertEquals(actualText, expectedText, "'Top Up Paylah' Text is not found");
												
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
											@Step( "Verify 'Enter Amount' field" )
										    public void verifyDisplayAmount(String expectedText) {
											try {
												String actualText=getTexOfElement(DBSappObject.displayAmount());
												
												Asserts.assertEquals(actualText, expectedText, "'Display Amount' is incorrect");
												
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
											/**
											 * This method will verify and click 'TOP UP NOW' field
											 */@Step("Verifying TOP UP NOW  Label and click")
												public void topUpNowVerifyClick(String expectecText) throws Exception    
												{
													try {

														String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.topUpNowButton());
														
															if(actualText.equalsIgnoreCase(expectecText))
																CommonAppiumTest.clickOnElement(DBSappObject.topUpNowButton());
															   
															
															Asserts.assertEquals(actualText, expectecText, "TOP UP NOW button Not exist");
																
														
													} catch (Exception e) {
														throw new Exception(CommonAppiumTest.getExceptionMessage(e));
													}
												
												}
											 @Step( "Verify 'Top-up Done' field" )
											    public void verifyTopUpDoneLabel(String expectedText) {
												try {
													String actualText=getTexOfElement(DBSappObject.topUpDoneLabel());
													
													Asserts.assertEquals(actualText, expectedText, "'Top-up Done' Text is not found");
													
													} catch (Exception e) {
														e.printStackTrace();
													}
												}
											 /**
												 * This method will verify and click 'Logout' field
												 */@Step("Verifying Logout Label and click")
													public void logOutTopUpVerifyClick(String expectecText) throws Exception    
													{
														try {

															String actualText = CommonAppiumTest.getTexOfElement(DBSappObject.logOutPaylahButton());
															
																if(actualText.equalsIgnoreCase(expectecText))
																	CommonAppiumTest.clickOnElement(DBSappObject.logOutPaylahButton());
																   
																
																Asserts.assertEquals(actualText, expectecText, "LogOut button Not exist");
																	
															
														} catch (Exception e) {
															throw new Exception(CommonAppiumTest.getExceptionMessage(e));
														}
													
													}
}
