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
    public void ModelDTOTest() {

        model.setId(1);
        model.setName("modeltest");

        assertEquals("modeltest", model.getName());
        assertEquals(1, model.getId());
    }
}