package com.tyba.challenge.utils;

public enum ErrorMessages {
  INVALID_CODE("El código de respuesta retornado no es el esperado"),
  INVALID_TOKEN("El token retornado no puede ser nulo"),
  INVALID_REASON("El mensaje de validación retornado no es el esperado"),
  INVALID_QUANTITY("La cantidad de productos en el inventario no es la espeada");

  private final String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
