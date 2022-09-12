package demo.sprint.controller.walmart;

import demo.sprint.controller.walmart.model.response.ProductControllerResponse;
import demo.sprint.repository.walmart.walmartentity.ProductQuery;
import io.swagger.annotations.ApiParam;
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

    private WalmartControllerFacade facade;

    @GetMapping("/stock-walmart")
    public ProductControllerResponse findProductDetails(@RequestParam
                                                            @Valid
                                                            @ApiParam(name = "Find by Id", value = "Return a JSON of product, " +
                                                                    "searching in database and if don't found," +
                                                                    " looks in the integration" +
                                                                    " returning name,price,usItemId,segment,type and short description")
                                                            String usItemId) {
        return facade.findProductDetails(usItemId);
    }

    @GetMapping("/stock-walmart-overall")
    public Page<ProductControllerResponse> findAllProduct(Pageable pageble) {
        return facade.findAllProd(pageble);
    }

    @GetMapping("/stock-walmart/{name}")
    public List<ProductControllerResponse> findByName(@PathVariable("name") String name) {
        return facade.findByName(name);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam List<String> usItemId) {
        facade.deleteProdById(usItemId);
    }

    @GetMapping("/custom")
    public List<ProductControllerResponse> find(@RequestBody @ApiParam(name = "Product Body", value = "a JSON representing the product, " +
            "with name, price, segment, type") ProductQuery productQuery) {
        return facade.find(productQuery);
    }
}


