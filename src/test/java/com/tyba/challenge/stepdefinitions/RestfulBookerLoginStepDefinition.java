package com.tyba.challenge.stepdefinitions;

import static com.tyba.challenge.utils.ErrorMessages.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import com.tyba.challenge.exceptions.CodeValueException;
import com.tyba.challenge.exceptions.ExpectedValueException;
import com.tyba.challenge.questions.AuthToken;
import com.tyba.challenge.questions.LastResponseStatusCode;
import com.tyba.challenge.questions.Reason;
import com.tyba.challenge.tasks.Login;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import java.util.Map;

public class RestfulBookerLoginStepDefinition {

  @Cuando(
      "{word} ingresa un usuario y/o contraseña correctos/incorrectos en el endpoint de autenticación")
  public void login(String actor, Map<String, String> credentials) {
    theActorCalled(actor).attemptsTo(Login.withCredentials(credentials));
  }

  @Entonces("ella debería ver que el código de respuesta del servicio es {int}")
  public void validateStatusCode(int statusCode) {
    theActorInTheSpotlight()
        .should(
            seeThat(LastResponseStatusCode.is(), equalTo(statusCode))
                .orComplainWith(CodeValueException.class, INVALID_CODE.getMessage()));
  }

  @Entonces("ella debería ver un token de autenticación en la respuesta del servicio")
  public void validateAuthToken() {
    theActorInTheSpotlight()
        .should(
            seeThat(AuthToken.is(), notNullValue())
                .orComplainWith(ExpectedValueException.class, INVALID_TOKEN.getMessage()));
  }

  @Entonces("ella debería ver el siguiente mensaje en la respuesta del servicio: {string}")
  public void validateMessage(String reason) {
    theActorInTheSpotlight()
        .should(
            seeThat(Reason.is(), equalTo(reason))
                .orComplainWith(ExpectedValueException.class, INVALID_REASON.getMessage()));
  }
}
