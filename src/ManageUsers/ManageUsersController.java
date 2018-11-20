/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageUsers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import database.TableUsername;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
/**
 * FXML Controller class
 *
 * @author ai-19
 */
public class ManageUsersController implements Initializable {
    
    @FXML
    private JFXTextField tfauFirstName;

    @FXML
    private JFXTextField tfauLastName;

    @FXML
    private JFXTextField tfauEmail;

    @FXML
    private JFXTextField tfauPhoneNumber;

    @FXML
    private JFXTextField tfauSSN;

    @FXML
    private JFXDatePicker dpauBirthdate;

    @FXML
    private JFXTextField tfauUsername;

    @FXML
    private JFXTextField tfauPassword;

    @FXML
    private JFXRadioButton rbauStudent;

    @FXML
    private JFXRadioButton rbauTeacher;

    @FXML
    private JFXRadioButton rbauAdministrator;

    @FXML
    private JFXComboBox<?> cbauSkill;

    @FXML
    private JFXTextArea taauAdditionalInfo;

    @FXML
    private JFXButton btnauClear;

    @FXML
    private JFXButton btnauAddUser;

    @FXML
    private Label labelRegisteredStudents;

    @FXML
    private Label labelRegisteredTeachers;

    @FXML
    private Label labelAdministrators;

    @FXML
    private JFXComboBox<?> cbeuRankFilter;

    @FXML
    private JFXComboBox<?> cbeuSkillFilter;

    @FXML
    private TableView<?> tvMainTable;

    @FXML
    private JFXTextField tfeuUserName;

    @FXML
    private JFXTextField tfeuPassoword;

    @FXML
    private JFXTextField tfeuEmail;

    @FXML
    private JFXTextField tfeuFirstName;

    @FXML
    private JFXTextField tfeuLastName;

    @FXML
    private JFXTextField tfeuPhoneNumber;

    @FXML
    private JFXDatePicker dpeuBirthdate;

    @FXML
    private JFXTextArea taeuAdditionalInfo;

    @FXML
    private JFXComboBox<?> cbeuRank;

    @FXML
    private JFXComboBox<?> cbeuSkill;

    @FXML
    private JFXButton btneuSaveChanges;

    @FXML
    private JFXButton btneuDeleteUser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TableUsername user= new TableUsername(); 
        
    }    
    
}
