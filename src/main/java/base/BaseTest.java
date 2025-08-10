package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CSVReader;
import utils.Constants;

/*
 * This class initializes the browsers, extent report and handles test setup
 */
public class BaseTest {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	protected CSVReader data;
	
	protected void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}
	
	public static WebDriver getDriver() {
	    return driver.get();
	}
	
	//@BeforeTest
	private void setupExtentReport() {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "ExtentReport_" + getSystemDate() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("HostName", "Sauce Demo");
		extent.setSystemInfo("UserName", "root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation Test Resutls");
	}
	
	private void setupReadingCSV() throws IOException{
		//String path = "/saucedemo/src/test/java/resources/testdata.csv"; // needs update 
		InputStream is = getClass().getClassLoader().getResourceAsStream("testdata.csv");
		if (is == null) {
		    throw new FileNotFoundException("Could not find 'testdata.csv' in test resources.");
		}
        InputStreamReader isr = new InputStreamReader(is);
		data = new CSVReader(isr);
	}
	
	
	@BeforeTest
	public void beforeTestSetup() {
		setupExtentReport();
		try {
			setupReadingCSV();
		} catch (IOException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to load test data CSV", e);
	    }
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser, Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		
		setupDriver(browser);
		getDriver().manage().window().maximize();
		getDriver().get(Constants.url);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
		}
		
		getDriver().quit();
	}
	
	@AfterTest
	public void closeReport() {
		extent.flush();
	}
	
	private void setupDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
	}
	
	private String getSystemDate() {
		Date date = new Date(); 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss"); 
        String timestamp = sdf.format(date); 
        return timestamp;
	}
	
}
