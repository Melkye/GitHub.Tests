package pages;

import com.github.dockerjava.api.model.Repository;
import elements.Anchor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver, WebDriverWait wait, String URL) {
        super(driver, wait, URL);
    }

    private Anchor getRepositoryAnchor(String repositoryTitle) {
        String foundRepoAnchorXPath = String.format("//a[contains(@href, \"%s\")]", repositoryTitle);

        return new Anchor(driver, wait, foundRepoAnchorXPath);
    }

    public RepositoryPage openRepository(String repositoryTitle) {

        Anchor foundRepoAnchor = getRepositoryAnchor(repositoryTitle);
        String URL = foundRepoAnchor.go();

        return new RepositoryPage(driver, wait, URL);
    }

}
