package com.lizana.msproduct.config.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID =1L;

  private final String message;
  private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

  public ResourceNotFoundException(String message) {
    super(message);
    this.message = message;
  }

}
