package com.certification.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.certification.automation.utils.Constants.ID;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TheId implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String id=lastResponse().jsonPath().getString(ID);
        actor.recall(ID);

        return id;
    }
    public static TheId answered(){
        return new TheId();
    }
}
