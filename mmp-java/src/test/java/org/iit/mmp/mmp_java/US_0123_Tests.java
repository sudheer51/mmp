package org.iit.mmp.mmp_java;

import org.iit.openmrs.pages.LogoutPage;
import org.iit.openmrs.pages.OpenMRSUtils;
import org.selenium.util.TestBaseClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 

public class US_0123_Tests extends TestBaseClass {

	@Parameters({"url"})
	@Test
	public void TC_0123_validateText(String url)
	{
		OpenMRSUtils o1 = new OpenMRSUtils(driver);
		o1.navigateToURL(url);
		o1.login();
		String expected= null,actual=null;
		try
		{
			expected = "Logged in as Super User () at Isolation Ward.";
			actual = o1.verifyText();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		AssertJUnit.assertEquals(actual, expected);
		LogoutPage l1 = new LogoutPage(driver);
		l1.logout();
	}
}
