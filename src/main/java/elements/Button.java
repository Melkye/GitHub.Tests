package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button extends BaseElement {
    public Button(String xPath, WebDriver driver, WebDriverWait wait) {
        super(xPath, driver, wait);
    }
}
