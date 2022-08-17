package demo.sprint.controller.amazon;

import demo.sprint.controller.amazon.model.ControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/prod")
public class ControllerAmazon {
    private final ControllerFacadeAmazon facade;


    @GetMapping("/find")
    public List<ControllerResponse> findProducts(@RequestParam String name){
        return facade.findProductsDetails(name);
    }
}
