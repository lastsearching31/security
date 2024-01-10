package com.teperikov.security.service;

import com.teperikov.security.dto.resource.ResourceObject;
import com.teperikov.security.dto.resource.ResourceObjectEntity;
import com.teperikov.security.repository.ResourceObjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * ResourceObjectService.
 *
 * @author Teperikov_Anton
 */
@Service
@RequiredArgsConstructor
public class ResourceObjectService {

  private final ResourceObjectRepository repository;

  public Integer save(ResourceObject resourceObject) {
    return repository.save(new ResourceObjectEntity(
        resourceObject.getId(), resourceObject.getValue(),
        resourceObject.getPath())).getId();

  }

  public ResourceObject get(int id) {
    return repository.findById(id)
        .map(r -> new ResourceObject(r.getId(), r.getValue(), r.getPath()))
        .orElse(null);
  }

}
