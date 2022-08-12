package demo.sprint.service.walmart;

import demo.sprint.configuration.exception.apinotfoundexception.ApiNotFoundException;
import demo.sprint.integration.walmart.WalmartIntegration;
import demo.sprint.repository.WalmartRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static demo.sprint.service.walmart.WalmartServiceStub.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {WalmartService.class, WalmartRepository.class,WalmartIntegration.class})
@ExtendWith(MockitoExtension.class)
class WalmartServiceTest {

    @Mock
    private WalmartRepository repository;

    @InjectMocks
    private WalmartService walmartService;

    @Mock
    private WalmartIntegration integration;


    /**
     * The function is testing the service layer, which is responsible for calling the repository layer, which is
     * responsible for calling the API
     */
    @Test
    @DisplayName("Procurando no repositório pelo usItemId")
    void retornarProcuraNaServicePorUsItemId() {

        var expectedEntity = WalmartServiceStubExpected();
        var responseEntity = WalmartServiceStubResponse();

        when(repository.findById("54457638"))
                .thenReturn(responseEntity);

        var actual = walmartService.findByUsItemId("54457638");
        assertEquals(expectedEntity, actual);
    }

    /**
     * When I call the findProductIntegration method with the parameter "54457638", I expect the method to return the
     * expectedServiceResponse object.
     */
    @Test
    @DisplayName("Procurando na integração e salvando no banco de dados")
    void retornarProcuraNaIntegração() {
        var expectedServiceResponse = WalmartServiceResponseExpectedStub();
        var ProductEntity = productEntityStub();
        var expectedIntegrationResponse = WalmartIntegrationStubResponse();

        when(integration.findProductDetails("54457638")).thenReturn(expectedIntegrationResponse);

        when(repository.save(ProductEntity)).thenReturn(ProductEntity);

        var actual = walmartService.findProductIntegration("54457638");

        assertEquals(expectedServiceResponse, actual);
    }

    /**
     * A test function that tests the findAllProd() function.
     */
    @Test
    @Disabled
    @DisplayName("Retornando uma lista de produtos")
    void retornarListaDeProdutos() {
//        var expectedServiceResponse = WalmartServiceResponseExpectedStub();
//        var ProductEntity = WalmartentityStubListResponse();
//        when(repository.findAll()).thenReturn(ProductEntity);
//        var actual = walmartService.findAllProd();
//        assertEquals(expectedServiceResponse, actual);
    }


    // Testing if the method findProductIntegration is throwing an exception.
    @Test
    @DisplayName("Retornando um bad request")
    void whenNotFindProductIntegrationBadRequest() {

        var expectedIntegrationResponse = WalmartServiceStubBadRequest();

        when(integration.findProductDetails("13")).thenReturn(expectedIntegrationResponse);

// Testing if the method findProductIntegration is throwing an exception.
        Exception exception = assertThrows(ApiNotFoundException.class,
                () -> walmartService.findProductIntegration("13"));

        var expectativa = "Please,insert a valid usItemId";
        var actual = exception.getMessage();

        assertEquals(actual, expectativa);
    }
}