package myProject.auto.tests;

import myProject.auto.BaseTest;
import myProject.auto.utils.Properties;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseTest {
        @Test
    public void checkSiteVersion() {
        actions.checkSiteVersion(Properties.getBaseUrl());
        if(isMobileTesting){
            Reporter.log("Use mobile version");
            System.out.println("Use mobile version");

        }else {
            Reporter.log("Use desktop browser version");
            System.out.println("Use desktop browser version");
        }
    }

    @Test
    public void createNewOrder() {
        // TODO implement order creation test
        actions.openRandomProduct();
        actions.addToCart();
        actions.verifyDeteilsProduct();
        actions.createdOrderMethod();
        actions.inputOrderData();
        actions.fillAddressData();
        actions.enterDeliveryButton();
        actions.paymentMethod();
        actions.verifyOrderData();
        actions.checkCount();
        Reporter.log("Test Passed");

    }
}
