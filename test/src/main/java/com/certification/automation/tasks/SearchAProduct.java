package com.certification.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.certification.automation.userinterfaces.BannerComponents.*;

public class SearchAProduct implements Task {
    private String productTochoose;

    public SearchAProduct(String productTochoose) {
        this.productTochoose = productTochoose;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Enter.theValue(productTochoose).into(SEARCH_BOX));
        actor.attemptsTo(Click.on(SEARCH_SUBMIT));

    }
    public static SearchAProduct inTheWeb(String productTochoose){
        return Tasks.instrumented(SearchAProduct.class,productTochoose);
    }
}
