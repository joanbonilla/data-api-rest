package io.spring.api.data.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.spring.api.data.model.DataResponse;
import io.spring.api.data.model.ItemResponse;
import io.spring.api.data.model.Organization;
import io.spring.api.data.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpenDataService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public DataResponse getData() throws IOException {

        String result = restTemplate.getForObject(
                "http://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search",
                String.class);

        DataResponse response = objectMapper.readValue(result, DataResponse.class);

        return response;
    }

}
