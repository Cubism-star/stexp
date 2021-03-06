// Generated by Selenium IDE
package st.exp2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Before;
import org.junit.BeforeClass;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Parameterized.class)
public class GetgitrepoTest {
	private static WebDriver driver;
	private static Map<String, Object> vars;
	static JavascriptExecutor js;
	String userNumber;
	String passWord;

	@Parameters
	public static Collection prepareData() throws EncryptedDocumentException, IOException {
		String filePath = System.getProperty("user.dir") + "/test/st/exp2/Selenium+Lab2020.xlsx";
		ReadExcel readExcel = new ReadExcel();
		Workbook workbook = readExcel.readData(filePath);
		Object[][] results = readExcel.getData(workbook, 20, 2);
		return Arrays.asList(results);
	}

	public GetgitrepoTest(String userNumber, String passWord) {
		// TODO Auto-generated constructor stub
		System.out.println("constructor");
		this.userNumber = userNumber;
		this.passWord = passWord;
	}

	@BeforeClass
	public static void setUp() {
		String driverPath = System.getProperty("user.dir") + "/src/driver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void getgitrepo() {
		// Test name: get git-repo
		// Step # | name | target | value
		// 1 | open | http://103.120.226.190/selenium-demo/git-repo |
		driver.get("http://103.120.226.190/selenium-demo/git-repo");
		// 2 | type | name=user_number | 3017218053
		// input User Number
		driver.findElement(By.name("user_number")).sendKeys(this.userNumber);
		// 3 | type | name=password | https://gitee.com/chenkuochih/software_test.git\n
		// input Password
		driver.findElement(By.name("password")).sendKeys(this.passWord);
		// 4 | click | css=.btn |
		// Query
		driver.findElement(By.cssSelector(".btn")).click();
		// 5 | assertText | css=.mb-2:nth-child(6) > code |
		// https://gitee.com/chenkuochih/software_test.git
		// get text
//		System.out.println(driver.findElement(By.cssSelector(".mb-2:nth-child(6) > code")).getText());
		assertThat(driver.findElement(By.cssSelector(".mb-2:nth-child(6) > code")).getText(),is(this.passWord));
	}
}
