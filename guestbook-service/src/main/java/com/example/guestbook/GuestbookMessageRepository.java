package com.example.guestbook;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *	@KEN
 *	https://docs.spring.io/spring-data/rest/docs/current/reference/html/#reference
 *	Spring Data REST exposes a collection resource at the root path '/guestbookMessages'.
 *	The path is derived from the uncapitalized, pluralized, simple class name of the domain class being managed.
 *	It also exposes an item resource for each of the items managed by the repository under the URI template /guestbookMessages/{id}
 *
 *	If this resource needs to be exported under a separate base path, then follow this:
 *	https://stackoverflow.com/questions/24577400/how-can-i-map-a-spring-boot-repositoryrestresource-to-a-specific-url
 *	To change the base URI, update 'application.properties':
 *		spring.data.rest.base-path=/my/base/uri
 *	Or by annotating as
 *	@RepositoryRestResource(path = "messages")
 *
 *  The default annotation below exports the root path 'http://localhost:8081/guestbookMessages'
 */
@RepositoryRestResource
public interface GuestbookMessageRepository extends
	PagingAndSortingRepository<GuestbookMessage, Long> {
}

