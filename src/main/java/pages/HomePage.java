package pages;

import components.Header;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public final String URL = "https://github.com";

    // TODO decide what to do with content depending on if logged in or not
    public HomePage(WebDriver driver, WebDriverWait wait, boolean isLoggedIn) {
        super(driver, wait);

        driver.get(URL);

        if (isLoggedIn) {
            // make some things visible
        }
        else {
            // make other things visible
        }
    }

    public Header getHeader() {
        return new Header(driver, wait);
    }

    public HomePage searchText(String text) {
        getHeader().getSearchButton()
                .click();

        getHeader().getSearchInput()
                .setText(text)
                .pressKey(Keys.ENTER);

        return this;
    }
}
