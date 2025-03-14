package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

import java.util.List;

public class _09_DataTableSteps {

    LeftNav leftNav = new LeftNav();
    DialogContent dialogContent = new DialogContent();

    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable links) {
        List<String> linksList = links.asList();

        for (int i = 0; i < linksList.size(); i++) {
            String link = linksList.get(i);
            WebElement webElement = leftNav.getWebElement(link);
            leftNav.myClick(webElement);
        }
    }

    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialog(DataTable buttons) {
        List<String> buttonsList = buttons.asList();

        for (int i = 0; i < buttonsList.size(); i++) {
            String button = buttonsList.get(i);
            WebElement webElement = dialogContent.getWebElement(button);
            dialogContent.myClick(webElement);
        }
    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable dataTable) {
        List<List<String>> items = dataTable.asLists();

        for (int i = 0; i < items.size(); i++) {
            WebElement webElement = dialogContent.getWebElement(items.get(i).get(0)); // 0. Web Element
            dialogContent.mySendKeys(webElement, items.get(i).get(1));
        }
        // Click on the body element to close popups, dropdowns, or reset the UI state
        // new Actions(GWD.getDriver()).click(GWD.getDriver().findElement(By.tagName("body"))).perform();
    }

    @And("User delete the element from Dialog")
    public void userDeleteTheElementFromDialog(DataTable dataTable) {
        List<String> willBeDeleted = dataTable.asList();

        for (int i = 0; i < willBeDeleted.size(); i++) {
            String s = willBeDeleted.get(i);
            dialogContent.deleteItem(s);
        }
    }
}