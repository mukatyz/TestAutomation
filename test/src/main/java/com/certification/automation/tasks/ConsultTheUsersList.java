package com.certification.automation.tasks;

import com.certification.automation.models.Routes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.certification.automation.utils.Constants.*;

public class ConsultTheUsersList implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(URL_BASE));
        actor.attemptsTo(Get.resource(Routes.valueOf(CONSULT_USERS_LIST).getRouteService()));

    }

    public static ConsultTheUsersList complete(){
        return Tasks.instrumented(ConsultTheUsersList.class);
    }
}
