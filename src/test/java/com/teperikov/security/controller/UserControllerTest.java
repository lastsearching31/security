package com.teperikov.security.controller;

import com.teperikov.security.BaseTest;
import com.teperikov.security.dto.user.ChangePasswordRequest;
import com.teperikov.security.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest extends BaseTest {

  @Mock
  private UserService userService;

  @InjectMocks
  private UserController userController;

  @Test
  public void testChangePassword() {
    //given
    final var changePasswordRequest = new ChangePasswordRequest();
    final var principal = mock(Principal.class);
    final var expectedResponseEntity = ResponseEntity.ok().build();
    doNothing().when(userService).changePassword(changePasswordRequest, principal);

    //when
    final var responseEntity = userController.changePassword(changePasswordRequest, principal);

    //then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(expectedResponseEntity, responseEntity);
    verify(userService, times(1)).changePassword(changePasswordRequest, principal);
  }
}
