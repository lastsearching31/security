package com.teperikov.security.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.teperikov.security.BaseTest;
import com.teperikov.security.controller.ResourceController;
import com.teperikov.security.dto.resource.ResourceObject;
import com.teperikov.security.service.ResourceObjectService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

public class ResourceControllerTest extends BaseTest {

  @Mock
  private ResourceObjectService resourceObjectService;

  @InjectMocks
  private ResourceController resourceController;

  @Test
  public void testCreateResourceObject() {
    //given
    final var resourceObject = getResourceObject();
    final var expectedResult = 1;
    when(resourceObjectService.save(resourceObject)).thenReturn(expectedResult);

    //when
    final var responseEntity = resourceController.createResourceObject(
        resourceObject);

    //then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(expectedResult, responseEntity.getBody());
    verify(resourceObjectService, times(1)).save(resourceObject);
  }

  @Test
  public void testGetResourceObject() {
    //given
    final var resourceId = 1;
    final var expectedResourceObject = new ResourceObject();
    when(resourceObjectService.get(resourceId)).thenReturn(expectedResourceObject);

    //when
    final var responseEntity = resourceController.getResourceObject(
        resourceId);

    //then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(expectedResourceObject, responseEntity.getBody());
    verify(resourceObjectService, times(1)).get(resourceId);
  }

  public static ResourceObject getResourceObject() {
    final var resourceObject = new ResourceObject();
    resourceObject.setId(1);
    resourceObject.setPath("Path");
    resourceObject.setValue("Value");
    return resourceObject;
  }
}
