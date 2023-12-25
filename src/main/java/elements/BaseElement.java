package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


public class BaseElement {
    protected String xPath;
    protected WebDriver driver;
    // TODO use implicit wait defined in webDriver? why no? implicit vs explicit
    protected WebDriverWait wait;
    public BaseElement(WebDriver driver, WebDriverWait wait, String xPath) {
        this.driver = driver;
        this.wait = wait;
        this.xPath = xPath;
    }

    public BaseElement click() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

        driver.findElement(By.xpath(xPath)).click();

        return this;
    }

    public BaseElement pressKey(Keys key) {

        var actions = new Actions(driver);

        actions.click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath))))
                .keyDown(key)
                .keyUp(key)
                .build()
                .perform();

        return this;
    }
}
