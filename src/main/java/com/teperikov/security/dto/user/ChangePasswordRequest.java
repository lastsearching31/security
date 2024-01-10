package com.teperikov.security.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordRequest {

  private String currentPassword;
  private String newPassword;
  private String confirmationPassword;

  public ChangePasswordRequest() {

  }

  public ChangePasswordRequest(String currentPassword, String newPassword,
      String confirmationPassword) {
    this.currentPassword = currentPassword;
    this.newPassword = newPassword;
    this.confirmationPassword = confirmationPassword;
  }
}
