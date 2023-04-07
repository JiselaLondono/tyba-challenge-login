package com.tyba.challenge.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import com.tyba.challenge.questions.AuthToken;
import com.tyba.challenge.questions.InventoryList;
import com.tyba.challenge.questions.LastResponseStatusCode;
import com.tyba.challenge.tasks.Login;
import com.tyba.challenge.tasks.LoginToTheSystem;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

public class SwagLabsLoginStepDefinition {



  @Dado("que {word} quiere iniciar sesión en el sistema")
  public void login(String actor) {
    theActorCalled(actor).wasAbleTo(Open.url("https://www.saucedemo.com/"));
  }

  @Cuando("ingresa un usuario {word} y contraseña {word} correctos")
  public void enterCredentials(String username, String password) {
    theActorInTheSpotlight().attemptsTo(LoginToTheSystem.withCredentials(username, password));
  }





  @Entonces(
      "ella debería ingresar al portal de manera exitosa, en donde visualice el inventario de productos")
  public void seeInventory() {
    theActorInTheSpotlight().should(seeThat(InventoryList.is(), greaterThan(0)));
  }
}
