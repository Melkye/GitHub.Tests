package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class RepoUITest extends BaseUITest {

    // TODO move this out to separate file?
    // TODO configure env loading into class in before test
    // static constructor
    @DataProvider(name = "searchDataProvider")
    public Object[][] createData1() {
        return new Object[][] {
                { "Melkye/GitHub.Tests"},
        };
    }

    @Test(dataProvider = "searchDataProvider")
    public void HomeTest(String searchText) throws InterruptedException {

        LoginPage page = new LoginPage(driver, wait);

        // TODO move out login data to separate class
        HomePage homePage = page.login("AbubaAbubakar", "otpbank1234");
        homePage.searchText(searchText);

        // TODO create SearchResultPage class and corresponsing methods
        //SearchResultPage searchResultPage = new SearchResultPage(driver, wait);
        String foundRepoAnchorXPath = String.format("//a[contains(@href, \"%s\")]", searchText);

        // searchResultPage.getOneResultUrlByXPath(foundRepoXPath)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(foundRepoAnchorXPath)));
        // TODO implement WebElement in BaseElement(?)
        WebElement foundRepo = driver.findElement(By.xpath(foundRepoAnchorXPath));
        foundRepo.click();

        // TODO create RepoPage class and corresponsing methods
        //RepoPage repoPage = new RepoPage(driver, wait);
        String fileUrlAnchorXPath = "//td[contains(@class, \"large-screen\")]//a[contains(@href, \"pom.xml\")]";

        // repoPage.openFileOrDirectory(fileUrlAnchorXPath)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fileUrlAnchorXPath)));
        WebElement fileUrlAnchor = driver.findElement(By.xpath(fileUrlAnchorXPath));
        fileUrlAnchor.click();

        // TODO create FilePage class and corresponsing methods
        //FilePage filePage = new FilePage(driver, wait);
        String fileTestAreaXPath = "//textarea[@id=\"read-only-cursor-text-area\"]";

        // TODO find out whether getting the while file is ok
        // filePage.getFileContent(fileTestAreaXPath)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(fileTestAreaXPath)));
        WebElement fileTextArea = driver.findElement(By.xpath(fileTestAreaXPath));
        String fileTestAreaValue = fileTextArea.getAttribute("value");

        String testngExpectedDependency = """
                        <dependency>
                            <groupId>org.testng</groupId>
                            <artifactId>testng</artifactId>
                            <version>7.8.0</version>
                            <scope>test</scope>
                        </dependency>
                """;

        // TODO use assertion library like FluentAssertions
        Assert.assertTrue(fileTestAreaValue.contains(testngExpectedDependency));
    }
}
