package reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static WebDriver launchBrowser(String browserName) {
        WebDriver localDriver;
        if (browserName.equalsIgnoreCase("Chrome")) {
            localDriver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            localDriver = new FirefoxDriver();
        } else {
            throw new InvalidArgumentException("Invalid Browser");
        }
        localDriver.manage().window().maximize();
        return localDriver;
    }

    public static void elementWait(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void dropdownHandle(WebDriver driver, By locator, String countryName) {
        WebElement country = driver.findElement(locator);
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText(countryName);
    }
}