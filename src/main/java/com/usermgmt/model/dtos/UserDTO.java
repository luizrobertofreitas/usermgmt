package com.usermgmt.model.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
  private final Long id;
  private final String name, email, password;
}
