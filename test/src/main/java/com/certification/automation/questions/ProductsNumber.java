package com.certification.automation.questions;

import com.certification.automation.userinterfaces.BannerComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ProductsNumber implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(BannerComponents.PRODUCTS_NUMBER).viewedBy(actor).asString();
    }

    public static ProductsNumber choosen(){
        return new ProductsNumber();
    }
}
