package com.certification.automation.stepdefinitions.reqres;

import com.certification.automation.models.UsersData;
import com.certification.automation.questions.*;
import com.certification.automation.tasks.ConsultTheUsersList;
import com.certification.automation.tasks.CreateUser;
import com.certification.automation.tasks.DeleteTheUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class VerifyServiceStepDefinitios {
    @Given("^The user Create an user whit the information$")
    public void theUserCreateAnUser(List<UsersData> usersData) {
        theActorInTheSpotlight().attemptsTo(CreateUser.withTheInformation(usersData.get(0)));
    }

    @Then("^Should see the id was created$")
    public void shouldSeeTheIdWasCreated() {
        theActorInTheSpotlight().should(seeThat(TheId.answered(), Matchers.is(Matchers.notNullValue())));
    }

    @Given("^The user delete an user$")
    public void theUserDeleteAnUser(List<UsersData> usersData) {
        theActorInTheSpotlight().remember("idToDelete",usersData.get(0).getId());
        theActorInTheSpotlight().attemptsTo(DeleteTheUser.withInformation(usersData.get(0)));
    }

    @Then("^should see the user information in the user list$")
    public void shouldSeeTheUserInformationInTheUserList() {
        theActorInTheSpotlight().should(seeThat(TheInformation.fromCreatedUser(), not(isEmptyOrNullString())));
    }
    @Then("^should see the service response was (.*)$")
    public void shouldSeeTheServiceResponseWas(int statusCode) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheStatusCode.obtained(),Matchers.is(Matchers.equalTo(statusCode))));

    }
    @Then("^shouldn't see the user information in the user list$")
    public void shouldnTSeeTheUserInformationInTheUserList() {
        theActorInTheSpotlight().should(seeThat(TheInformation.withId(theActorInTheSpotlight().recall("idToDelete")), isEmptyOrNullString()));
    }

    @Given("^The user consult the Users List$")
    public void theUserConsultTheUsersList() {
        theActorInTheSpotlight().wasAbleTo(ConsultTheUsersList.complete());
    }

    @Then("^should see the information correspondence$")
    public void shouldSeeTheInformationCorrespondence() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheRegistersNumber.corresponceWithHeader(),Matchers.is(false)));
    }
    @Then("^should see the user in users list$")
    public void shouldSeeTheUserInUsersList() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheUserExists.inUsersList(), Matchers.is(Matchers.equalTo(true))));
    }
    @Then("^shouldn't see the user in users list$")
    public void shouldnTSeeTheUserInUsersList() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheUserExists.inUsersList(), Matchers.is(Matchers.equalTo(false))));
    }
}
