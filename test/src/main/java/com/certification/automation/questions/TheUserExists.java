package com.certification.automation.questions;

import com.certification.automation.models.Routes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.ArrayList;
import java.util.List;

import static com.certification.automation.utils.Constants.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TheUserExists implements Question<Boolean> {
    public TheUserExists() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        int totalPages = Integer.parseInt(lastResponse().jsonPath().getString(TOTAL_PAGES));
        for(int i=1;i<totalPages+1;i++){
            actor.whoCan(CallAnApi.at(URL_BASE));
            actor.attemptsTo(Get.resource(Routes.valueOf(CONSULT_USERS_LIST).getRouteService()+i));

            List<Integer> idList = lastResponse().jsonPath().getList("data.id");
            for (int id:
                    idList) {
                if (actor.recall(ID).equals(String.valueOf(id)))
                    return true;
            }
        }
        return false;
    }
    public static TheUserExists inUsersList(){
        return new TheUserExists();
    }
}
