package ui;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class RepoUITest extends BaseUITest {

    // TODO move this out to separate file?
    // TODO configure env loading into class in before test
    // static constructor
    @DataProvider(name = "searchDataProvider")
    public Object[][] createData1() {
        return new Object[][] {
                { "Melkye/GitHub.Tests", """
                        <dependency>
                            <groupId>org.testng</groupId>
                            <artifactId>testng</artifactId>
                            <version>7.8.0</version>
                            <scope>test</scope>
                        </dependency>
                """},
        };
    }

    @Test(dataProvider = "searchDataProvider")
    public void DependencyHasRightVersionTest(String searchText, String dependency) {

        String dependenciesFilename = "pom.xml";

        LoginPage page = new LoginPage(driver, wait);

        // TODO move out login data to separate class
        HomePage homePage = page.login("AbubaAbubakar", "otpbank1234");

        SearchResultPage searchResultPage = homePage.searchText(searchText);

        RepositoryPage repoPage = searchResultPage.openRepository(searchText);

        FilePage filePage = repoPage.openFile(dependenciesFilename);

        String fileTestAreaValue = filePage.getFileContent();

        // TODO use assertion library like FluentAssertions
        Assert.assertTrue(fileTestAreaValue.contains(dependency));

        driver.close();
    }
}
