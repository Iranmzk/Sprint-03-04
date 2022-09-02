package demo.sprint.controller.walmart.facade;

import demo.sprint.controller.walmart.WalmartControllerFacade;
import demo.sprint.service.walmart.WalmartServiceFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static demo.sprint.controller.walmart.facade.ControllerFacadeStub.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {WalmartControllerFacade.class, WalmartServiceFacade.class})
class AmazonWalmartControllerFacadeTest {

    @InjectMocks
    private static WalmartControllerFacade facade;
    @Mock
    private static WalmartServiceFacade serviceFacade;

    /**
     * It tests the findProductDetails function in the facade class by mocking the serviceFacade and returning a
     * WalmartControllerExpectedStub object
     */
    @Test
    void findProductDetails() {
        var expectedProductControllerResponse = WalmartControllerStubResponse();
        var responseWalmartControllerExpectedStub = WalmartControllerExpectedStub();

        when(serviceFacade.findProductDetails("54457638")).thenReturn(responseWalmartControllerExpectedStub);

        var actual = facade.findProductDetails("54457638");

        assertEquals(expectedProductControllerResponse,actual);
    }
}