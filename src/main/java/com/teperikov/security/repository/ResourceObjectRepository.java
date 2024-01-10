package com.teperikov.security.repository;

import com.teperikov.security.dto.resource.ResourceObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceObjectRepository extends JpaRepository<ResourceObjectEntity, Integer> {

}
