package com.burra.business.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DataAlreadyExistsException extends RuntimeException {

  public DataAlreadyExistsException(String message) {
    super(message);
  }
}
