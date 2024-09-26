package br.com.erudio.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException {
  
  private static final long serialVersionUID = 1L;
  
  public InvalidJwtAuthenticationException(String ex) {
    super(ex);
  }

}