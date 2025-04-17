package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

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
        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, countryName);
        dialogContent.mySendKeys(dialogContent.codeInput, countryCode);
        dialogContent.myClick(dialogContent.saveButton);
    }

    @When("Create a unique country based on name {string} and code {string}") // Parameterized but unique
    public void createCountryWithParamButGenerateUnique(String baseName, String baseCode) {
        String uniqueSuffix = String.valueOf(System.currentTimeMillis() % 100000);

        String countryName = baseName + " - " + faker.country().name() + " - " + uniqueSuffix;
        String countryCode = baseCode + "-" + faker.country().countryCode3() + uniqueSuffix;

        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, countryName);
        dialogContent.mySendKeys(dialogContent.codeInput, countryCode);
        dialogContent.myClick(dialogContent.saveButton);
    }

    @When("User delete the country that name as {string}")
    public void userDeleteTheCountryThatNameAs(String name) {
        GWD.getDriver().navigate().refresh(); // It was put due to a system/software side error of Country.
        dialogContent.deleteItem(name);
    }
}