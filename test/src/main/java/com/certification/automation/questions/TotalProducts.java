package com.certification.automation.questions;

import com.certification.automation.userinterfaces.CartComponents;
import com.certification.automation.userinterfaces.CheckoutComponents;
import com.certification.automation.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static com.certification.automation.utils.Constants.CART;
import static com.certification.automation.utils.Constants.CHECKOUT;

public class TotalProducts implements Question<Double> {
    private String screen;

    private TotalProducts(String screen) {
        this.screen = screen;
    }

    @Override
    public Double answeredBy(Actor actor) {
        switch (screen){
            case CHECKOUT:
                return Double.parseDouble(Text.of(CheckoutComponents.TOTAL_VALUE_CHECKOUT_SCREEN).viewedBy(actor).asString().replace("$",""));
            case CART:
                Double totalProductsValueCart = Double.parseDouble(Text.of(CartComponents.TOTAL_PRODUCTS_VALUE_CART).viewedBy(actor).asString().replace("$",""));
                Double shipping = Double.parseDouble(Text.of(CartComponents.SHIPPING).viewedBy(actor).asString().replace("$",""));
                return totalProductsValueCart-shipping;
            default:
                return null;
        }
    }

    public static TotalProducts value(String screen){
        return new TotalProducts(screen);
    }
}
