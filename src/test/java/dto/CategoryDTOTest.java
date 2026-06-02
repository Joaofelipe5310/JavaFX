package dto;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CategoryDTOTest {

    CategoryDTO category;

    @Before
    public void setup() {

        category = new CategoryDTO();

    }

    @Test
    public void SettersGettersTest() {

        ModelDTO models = new ModelDTO();
        models.setId(1);
        models.setName("modeltest");
        category.setId(1);
        category.setName("categorytest");
        category.setModels(Collections.singletonList(models));

        assertEquals("categorytest", category.getName());
        assertEquals(1, category.getId());
        assertEquals("modeltest", category.getModels().get(0).getName());
    }

    @Test
    public void CategoryDTOConstructorTest() {

        List<ModelDTO> models = new ArrayList<>();
        CategoryDTO category = new CategoryDTO(1, "categorytest", models);

        assertEquals(1, category.getId());
        assertEquals("categorytest", category.getName());
        assertEquals(models, category.getModels());
    }

    @Test
    public void ToStringTest() {

        CategoryDTO category = new CategoryDTO();
        category.setName("categorytest");

        assertEquals("categorytest", category.toString());
    }
}