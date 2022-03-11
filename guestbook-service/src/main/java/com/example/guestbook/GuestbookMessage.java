package com.example.guestbook;

import javax.persistence.*;
import lombok.*;

/**
 *  @Entity: makes JPA aware that this is a DB object that would be stored/read from a DB.
 *  An entity has a no-arg (default) constructor and a primary key.
 *  https://docs.spring.io/spring-data/rest/docs/current/reference/html/#customizing-sdr.configuring-the-rest-url-path
 *
 * @Data: is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode, @Getter/@Setter
 * and @RequiredArgsConstructor together.
 * I.E. getters for all fields, setters for all non-final fields, and appropriate toString, equals and hashCode
 * implementations that involve the fields of the class, and a constructor that initializes all final fields, as well as
 * all non-final fields with no initializer that have been marked with @NonNull, in order to ensure the field is never null.
 * https://projectlombok.org/features/Data
 *
 * @Id: Specifies the primary key of an entity.
 *
 * @GeneratedValue: https://docs.oracle.com/javaee/7/api/javax/persistence/GeneratedValue.html
 * applied to a primary key property or field of an entity or mapped superclass in conjunction with the Id annotation
 */
@Entity
@Data
public class GuestbookMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String message;
	
	private String imageUri;
}

