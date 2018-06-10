package io.spring.api.data.endpoint;

import io.spring.api.data.service.OpenDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DataController {

    @Autowired
    private OpenDataService service;

    @GetMapping("/data")
    @ResponseBody
    public Mono<String> data() {
        return Mono.just(service.getData());
    }

}
