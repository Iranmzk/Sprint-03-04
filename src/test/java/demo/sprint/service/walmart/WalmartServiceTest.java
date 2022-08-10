package demo.sprint.service.walmart;

import demo.sprint.integration.walmart.WalmartIntegration;
import demo.sprint.model.walmartentity.ProductEntity;
import demo.sprint.repository.WalmartRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {WalmartService.class, WalmartRepository.class,WalmartIntegration.class})
@ExtendWith(MockitoExtension.class)
class WalmartServiceTest {
    @Mock
    private WalmartRepository repository;
    @InjectMocks
    private WalmartService walmartService;
    @Mock
    private WalmartIntegration integration;

    @Test
    // Creating a new object of type ProductEntity.
    void retornarProcuraPorUsItemId() {
        var expectativa = Optional.ofNullable(ProductEntity.builder()
                .usItemId("498095235")
                .id("2SPQWCUTAFIH")
                .segment("Vehicles, Parts & Accessories")
                .type("Automotive Seat Cushions")
                .name("Sleepavo Orthopedic Memory Foam Seat Cushion Back and Coccyx Support Pillow for Office Chair and Car")
                .build());

        // The expected value.
        when(walmartService.findByUsItemId("498095235")).thenReturn(expectativa);

        var atual = repository.findById("498095235");

        Assertions.assertEquals(expectativa,atual);
    }
}
