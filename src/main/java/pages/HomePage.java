package pages;

import com.github.dockerjava.api.model.Repository;
import components.Header;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    // TODO decide what to do with content depending on if logged in or not
    public HomePage(WebDriver driver, WebDriverWait wait, boolean isLoggedIn) {
        super(driver, wait, "https://github.com");

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

    public SearchResultPage searchText(String text) {
        getHeader().getSearchButton()
                .click();

        getHeader().getSearchInput()
                .setText(text)
                .pressKey(Keys.ENTER);

        String URL = driver.getCurrentUrl();
        return new SearchResultPage(driver, wait, URL);
    }
}
