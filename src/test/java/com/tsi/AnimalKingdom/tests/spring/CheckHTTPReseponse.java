package com.tsi.AnimalKingdom.tests.spring;

import com.tsi.AnimalKingdom.spring.AnimalKingdomApplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AnimalKingdomApplication.class)
public class CheckHTTPReseponse {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldPassIfHello() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject(
                "http://localhost:"+port+"/",
                String.class)).contains("Hello from Mat.");
    }
}
