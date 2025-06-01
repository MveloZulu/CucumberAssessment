package Steps;

import Pages.*;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.getDriver("chrome", "https://www.demoblaze.com/index.html");
    ProductStorePage productStorePage = PageFactory.initElements(driver, ProductStorePage.class);
    AddToCartPage addToCartPage = PageFactory.initElements(driver, AddToCartPage.class);
    ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
    PlaceOrderPage placeOrderPage = PageFactory.initElements(driver, PlaceOrderPage.class);
    ConfirmPage confirmPage = PageFactory.initElements(driver, ConfirmPage.class);


}
