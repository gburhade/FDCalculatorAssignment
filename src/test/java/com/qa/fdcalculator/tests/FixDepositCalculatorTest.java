package com.qa.fdcalculator.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.fdcalculator.pages.FixDepositCalculatorPage;
import com.qa.fdcalculator.testbase.TestBase;

public class FixDepositCalculatorTest extends TestBase
{
	public FixDepositCalculatorPage fdcp;
	
	@BeforeTest
	public void setup()
	{
		TestBase.initialisation();
		fdcp = new FixDepositCalculatorPage();
		fdcp.CalculateFixedDeposit();
	}
	
  @Test
  public void VerifySummaryDetails() throws InterruptedException
  {
	  fdcp.VerifyDetail();
  }
}
