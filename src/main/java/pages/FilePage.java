package pages;

import elements.TextArea;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilePage extends BasePage{
    public FilePage(WebDriver driver, WebDriverWait wait, String URL) {
        super(driver, wait, URL);
    }

    public String getFileContent() {
        String fileTestAreaXPath = "//textarea[@id=\"read-only-cursor-text-area\"]";

        TextArea textArea = new TextArea(fileTestAreaXPath, driver, wait);

        return textArea.getText();
    }
}
