package controller;

import dto.CategoryDTO;
import dto.LineDTO;
import dto.ModelDTO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import service.LineService;
import java.util.List;

public class Controller {

    @FXML
    private ComboBox<LineDTO> cbDevice;

    @FXML
    private TreeView<String> treeData;

    @FXML
    private TitledPane tpMeters;

    protected LineService service = new LineService();

    @FXML
    public void initialize() {
        setTpMeters();
        setCbDevice();
    }

    public void setTpMeters() {
        tpMeters.setDisable(true);
        tpMeters.setExpanded(false);
    }

    public void setCbDevice() {

        List<LineDTO> lines = service.lineEndpointConnectionByRestTemplate();
        cbDevice.getItems().addAll(FXCollections.observableList(lines));

        cbDevice.valueProperty().addListener((observable, oldValue, newValue) -> {
            tpMeters.setDisable(false);
            tpMeters.setExpanded(true);

          LineDTO meter = cbDevice.getValue();
          TreeItem<String> root = new TreeItem<>(meter.getName());
          TreeItem<String> branch;
          for (CategoryDTO categories : meter.getCategories()) {
              branch = new TreeItem<>(categories.getName());
              root.getChildren().add(branch);
              for (ModelDTO model : categories.getModels()) {
                  branch.getChildren().add(new TreeItem<>(model.getName()));
              }
          }
          treeData.setRoot(root);
          root.setExpanded(true);
        });
    }
}