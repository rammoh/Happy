package com.cucumber.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.helper.fileReaderManager;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver browserLaunch(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("WebDriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\Driver\\geckoDriver.exe");
			} else {
				throw new Exception("Browser name id not valid");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		return driver;
	}

	public static void geturl(String url) throws Throwable {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			long implicitlywait = fileReaderManager.getInstance().getconfigReader().getImplicitlywait();
			driver.manage().timeouts().implicitlyWait(implicitlywait, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static boolean elementIsDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return displayed;
	}

	public static boolean elementIsEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static boolean elementIsSelected(WebElement element) {
		try {
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void waitUntilElementVisibility(WebElement element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 20);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementIsClear(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void sendKeys(WebElement element, String value) {
		try {
			waitUntilElementVisibility(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.sendKeys(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static String getText(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			String text = element.getText();
			return text;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static String getAttribute(WebElement element) {
		String attribute = null;
		try {
			// waitUntilElementVisibility(element);
			attribute = element.getAttribute("value");
			System.out.println(attribute);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return attribute;
	}

	public static String getTitle() {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static void selectOptionDD(WebElement element, String options, String value) {
		try {
			waitUntilElementVisibility(element);
			Select sc = new Select(element);
			if (options.equalsIgnoreCase("value")) {
				sc.selectByValue(value);
			} else if (options.equalsIgnoreCase("visiblrtext")) {
				sc.selectByVisibleText(value);
			} else if (options.equalsIgnoreCase("Index")) {
				sc.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void moveToElement(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void dragAndDrop(WebElement element, WebElement target) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.dragAndDrop(element, target).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementClick(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void doubleClick(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void contextClick(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementClickUsingActions(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.click(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void elementInputValueUsingActions(WebElement element, String value) {
		try {
			waitUntilElementVisibility(element);
			Actions ac = new Actions(driver);
			ac.sendKeys(element, value).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void scrollUpandDownUsingElement(WebElement element) {
		try {
			waitUntilElementVisibility(element);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void scroolUpandDownCoordinates(String width, String height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + width + "," + height + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void scrollBottomOfPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void takeScreenShot(String fileName) {
		try {
			File f = new File(System.getProperty("user.dir") + "\\cucumber.Adactin\\src\\lib" + fileName + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(temp, f);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void scroolToBottomPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void waitForAlertIsPresent() {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 50);
			wb.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void simpleAlert() {
		try {
			waitForAlertIsPresent();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void confirmAlert(String option) {
		try {
			waitForAlertIsPresent();
			Alert alert = driver.switchTo().alert();
			if (option.equalsIgnoreCase("confirm")) {
				alert.accept();
			} else if (option.equalsIgnoreCase("Dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void promptAlert(String options, String values) {
		try {
			waitForAlertIsPresent();
			Alert alert = driver.switchTo().alert();
			if (options.equalsIgnoreCase("confirm")) {
				alert.sendKeys(values);
				alert.accept();
			} else if (options.equalsIgnoreCase("Dismiss")) {
				alert.sendKeys(values);
				alert.dismiss();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void navigateToUrl(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void switchToIframe(String options, Object value) {
		try {
			if (options.equalsIgnoreCase("Index")) {
				driver.switchTo().frame(Integer.parseInt((String) value));
			} else if (options.equalsIgnoreCase("name")) {
				driver.switchTo().frame((String) value);
			} else if (options.equalsIgnoreCase("element")) {
				driver.switchTo().frame((WebElement) value);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
