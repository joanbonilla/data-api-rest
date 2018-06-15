package io.spring.api.data.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.spring.api.data.model.DataResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class OpenDataService {

    private static final String DATA_URI = "http://opendata-ajuntament.barcelona.cat/data/api/3/action/package_search";

    private final Logger logger = LogManager.getLogger(OpenDataService.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public DataResponse getData() throws IOException {

        logger.info("Getting remote data {}.", System.currentTimeMillis());

        DataResponse response = objectMapper.readValue(
                restTemplate.getForObject(DATA_URI, String.class),
                DataResponse.class);

        return response;
    }

}
