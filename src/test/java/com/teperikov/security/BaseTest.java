package com.teperikov.security;


import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseTest {
  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

}
