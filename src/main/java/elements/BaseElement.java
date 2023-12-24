package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


public class BaseElement {
    protected String xPath;
    // TODO change for browser?
    protected WebDriver driver;
    // TODO use implicit wait defined in webDriver?
    // TODO why no?
    // TODO implicit vs explicit
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

    // TODO make this work
    public boolean isVisible() {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        }
        catch (Exception ElementNotInteractableException) {
            return false;
        }
        return true;
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
