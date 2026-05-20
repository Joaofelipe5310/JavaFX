package dto;

import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private List<dto.ModelDTO> models;

    public CategoryDTO(){}

    public CategoryDTO(int id, String name, List<ModelDTO> models) {
        this.id = id;
        this.name = name;
        this.models = models;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<ModelDTO> getModels() { return models; }
}