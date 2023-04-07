package com.tyba.challenge.tasks;

import static com.tyba.challenge.userinterfaces.Login.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginToTheSystem implements Task {

  private final String username;
  private final String password;

  private static final String USER = "usuario";
  private static final String PASS = "contrasena";

  public LoginToTheSystem(Map<String, String> credentials) {
    username = credentials.get(USER) == null ? "" : credentials.get(USER);
    password = credentials.get(PASS) == null ? "" : credentials.get(PASS);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(username).into(USERNAME),
        Enter.theValue(password).into(PASSWORD),
        Click.on(LOGIN_BUTTON));
  }

  public static LoginToTheSystem withCredentials(Map<String, String> credentials) {
    return instrumented(LoginToTheSystem.class, credentials);
  }
}
