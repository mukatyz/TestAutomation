package com.certification.automation.runners.reqres;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\reqres\\verify_service.feature"
        ,glue = "com.certification.automation.stepdefinitions"
        ,snippets = SnippetType.CAMELCASE
)
public class VerifyService {
}
