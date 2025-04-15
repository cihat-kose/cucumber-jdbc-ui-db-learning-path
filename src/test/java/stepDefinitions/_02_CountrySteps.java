package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import pages.DialogContent;
import pages.LeftNav;

public class _02_CountrySteps {

    DialogContent dialogContent = new DialogContent();
    LeftNav leftNav = new LeftNav();
    Faker faker = new Faker();

    @And("Navigate to country")
    public void navigateToCountry() {
        leftNav.myClick(leftNav.setup);
        leftNav.myClick(leftNav.parameters);
        leftNav.myClick(leftNav.countries);
    }

    @When("Create a country")
    public void createACountry() {
        String countryName = faker.country().name() + " - " + faker.country().countryCode3();
        String countryCode = faker.country().countryCode3();

        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, countryName);
        dialogContent.mySendKeys(dialogContent.codeInput, countryCode);
        dialogContent.myClick(dialogContent.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dialogContent.verifyContainsText(dialogContent.successMessage, "success");
    }

    @When("Create a country that name as {string} code as {string}")
    public void createACountryThatNameAsCodeAs(String countryName, String countryCode) {
        countryName = "RandomCountry" + " - " + faker.country().name() + " - " + faker.country().countryCode3();
        countryCode = "RandomCode" + faker.country().countryCode3();

        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, countryName);
        dialogContent.mySendKeys(dialogContent.codeInput, countryCode);
        dialogContent.myClick(dialogContent.saveButton);
    }
}