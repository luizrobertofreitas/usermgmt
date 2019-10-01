package com.usermgmt.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
  private final Long id;
  @NotEmpty  private final String name;
  @Email private final String email;
  private final String password;
  private final String passwordConfirmation;

  @JsonIgnore
  public Boolean shouldPasswordBeValidated() {
    return password != null || passwordConfirmation != null;
  }

  @JsonIgnore
  public Boolean isPasswordConfirmationValid() {
    return password != null && password.equals(passwordConfirmation);
  }
}
