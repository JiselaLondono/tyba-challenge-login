package com.tyba.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.tyba.challenge.utils.JsonObjects.REASON;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class Reason implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return lastResponse().jsonPath().getString(REASON.getObjectName());
    }

    public static Reason is() {
        return new Reason();
    }


}
