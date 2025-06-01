package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;

//    @FindBy(xpath = "//td[contains(text(), 'Sony vaio i5')]")
//    WebElement sonyVaioProduct_xpath;

    @FindBy(xpath = "//button[contains(.,'Place Order')]")
    WebElement placeOrderButton_xpath;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifySonyVaioProductIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(), '" +  "')]")));
        assert product.isDisplayed();
    }

    public void clickPlaceOrderButton() {
        placeOrderButton_xpath.click();
        System.out.println("✅ 'Place Order' button clicked.");
    }
}
