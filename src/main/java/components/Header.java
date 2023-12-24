package components;

import elements.Button;
import elements.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BaseComponent {

    public Header(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // burger menu
    // github logo
    // dashboard button

    // search button (present)
    // create-new button
    // issues button
    // pull requests button
    // notifications button
    // account button

    public Button getSearchButton() {
        return new Button("//*[contains(@class, \"AppHeader-searchButton\")]",
                driver, wait);
    }

    public Header openSearch() {
        getSearchButton().click();
        return this;
    }

    public Input getSearchInput() {
        return new Input("//input[@id=\"query-builder-test\"]", driver, wait);
    }
}
