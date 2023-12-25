package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.EnvReader;

import java.time.Duration;

public class BaseUITest {
    protected WebDriver driver = new ChromeDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    protected EnvReader envReader = new EnvReader();
}
