package demo.sprint.service.walmart.facade;

import demo.sprint.service.walmart.WalmartService;
import demo.sprint.service.walmart.WalmartServiceFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static demo.sprint.service.walmart.facade.WalmartServiceFacadeStub.WalmartServiceResponseExpectedStub;
import static demo.sprint.service.walmart.facade.WalmartServiceFacadeStub.WalmartServiceStubResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {WalmartServiceFacade.class, WalmartService.class})
class WalmartServiceFacadeTest {
    @InjectMocks
    private static WalmartServiceFacade facade;
    @Mock
    private WalmartService service;

    @Test
    void findProductDetails() {
        var expectedProduct = WalmartServiceResponseExpectedStub();
        var responseExpected = WalmartServiceStubResponse();

        when(service.findByUsItemId("54457638")).thenReturn(responseExpected);

        var actual = facade.findProductDetails("54457638");

        assertEquals(expectedProduct, actual);
    }
}