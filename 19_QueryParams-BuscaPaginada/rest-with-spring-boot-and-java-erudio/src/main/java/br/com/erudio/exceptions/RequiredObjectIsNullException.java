package br.com.erudio.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;
  
  public RequiredObjectIsNullException() {
	  super("It is not possible to persist a null object!");
  }
  
  public RequiredObjectIsNullException(String ex) {
    super(ex);
  }
  

}