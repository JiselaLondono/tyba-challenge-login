package com.tyba.challenge.utils;

public enum ErrorMessages {
  INVALID_CODE("El código de respuesta retornado no es el esperado"),
  INVALID_TOKEN("El token retornado no puede ser nulo");

  private String message;

  ErrorMessages(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
