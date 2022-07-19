package demo.sprint.service.data;

import demo.sprint.service.data.model.response.DataServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataServiceFacade {
    private final DataService dataService;

//    public DataServiceResponse findProduct(String usItemId){
//        return dataService.findProduct(usItemId);
//    }
}
