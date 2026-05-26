package service;

import dto.LineDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class LineService {

    protected RestTemplate restTemplate = new RestTemplate();

    protected String url = "http://localhost:8080/lines";

    public List<LineDTO> lineEndpointConnectionByRestTemplate() {

        try {
            ResponseEntity<LineDTO[]> response = restTemplate.exchange(new URI(url), HttpMethod.GET,  HttpEntity.EMPTY, LineDTO[].class);

            LineDTO[] lines = response.getBody();

            return Arrays.asList(lines);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return java.util.Collections.emptyList();
    }
}
