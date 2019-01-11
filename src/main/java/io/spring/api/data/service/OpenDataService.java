package io.spring.api.data.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.spring.api.data.model.DataResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import reactor.core.publisher.Mono;

@Service
public class OpenDataService {

    @Value("${api.data.uri}")
    private String  dataURI;

    private final Logger logger = LogManager.getLogger(OpenDataService.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public Mono<DataResponse> getData() throws IOException {

        logger.info("Getting remote data {}.", System.currentTimeMillis());

        DataResponse response = objectMapper.readValue(
                restTemplate.getForObject(dataURI, String.class),
                DataResponse.class);

        return Mono.just(response);
    }

}
