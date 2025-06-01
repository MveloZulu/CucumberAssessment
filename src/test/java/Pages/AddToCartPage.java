package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage {

    WebDriver driver;

//    @FindBy(css = ".btn-success")
//    WebElement addToCart_xpath;

    @FindBy(id = "cartur")
    WebElement cartButton_id;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        //addToCart_xpath.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Add to cart']")
        ));
        addToCartBtn.click();
        //System.out.println("✅ 'Add to cart' button clicked.");

    }

    public void verifyPopUpMessageDisplays() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        if (alertText.equals("Product added")) {
            System.out.println("✅ Alert message is correct: " + alertText);
        } else {
            System.out.println("❌ Unexpected alert message: " + alertText);
        }
    }

    public void clickOnOkayButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.accept(); // Clicks the "OK" button on the alert
        System.out.println("✅ Clicked OK on the alert");
    }

    public void addToCart() {
        cartButton_id.click();
    }
}
