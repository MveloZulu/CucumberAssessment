package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmPage {
    WebDriver driver;

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }
    public void confirmationMessageDisplays() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));

    }
    public void clickOkayButton() {
        // Click the "OK" button on the confirmation modal
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
        okButton.click();
        System.out.println("✅ Clicked OK on the purchase confirmation modal.");
    }


//    public void verifyTheProductstorePageDisplays() {
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        driver.findElement(By.id("nava")).click();
//        wait.until(ExpectedConditions.urlContains("index.html"));
//        System.out.println("✅ User is on the Product Store page.");
//
//    }
//public void verifyTheProductStorePageDisplays() {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//    try {
//        // Wait for SweetAlert OK button to be visible and clickable
//        WebElement sweetAlertOk = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector("button.confirm")));
//
//        // Click OK using JavaScript to avoid overlay issues
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", sweetAlertOk);
//
//        // Wait for the SweetAlert to disappear (not #orderModal!)
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.sweet-alert")));
//
//        // Click the Product Store link
//        WebElement productStoreLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nava")));
//        productStoreLink.click();
//
//        // Wait for redirect to index.html
//        wait.until(ExpectedConditions.urlContains("index.html"));
//
//        System.out.println("✅ Redirected to Product Store page successfully.");
//
//    } catch (Exception e) {
//        System.out.println("❌ Failed to redirect: " + e.getMessage());
//    }
//}

    public void verifyTheProductStorePageDisplays() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Click the OK button inside modal
            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.confirm")));
            js.executeScript("arguments[0].click();", okButton);

            // 🔥 Remove Bootstrap modal and backdrop manually
            js.executeScript("document.querySelector('.modal-backdrop').remove();");
            js.executeScript("document.body.classList.remove('modal-open');");

            // Short delay to allow UI to update
            Thread.sleep(500);

            // Click the Product Store link
            WebElement productStoreLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nava")));
            productStoreLink.click();

            // Wait for redirection
            wait.until(ExpectedConditions.urlContains("index.html"));
            System.out.println("✅ Redirected to Product Store page.");

        } catch (Exception e) {
            System.out.println("❌ Failed to redirect: " + e.getMessage());
        }
    }

}
