package com.tyba.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public final class Inventory {
  public static final Target INVENTORY_LIST =
      Target.the("SwagLabs product list").locatedBy("//div[@class='inventory_item']");

  private Inventory() {}
}
