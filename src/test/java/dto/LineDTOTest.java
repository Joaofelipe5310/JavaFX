package dto;

import org.junit.Test;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class LineDTOTest {

    @Test
    public void LineDTOTest() {

        LineDTO line = new LineDTO();
        CategoryDTO category = new CategoryDTO();
        category.setId(1);
        category.setName("cattest");
        line.setId(1);
        line.setName("linetest");
        line.setCategories(Collections.singletonList(category));

        assertEquals("linetest", line.getName());
        assertEquals(1, line.getId());
        assertEquals("cattest", line.getCategories().get(0).getName());
    }
}