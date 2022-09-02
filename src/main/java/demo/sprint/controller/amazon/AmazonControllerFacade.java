package demo.sprint.controller.amazon;

import demo.sprint.controller.amazon.model.ControllerResponse;
import demo.sprint.service.amazon.AmazonServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static demo.sprint.controller.amazon.mapper.ServiceToController.serviceToController;

@Component
@AllArgsConstructor
public class AmazonControllerFacade {

    private final AmazonServiceFacade facade;

    public List<ControllerResponse> findProductsDetails(String name){
    return serviceToController(facade.findProductDetails(name));
    }
}
