package com.donmba.auth_api.exceptions;

public class InvalidRedirectUriException extends RuntimeException {

  public InvalidRedirectUriException(String message) {
    super(message);
  }
}
