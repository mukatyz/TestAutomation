package com.certification.automation.questions;

import com.certification.automation.models.Routes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.certification.automation.utils.Constants.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TheRegistersNumber implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        int totalPages = Integer.parseInt(lastResponse().jsonPath().getString(TOTAL_PAGES));
        for(int i=1;i<totalPages+1;i++){
            actor.whoCan(CallAnApi.at(URL_BASE));
            actor.attemptsTo(Get.resource(Routes.valueOf(CONSULT_USERS_LIST).getRouteService()+i));
            if(!lastResponse().jsonPath().getString("per_page").equals(lastResponse().jsonPath().getList("data").size()))
                return false;
        }
        return true;
    }

    public static TheRegistersNumber corresponceWithHeader(){
        return new TheRegistersNumber();
    }

}
