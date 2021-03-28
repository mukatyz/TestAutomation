package com.certification.automation.questions;

import com.certification.automation.userinterfaces.CartComponents;
import com.certification.automation.userinterfaces.CheckoutComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static com.certification.automation.utils.Constants.CART;
import static com.certification.automation.utils.Constants.CHECKOUT;

public class ProductsList implements Question<List<String>> {

    private String screen;

    public ProductsList(String screen) {
        this.screen = screen;
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        switch (screen){
            case CHECKOUT:
                return Text.of(CheckoutComponents.PRODUCTS_LIST_CHECKOUT).viewedBy(actor).asList();
           case CART:
               return Text.of(CartComponents.PRODUCTS_LIST_CART).viewedBy(actor).asList();
            default:
                return null;
        }
    }
    public static ProductsList in(String screen){
        return new ProductsList(screen);
    }
}
