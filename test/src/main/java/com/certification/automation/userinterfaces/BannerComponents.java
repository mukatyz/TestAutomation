package com.certification.automation.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BannerComponents {
    public static final Target SEARCH_BOX = Target.the("Type product to search").
            located(By.id("search_query_top"));

    public static final Target SEARCH_SUBMIT = Target.the("Submit search").
            located(By.name("submit_search"));

    public static final Target CART = Target.the("Cart").
            locatedBy("//a[title='View my shopping cart']");

    public static final Target PRODUCTS_NUMBER = Target.the("Cart").
            located(By.className("ajax_cart_quantity"));


    public BannerComponents() {
    }
}
