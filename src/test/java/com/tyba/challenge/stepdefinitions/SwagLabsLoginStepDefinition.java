package com.tyba.challenge.stepdefinitions;

import static com.tyba.challenge.utils.ErrorMessages.INVALID_QUANTITY;
import static com.tyba.challenge.utils.ErrorMessages.INVALID_REASON;
import static com.tyba.challenge.utils.Resources.DEMO_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;

import com.tyba.challenge.exceptions.ExpectedValueException;
import com.tyba.challenge.questions.InventoryList;
import com.tyba.challenge.questions.ValidationMessage;
import com.tyba.challenge.tasks.LoginToTheSystem;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import java.util.Map;
import net.serenitybdd.screenplay.actions.Open;

public class SwagLabsLoginStepDefinition {

  @Dado("que {word} quiere iniciar sesión en Swag Labs")
  public void login(String actor) {
    theActorCalled(actor).wasAbleTo(Open.url(DEMO_URL.getValue()));
  }

  @Cuando("ella ingresa un usuario y/o contraseña correctos/incorrectos en el sistema")
  public void enterCredentials(Map<String, String> credentials) {
    theActorInTheSpotlight().attemptsTo(LoginToTheSystem.withCredentials(credentials));
  }

  @Entonces(
      "ella debería ingresar al portal de manera exitosa, en donde visualice el inventario de productos")
  public void seeInventory() {
    theActorInTheSpotlight()
        .should(
            seeThat(InventoryList.is(), greaterThan(0))
                .orComplainWith(ExpectedValueException.class, INVALID_QUANTITY.getMessage()));
  }

  @Entonces("ella debería ver el siguiente mensaje en pantalla {string}")
  public void validateLogin(String message) {
    theActorInTheSpotlight()
        .should(
            seeThat(ValidationMessage.is(), containsString(message))
                .orComplainWith(ExpectedValueException.class, INVALID_REASON.getMessage()));
  }
}
