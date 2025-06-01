package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PlaceOrderPage {

    WebDriver driver;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseButton_xpath;

    @FindBy(id = "name")
    WebElement nameField_id;

    @FindBy(id ="country")
    WebElement countryField_id;

    @FindBy(id = "city")
    WebElement cityField_id;

    @FindBy(id = "card")
    WebElement cardField_id;

    @FindBy(id="month")
    WebElement monthField_id;

    @FindBy(id="year")
    WebElement yearField_id;

    public PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPurchaseWithoutDetails() {
        // Click the 'Purchase' button without entering any details
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // purchaseButton_xpath.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement purchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Purchase']")));
        purchaseButton.click();
        System.out.println("✅ 'Purchase' button clicked without entering details.");
    }

    public void clickOkButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        System.out.println("✅ Clicked OK on the alert after clicking 'Purchase' without details.");
    }

    public void enterName(String name) {
        nameField_id.sendKeys(name);
        System.out.println("✅ Entered name: " + name);
    }
    public void enterCountry(String country) {
        countryField_id.sendKeys(country);
        System.out.println("✅ Entered country: " + country);
    }

    public void enterCity(String city) {
        cityField_id.sendKeys(city);
        System.out.println("✅ Entered city: " + city);
    }
    public void enterCard(Long card) {
        driver.findElement(By.id("card")).sendKeys(String.valueOf(card));
        //cardField_id.sendKeys(card);
        System.out.println("✅ Entered card: " + card);

    }
    public void enterMonth(String month) {
        monthField_id.sendKeys(month);
        System.out.println("✅ Entered month: " + month);
    }

    public void enterYear(String year) {
        yearField_id.sendKeys(year);
        System.out.println("✅ Entered year: " + year);
    }

    public void clickPurchaseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement purchaseButton = wait.until(ExpectedConditions.elementToBeClickable(purchaseButton_xpath));
        purchaseButton.click();
        System.out.println("✅ 'Purchase' button clicked with details.");
    }


}
