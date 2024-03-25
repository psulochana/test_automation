package stepdefinitionfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusable.Utils;

public class StepDefenitions {
    private WebDriver driver;

    @Given("User navigates to ecommerce login page url {string} using {string} browser")
    public void userNavigatesToecommerceLoginPageUrlUsingBrowser(String url, String browserName) {
        driver = Utils.launchBrowser(browserName);
        driver.navigate().to(url);
    }

    @When("User enters the username {string} and password {string}")
    public void userEntersTheUsernameAndPassword(String userName, String passWord) {
        Utils.elementWait(driver, By.id("nav-link-accountList"));
        driver.findElement(By.id("nav-link-accountList")).click();
        Utils.elementWait(driver, By.id("ap_email"));
        driver.findElement(By.id("ap_email")).sendKeys(userName);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.name("password")).sendKeys(passWord);

    }

    @And("User click login button")
    public void userClickLoginButton() throws InterruptedException {
        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(10000);
    }

    @And("Validate the login page")
    public void validateTheLoginPage() {
        WebElement text = driver.findElement(By.partialLinkText("Hello, User"));
        if (text.isDisplayed()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse("not displayed", false);
        }
    }

    @And("User have to search for {string} and select {string} phone on listing page")
    public void userHaveToSearchForAndSelectPhoneOnListingPage(String mobileModel, String size) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(mobileModel);
        driver.findElement(By.id("nav-search-submit-button")).click();
        Utils.elementWait(driver, By.partialLinkText("Apple " + mobileModel + ", " + size + ", Black - "));
        driver.findElement(By.partialLinkText("Apple " + mobileModel + ", " + size + ", Black - ")).click();

    }

    @And("Add the product to cart and validate if the product added and available in Cart")
    public void addTheProductToCartAndValidateIfTheProductAddedAndAvailableInCart() {
        Utils.elementWait(driver, By.id("add-to-cart-button"));
        driver.findElement(By.id("add-to-cart-button")).click();
        try {
            driver.findElement(By.id("attachSiNoCoverage-announce")).click();
        } catch (Exception e) {
            System.out.println("No Thanks button not present");
        }
    }

    @And("Add a new address for shipping and proceed to checkout page then validate it")
    public void addANewAddressForShippingAndProceedToCheckoutPageThenValidateIt() {
        Utils.elementWait(driver, By.name("proceedToRetailCheckout"));
        driver.findElement(By.name("proceedToRetailCheckout")).click();

        try {
            driver.findElement(By.id("primepanel_nothanks-truespc")).click();
        } catch (Exception e) {
            System.out.println("Not right now not present");
        }
        driver.findElement(By.id("addressChangeLinkId")).click();
        Utils.elementWait(driver, By.id("add-new-address-popover-link"));
        driver.findElement(By.id("add-new-address-popover-link")).click();

        String result = driver.findElement(By.xpath("//*[@class='displayAddressDiv']")).getText();

        Assert.assertTrue(result.contains("TESTING DR"));
    }
}
