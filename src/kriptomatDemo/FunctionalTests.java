package kriptomatDemo;


import java.math.BigInteger;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionalTests extends BaseTest
{
	

	
	@Test(dataProvider = "getData1")
	public void calculateFactorialPositive(String numberForCalc) throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case calculateFactorialPositive"); 
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(1000);
        
		// Test Step 2: Enter internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(3000);
		
		// Test Step 3: Find the 'number' text field and enter a positive integer number
	    driver.findElement(By.xpath("//input[@name='number']")).sendKeys(numberForCalc);
	    Thread.sleep(1000);
	    
	    // Test Step 4: Click on the calculate button
	    driver.findElement(By.xpath("//*[@id='getFactorial']")).click();
	    Thread.sleep(1000);
	    
	    // Calculate the factorial of entered number
	    // ************ Factorial calculation ************ 
		int i = 1;  
		int number = Integer.parseInt(numberForCalc);//It is the number to calculate factorial  
		BigInteger factorial = BigInteger.ONE;
		for(i = number; i > 0; i--)
		{    
			factorial = factorial.multiply(BigInteger.valueOf(i));    
		}
		
		// Test Step 5: Check that actual calculated factorial in web app is equal to expected value
		// ************ Create a string in expected shape ************ 
		String calculatedValue;
		if (number>21)
		{
			// If a number is bigger, then we need to use double
			double factorialDouble = factorial.doubleValue();
			calculatedValue = String.valueOf(factorialDouble);
		}
		else 
	    {
			calculatedValue = String.valueOf(factorial);
		}
		
		// Convert the calculatedValue into the expected format (string)
        calculatedValue = calculatedValue.replace("E", "e+");

		// Formating string as expected result
    	String expectedResult = "The factorial of " + numberForCalc + " is: " + calculatedValue;
    	//Storing the text of the heading in a string (result of web app calculation)
    	String resultText = driver.findElement(By.xpath("//*[@id='resultDiv']")).getText();

    	if(expectedResult.equalsIgnoreCase(resultText))
          	System.out.println("The expected heading is same as actual heading --- "+resultText);
    	else
          	System.out.println("The expected heading doesn't match the actual heading --- "+resultText);
		
    	Assert.assertEquals(resultText, expectedResult); 
	}
	
	@DataProvider
    public Object[][] getData1(ITestContext context) {
        String parameter = context.getCurrentXmlTest().getLocalParameters().get("numbers");
        String[] numbers = parameter.split(",");
        Object[][] returnValues = new Object[numbers.length][1];
        int index = 0;
        for (Object[] each : returnValues) {
            each[0] = numbers[index++].trim();
        }
        return returnValues;
    }
	
	@Test(dataProvider = "getData2")
	public void calculateFactorialFaultNonInt(String faultValueNonInt) throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case calculateFactorialFaultLetters"); 
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(1000);
        
		// Test Step 2: Enter internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(3000);
		
		// Test Step 3: Find the 'number' text field and enter a non-integer number
	    driver.findElement(By.xpath("//input[@name='number']")).sendKeys(faultValueNonInt);
	    Thread.sleep(1000);
	    
	    // Test Step 4: Click on the calculate button
	    driver.findElement(By.xpath("//*[@id='getFactorial']")).click();
	    Thread.sleep(1000);
	    
	    // Test Step 5: Check the result of calculation
    	String resultText = driver.findElement(By.xpath("//*[@id='resultDiv']")).getText();
    	
    	Assert.assertEquals(resultText, "Please enter an integer"); 
	}
	
	@DataProvider
    public Object[][] getData2(ITestContext context) {
        String parameter = context.getCurrentXmlTest().getLocalParameters().get("faultsNonInt");
        String[] faultsNonInt = parameter.split(",");
        Object[][] returnValues = new Object[faultsNonInt.length][1];
        int index = 0;
        for (Object[] each : returnValues) {
            each[0] = faultsNonInt[index++].trim();
        }
        return returnValues;
    }
	
	@Test(dataProvider = "getData3")
	public void calculateFactorialFaultNegativeInt(String faultValueNegativeInt) throws InterruptedException
	{
		// Start of the Test Case
		System.out.println("Start of test case calculateFactorialFaultNegativeInt"); 
		
        // Test Step 1: Maximize browser window
        driver.manage().window().maximize();
		Thread.sleep(1000);
        
		// Test Step 2: Enter internet address into the browser
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(3000);
		
		// Test Step 3: Find the 'number' text field and enter a negative integer number
	    driver.findElement(By.xpath("//input[@name='number']")).sendKeys(faultValueNegativeInt);
	    Thread.sleep(1000);
	    
	    // Test Step 4: Click on the calculate button
	    driver.findElement(By.xpath("//*[@id='getFactorial']")).click();
	    Thread.sleep(1000);
	    
	    // Test Step 5: Check the result of calculation
    	String resultText = driver.findElement(By.xpath("//*[@id='resultDiv']")).getText();
    	
    	Assert.assertEquals(resultText, "Please enter an positive integer"); 
	}
	
	@DataProvider
    public Object[][] getData3(ITestContext context) {
        String parameter = context.getCurrentXmlTest().getLocalParameters().get("faultsNegativeInt");
        String[] faultsNegativeInt = parameter.split(",");
        Object[][] returnValues = new Object[faultsNegativeInt.length][1];
        int index = 0;
        for (Object[] each : returnValues) {
            each[0] = faultsNegativeInt[index++].trim();
        }
        return returnValues;
    }
}


