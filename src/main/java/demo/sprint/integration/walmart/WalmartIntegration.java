package demo.sprint.integration.walmart;

import demo.sprint.integration.model.DataIntegrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
@Qualifier()
public class WalmartIntegration {
//TODO: @QUALIFIER E PRIORIDADE DE BEAN -
//TODO: FAZER REQUEST E RESPONSE DOS PRODUTOS - (OK)
//TODO: ORGANIZAÇÃO DE PASTAS - (OK)
//TODO: REFATORAR NOMES PASTAS - (OK)
//TODO: .ERRORHANDLER COSTUMIZADO NA CONFIG DO RESTEMPLATE - (OK)
//TODO: INTEGRAR OUTRA APLICAÇÃO -
//TODO: MONGOTEMPLATE/QUERY DATAS -
//TODO: SEPARAR CLASSES DE CONTROLERS -
//TODO: ESTUDAR PROPERTIES DO SPRING -
    private final RestTemplate restTemplate;

    /**
     * > This function will make a GET request to the Walmart Open API and return the response as a DataIntegrationResponse
     * object
     *
     * @param usItemId The unique identifier for the product.
     * @return A DataIntegrationResponse object
     */
    public DataIntegrationResponse findProductDetails(String usItemId){
        return restTemplate.getForObject("/products/v3/get-details?usItemId=".concat(usItemId), DataIntegrationResponse.class);
    }
}
