package com.usermgmt.resources;

import com.usermgmt.exceptions.NotFoundException;
import com.usermgmt.exceptions.PasswordConfirmationException;
import com.usermgmt.model.dtos.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(PasswordConfirmationException.class)
  public ResponseEntity passwordConfirmationException(final PasswordConfirmationException ex) {
    log.warn("Password confirmation is invalid!");
    return ResponseEntity.badRequest().body(ErrorDTO.builder().message("Password confirmation is invalid for this resource").build());
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity notFoundException(final NotFoundException ex) {
    log.warn("Resource not found for id {}", ex.getResourceId());
    return ResponseEntity.notFound().build();
  }
}
