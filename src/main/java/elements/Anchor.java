package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Anchor extends BaseElement {
    public Anchor(WebDriver driver, WebDriverWait wait, String xPath) {
        super(driver, wait, xPath);
    }

    // TODO decide what to do when repo not found
    public String go() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        driver.findElement(By.xpath(xPath)).click();

        return driver.getCurrentUrl();
    }
}
