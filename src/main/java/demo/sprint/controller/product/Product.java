package demo.sprint.controller.product;

import demo.sprint.service.product.ProductServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v3/prod")
public class Product {
    ProductServiceFacade productServiceFacade;

}
