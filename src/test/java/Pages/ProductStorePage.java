package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductStorePage {

    WebDriver driver;

    private WebDriverWait wait;

    @FindBy(id = "nava")
    WebElement ProductStore_id;

    @FindBy(xpath = "//a[contains(text(),'Laptops')]")
    WebElement Laptops_xpath;

//    @FindBy(xpath = "//div[@id='tbodyid']//div[contains(@class,'card') and .//a[contains(text(),'Sony vaio i5')]]//a")
//    WebElement SonyVaio_xpath;



    public ProductStorePage(WebDriver driver) {
        this.driver = driver;
            }

    public void VerifyUserIsOnProductStorePage() {
        ProductStore_id.isDisplayed();
    }

    public void clickOnLaptops() {
        Laptops_xpath.click();
    }
    public void clickOnSonyVaio() {
        //SonyVaio_xpath.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sonyVaioI5 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='tbodyid']//div[contains(@class,'card') and .//a[contains(text(),'Sony vaio i5')]]//a")
        ));
        sonyVaioI5.click();
    }

}
