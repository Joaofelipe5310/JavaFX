package dto;

import org.junit.Before;
import org.junit.Test;
import java.util.Collections;
import static org.junit.Assert.assertEquals;

public class CategoryDTOTest {

    CategoryDTO category;

    @Before
    public void setup() {

        category = new CategoryDTO();

    }

    @Test
    public void CategoryDTOTest() {

        ModelDTO models = new ModelDTO();
        models.setId(1);
        models.setName("modtest");
        category.setId(1);
        category.setName("categorytest");
        category.setModels(Collections.singletonList(models));

        assertEquals("categorytest", category.getName());
        assertEquals(1, category.getId());
        assertEquals("modtest", category.getModels().get(0).getName());
    }
}