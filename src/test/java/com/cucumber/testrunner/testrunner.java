package com.cucumber.testrunner;

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.cucumber.baseclass.BaseClass;
import com.cucumber.helper.fileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//junit used to run with cucumber.class
@CucumberOptions(features = "src/test/java/com/cucumber/feature/loginAdactin.feature",
glue = {"com.cucumber.stepdefinition" },
dryRun = false,
tags = {"@sce1,@sec2,@sec3"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:rc\\test\\resource\\library\\cucumber-reports\\report.html",
		  "pretty", "html:src\\test\\resource\\library",
		  "json:src\\test\\resource\\library\\cucumber.json",
		  "junit:src\\test\\resource\\library\\cucumber.xml"
		  }

)
//String browserName = fileReaderManager.getInstance().getconfigReader().getBrowserName();
// driver = BaseClass.browserLaunch(browserName);
	//dry run=false (if running time >>converted into method(print to console) +
//true= if running time converted into method only (print to console))
public class testrunner {
	public static WebDriver driver;

	@BeforeClass
	public static void openTheWebsite() throws Throwable {
		String browserName = fileReaderManager.getInstance().getconfigReader().getBrowserName();
		driver = BaseClass.browserLaunch(browserName);
	}

	@AfterClass
	public static void teardown() {
		new File(System.getProperty("user.dir") + "src\\test\\resource\\Resource\\extent-config.xml");
		driver.quit();
	}

}
