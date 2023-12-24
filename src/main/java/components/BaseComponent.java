package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseComponent(WebDriver webDriver, WebDriverWait wait) {
        this.driver = webDriver;
        this.wait = wait;
    }

//    public boolean isVisible() {
//
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
//        }
//        catch (Exception ElementNotInteractableException) {
//            return false;
//        }
//        return true;
//    }
}
