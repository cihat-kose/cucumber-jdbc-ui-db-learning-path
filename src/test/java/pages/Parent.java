package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        wait.until(ExpectedConditions.visibilityOf(element));
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

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void myJsClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        js.executeScript("arguments[0].click();", element);
    }

    // Left as an example
    public void verifyMessageContainsTextREVIEW(String value) {
        // Problem: Due to the message appearing and disappearing quickly,
        // it is difficult to use getText and perform an Assert.
        // Purpose: Find an alternative way to Assert the message on the element's location.

        // List<WebElement> MessageBoxElements=
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//hot-toast-container/div/div/div//*"), 0));
        // Wait until there is more than 1 element in the specified area, meaning the MESSAGE box is visible

//    System.out.println("MessageBoxElements.size() = " + MessageBoxElements.size());
//    for(WebElement e : MessageBoxElements)
//        System.out.println("->"+e.getText()+"<->"+e.getAccessibleName()+"<->"+e.getTagName());

        // WebElement MessageBoxParent1 = GWD.getDriver().findElement(By.xpath("//hot-toast-container/div/div/div"));
        WebElement MessageBoxParent2 = GWD.getDriver().findElement(By.tagName("mat-panel-description")); // mat-expansion-panel-header
//
//    System.out.println("MessageBoxParent2.getText() = " + MessageBoxParent2.getText()); // Visible text on the screen
//    System.out.println("MessageBoxParent2.getAccessibleName() = " + MessageBoxParent2.getAccessibleName()); // Provides accessible HTML info on the screen
//    System.out.println("MessageBoxParent2.getTagName() = " + MessageBoxParent2.getTagName()); // Tag name
//    System.out.println("MessageBoxParent2.getAttribute(innerHTML) = " + MessageBoxParent2.getAttribute("innerHTML")); // HTML code between tags

        Assert.assertTrue(MessageBoxParent2.getAttribute("innerHTML").toLowerCase().contains(value.toLowerCase()));
    }
}