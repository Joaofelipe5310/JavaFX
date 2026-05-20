package service;

import dto.LineDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LineServiceTest {

    LineService service;

    RestTemplate restTemplate;

    @Before
    public void setup() {

        restTemplate = mock(RestTemplate.class);

        service = new LineService();

        service.restTemplate = restTemplate;
    }

    @Test
    public void lineEndpointConnectionByRestTemplateSucessTest() {

        LineDTO line = new LineDTO();
        line.setName("LINHA TESTE");
        LineDTO line2 = new LineDTO();
        line2.setName("LINHA TESTE 2");
        LineDTO[] fakeJSON = {line, line2};
        ResponseEntity<LineDTO[]> response = new ResponseEntity<>(fakeJSON, HttpStatus.OK);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(LineDTO[].class))).thenReturn(response);
        LineDTO[] lines = response.getBody();
        List<LineDTO> result = Arrays.asList(lines);
        service.lineEndpointConnectionByRestTemplate();
        System.out.println(Arrays.asList(lines));
        System.out.println(result);
        System.out.println(Collections.singletonList(response));
        System.out.println(service.lineEndpointConnectionByRestTemplate());


        assertEquals("LINHA TESTE", result.get(0).getName());
        assertEquals("LINHA TESTE 2", result.get(1).getName());
    }

//    @Test
//    public void lineEndpointConnectionByRestTemplateErrorTest() {
//
//        when(service.lineEndpointConnectionByRestTemplate()).thenThrow(new RuntimeException());
//
//        assertThrows(RuntimeException.class, () -> service.lineEndpointConnectionByRestTemplate());
//
//    }
}