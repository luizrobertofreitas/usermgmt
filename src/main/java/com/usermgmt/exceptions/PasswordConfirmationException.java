package com.usermgmt.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PasswordConfirmationException extends RuntimeException {
  private Long userId;
  private String message;
}
