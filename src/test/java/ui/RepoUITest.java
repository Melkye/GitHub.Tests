package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.util.Dictionary;

public class RepoUITest extends BaseUITest {
    // TODO change repo title when switch to another acc
    @DataProvider(name = "searchDataProvider")
    public Object[][] createData1() {
        return new Object[][] {
                { "Melkye/GitHub.Tests", "testng", "7.8.0"},
        };
    }

    @Test(dataProvider = "searchDataProvider")
    public void DependencyHasRightVersionTest(String searchText, String dependencyTitle, String dependencyVersion) {

        String dependenciesFilename = "pom.xml";

        LoginPage page = new LoginPage(driver, wait);

        HomePage homePage = page.login(envReader.getUsername(), envReader.getPassword());

        SearchResultPage searchResultPage = homePage.searchText(searchText);

        RepositoryPage repoPage = searchResultPage.openRepository(searchText);

        FilePage filePage = repoPage.openFile(dependenciesFilename);

        String fileTextAreaValue = filePage.getFileContent();

        HashMap<String, String> dependencies = parseDependencies(fileTextAreaValue);
        // TODO print dependencies to console

        Assert.assertEquals(dependencies.get(dependencyTitle), dependencyVersion);
        // TODO decide how to close window
        driver.close();
    }

    private HashMap<String, String> parseDependencies(String fileTextAreaValue) {
        String regex = "<artifactId>([\\S]*)</artifactId>[\\n] *<version>([\\d.]*)</version>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fileTextAreaValue);

        logger.info("Dependencies:");

        HashMap<String, String> dependencies = new HashMap<String, String>();
        while(matcher.find()) {
            String artifactId = matcher.group(1);
            String version = matcher.group(2);

            dependencies.put(artifactId, version);

            String logMessage = String.format("ArtifactId: %s, Version: %s", artifactId, version);
            logger.info(logMessage);
        }
        return dependencies;
    }
}
