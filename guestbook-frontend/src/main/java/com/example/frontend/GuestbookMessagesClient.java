package com.example.frontend;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * We can use a number of different clients. For the lab, we'll use Feign.
 * For simplicity, we'll just use Map to represent the entities.
 * We'll default the endpoint to localhost for now, this will be overridden.
 *
 * @KEN
 * With feign, Spring Cloud integrates Ribbon and Eureka to provide a client-side load balanced http clients.
 * Client-side load-balancing: (https://www.linkedin.com/pulse/server-vs-client-side-load-balancing-ramit-sharma)
 * 	The load balancing decision resides with the client itself.
 * 	The client can take the help of a naming server (eg. Netflix Eureka) to get the list of registered backend server instances,
 * 	and then route the request to one of these backend instances using client-side load balancing libraries like Netflix Ribbon.
 * 	Advantages of client-side load balancing:
 * 		No more single point of failure as in the case of the traditional load balancer approach.
 * 		Reduced cost as the need for server-side load balancer goes away.
 * 		Less network latency as the client can directly invoke the backend servers removing an extra hop for the load balancer.
 *
 * The 'value' argument passed in the @FeignClient annotation is a mandatory, arbitrary client name,
 * while with the url argument, we specify the API base URL.
 *
 */
@FeignClient(
	value="messages",
	url="${messages.endpoint:http://localhost:8081/guestbookMessages}")
public interface GuestbookMessagesClient {
	@RequestMapping(method=RequestMethod.GET, path="/")
	PagedModel<GuestbookMessage> getMessages();
	
	@RequestMapping(method=RequestMethod.GET, path="/{id}")
	GuestbookMessage getMessage(@PathVariable("id") long messageId);
	
	@RequestMapping(method=RequestMethod.POST, path="/")
	GuestbookMessage add(@RequestBody GuestbookMessage message);

}

