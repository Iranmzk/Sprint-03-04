package demo.sprint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StatusController {

    @GetMapping(path = "/v1/sprint03/test")
    public String check(){
        return "Status: Ok!";
    }

}
