package demo.sprint.configuration.exception.apiexterror;

import demo.sprint.configuration.exception.apinotfoundexception.ApiNotFoundException;
import demo.sprint.integration.walmart.model.DataIntegrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.function.Function;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;
public class ApiErrorHandler implements ResponseErrorHandler {
    public static Function<DataIntegrationResponse, DataIntegrationResponse> productValidation() {
        return product -> {
            // A class that provides static utility methods for simple operations on objects.
            if (ObjectUtils.isEmpty(product.getData()
                    .getProduct())) {
                throw new ApiNotFoundException("Insert a valid usItemId");
            }
            return product;
        };
    }

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        return (httpResponse.getStatusCode().series() == CLIENT_ERROR
                        || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {

        if (httpResponse.getStatusCode()
                .series() == SERVER_ERROR) {
        } else if (httpResponse.getStatusCode()
                .series() == CLIENT_ERROR) {
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ApiNotFoundException("Not found");
            }
        }
    }
}
