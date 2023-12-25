package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String URL;

    protected Logger logger;

    public BasePage(WebDriver driver, WebDriverWait wait, String URL) {
        this.driver = driver;
        this.wait = wait;
        this.URL = URL;

        logger = LogManager.getLogger();
    }
}