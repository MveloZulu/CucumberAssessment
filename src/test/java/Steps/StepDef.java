package Steps;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class StepDef extends Base {

    @Given("I am on the product store page")
    public void i_am_on_the_product_store_page() {
        productStorePage.VerifyUserIsOnProductStorePage();

    }

    @When("I click on the laptops")
    public void i_click_on_the_laptops() {
        productStorePage.clickOnLaptops();

    }

    @And("I click on first laptop")
    public void i_click_on_first_laptop() {
        productStorePage.clickOnSonyVaio();
    }


    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        addToCartPage.clickAddToCart();
    }
    

    @Then("I should see the pop up message")
    public void iShouldSeeThePopUpMessage() {
        addToCartPage.verifyPopUpMessageDisplays();
    }

    @When("I click ok button")
    public void iClickOkButton() {
        addToCartPage.clickOnOkayButton();
    }

    @And("I click on add to cart link")
    public void iClickOnAddToCartLink() {
        addToCartPage.addToCart();
    }

    @Then("I should see the item in my cart")
    public void iShouldSeeTheItemInMyCart() {
        productsPage.verifySonyVaioProductIsDisplayed();

    }

    @When("I click on the place order button")
    public void iClickOnThePlaceOrderButton() {
        productsPage.clickPlaceOrderButton();
    }

    @And("I click on purchase button without entering any details")
    public void iClickOnPurchaseButtonWithoutEnteringAnyDetails() {
        placeOrderPage.clickPurchaseWithoutDetails();
    }

//    @Then("I should see the error message")
//    public void iShouldSeeTheErrorMessage() {
//        placeOrderPage.clickOkButton();
//    }

    @And("I click on ok button")
    public void iClickOnOkButton() {
        placeOrderPage.clickOkButton();
    }

    @And("I enter my name (.*)$")
    public void iEnterMyNameName(String name) {
        placeOrderPage.enterName(name);
    }

    @And("I enter country (.*)$")
    public void iEnterCountryCountry(String country) {
        placeOrderPage.enterCountry(country);
    }

    @And("I enter city (.*)$")
    public void iEnterCityCity( String city) {
        placeOrderPage.enterCity(city);

    }

    @And("I enter credit card number {long}")
    public void iEnterCreditCardNumberCreditCardNumber(Long cardNumber) {
        placeOrderPage.enterCard(cardNumber);
    }

    @And("I enter month {int}")
    public void iEnterMonthMonth(Integer month) {
        placeOrderPage.enterMonth(String.valueOf(month));
    }

    @And("I enter year {int}")
    public void iEnterYearYear(Integer year) {
        placeOrderPage.enterYear(String.valueOf(year));
    }

    @And("I click on purchase button")
    public void iClickOnPurchaseButton() {
        placeOrderPage.clickPurchaseButton();
    }

    @Then("I should see the purchase confirmation message")
    public void iShouldSeeThePurchaseConfirmationMessage() {
        confirmPage.confirmationMessageDisplays();
    }

    @And("I click okay button")
    public void iClickOkayButton() {
        confirmPage.clickOkayButton();
    }


    @Then("I should see the product store page")
    public void iShouldSeeTheProductStorePage() {
//        placeOrderPage.closeModal();
        confirmPage.verifyTheProductStorePageDisplays();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }


}
