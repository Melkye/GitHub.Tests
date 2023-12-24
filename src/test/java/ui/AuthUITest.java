package ui;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AuthUITest extends BaseUITest {
    // TODO move this out to separate file?
    // TODO configure env loading into class in before test
    // static constructor
    @DataProvider(name = "loginDataProvider")
    public Object[][] createData1() {
        return new Object[][] {
                { "AbubaAbubakar", "otpbank1234"},
        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void LoginTest(String username, String password) {
        LoginPage page = new LoginPage(driver, wait);

        page.login(username, password);

        // check name in account sidebar

        String urlCur = driver.getCurrentUrl();
        Assert.assertEquals(urlCur, "https://github.com/");

        driver.close();
        driver.quit();
    }
}
