package com.cucumber.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.cucumber.baseclass.BaseClass;
import com.cucumber.helper.fileReaderManager;
import com.cucumber.helper.pageObjectManager;
import com.cucumber.pom.bookAHotel;
import com.cucumber.pom.clickOnRadioButton;
import com.cucumber.pom.login;
import com.cucumber.pom.searchHotel;
import com.cucumber.pom.selectHotel;
import com.cucumber.testrunner.testrunner;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition extends BaseClass {
	public static WebDriver driver = testrunner.driver;
	pageObjectManager x = new pageObjectManager(driver);    //we can create a object commonly step definition to access all pom class 

//sce1
	@Given("^user navigates to the application$")
	public void user_navigates_to_the_application() throws Throwable {
		String Url = fileReaderManager.getInstance().getconfigReader().geturl();
		geturl(Url);
	}

	@Given("^user enter the valid usernames$")
	public void user_enter_the_valid_usernames() throws Throwable {
		// login x = new login(driver);
		sendKeys(x.getlogin().getEnterTheUserName(), "8056234232");
	}

	@Given("^user enter the valid passwords$")
	public void user_enter_the_valid_passwords() throws Throwable {
		// login x = new login(driver);
		sendKeys(x.getlogin().getEnterThepassWord(), "mohanece");
	}

	@Given("^user click the signin buttons$")
	public void user_click_the_signin_buttons() throws Throwable {
		// login x = new login(driver);
		elementClick(x.getlogin().getEnterThesubmitButton());
	}

//sce2
	@Given("^user verify the checkout date fields in get the url$")
	public void user_verify_the_checkout_date_fields_in_get_the_url() throws Throwable {
		geturl("https://adactin.com/HotelAppBuild2");
	}

	@Given("^user enter the location of roomms$")
	public void user_enter_the_location_of_roomms() throws Throwable {
		// searchHotel x = new searchHotel(driver);
		selectOptionDD(x.getsearchHotel().getSelectThelocation(), "value", "Sydney");

	}

	@Given("^select the hotel types$")
	public void select_the_hotel_types() throws Throwable {
		// searchHotel x = new searchHotel(driver);
		selectOptionDD(x.getsearchHotel().getSelectTheHotels(), "value", "Hotel Creek");
	}

	@Given("^user enter the room type$")
	public void user_enter_the_room_type() throws Throwable {
		// searchHotel x = new searchHotel(driver);
		selectOptionDD(x.getsearchHotel().getSelectTheroomType(), "value", "Standard");
	}

	@Given("^user enter the number of rooms$")
	public void user_enter_the_number_of_rooms() throws Throwable {
		// searchHotel x = new searchHotel(driver);
		selectOptionDD(x.getsearchHotel().getSelectTheNumberOfRooms(), "visibletext", "1 - One");
	}

	@Given("^user enter the check in date$")
	public void user_enter_the_check_in_date() throws Throwable {
		// searchHotel x = new searchHotel(driver);
		sendKeys(x.getsearchHotel().getEnterTheCheckInDate(), "05/03/2019");
	}

	@Given("^user enter the check out date$")
	public void user_enter_the_check_out_date() throws Throwable {
		// searchHotel x = new searchHotel(driver);
		sendKeys(x.getsearchHotel().getEnterTheCheckOutDate(), "03/03/2019");

	}

	@Given("^user enter the adults per room$")
	public void user_enter_the_adults_per_room() throws Throwable {
		// searchHotel x = new searchHotel(driver);
		selectOptionDD(x.getsearchHotel().getSelectTheAdultsPerRoom(), "value", "1");
	}

	@Given("^user eneter the children per room$")
	public void user_eneter_the_children_per_room() throws Throwable {
		// searchHotel x = new searchHotel(driver);
		selectOptionDD(x.getsearchHotel().getSelectThechildPerRoom(), "value", "1");
		Thread.sleep(3000);
	}


	@Then("^Verify that system gives an error saying ‘check-in-date should not be later than check-out-date’$")
	public void verify_that_system_gives_an_error_saying_check_in_date_should_not_be_later_than_check_out_date()
			throws Throwable {

		// searchHotel x = new searchHotel(driver);
		org.junit.Assert.assertEquals("Check-In Date shall be before than Check-Out Date",
				getText(x.getsearchHotel().getCheckinHotelDate()));
		org.junit.Assert.assertEquals("Check-Out Date shall be after than Check-In Date",
				getText(x.getsearchHotel().getCheckOutHotelDate()));

	}

	// sce3
	
	@Given("^verify the whether check the system get in url$")
	public void verify_the_whether_check_the_system_get_in_url() throws Throwable {
		geturl("https://adactin.com/HotelAppBuild2");
	}
	
	@Given("^enter the check in previes five date$")
	public void enter_the_check_in_previes_five_date() throws Throwable {
// searchHotel x = new searchHotel(driver);
		sendKeys(x.getsearchHotel().getEnterTheCheckInDate(), "21/03/2019");
	}

	@Given("^enter the check out previes three date$")
	public void enter_the_check_out_previes_three_date() throws Throwable {
	  // searchHotel x = new searchHotel(driver);
		sendKeys(x.getsearchHotel().getEnterTheCheckOutDate(), "23/03/2019");
	}

 	@Then("^Verify that application throws error message$")
 	public void verify_that_application_throws_error_message() throws Throwable {

//		searchHotel x = new searchHotel(driver);
		org.junit.Assert.assertEquals("26/02/2019", getAttribute(x.getsearchHotel().getEnterTheCheckInDate()));
		// if (arg1.contains((CharSequence) x.getEnterTheCheckInDate())) {
		// System.out.println(arg1);
		// }
		org.junit.Assert.assertEquals("27/02/2019", getAttribute(x.getsearchHotel().getEnterTheCheckOutDate()));
	}

	// sce4
 	
 	@Given("^To verify whether Check-in date and Check Out date$")
 	public void to_verify_whether_Check_in_date_and_Check_Out_date() throws Throwable {
 		geturl("https://adactin.com/HotelAppBuild2");
 	}
 	
 	@Given("^location displayed verify the whether check the system get in url$")
 	public void location_displayed_verify_the_whether_check_the_system_get_in_url() throws Throwable {
 		geturl("https://adactin.com/HotelAppBuild2");
 	}
 	
	@Given("^user enter the room location scenario four \"([^\"]*)\"$")
	public void user_enter_the_room_location_scenario_four(String arg1) throws Throwable {
		// searchHotel x = new searchHotel(driver);
		sendKeys(x.getsearchHotel().getSelectThelocation(), arg1);
	}

	@Given("^Enter check-in-date as in test data \"([^\"]*)\"$")
	public void enter_check_in_date_as_in_test_data(String arg1) throws Throwable {
		// searchHotel x = new searchHotel(driver);
		sendKeys(x.getsearchHotel().getEnterTheCheckInDate(), arg1);
	}

	@Given("^Enter check-out-date as in test data \"([^\"]*)\"$")
	public void enter_check_out_date_as_in_test_data(String arg1) throws Throwable {
		// searchHotel x = new searchHotel(driver);
		sendKeys(x.getsearchHotel().getEnterTheCheckOutDate(), arg1);
	}

	@Given("^user eneter the children per room in forth scenario$")
	public void user_eneter_the_children_per_room_in_forth_scenario() throws Throwable {
		// searchHotel x = new searchHotel(driver);
		selectOptionDD(x.getsearchHotel().getSelectThechildPerRoom(), "Index", "0");
	}

	@Then("^Verify that hotel displayed is the same as selected in search Hotel form\"([^\"]*)\"$")
	public void verify_that_hotel_displayed_is_the_same_as_selected_in_search_Hotel_form(String arg1) throws Throwable {
		// selectHotel x = new selectHotel(driver);
		org.junit.Assert.assertEquals(arg1, getAttribute(x.getselectHotel().getCheckTheLocation()));
	}

	// sce5
	
	@Given("^To verify whether Check-in date and Check Out date launch the url$")
	public void to_verify_whether_Check_in_date_and_Check_Out_date_launch_the_url() throws Throwable {
		geturl("https://adactin.com/HotelAppBuild2");
	}

	@Then("^Check-in-date and check-outdate should be displayed according to the data entered \"([^\"]*)\",\"([^\"]*)\"$")
	public void check_in_date_and_check_outdate_should_be_displayed_according_to_the_data_entered(String arg1, String arg2) throws Throwable {
	  
		// selectHotel x = new selectHotel(driver);
		org.junit.Assert.assertEquals(arg1, getAttribute(x.getselectHotel().getCheckTheArrivalDate()));
		org.junit.Assert.assertEquals(arg2, getAttribute(x.getselectHotel().getCheckTheDepatureDate()));

	}

	
}

// sce12
