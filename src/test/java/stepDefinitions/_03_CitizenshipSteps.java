package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import pages.DialogContent;
import pages.LeftNav;

public class _03_CitizenshipSteps {

    LeftNav leftNav = new LeftNav();
    DialogContent dialogContent = new DialogContent();
    Faker faker = new Faker();

    @And("Navigate to citizenship")
    public void navigateToCitizenship() {
        leftNav.myClick(leftNav.setup);
        leftNav.myClick(leftNav.parameters);
        leftNav.myClick(leftNav.citizenship);
    }

    @When("Create a citizenship")
    public void createACitizenship() {
        String citizenshipName = faker.nation().nationality() + " - " + faker.random().hex(3);
        String citizenshipShortCode = faker.random().hex(3);

        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, citizenshipName);
        dialogContent.mySendKeys(dialogContent.shortName, citizenshipShortCode);
        dialogContent.myClick(dialogContent.saveButton);
    }

    @When("Create a citizenship that name as {string} short name as {string}")
    public void createACitizenshipThatNameAsShortNameAs(String name, String shortName) {
        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, name);
        dialogContent.mySendKeys(dialogContent.shortName, shortName);
        dialogContent.myClick(dialogContent.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dialogContent.verifyContainsText(dialogContent.alreadyExist, "already");
    }

    @When("User delete the citizenship that name as {string}")
    public void userDeleteTheCitizenshipThatNameAs(String name) {
        dialogContent.deleteItem(name);
    }
}
