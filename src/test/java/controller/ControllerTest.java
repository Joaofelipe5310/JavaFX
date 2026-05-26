package controller;

import dto.CategoryDTO;
import dto.LineDTO;
import dto.ModelDTO;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.junit.Before;
import org.junit.Test;
import service.LineService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ControllerTest {

    Controller controller;

    TitledPane tpMeters;

    ComboBox<LineDTO> cbDevice;

    TreeView<String> treeData;

    LineService service;

    @Before
    public void setUp() {

        new JFXPanel();

        service = mock(LineService.class);

        controller = new Controller();
        tpMeters = new TitledPane();
        cbDevice = new ComboBox<>();
        treeData = new TreeView<>();

        controller.tpMeters = tpMeters;
        controller.treeData = treeData;
        controller.cbDevice = cbDevice;

        controller.service = service;
    }

    @Test
    public void initializeTest() {

        tpMeters.setDisable(false);
        cbDevice.isDisable();

        controller.initialize();

        assertTrue(tpMeters.isDisable());
        assertFalse(cbDevice.isDisable());
    }

    @Test
    public void setTpMetersTest() {

        tpMeters.setDisable(false);
        tpMeters.setExpanded(true);

        controller.setTpMeters();

        assertTrue(tpMeters.isDisable());
        assertFalse(tpMeters.isExpanded());
    }

    @Test
    public void setCbDeviceTestCase1() {

        tpMeters.setDisable(true);
        tpMeters.setExpanded(false);
        List<LineDTO> fakeJSON = new ArrayList<>();
        ModelDTO model = new ModelDTO();
        model.setName("MODELO TESTE");
        ModelDTO model2 = new ModelDTO();
        model2.setName("MODELO TESTE 2");
        CategoryDTO category = new CategoryDTO();
        category.setName("CATEGORIA TESTE");
        category.setModels(Collections.singletonList(model));
        CategoryDTO category2 = new CategoryDTO();
        category2.setName("CATEGORIA TESTE 2");
        category2.setModels(Collections.singletonList(model2));
        LineDTO line = new LineDTO();
        line.setName("LINHA TESTE");
        line.setCategories(Collections.singletonList(category));
        LineDTO line2 = new LineDTO();
        line2.setName("LINHA TESTE 2");
        line2.setCategories(Collections.singletonList(category2));
        fakeJSON.add(line);
        fakeJSON.add(line2);

        when(service.lineEndpointConnectionByRestTemplate()).thenReturn(fakeJSON);
        controller.setCbDevice();
        cbDevice.setValue(line);
        TreeItem<String> root = treeData.getRoot();
        TreeItem<String> branch = root.getChildren().get(0);

        assertEquals("LINHA TESTE", root.getValue());
        assertEquals("CATEGORIA TESTE", branch.getValue());
        assertEquals("MODELO TESTE", branch.getChildren().get(0).getValue());
        assertFalse(tpMeters.isDisable());
        assertTrue(tpMeters.isExpanded());
    }

    @Test
    public void setCbDeviceTestCase2() {

        tpMeters.setDisable(true);
        tpMeters.setExpanded(false);
        List<LineDTO> fakeJSON = new ArrayList<>();
        ModelDTO model = new ModelDTO();
        model.setName("MODELO TESTE");
        ModelDTO model2 = new ModelDTO();
        model2.setName("MODELO TESTE 2");
        CategoryDTO category = new CategoryDTO();
        category.setName("CATEGORIA TESTE");
        category.setModels(Collections.singletonList(model));
        CategoryDTO category2 = new CategoryDTO();
        category2.setName("CATEGORIA TESTE 2");
        category2.setModels(Collections.singletonList(model2));
        LineDTO line = new LineDTO();
        line.setName("LINHA TESTE");
        line.setCategories(Collections.singletonList(category));
        LineDTO line2 = new LineDTO();
        line2.setName("LINHA TESTE 2");
        line2.setCategories(Collections.singletonList(category2));
        fakeJSON.add(line);
        fakeJSON.add(line2);

        when(service.lineEndpointConnectionByRestTemplate()).thenReturn(fakeJSON);
        controller.setCbDevice();
        cbDevice.setValue(line2);
        TreeItem<String> root = treeData.getRoot();
        TreeItem<String> branch = root.getChildren().get(0);

        assertEquals("LINHA TESTE 2", root.getValue());
        assertEquals("CATEGORIA TESTE 2", branch.getValue());
        assertEquals("MODELO TESTE 2", branch.getChildren().get(0).getValue());
        assertFalse(tpMeters.isDisable());
        assertTrue(tpMeters.isExpanded());
    }
}