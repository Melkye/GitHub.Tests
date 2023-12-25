package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AuthUITest extends BaseUITest {

    // TODO decide how to test multipe login credentials
    @Test
    public void LoginTest() {
        LoginPage page = new LoginPage(driver, wait);

        page.login(envReader.getUsername(), envReader.getPassword());

        // check name in account sidebar

        String urlCur = driver.getCurrentUrl();
        Assert.assertEquals(urlCur, "https://github.com/");

        driver.close();
        driver.quit();
    }
}
