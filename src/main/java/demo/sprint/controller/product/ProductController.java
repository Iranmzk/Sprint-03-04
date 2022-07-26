package demo.sprint.controller.product;

import demo.sprint.controller.product.model.response.ProductControllerResponse;
import demo.sprint.model.walmartEntity.ProductEntity;
import demo.sprint.service.data.DataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/prod")
@AllArgsConstructor
public class ProductController {

    private ControllerFacade facade;
    private DataService service;

    @GetMapping("/search")
    public ProductControllerResponse getProd(@RequestParam String usItemId) {
        return facade.findProd(usItemId);
    }
    @GetMapping("/all")
    public List<ProductControllerResponse> findAll(){
        return facade.findAllProd();
    }
    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity save(@RequestBody ProductEntity entity) {
        return service.save(entity);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT )
    public void delete(@RequestParam List<String> usItemId){
        facade.deleteProdById(usItemId);
    }
}


