package com.example.frontend;

import lombok.Data;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;

/**
 * @KEN
 *
 * RepresentationModel:
 *  applies Hypermedia as the Engine of Application State (HATEOAS) formatting to a GuestbookMessage resource.
 */
@Data
public class GuestbookMessage extends RepresentationModel<GuestbookMessage> {
  private String id;

  private String name;

  private String message;

  private String imageUri;

}
