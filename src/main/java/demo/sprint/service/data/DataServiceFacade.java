package demo.sprint.service.data;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataServiceFacade {
    private final DataService dataService;

//    public DataServiceResponse findProductIntegration(String usItemId){
//        return dataService.(usItemId);
//    }
}
