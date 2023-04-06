package com.tyba.challenge.tasks;

import static com.tyba.challenge.userinterfaces.Login.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.tyba.challenge.userinterfaces.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginToTheSystem implements Task {

    private String username;
    private String password;

    public LoginToTheSystem(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Enter.theValue(String.valueOf(username)).into(USERNAME), Enter.theValue(String.valueOf(password)).into(PASSWORD), Click.on(LOGIN_BUTTON));
  }

    public static LoginToTheSystem withCredentials(String username, String password) {
        return instrumented(LoginToTheSystem.class, username, password);
    }


}
