package com.certification.automation.tasks;

import com.certification.automation.userinterfaces.ResultsCreenComponents;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.certification.automation.userinterfaces.ResultsCreenComponents.*;
import static com.certification.automation.utils.Constants.*;

public class ChooseProducts implements Task {
    @Override
    @Step("{0} fetches the user with id #id")
    public <T extends Actor> void performAs(T actor) {

        List<String> list = Text.of(ResultsCreenComponents.PRICES_LIST).viewedBy(actor).asList().stream().filter(lista->lista.startsWith("$")).collect(Collectors.toList());
        String priceMin=list.stream().min(Comparator.comparing(String::valueOf)).get();
        String priceMax=list.stream().max(Comparator.comparing(String::valueOf)).get();

        String positionMinProduct=String.valueOf(list.indexOf(priceMin)+1);
        String positionMaxProduct=String.valueOf(list.indexOf(priceMax)+1);

        actor.remember(PRODUCTS_VALUE, Double.parseDouble(priceMax.replace(SYMBOL_$, EMPTY))+Double.parseDouble(priceMin.replace(SYMBOL_$, EMPTY)));

        actor.remember(PRODUCTS_LIST,new ArrayList<>(Arrays.asList(Text.of(PRODUCTS_LIST_RESULTS_SCREEN.of(positionMaxProduct)).
                viewedBy(actor).asString(),Text.of(PRODUCTS_LIST_RESULTS_SCREEN.of(positionMinProduct)).viewedBy(actor).asString())));
        actor.remember(PRICES_LIST_STR,new ArrayList<>(Arrays.asList(priceMax,priceMin)));

        actor.attemptsTo(Click.on(ADD_TO_CAR.of(positionMaxProduct)),
                Click.on(CONTINUE_SHOPPING),
                Click.on(ADD_TO_CAR.of(positionMinProduct)),
                Click.on(CONTINUE_SHOPPING));
    }

    public static ChooseProducts inResultsScreen(){
        return Tasks.instrumented(ChooseProducts.class);
    }
}
