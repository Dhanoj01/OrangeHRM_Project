package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {

        // Load configuration file
        ConfigReader.loadProperties();

        // Get browser from config.properties
        String browser = ConfigReader.getProperty("browser");

        // Start Chrome
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        // Maximize browser
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open OrangeHRM
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        // Close browser after test
        if (driver != null) {
           // driver.quit();
        }
    }
}