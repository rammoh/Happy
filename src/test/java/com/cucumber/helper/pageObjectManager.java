package com.cucumber.helper;

import org.openqa.selenium.WebDriver;
import com.cucumber.pom.bookAHotel;
import com.cucumber.pom.clickOnRadioButton;
import com.cucumber.pom.login;
import com.cucumber.pom.searchHotel;
import com.cucumber.pom.selectHotel;

public class pageObjectManager {
	private WebDriver driver;
	private bookAHotel A;
	private clickOnRadioButton B;
	private login c;
	private searchHotel D;
	private selectHotel E;

	public bookAHotel getbookAHotel() {
		if (A == null) {
			A = new bookAHotel(driver);
		}
		return A;
	}

	public clickOnRadioButton getclickOnRadioButton() {
		if (B == null) {
			B = new clickOnRadioButton(driver);
		}
		return B;
	}

	public login getlogin() {
		if (c == null) {
			c = new login(driver);
		}
		return c;
	}

	public searchHotel getsearchHotel() {
		if (D == null) {
			D = new searchHotel(driver);
		}
		return D;
	}

	public selectHotel getselectHotel() {
		if (E == null) {
			E = new selectHotel(driver);
		}
		return E;
	}

	public pageObjectManager(WebDriver Idriver) {
		this.driver = Idriver;

	}
}
