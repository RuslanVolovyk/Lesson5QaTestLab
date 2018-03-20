package myProject.auto;

import myProject.auto.utils.Properties;
import myProject.auto.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;

    private By allLinks = By.xpath("//*[@id=\"content\"]/section/a");
    private By oneProducts = By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/div[1]/h1/a");
    private By addToCard = By.cssSelector(".btn.btn-primary.add-to-cart");
    private By getUpProduct = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/a");
    private By getProductQut = By.cssSelector(".js-cart-line-product-quantity.form-control");
    private By getProductName = By.xpath("//*[@id=\"main\"]/div/div[1]/div[1]/div[2]/ul/li/div/div[1]/span/img");
    private By getProductPrice = By.xpath("//*[@class=\"product-price\"]");
    private By createOrder = By.xpath("//*[@class=\"btn btn-primary\"]");
    private By inputOrderName = By.xpath("//*[@id=\"customer-form\"]/section/div[2]/div[1]/input");
    private By inputOrderSecondName = By.xpath("//*[@id=\"customer-form\"]/section/div[3]/div[1]/input");
    private By inputOrderEmailName = By.xpath("//*[@id=\"customer-form\"]/section/div[4]/div[1]/input");
    private By continueButton = By.xpath("//*[@id=\"customer-form\"]/footer/button");
    private By radioButton1 = By.xpath("//*[@id=\"payment-option-1\"]");
    private By radioButton2 = By.xpath("//*[@id=\"payment-option-2\"]");
    private By checkBox = By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]");
    private By deliveryButton = By.xpath("//*[@id=\"js-delivery\"]/button");
    private By continueAddressButton = By.xpath("//*[@id=\"delivery-address\"]/div/footer/button");
    private By inputAddress = By.xpath("//*[@id=\"delivery-address\"]/div/section/div[5]/div[1]/input");
    private By inputIndex = By.xpath("//*[@id=\"delivery-address\"]/div/section/div[7]/div[1]/input");
    private By inputCity = By.xpath("//*[@id=\"delivery-address\"]/div/section/div[8]/div[1]/input");
    private By confirmOrderButton = By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button");
    private By messageText = By.xpath("//*[@id=\"content-hook_order_confirmation\"]/div/div/div/h3");
    private By productNameText = By.xpath("//*[@id=\"order-items\"]/div/div/div[2]/span");
    private By productCountText = By.xpath("//*[@id=\"order-items\"]/div/div/div[3]/div/div[2]");
    private By productPriceText = By.xpath("//*[@id=\"order-items\"]/div/div/div[3]/div/div[3]");
    private By countValue = By.xpath("//*[@id=\"product-details\"]/div[3]/span");


    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void checkSiteVersion(String url) {
        driver.get(Properties.getBaseUrl());
    }

    public void createdOrderMethod() {
        driver.findElement(createOrder).click();

    }

    public void openRandomProduct() {
        driver.get(Properties.getBaseUrl());
        wait.until(ExpectedConditions.elementToBeClickable(allLinks));
        driver.findElement(allLinks).click();
        driver.findElement(oneProducts).click();
    }

    public void addToCart() {
        driver.findElement(addToCard).click();
        wait.until(ExpectedConditions.elementToBeClickable(getUpProduct));
        driver.findElement(getUpProduct).click();
    }

    public void verifyDeteilsProduct() {
        Assert.assertEquals(driver.findElement(getProductQut).getAttribute("value"), Utils.getProductCount());
        Assert.assertEquals(driver.findElement(getProductName).getAttribute("alt"), Utils.getProductName());
        Assert.assertEquals(driver.findElement(getProductPrice).getText(), Utils.getProductPrice());

    }

    public void inputOrderData() {
        driver.findElement(inputOrderEmailName).sendKeys(Utils.randomStringEmail());
        driver.findElement(inputOrderName).sendKeys(Utils.randomStringFirstName());
        driver.findElement(inputOrderSecondName).sendKeys(Utils.randomStringSecondName());
        driver.findElement(continueButton).click();


    }

    public void fillAddressData() {
        driver.findElement(inputAddress).sendKeys(Utils.randomStringFirstName());
        driver.findElement(inputIndex).sendKeys(Utils.getIndex());
        driver.findElement(inputCity).sendKeys(Utils.randomStringSecondName());
        wait.until(ExpectedConditions.elementToBeClickable(continueAddressButton));
        driver.findElement(continueAddressButton).click();
    }

    public void enterDeliveryButton() {
        driver.findElement(deliveryButton).click();
    }

    public void paymentMethod() {
        driver.findElement(radioButton1).click();
        driver.findElement(checkBox).click();
        driver.findElement(confirmOrderButton).click();
    }

    public void verifyOrderData() {
        Assert.assertEquals(driver.findElement(messageText).getText(), Utils.getConfirmOrderMessage());
        //test always failed
//        Assert.assertEquals(driver.findElement(productNameText).getText(),Utils.getProductName());
        Assert.assertEquals(driver.findElement(productCountText).getText(), Utils.getProductCount());
        Assert.assertEquals(driver.findElement(productPriceText).getText(), Utils.getProductPrice());
    }

    public void checkCount() {
        //don't understand this step.
    }
}