package io.spring.api.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenDataService {

    @Autowired
    private RestTemplate restTemplate;

    public String getData(){
        return restTemplate.getForObject(
                "http://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search",
                String.class);
    }

}
