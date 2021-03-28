package com.certification.automation.stepdefinitions;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class EnvironmentStepDefinitios {
    @Before
    public void setUpStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Camila");
    }
}
