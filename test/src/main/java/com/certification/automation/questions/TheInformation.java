package com.certification.automation.questions;

import com.certification.automation.models.Routes;
import com.certification.automation.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.certification.automation.utils.Constants.URL_BASE;
import static com.certification.automation.utils.Constants.USER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TheInformation implements Question<String> {
    private String id;
    private TheInformation() {
        this.id = theActorInTheSpotlight().recall("id");
    }

    private TheInformation(String id) {
        this.id = id;
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.whoCan(CallAnApi.at(URL_BASE));
        actor.attemptsTo(Get.resource(Routes.valueOf(USER).getRouteService()+"/"+id));
        return SerenityRest.lastResponse().jsonPath().getString("data");
    }
    public static TheInformation fromCreatedUser(){
        return new TheInformation();
    }
    public static TheInformation withId(String id){
        return new TheInformation(id);
    }
}
