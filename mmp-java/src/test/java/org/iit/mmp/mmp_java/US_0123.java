package org.iit.mmp.mmp_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.util.SeleniumUtils;
import org.selenium.util.TestBaseClass;
import org.testng.annotations.Test;

public class US_0123 extends TestBaseClass {
	
	@Test
	public void TC_001_validateCantLoginLink()
	{
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.findElement(By.cssSelector("#cantLogin")).click();
		String dialogText = driver.findElement(By.xpath("//p[@class='dialog-instructions']")).getText();
		System.out.println(dialogText);
		
		
		WebElement ele = driver.findElement(By.xpath("//button[@class='confirm']"));
		SeleniumUtils.verifyElementIsDisplayed(ele);
		ele.click();
		

		boolean result =SeleniumUtils.waitforanElementToBeDisplayed(driver,20,ele);
		System.out.println("Element is displayed:::::" + result);
	
	}

}
