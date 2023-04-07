package com.tyba.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.tyba.challenge.userinterfaces.Inventory.INVENTORY_LIST;

public class InventoryList implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return INVENTORY_LIST.resolveAllFor(actor).size();
    }

    public static InventoryList is() {
        return new InventoryList();
    }
}
