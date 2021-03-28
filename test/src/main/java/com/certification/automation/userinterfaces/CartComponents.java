package com.certification.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartComponents {
    public static final Target PRODUCTS_LIST_CART = Target.the("Product list in cart box").
            locatedBy("//*[@class='cart_block_product_name']");

    public static final Target TOTAL_PRODUCTS_VALUE_CART = Target.the("Prices list in cart box").
            locatedBy("//*[@class='price cart_block_total ajax_block_cart_total']");
    public static final Target SHIPPING = Target.the("Prices list in cart box").
            locatedBy("//*[@class=\"price cart_block_shipping_cost ajax_cart_shipping_cost\"]");
}
