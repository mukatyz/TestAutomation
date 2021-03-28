package com.certification.automation.tasks;

import com.certification.automation.models.Routes;
import com.certification.automation.models.UsersData;
import com.certification.automation.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static com.certification.automation.utils.Constants.URL_BASE;
import static com.certification.automation.utils.Constants.USER;

public class DeleteTheUser implements Task {
    private UsersData usersData;

    public DeleteTheUser(UsersData usersData) {
        this.usersData = usersData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(URL_BASE));
        actor.attemptsTo(Delete.from(Routes.valueOf(USER).getRouteService()+usersData.getId()));
    }
    public static DeleteTheUser withInformation(UsersData usersData){
        return Tasks.instrumented(DeleteTheUser.class,usersData);
    }
}
