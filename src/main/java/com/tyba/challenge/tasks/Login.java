package com.tyba.challenge.tasks;

import static com.tyba.challenge.utils.Resources.END_POINT_AUTH;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import io.restassured.http.ContentType;
import java.util.LinkedHashMap;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class Login implements Task {

  private final Map<String, String> credentials;

  public Login(Map<String, String> credentials) {
    this.credentials = credentials;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to(END_POINT_AUTH.getValue())
            .with(request -> request.contentType(ContentType.JSON).body(credentials).log().all()));
    actor.should(seeThatResponse(response -> response.log().all()));
  }

  public static Login withCredentials(Map<String, String> credentials) {
    return instrumented(Login.class, credentials);
  }
}
