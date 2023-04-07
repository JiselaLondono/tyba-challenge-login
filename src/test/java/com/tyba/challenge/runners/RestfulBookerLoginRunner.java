package com.tyba.challenge.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/restful_booker_login.feature",
        glue = "com.tyba.challenge.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RestfulBookerLoginRunner {}
