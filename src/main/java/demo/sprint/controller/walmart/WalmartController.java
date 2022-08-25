package demo.sprint.controller.walmart;

import demo.sprint.controller.walmart.model.response.ProductControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/prod")
@AllArgsConstructor
public class WalmartController {

    private ControllerFacadeWalmart facade;

    @GetMapping("/stock-walmart")
    public ProductControllerResponse findProductDetails(@RequestParam @Valid String usItemId) {
        return facade.findProductDetails(usItemId);
    }

    @GetMapping("/stock-walmart-overall")
    public Page<ProductControllerResponse> findAllProduct(Pageable pageble) {
        return facade.findAllProd(pageble);
    }

    @GetMapping("/stock-walmart/{name}")
    public Page<ProductControllerResponse> findByName(@PathVariable("name") String name,Pageable pageable){
        return facade.findByName(name, pageable);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam List<String> usItemId){
        facade.deleteProdById(usItemId);
    }
}


