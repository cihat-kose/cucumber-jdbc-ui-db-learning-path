package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import utilities.ExcelUtility;

import java.util.ArrayList;

public class _16_ApachePOISteps {

    DialogContent dialogContent = new DialogContent();

    @When("User create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {

        ArrayList<ArrayList<String>> table = ExcelUtility.getData("src/test/java/ApachePOI/resource/ApacheExcel.xlsx", "testCitizen", 2);

        for (int i = 0; i < table.size(); i++) {
            ArrayList<String> row = table.get(i);
            dialogContent.myClick(dialogContent.addButton);
            dialogContent.mySendKeys(dialogContent.nameInput, row.get(0));
            dialogContent.mySendKeys(dialogContent.shortName, row.get(1));
            dialogContent.myClick(dialogContent.saveButton);
            dialogContent.verifyContainsText(dialogContent.successMessage, "success");
        }
    }

    @Then("User delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {

        ArrayList<ArrayList<String>> table = ExcelUtility.getData("src/test/java/ApachePOI/resource/ApacheExcel.xlsx", "testCitizen", 2);

        for (int i = 0; i < table.size(); i++) {
            ArrayList<String> row = table.get(i);
            dialogContent.deleteItem(row.get(0));
            dialogContent.verifyContainsText(dialogContent.successMessage, "success");
        }
    }
}