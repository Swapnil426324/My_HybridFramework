package com.tka.test_cases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tka.utilities.BaseClass;
import com.tka.utilities.ReadExcel;

public class LoginPageTest extends BaseClass {

	@Test(dataProvider = "testData")
	public void loginTest(String email, String pass, String isSuccuss) {
		lp.enterEmail(email);
		lp.enterPassword(pass);
		lp.clickRemember();
		lp.clickSubmit();
		if (isSuccuss.equals("1")) {
			Assert.assertEquals(driver.getCurrentUrl(), "https://javabykiran.in/other/CC/index.php?_a=account");
		} else if (isSuccuss.equals("2")) {
			Assert.assertEquals(lp.errorEmailAndPassword(), "Invalid username or password");
		} else if (isSuccuss.equals("3")) {
			Assert.assertEquals(lp.wrongEmail(), "Please enter a valid email address.");
		} else if (isSuccuss.equals("4")) {
			Assert.assertEquals(lp.wrongPassword(), "Please enter a password.");
		}
	}

	@Test()
	public void veriftProfileBtn() {
		lp.validLogin();
		lp.clickProfileBtn();
		Assert.assertEquals(lp.verifyProfileMsg(), "Your existing details can be edited below.");
	}

//	@DataProvider
//	String[][] testData() {
//		return new String[][] { { "swapnilalaskar@gmail.com", "Swapnil@1234", "1" },
//				{ "vaibhav@gmail.com", "vaibhav@1234", "2" }, 
//				{ "gaurav", "gaurav123", "3" },
//	            { "gaurav@gmail.com", "gaurav123", "4" }
//		};
//	}

	@DataProvider
	String[][] testData() throws Exception {
		return ReadExcel.excelRead();
	}
}
