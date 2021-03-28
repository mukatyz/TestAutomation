package com.certification.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutComponents {
    public static final Target PRODUCTS_LIST_CHECKOUT = Target.the("Product list in cart box").
            locatedBy("//*[@class='cart_description']/p[@class='product-name']/a");

    public static final Target TOTAL_VALUE_CHECKOUT_SCREEN = Target.the("Total products value").
            located(By.id("total_product"));

    public CheckoutComponents() {
    }
}
