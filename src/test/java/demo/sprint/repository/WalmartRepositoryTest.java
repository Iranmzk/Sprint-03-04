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
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import static demo.sprint.repository.WallmartRepositoryStub.DataIntegrationResponseExpected;
import static demo.sprint.repository.WallmartRepositoryStub.prodIntegrationResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = WalmartIntegration.class)
class WalmartRepositoryTest {

    @InjectMocks
    private WalmartIntegration walmartIntegrationation;
    private static ClientAndServer server;

    @BeforeAll
    static void start() {
        server = startClientAndServer();
    }

    @AfterAll
    static void afterAll() {
        server.close();
    }

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
                .withQueryStringParameter("?usItemId=54457638")
                .withMethod("GET");

        var mapper = new ObjectMapper();

        var body = mapper.writeValueAsString(prodIntegrationResponse());

        var response = HttpResponse.response(body)
                .withStatusCode(HttpStatus.OK.value())
                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        server.when(httpRequest).respond(response);

        var actual = walmartIntegrationation.findProductDetails("54457638");
        assertEquals(expect, actual);

    }
}