package com.example.guestbook;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * These tests are for the CRUD operations of the API.
 * Can use either H2 inmemory database or hsqldb using the pom.xml.
 * The DB Schema is automa'G'ically configured by Spring using entities.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = GuestbookApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class RESTApiTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    /**
     * Sample Response:
     *  "{
     *   "_links" : {
     *     "guestbookMessages" : {
     *       "href" : "http://localhost:49154/guestbookMessages{?page,size,sort}",
     *       "templated" : true
     *     },
     *     "profile" : {
     *       "href" : "http://localhost:49154/profile"
     *     }
     *   }
     * }"
     */
    public void testRootPathShowsDiscoveryInfo() {
        String response = testRestTemplate.getForObject("http://localhost:" + port + "/",String.class);

        assertThat(response)
                .contains("\"_links\"")
                .hasLineCount(11) //May be not a good test, but it is possible
                .containsPattern("http://localhost:\\d+/guestbookMessages\\{\\?page,size,sort\\}")
                .contains("\"guestbookMessages\"")
                .contains("/guestbookMessages{?page,size,sort}")
                .contains("profile")
                .containsPattern("http://localhost:\\d+/profile");
    }

    @Test
    /**
     * This tests creation of a new record using the POST and reading it using GET
     *
     * response = {
     *   "name" : "N1",
     *   "message" : "M1",
     *   "imageUri" : null,
     *   "_links" : {
     *     "self" : {
     *       "href" : "http://localhost:62292/guestbookMessages/1"
     *     },
     *     "guestbookMessage" : {
     *       "href" : "http://localhost:62292/guestbookMessages/1"
     *     }
     *   }
     * }
     */
    public void testCreatReadMessage() {
        System.out.println("testPostMessage starting");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        GuestbookMessage guestbookMessage = new GuestbookMessage();
        guestbookMessage.setName("N1");
        guestbookMessage.setMessage("M1");
        HttpEntity<GuestbookMessage> httpEntity = new HttpEntity<>(guestbookMessage, headers);
        Object res = testRestTemplate.postForObject(
                "http://localhost:" + port + "/guestbookMessages",
                httpEntity,
                GuestbookMessage.class);
        System.out.printf("Returned object %s",res.getClass().toString());
        System.out.println("res = "+res.toString());
        String response = testRestTemplate.getForObject("http://localhost:" + port + "/guestbookMessages/1",String.class);
        System.out.println("response = " + response);
        assertThat(response)
                .contains("\"name\" : \"N1\"")
                .contains("\"message\" : \"M1\"")
                .contains("_links")
                .containsPattern("\"href\" : \"http://localhost:" + port+ "/guestbookMessages/1")
                .contains("\"guestbookMessage\"");
    }
}
