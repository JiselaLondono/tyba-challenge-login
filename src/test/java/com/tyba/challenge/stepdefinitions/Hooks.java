package com.tyba.challenge.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static com.tyba.challenge.utils.Resources.URI;

public class Hooks {

    @Managed(driver = "chrome")
    WebDriver herBrowser;

    @Before
    public void setStage() {
        OnStage.setTheStage(
                Cast.whereEveryoneCan(
                        BrowseTheWeb.with(herBrowser), CallAnApi.at(URI.getValue())));
    }
}
