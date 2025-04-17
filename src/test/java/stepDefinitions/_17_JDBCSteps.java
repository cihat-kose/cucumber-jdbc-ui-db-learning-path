package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.DialogContent;
import utilities.DBUtility;

import java.util.List;

public class _17_JDBCSteps {

    DialogContent dialogContent = new DialogContent();

    @Then("Send the query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sql) {
        // Read from DB
        List<List<String>> dbList = DBUtility.getDataList(sql); // I read from db

        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i).get(0));          // I check the DB information I read
        }

        System.out.println("-------------------------");

        // Read from UI
        List<WebElement> UIList = dialogContent.nameList;
        for (int i = 0; i < UIList.size(); i++) {
            System.out.println(UIList.get(i).getText());       // I check the UI information I read
        }

        // Compare
        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i).get(0) + " - " + UIList.get(i).getText());
            Assert.assertEquals(dbList.get(i).get(0).trim(), UIList.get(i).getText().trim(), "Pairing failed");
        }
    }

    // Alternate way

    /**
     @Then("Send the query the database {string} and control match")
     public void sendTheQueryTheDatabaseAndControlMatch(String sql) {
     // Read data from the database
     List<List<String>> dbList = DBUtility.getDataList(sql);

     // Check if database list or UI list is empty
     if (dbList.isEmpty() || dialogContent.nameList.isEmpty()) {
     System.out.println("Database or UI list is empty! Test is terminating.");
     Assert.fail("Comparison cannot be performed as the database or UI list is empty.");
     return;
     }

     // Get the UI list and compare list sizes
     List<WebElement> UIList = dialogContent.nameList;
     Assert.assertEquals(dbList.size(), UIList.size(), "Database and UI list sizes do not match!");

     // Print database data for verification
     System.out.println("Database Data:");
     for (int i = 0; i < dbList.size(); i++) {
     System.out.println(dbList.get(i).get(0));
     }

     // Print UI data for verification
     System.out.println("UI Data:");
     for (int i = 0; i < UIList.size(); i++) {
     System.out.println(UIList.get(i).getText());
     }

     // Compare data between the database and UI
     for (int i = 0; i < dbList.size(); i++) {
     String dbData = dbList.get(i).get(0).trim();
     String uiData = UIList.get(i).getText().trim();
     System.out.println("Comparison: " + dbData + " - " + uiData);
     Assert.assertEquals(dbData, uiData, "Matching failed!");
     }
     }
     */
}

