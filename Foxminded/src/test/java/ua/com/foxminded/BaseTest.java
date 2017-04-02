package ua.com.foxminded;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private static final String CHROME_BROWSER = "chrome";
    private static final String FIREFOX_BROWSER = "firefox";


    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUp(String browser) throws Exception {
        switch (browser) {
            case CHROME_BROWSER:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX_BROWSER:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }

        baseUrl = "https://www.google.com.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}

