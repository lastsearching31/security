package com.teperikov.security.controller;

import com.teperikov.security.dto.user.ChangePasswordRequest;
import com.teperikov.security.service.UserService;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  @PatchMapping
  public ResponseEntity<?> changePassword(
      @RequestBody ChangePasswordRequest request,
      Principal connectedUser
  ) {
    service.changePassword(request, connectedUser);
    return ResponseEntity.ok().build();
  }
}
