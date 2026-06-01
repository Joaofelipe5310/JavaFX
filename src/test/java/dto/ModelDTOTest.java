package dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class ModelDTOTest {

    ModelDTO model;

    @Before
    public void setup() {

        model = new ModelDTO();

    }

    @Test
    public void SettersGettersTest() {

        model.setId(1);
        model.setName("modeltest");

        assertEquals("modeltest", model.getName());
        assertEquals(1, model.getId());
    }

    @Test
    public void ModelDTOConstructorTest() {

        ModelDTO dto = new ModelDTO(1, "modeltest");

        assertEquals(1, dto.getId());
        assertEquals("modeltest", dto.getName());
    }

    @Test
    public void ToStringTest() {

        ModelDTO model = new ModelDTO();
        model.setName("modeltest");

        assertEquals("modeltest", model.toString());
    }
}