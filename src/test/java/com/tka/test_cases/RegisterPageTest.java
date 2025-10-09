package com.tka.test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tka.utilities.BaseClass;

public class RegisterPageTest extends BaseClass{

	@Test
	public void registerTest() {
		rp.clickRegisterBtn();
		rp.typeTitle("Mr.");
		rp.typeFname("Pratik");
		rp.typeLname("Mishra");
		rp.typeEmail("pratik1@gmail.com");
		rp.typePhone("7777777777");
		rp.typeMobile("7777777777");
		rp.typePassword("Pratik@123");
		rp.typePassConform("Pratik@123");
		rp.clickTerms();
		rp.clickMailbox();
		rp.clickSubmit();
		String actmsg = rp.displayConformMsg();
		Assert.assertEquals(actmsg, "Your email address has been added to our mailing list.");
	}
}
