package com.tyba.challenge.questions;

import static com.tyba.challenge.utils.JsonObjects.TOKEN;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AuthToken implements Question<String> {

  @Override
  public String answeredBy(Actor actor) {
    return lastResponse().jsonPath().getString(TOKEN.getObjectName());
  }

  public static AuthToken is() {
    return new AuthToken();
  }
}
