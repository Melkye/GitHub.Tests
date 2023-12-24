package pages;

import elements.Anchor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepositoryPage extends BasePage {
    public RepositoryPage(WebDriver driver, WebDriverWait wait, String URL) {
        super(driver, wait, URL);
    }

    public FilePage openFile(String filename) {
        String fileUrlAnchorXPath = String.format("//td[contains(@class, \"large-screen\")]//a[contains(@href, \"%s\")]",
                filename);

        Anchor fileUrlAnchor = new Anchor(driver, wait, fileUrlAnchorXPath);
        String fileURL = fileUrlAnchor.go();

        return new FilePage(driver, wait, fileURL);
    }
}
