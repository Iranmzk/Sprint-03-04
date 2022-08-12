package demo.sprint.controller.walmart;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static demo.sprint.controller.walmart.WalmartControllerStub.WalmartControllerExpectedStub;
import static demo.sprint.controller.walmart.WalmartControllerStub.WalmartControllerStubResponse;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WalmartController.class)
class WalmartControllerTest {

    // Main entry point for server-side Spring MVC test support.
        @Autowired
    private MockMvc mvc;

    // Mocking the ControllerFacade class.
    @MockBean
    private static ControllerFacade facade;

    @Test
    void findProductDetails() throws Exception {
        var controllerExpected = WalmartControllerExpectedStub();
        var controllerResponse = WalmartControllerStubResponse();

        when(facade.findProductDetails("54457638")).thenReturn(controllerResponse);

        // Creating a new instance of the ObjectMapper class.
        var objMapper = new ObjectMapper();

        // Converting the object to a JSON string.
        var expected = objMapper.writeValueAsString(controllerExpected);

        // Testing the controller.
        mvc.perform( MockMvcRequestBuilders
                        .get("http://localhost:8080//v1/prod/stock?usItemId=54457638"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));

    }
}