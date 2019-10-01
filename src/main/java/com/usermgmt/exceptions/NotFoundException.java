package com.usermgmt.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotFoundException extends RuntimeException {
  private Long resourceId;
}
