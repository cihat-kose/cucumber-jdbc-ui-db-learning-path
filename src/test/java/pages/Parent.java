package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.GWD;

import java.time.Duration;

public class Parent {
    public WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    public JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

    public void loginContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
    }

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Waits for the given WebElement to contain the expected text.
     * Handles potential StaleElementReferenceException and NoSuchElementException
     * that may occur due to dynamic DOM updates (e.g. toast messages, popups).
     *
     * @param element      The WebElement to check
     * @param expectedText The text expected to be contained in the element
     */
    public void verifyContainsText(WebElement element, String expectedText) {
        // Create a FluentWait instance with a timeout of 10 seconds and polling every 300 ms
        FluentWait<WebDriver> waitWithRetry = new FluentWait<>(GWD.getDriver())
                .withTimeout(Duration.ofSeconds(10))             // total wait time
                .pollingEvery(Duration.ofMillis(300))              // check every 300ms
                .ignoring(StaleElementReferenceException.class)    // ignore stale element errors
                .ignoring(NoSuchElementException.class);           // ignore element not found errors

        // The condition we're waiting for: the element should contain the expected text
        boolean result = waitWithRetry.until(driver -> {
            try {
                return element.isDisplayed() &&
                        element.getText().toLowerCase().contains(expectedText.toLowerCase());
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                return false; // keep trying
            }
        });

        // If the condition was never met, fail the test
        Assert.assertTrue(result, "Expected text not found in element.");

        // Send ESC to close any remaining popup/toast messages
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void myJsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        js.executeScript("arguments[0].click();", element);
    }
}