package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String URL;

    public BasePage(WebDriver driver, WebDriverWait wait, String URL) {
        this.driver = driver;
        this.wait = wait;
        this.URL = URL;
    }
}