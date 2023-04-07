package com.tyba.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.tyba.challenge.userinterfaces.Login.VALIDATION_LABEL;

public class ValidationMessage implements Question<String> {

  @Override
  public String answeredBy(Actor actor) {
    return VALIDATION_LABEL.resolveFor(actor).getText();
  }

  public static ValidationMessage is() {
    return new ValidationMessage();
  }
}
