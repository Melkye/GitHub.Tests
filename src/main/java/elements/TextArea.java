package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextArea extends BaseElement {
    public TextArea(String xPath, WebDriver driver, WebDriverWait wait) {
        super( driver, wait, xPath);
    }

    public String getText() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));

        String text = driver.findElement(By.xpath(xPath)).getAttribute("value");

        logger.info(String.format("Got text from textarea. XPath: %s. Text: %s", xPath, text));

        return text;
    }
}
