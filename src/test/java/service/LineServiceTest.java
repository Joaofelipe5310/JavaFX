package service;

import dto.LineDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LineServiceTest {

    LineService service;

    @Before
    public void setup() {
        service = spy(LineService.class);

        service.restTemplate = spy(RestTemplate.class);

        service.url = "http://localhost:8080/lines";

    }

    @Test
    public void lineEndpointConnectionByRestTemplateSuccessTest() {
        LineDTO line = new LineDTO();
        line.setName("LINHA TESTE");
        LineDTO line2 = new LineDTO();
        line2.setName("LINHA TESTE 2");
        LineDTO[] fakeJSON = {line, line2};
        ResponseEntity<LineDTO[]> response = new ResponseEntity<>(fakeJSON, HttpStatus.OK);

        doReturn(response).when(service.restTemplate).exchange(any(), eq(HttpMethod.GET), eq(HttpEntity.EMPTY), eq(LineDTO[].class));

        LineDTO[] lines = response.getBody();
        List<LineDTO> result = new ArrayList<>();
        result.addAll(Arrays.asList(lines));

        service.lineEndpointConnectionByRestTemplate();

        assertEquals("LINHA TESTE", result.get(0).getName());
        assertEquals("LINHA TESTE 2", result.get(1).getName());
    }

    @Test
    public void lineEndpointConnectionByRestTemplateFailConnectionTest() {

        RestTemplate mockRestTemplate = mock(RestTemplate.class);

        service.restTemplate = mockRestTemplate;

        when(service.restTemplate.exchange(any(URI.class), eq(HttpMethod.GET), eq(HttpEntity.EMPTY), eq(LineDTO[].class))).thenThrow(new RuntimeException());

        List<LineDTO> result = service.lineEndpointConnectionByRestTemplate();

        assertTrue(result.isEmpty());
    }
}