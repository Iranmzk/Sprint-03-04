package demo.sprint.controller.amazon.mapper;

import demo.sprint.controller.amazon.model.ControllerResponse;
import demo.sprint.service.amazon.model.ProductService;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceToController{

    public static List<ControllerResponse> serviceToController(List<ProductService> service){
        return service.stream()
                .map(productServices -> ControllerResponse.builder()
                        .usItemId(productServices.getUsItemId())
                        .name(productServices.getName())
                        .price(productServices.getPrice())
                        .rate(productServices.getRate())
                        .prime(productServices.getPrime())
                        .build()).collect(Collectors.toList());
    }
}
