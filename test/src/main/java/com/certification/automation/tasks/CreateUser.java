package com.certification.automation.tasks;

import com.certification.automation.models.Routes;
import com.certification.automation.models.UsersData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.certification.automation.utils.Constants.*;
import static com.certification.automation.utils.Constants.ID;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CreateUser implements Task {
    private UsersData usersData;

    public CreateUser(UsersData usersData) {
        this.usersData = usersData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(URL_BASE));
        actor.attemptsTo(Post.to(Routes.valueOf(USER).getRouteService()).with(request ->request.relaxedHTTPSValidation()
                .body(usersData)));
        String id=lastResponse().jsonPath().getString(ID);
        actor.remember(ID,id);

    }

    public static CreateUser withTheInformation(UsersData usersData){
        return Tasks.instrumented(CreateUser.class,usersData);
    }
}
