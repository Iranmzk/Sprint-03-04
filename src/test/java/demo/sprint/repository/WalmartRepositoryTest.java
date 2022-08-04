package demo.sprint.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.sprint.integration.data.WalmartIntegration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static demo.sprint.repository.WallmartRepositoryStub.DataIntegrationResponseExpected;
import static demo.sprint.repository.WallmartRepositoryStub.prodIntegrationResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

// Telling JUnit to use Mockito to create the mock objects.
@ExtendWith(MockitoExtension.class)
// Telling Spring to use the `WalmartIntegration` class as the configuration class.
@ContextConfiguration(classes = WalmartIntegration.class)
class WalmartRepositoryTest {

    // Injecting the mock object into the class under test.
    @InjectMocks
    private WalmartIntegration walmartIntegrationation;
    // Creating a mock server.
    private static ClientAndServer server;

    /**
     * `startClientAndServer()` starts a mock server on a random port and returns a `WireMockServer` object
     */
    @BeforeAll
    static void start() {
        server = startClientAndServer();
    }

    /**
     * After all tests have run, stop the server.
     */
    @AfterAll
    static void afterAll() {
        server.stop();
    }

    /**
     * It sets up the RestTemplateBuilder to use the port of the server.
     */
    @BeforeEach
    void setUpRest() {
        var template = new RestTemplateBuilder()
                .rootUri(String.format("http://localhost:%d", server.getPort()))
                .build();

        walmartIntegrationation = new WalmartIntegration(template);
    }

    @Test
    @DisplayName("Testando se encontra item banco de dados")
    void WhenFindProductExpect() throws JsonProcessingException {
        var expect = DataIntegrationResponseExpected();

        var httpRequest = HttpRequest.request()
                .withPath("/products/v3/get-details")
                .withQueryStringParameter("usItemId","54457638")
                .withMethod("GET");

        var mapper = new ObjectMapper();

        // Converting the object to a string.
        var body = mapper.writeValueAsString(prodIntegrationResponse());

        // Creating a response with the body, status code and content type.
        var response = HttpResponse.response(body)
                .withStatusCode(HttpStatus.OK.value())
                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        // Mocking the response of the server.
        server.when(httpRequest).respond(response);

        var actual = walmartIntegrationation.findProductDetails("54457638");
        // Comparing the expected value with the actual value.
        assertEquals(expect, actual);

    }
}