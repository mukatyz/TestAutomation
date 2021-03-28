package com.certification.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultsCreenComponents {

    public static final Target PRICES_LIST = Target.the("Prices list").
            locatedBy("//*[@class=\"price product-price\"]");
    public static final Target PRICES = Target.the("Prices list").
            locatedBy("//(*[contains(text(),'{0}')]");
    public static final Target ADD_TO_CAR = Target.the("Prices list").
            locatedBy("(//*[contains(text(),'Add to cart')])[{0}]");
    public static final Target CONTINUE_SHOPPING = Target.the("Continue Shoping button").
            located(By.className("cross"));
    public static final Target PRODUCTS_LIST_RESULTS_SCREEN = Target.the("Product List").
            locatedBy("(//h5[@itemprop='name'])[{0}]");


    public ResultsCreenComponents() {
    }
}
