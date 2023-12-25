package ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import settings.EnvReader;

import java.time.Duration;

public class BaseUITest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;
    @BeforeMethod
    public void beforeMethod() {
        logger  = LogManager.getLogger();

        if(EnvReader.getIsHeadless()) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);

            logger.info("Created driver in headless mode");
        }
        else {
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            logger.info("Created driver in full mode");
        }

         wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}

