package kriptomatDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyWebElements extends BaseTest
{
	@Test
	public void verifyPageTitle () throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case verifyPageTitle"); 
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(2000);
        
		// Test Step 2: Enter Internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(5000);
		
		// Test Step 3: Check the title of the webpage
	    String title = driver.getTitle();
		Assert.assertEquals(title, "Factorial");
		System.out.println("Title is " + title);  
	}
	
	@Test
	public void verifyMainHeader () throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case verifyMainHeader"); 
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(2000);
        
		// Test Step 2: Enter Internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(5000);
		
		// Test Step 3: Check the main header text
	    String header = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/h1")).getText();
		Assert.assertEquals(header, "The greatest factorial calculator!");
		System.out.println("Header is: " + header);  
	}
	
	@Test
	public void verifyCalculateButton () throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case verifyCalculateButton"); 
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(2000);
        
		// Test Step 2: Enter Internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(5000);
		
		// Test Step 3: Check the button existence
	    String button = driver.findElement(By.xpath("//*[@id='getFactorial']")).getText();
		Assert.assertEquals(button, "Calculate!");
		System.out.println("Button is: " + button);  
	}
	
	@Test
	public void verifyPlaceholderText () throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case verifyCalculateButton"); 
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(2000);
        
		// Test Step 2: Enter Internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(5000);
		
		// Test Step 3: Check the Placeholder Text existence
	    String placeholder = driver.findElement(By.xpath("//*[@id='number']")).getAttribute("placeholder");
		Assert.assertEquals(placeholder, "Enter an integer");
		System.out.println("Button is: " + placeholder);  
	}
	
	@Test
	public void verifyPrivacyLink() throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case verifyPrivacyLink"); 
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(2000);
        
		// Test Step 2: Enter Internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(3000);
		
		// Test Step 3: Find Privacy link and click on it
	    driver.findElement(By.xpath("/html/body/div[2]/div/p[1]/a[2]")).click();
	    Thread.sleep(3000);
	    
	    String url = driver.getCurrentUrl(); // Store the actual url
		// Test Step 4: Check the Privacy link
		Assert.assertEquals(url, "https://qainterview.pythonanywhere.com/privacy");
		System.out.println("The Privacy URL is: " + url);  
	}
	
	@Test
	public void verifyTermsLink() throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case verifyTermsLink");
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(2000);
        
		// Test Step 2: Enter Internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(3000);
		
		// Test Step 3: Find Terms and Conditions link and click on it
	    driver.findElement(By.xpath("/html/body/div[2]/div/p[1]/a[1]")).click();
	    Thread.sleep(3000);
	    
	    String url = driver.getCurrentUrl(); // Store the actual url

		// Test Step 3: Check the Terms and Conditions link
		Assert.assertEquals(url, "https://qainterview.pythonanywhere.com/terms");
		System.out.println("The Terms and Conditions URL is: " + url);  
	}
	
	@Test
	public void verifyOtherLinks() throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case verifyTermsLink");
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(2000);
        
		// Test Step 2: Enter Internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(3000);
		
		// Test Step 3: Find Other link/links and click on it
	    driver.findElement(By.xpath("/html/body/div[2]/div/p[2]/a")).click();
	    Thread.sleep(3000);
	    
	    String url = driver.getCurrentUrl(); // Store the actual url

		// Test Step 4: Check the other links
		Assert.assertEquals(url, "https://qxf2.com/?utm_source=qa-interview&utm_medium=click&utm_campaign=From%20QA%20Interview");
		System.out.println("The Other link URL is: " + url);  
	}
}
