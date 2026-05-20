package service;

import dto.LineDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class LineService {

    RestTemplate restTemplate = new RestTemplate();

    public List<LineDTO> lineEndpointConnectionByRestTemplate() {

        try {

            URL url = new URL("http://localhost:8080/lines");

            ResponseEntity<LineDTO[]> response = restTemplate.exchange(url.toURI(), HttpMethod.GET,  HttpEntity.EMPTY, LineDTO[].class);

            LineDTO[] lines = response.getBody();

            return Arrays.asList(lines);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return java.util.Collections.emptyList();
    }
}
