package demo.sprint.service.data;

import demo.sprint.integration.data.WalmartIntegration;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DataService {

    private final WalmartIntegration walmartIntegration;

//    public DataServiceResponse findProductIntegration(String usItemId){
//        return null;
//    }
}

