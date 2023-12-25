package pages;

import components.Header;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "https://github.com");

        driver.get(URL);
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
