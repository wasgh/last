/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContactUsers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author ai-19
 */
public class ContactusersController implements Initializable {
    
    @FXML
    private TableView<?> contactTable;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> usernameCol;

    @FXML
    private TableColumn<?, ?> emailCol;

    @FXML
    private TableColumn<?, ?> rankCol;

    @FXML
    private TableColumn<?, ?> skillCol;

    @FXML
    private TableColumn<?, ?> phoneNumberCol;

    @FXML
    private TableColumn<?, ?> dataAddedCol;

    @FXML
    private JFXTextArea taMessage;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnSaveAll;

    @FXML
    private JFXTextArea taAnnouncement;

    @FXML
    private JFXButton btnUpdateAnnouncement;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
