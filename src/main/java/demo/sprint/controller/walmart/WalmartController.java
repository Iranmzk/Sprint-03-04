package demo.sprint.controller.walmart;

import demo.sprint.configuration.exception.errorresponse.ErrorResponse;
import demo.sprint.controller.walmart.model.response.ProductControllerResponse;
import demo.sprint.repository.walmart.walmartentity.ProductQuery;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/prod")
@AllArgsConstructor
public class WalmartController {

    private WalmartControllerFacade facade;

    @GetMapping("/stock-walmart-overall")
    @ApiResponses(
            @ApiResponse(
                    code = 200, message = "ok"
            )
    )
    public Page<ProductControllerResponse> findAllProduct(Pageable pageble) {
        return facade.findAllProd(pageble);
    }

    @DeleteMapping("/product")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses(
            @ApiResponse(code = 204, message = "no content")
    )
    public void delete(@RequestParam List<String> usItemId) {
        facade.deleteProdById(usItemId);
    }

    @GetMapping("/custom")
    @ApiResponses(
            @ApiResponse(code = 400, message = "bad request", response = ErrorResponse.class)
    )
    public List<ProductControllerResponse> find(@RequestBody @ApiParam(name = "Product Body", value = "a JSON representing the product, " +
            "with name, price(LT and GT), segment, type") ProductQuery productQuery) {
        return facade.find(productQuery);
    }
}


