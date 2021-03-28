package com.certification.automation.stepdefinitions.automationpractice;

import com.certification.automation.questions.TotalProducts;
import com.certification.automation.questions.ProductsList;
import com.certification.automation.tasks.ChooseProducts;
import com.certification.automation.tasks.SearchAProduct;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Click;
import org.hamcrest.Matchers;

import static com.certification.automation.userinterfaces.BannerComponents.PRODUCTS_NUMBER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckoutScreenStepDefinitions {

    @Given("^the user open checkout screen to see the products for (.*) choosen$")
    public void theUserOpenCheckoutScreenToSeeTheProductsChoosen(String productToChoose) {
        theActorInTheSpotlight().attemptsTo(SearchAProduct.inTheWeb(productToChoose));
        theActorInTheSpotlight().attemptsTo(ChooseProducts.inResultsScreen());
        theActorInTheSpotlight().attemptsTo(Click.on(PRODUCTS_NUMBER));
    }

    @When("^open screen checkout$")
    public void openScreenCheckout() {
        theActorInTheSpotlight().attemptsTo(Click.on(PRODUCTS_NUMBER));
    }

    @Then("^should see choosen products in (.*) screen$")
    public void shouldSeeChoosenProducts(String screen) {
        theActorInTheSpotlight().should(seeThat(ProductsList.in(screen), is(equalTo(theActorInTheSpotlight().recall("productsList")))));
    }

    @Then("^should see total value in the (.*) screen$")
    public void shouldSeeTotalValueInTheScreen(String screen) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(TotalProducts.value(screen), is(equalTo(theActorInTheSpotlight().recall("productsValue")))));
    }

}
