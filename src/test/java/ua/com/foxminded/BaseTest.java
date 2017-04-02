package ua.com.foxminded;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
//       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//       driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
       driver = new FirefoxDriver();
       baseUrl = "https://www.google.com.ua/";
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}

