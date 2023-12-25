package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Input extends BaseElement {
    public Input(String xPath, WebDriver driver, WebDriverWait wait) {
        super( driver, wait, xPath);
    }

    public Input setText(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

        driver.findElement(By.xpath(xPath)).sendKeys(text);

        logger.info(String.format("Set text to input. XPath: %s. Text: %s", xPath, text));

        return this;
    }
}
