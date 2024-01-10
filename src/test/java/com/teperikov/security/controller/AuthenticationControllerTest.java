package com.teperikov.security.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.teperikov.security.BaseTest;
import com.teperikov.security.controller.AuthenticationController;
import com.teperikov.security.dto.auth.AuthenticationRequest;
import com.teperikov.security.dto.auth.AuthenticationResponse;
import com.teperikov.security.dto.auth.RegisterRequest;
import com.teperikov.security.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

public class AuthenticationControllerTest extends BaseTest {

  @Mock
  private AuthenticationService authenticationService;
  @InjectMocks
  private AuthenticationController authenticationController;


  @Test
  public void testRegister() {
    //given
    final var registerRequest = new RegisterRequest();
    final var expectedResponse = new AuthenticationResponse();
    when(authenticationService.register(registerRequest)).thenReturn(expectedResponse);

    //when
    final var responseEntity = authenticationController.register(registerRequest);

    //then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(expectedResponse, responseEntity.getBody());
    verify(authenticationService, times(1)).register(registerRequest);
  }

  @Test
  public void testAuthenticate() {
    //given
    final var authenticationRequest = new AuthenticationRequest();
    final var expectedResponse = new AuthenticationResponse();
    when(authenticationService.authenticate(authenticationRequest)).thenReturn(expectedResponse);

    //when
    final var responseEntity = authenticationController.authenticate(authenticationRequest);

    //then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(expectedResponse, responseEntity.getBody());
    verify(authenticationService, times(1)).authenticate(authenticationRequest);
  }

  @Test
  public void testRefreshToken() throws IOException {
    //given
    final var request = mock(HttpServletRequest.class);
    final var response = mock(HttpServletResponse.class);

    //when
    authenticationController.refreshToken(request, response);

    //then
    verify(authenticationService, times(1)).refreshToken(request, response);
  }
}