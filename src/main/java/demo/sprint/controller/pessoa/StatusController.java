package demo.sprint.controller.pessoa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("SameReturnValue")
@RestController
public class StatusController {

    @SuppressWarnings("SameReturnValue")
    @GetMapping(path = "/v1/sprint03/test")
    public String check(){
        return "Status: Ok!";
    }

}
