package com.teperikov.security.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.teperikov.security.dto.resource.ResourceObject;
import com.teperikov.security.service.ResourceObjectService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resource")
public class ResourceController {

  private final ResourceObjectService service;

  @PostMapping
  public ResponseEntity<Integer> createResourceObject(@RequestBody ResourceObject object) {
    final var result = service.save(object);
    return ok(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ResourceObject> getResourceObject(@PathVariable Integer id) {
    return ok(service.get(id));
  }

}
