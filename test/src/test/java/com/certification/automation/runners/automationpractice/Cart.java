package com.certification.automation.runners.automationpractice;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\automationpractice\\cart.feature"
        ,glue = "com.certification.automation.stepdefinitions"
        ,snippets = SnippetType.CAMELCASE
)
public class Cart {
}
