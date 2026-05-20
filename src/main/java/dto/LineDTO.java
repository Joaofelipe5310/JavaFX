package dto;

import java.util.List;

public class LineDTO {

    private int id;
    private String name;
    private List<CategoryDTO> categories;

    public LineDTO(){}

    public LineDTO(int  id, String name, List<CategoryDTO> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public int getId() {return id; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public String getName() { return name; }

    public List<CategoryDTO> getCategories() { return categories;}

    @Override
    public String toString() {
        return name;
    }
}
