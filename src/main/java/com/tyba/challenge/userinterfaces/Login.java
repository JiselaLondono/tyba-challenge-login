package com.tyba.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public final class Login {
  public static final Target USERNAME =
      Target.the("Text input to type username").located(By.id("user-name"));
  public static final Target PASSWORD =
      Target.the("Text input to type password").located(By.id("password"));
  public static final Target LOGIN_BUTTON =
      Target.the("Button to login to the Swags Labs system").located(By.id("login-button"));
  public static final Target VALIDATION_LABEL =
      Target.the("Section where the validation message is displayed")
          .locatedBy("//h3[@data-test='error']");

  private Login() {}
}
