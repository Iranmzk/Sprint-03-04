package demo.sprint.service.data;

import demo.sprint.integration.data.DataIntegration;
import demo.sprint.service.data.model.response.DataServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DataService {

    private final DataIntegration dataIntegration;

    public DataServiceResponse findProduct(String usItemId){
        return null;
    }
}

