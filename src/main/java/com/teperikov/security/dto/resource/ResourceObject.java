package com.teperikov.security.dto.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceObject {

  private Integer id;
  private String value;
  private String path;

}
