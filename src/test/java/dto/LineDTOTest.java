package dto;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class LineDTOTest {

    @Test
    public void SettersGettersTest() {

        LineDTO line = new LineDTO();
        CategoryDTO category = new CategoryDTO();
        category.setId(1);
        category.setName("categorytest");
        line.setId(1);
        line.setName("linetest");
        line.setCategories(Collections.singletonList(category));

        assertEquals("linetest", line.getName());
        assertEquals(1, line.getId());
        assertEquals("categorytest", line.getCategories().get(0).getName());
    }

    @Test
    public void LineDTOConstructorTest() {

        List<CategoryDTO> categories = new ArrayList<>();
        LineDTO dto = new LineDTO(1, "linetest", categories);

        assertEquals(1, dto.getId());
        assertEquals("linetest", dto.getName());
        assertEquals(categories, dto.getCategories());
    }

    @Test
    public void ToStringTest() {

        LineDTO line = new LineDTO();
        line.setName("linetest");

        assertEquals("linetest", line.toString());
    }
}