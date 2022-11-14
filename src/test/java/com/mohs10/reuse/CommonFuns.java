package com.mohs10.reuse;
	import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.mohs10.base.StartBrowser;
	import com.mohs10.ActionDriver.Action;
	import com.mohs10.or.AllPageObjects;

	public class CommonFuns {
		
		public Action aDriver;
		public static WebDriver driver;
		
		public CommonFuns()
		{
			aDriver = new Action();
			driver = StartBrowser.driver;
		}
		
		//Registration process
				public void Register(String Firstname, String Lastname, String Email, String Pwd, String ConfirmPwd) throws Exception
				{
					StartBrowser.childTest = StartBrowser.parentTest.createNode("Register in DemoWeb shop");
					aDriver.navigateToApplication("http://demowebshop.tricentis.com/");
					aDriver.click(AllPageObjects.lnkRegister, "Register link");
					aDriver.click(AllPageObjects.rbGender, "Radio button Gender");
					aDriver.type(AllPageObjects.txtFirstname,  Firstname, "FirstName text box");
					aDriver.type(AllPageObjects.txtLastname, Lastname, "LastName text box");
					aDriver.type(AllPageObjects.txtEmail, Email, "Email text box");
					aDriver.type(AllPageObjects.txtPassword, Pwd, "password text box");
					aDriver.type(AllPageObjects.txtConfirmpassword, ConfirmPwd, "confirm password text box");		
					aDriver.click(AllPageObjects.btnRegister, "Register button");
					aDriver.click(AllPageObjects.btnContinue, "Continue button");
					aDriver.click(AllPageObjects.lnkLogout, "Logout link");
				}
				
			//Login process
				public void logIn(String email, String pwd) throws Exception
				{
					StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to DemoWeb shop");
					aDriver.navigateToApplication("http://demowebshop.tricentis.com/");
					aDriver.click(AllPageObjects.lnkLogin, "Login link");
					aDriver.type(AllPageObjects.txtemail, email, "email text box");
					aDriver.type(AllPageObjects.txtpwd, pwd, "password text box");
					aDriver.click(AllPageObjects.btnlogin, "Login button");
					aDriver.click(AllPageObjects.lnkLogout, "Logout link");
				}
				
	   	//invalid login process
				public void invalidLogIn(String email, String pwd) throws Exception
				{
					StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to DemoWeb shop with invalid credentials");
					aDriver.navigateToApplication("http://demowebshop.tricentis.com/");
					aDriver.click(AllPageObjects.lnkLogin, "Login link");
					aDriver.type(AllPageObjects.txtemail, email, "email text box");
					aDriver.type(AllPageObjects.txtpwd, pwd, "password text box");
					aDriver.click(AllPageObjects.btnlogin, "Login button");
				}	
		
		
		//News button
		  public void Pagedown() throws Exception
		  
		  { 
		  StartBrowser.childTest =StartBrowser.parentTest.createNode("Page down");
		  aDriver.navigateToApplication("http://demowebshop.tricentis.com/");
		  Actions a=new Actions(driver);
		  a.sendKeys(Keys.PAGE_DOWN).perform();
		  a.sendKeys(Keys.PAGE_DOWN).perform();
		  }
		 
		  public void Newsbtn() throws Exception
		  {
			StartBrowser.childTest = StartBrowser.parentTest.createNode("News button");
			aDriver.navigateToApplication("http://demowebshop.tricentis.com/");
			aDriver.click(AllPageObjects.btnNews, "Performed click operation on News button");
		  }
		  
		  //Blog Link
		  public void Blogbtn() throws Exception
			{
				StartBrowser.childTest = StartBrowser.parentTest.createNode("Blog buttton");
				aDriver.navigateToApplication("http://demowebshop.tricentis.com/");
				aDriver.click(AllPageObjects.btnBlog, "Performed click operation on Blog button");
			}
			
		  //Categories
		  public void Categories() throws Exception 
		  {
			  	StartBrowser.childTest = StartBrowser.parentTest.createNode("Category links");
				aDriver.navigateToApplication("http://demowebshop.tricentis.com/");
				aDriver.click(AllPageObjects.lnkBooks, "Performed click operation on books link");
				aDriver.click(AllPageObjects.lnkComputer,"Performed click operation on Computer Link");
				aDriver.click(AllPageObjects.lnkElectronics,"Performed click operation on Electronics Link");
				aDriver.click(AllPageObjects.lnkApparelandShoes,"Performed click operation on Apparel and Shoes Link");
				aDriver.click(AllPageObjects.lnkDigitaldownloads,"Performed click operation on Digital Downloads Link");
				aDriver.click(AllPageObjects.lnkJewelry,"Performed click operation on Jewelry Link");
				aDriver.click(AllPageObjects.lnkGiftCards,"Performed click operation on Gift Cards Link");
		  }
		  
		  //AutoIT Reuse functions
		  public void uploadWordFile() throws Exception
			{
				try {
				
				StartBrowser.childTest = StartBrowser.parentTest.createNode("Automation using Autoit tool");
				aDriver.navigateToApplication("https://www.ilovepdf.com/word_to_pdf");
				aDriver.click(AllPageObjects.selectwordfile, "Wordtopdf convert btn");
				
				Runtime.getRuntime().exec("Fileupload.exe");
				
				aDriver.click(AllPageObjects.Converttopdf, "Convert btn");
				
				Thread.sleep(3000);
				aDriver.click(AllPageObjects.downloadbtn, "Download the converted file");	
				 
				}
				catch (StaleElementReferenceException e) {
					
				}
				finally {
					Runtime.getRuntime().exec("Filedownload.exe");
				}
				  
				Thread.sleep(5000);
			}
		  
		  //Verify the website title
		  public void VerifyingWebsiteTitle() 
		  {
			  StartBrowser.childTest = StartBrowser.parentTest.createNode("Verifying the Title of the Application");
			  aDriver.navigateToApplication("http://demowebshop.tricentis.com/");
			  
			  String actualTitle = driver.getTitle();
			  String expTitle = "Demo Web Shop";
			  
			  if(actualTitle.equalsIgnoreCase(expTitle)) 
			  {
				
				System.out.println("Verified Title : Test Passed   "+actualTitle); 
			  }
				else {
					System.out.println("Title Not Matched : Test Failed"+expTitle); 
			  }
		}
	
}
		  


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	