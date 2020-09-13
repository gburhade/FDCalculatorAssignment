package com.qa.fdcalculator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.fdcalculator.testbase.TestBase;

public class FixDepositCalculatorPage extends TestBase 
{
	//PageFactory
	
	@FindBy(id="amountInputField")
	WebElement fdamount;
	
	@FindBy(id="periodInputField")
	WebElement fdperiod;
	
	@FindBy(id="interestInputField")
	WebElement interest;
	
	@FindBy(id="calculateButton")
	WebElement calcbtn;
	
	@FindBy(id="futureValue")
	WebElement maturityamount;
	
	@FindBy(id="totalInterestEarned")
	WebElement totintearn;
	
	@FindBy(id="barChart")
	WebElement barchart;
	
	@FindBy(id="pieChart")
	WebElement piechart;
	
	public FixDepositCalculatorPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void CalculateFixedDeposit()
	{
		fdamount.sendKeys(prop.getProperty("amount"));
		Select select = new Select(driver.findElement(By.id("amountSelectField")));
		select.selectByIndex(2);
		fdperiod.sendKeys(prop.getProperty("period"));
		interest.sendKeys(prop.getProperty("interestrate"));
		Select select1 = new Select(driver.findElement(By.id("frequencySelectField")));
		select1.selectByVisibleText("Yearly");
		calcbtn.click();
	}
	
	public void VerifyDetail() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='futureValue']")));
		String value = maturityamount.getText();
		Assert.assertEquals(value, "1.1 Lakh");
		String intr = totintearn.getText();
		Assert.assertEquals(intr, "0.1 Lakh");
		//Barchart
		System.out.println("Maturity Details are Verified");
	    Boolean img = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", barchart);
	    if(!img)
	    {
	    	System.out.println("Barchart Image not exist");
	    }
	    else
	    {
	    	System.out.println("Barchart Image exist");
	    }
	    
	  //Piechart
	  	    Boolean img1 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", piechart);
	  	    if(!img1)
	  	    {
	  	    	System.out.println("Piechart Image not exist");
	  	    }
	  	    else
	  	    {
	  	    	System.out.println("Piechart Image exist");
	  	    }
	    
	    
	}
	
	
	
	

}
