package com.certification.automation.stepdefinitions.automationpractice;

import com.certification.automation.interactions.Refresh;
import com.certification.automation.questions.ProductsNumber;
import com.certification.automation.tasks.ChooseProducts;
import com.certification.automation.tasks.CreateUser;
import com.certification.automation.tasks.SearchAProduct;
import com.certification.automation.userinterfaces.BannerComponents;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartStepDefinitions {
    @Given("^that the user open the web page$")
    public void thatTheUserOpenTheWebPage() {

        theActorInTheSpotlight().attemptsTo(Open.url("http://automationpractice.com/"));

    }


    @When("^the user search (.*) and choose the products$")
    public void theUserChooseTheProducts(String productToChoose) {
        theActorInTheSpotlight().attemptsTo(SearchAProduct.inTheWeb(productToChoose));
        theActorInTheSpotlight().attemptsTo(ChooseProducts.inResultsScreen());
    }

    @Then("^should see (.*) number in the cart$")
    public void shouldSeeNumberInTheCart(String productsNumber) {
        theActorInTheSpotlight().should(seeThat(ProductsNumber.choosen(), is(equalTo(productsNumber))));
    }


    @When("^open cart box$")
    public void openCartBox() {
        theActorInTheSpotlight().attemptsTo(MoveMouse.to(BannerComponents.PRODUCTS_NUMBER).andThen(actions->actions.pause(9000)));
    }


    @When("^refresh the web page$")
    public void refreshTheWebPage() {
        theActorInTheSpotlight().attemptsTo(Refresh.page());
    }

}
