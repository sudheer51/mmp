package org.iit.mmp.mmp_java;

import org.iit.mmp.pages.LoginPage;
import org.iit.mmp.pages.ScheduleAppointmentPage;
import org.selenium.util.TestBaseClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US_004_ScheduleAppointment extends TestBaseClass{
	 
	//Modify the code
	
	@Test
	public void validateAppointment() throws InterruptedException
	{
		//Login

		LoginPage lPage = new LoginPage(driver);
		String loginMsg = lPage.login();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(loginMsg.contains("ria1"));

		//Navigate
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		String expected = "Current Appointments";
		String actual = sPage.navigationToAppointmentsPage();
		sa.assertEquals(actual, expected);
		
		//Create an Appointment
		String trText = sPage.createAppointment("Cardiologist","Dr.Charlie");
		 
		sa.assertTrue(trText.contains("Dr.Charlie"));
		sa.assertTrue(trText.contains("Fever"));

		sa.assertAll();

	}
 
}
