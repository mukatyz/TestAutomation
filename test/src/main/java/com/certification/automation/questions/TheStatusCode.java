package com.certification.automation.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheStatusCode implements Question<Integer> {


    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
    public static TheStatusCode obtained(){
        return new TheStatusCode();
    }
}
