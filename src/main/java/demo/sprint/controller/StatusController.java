package demo.sprint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StatusController {

    @GetMapping(path = "/v1/test")
    public Optional<String> check(){
        return Optional.ofNullable("Status: Ok!");
    }

}
