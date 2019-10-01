package com.usermgmt.model.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorDTO {
  private String message;
}
