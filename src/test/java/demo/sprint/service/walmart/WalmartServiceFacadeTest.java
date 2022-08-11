package demo.sprint.service.walmart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {WalmartServiceFacade.class, WalmartService.class})
class WalmartServiceFacadeTest {
    @InjectMocks
    private static WalmartServiceFacade facade;
    @Mock
    private WalmartService service;

    @Test
    void findProductDetails() {


    }

    @Test
    void deleteProdById() {
    }
}