package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class LeftNav extends Parent {

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    public WebElement setup;
    @FindBy(xpath = "//span[text()='Parameters']")
    public WebElement parameters;
    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    public WebElement countries;
    @FindBy(xpath = "(//span[text()='Citizenships'])[1]")
    public WebElement citizenship;
    @FindBy(xpath = "(//span[text()='Inventory'])[1]")
    public WebElement inventory;
    @FindBy(xpath = "(//span[text()='Setup'])[4]")
    public WebElement setupInventory;
    @FindBy(xpath = "//span[text()='Item Categories']")
    public WebElement itemCategories;
    @FindBy(xpath = "(//span[text()='Cities'])[1]")
    public WebElement cities;
    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;
    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    private WebElement fees;
    @FindBy(xpath = "(//span[text()='States'])[1]")
    private WebElement states;

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    public WebElement getWebElement(String stringElement) {
        switch (stringElement) {
            case "setup":
                return this.setup;
            case "parameters":
                return this.parameters;
            case "countries":
                return this.countries;
            case "citizenship":
                return this.citizenship;
            case "nationalities":
                return this.nationalities;
            case "fees":
                return this.fees;
            case "itemCategories":
                return this.itemCategories;
            case "inventory":
                return this.inventory;
            case "setupInventory":
                return this.setupInventory;
            case "states":
                return this.states;
            case "cities":
                return this.cities;
        }
        return null;
    }
}