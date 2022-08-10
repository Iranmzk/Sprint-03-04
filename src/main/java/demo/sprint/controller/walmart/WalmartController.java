package demo.sprint.controller.walmart;

import demo.sprint.controller.walmart.model.response.ProductControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/prod")
@AllArgsConstructor
public class WalmartController {

    private ControllerFacade facade;

    //TODO: JUNTAR OS DOIS ENDPOINTS DE GET - (OK)
    @GetMapping("/stock")
    public ProductControllerResponse findProductDetails(@RequestParam @Valid String usItemId) {
        return facade.findProductDetails(usItemId);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam List<String> usItemId){
        facade.deleteProdById(usItemId);
    }
}


