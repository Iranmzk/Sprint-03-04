package demo.sprint.controller.product;

import demo.sprint.configuration.rest.RestConfig;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class Product {

    RestConfig rest;
    @GetMapping("/prod")
    public RestTemplate data(){
        return rest.restTemplate();
    }
}
