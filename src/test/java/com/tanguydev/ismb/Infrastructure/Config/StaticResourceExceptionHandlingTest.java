package com.tanguydev.ismb.Infrastructure.Config;

import com.tanguydev.ismb.Domain.Response.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class StaticResourceExceptionHandlingTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void whenStaticResourceNotFound_shouldReturn404AndErrorResponse() {
        // Request a non-existent file in the /uploads directory
        ResponseEntity<ErrorResponse> response = restTemplate.getForEntity("/uploads/non-existent-file.jpeg", ErrorResponse.class);

        // Verify that the status code is 404 NOT FOUND
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        // Verify the ErrorResponse body
        ErrorResponse body = response.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getMessage()).isEqualTo("La ressource demandée n'a pas été trouvée");
        assertThat(body.getError()).isEqualTo("Resource Not Found");
        assertThat(body.getPath()).isEqualTo("/uploads/non-existent-file.jpeg");
    }
}
