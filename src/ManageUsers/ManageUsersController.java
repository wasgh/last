/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageUsers;
import Database.CurrentUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 * FXML Controller class
 *
 * @author ai-19
 */

public class ManageUsersController implements Initializable {
         public   String persistenceUnitName="schoolMusicFxPU";

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
    private JFXComboBox<?> cbauSkill1;

    @FXML
    private JFXComboBox<?> cbauSkill;

    @FXML
    private JFXComboBox<?> cbauLevel;
       @FXML
    private JFXComboBox<?> cbauRank;


    @FXML
    private JFXTextArea taauAdditionalInfo;

    @FXML
    private JFXButton btnauClear;
    
    @FXML
    private Button nidal;

   
    @FXML
    private JFXButton btnauAddUser;

    @FXML
    private Label labelRegisteredStudents;

    @FXML
    private Label labelRegisteredTeachers;
    
    @FXML
    private JFXCheckBox checkboxauMale;

    @FXML
    private JFXCheckBox checkboxauFemale;
    @FXML
    private Label labelAdministrators;

    @FXML
    private TableView<?> tvMainTable;

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
    private JFXTextField tfeuFirstName;

    @FXML
    private JFXTextField tfeuLastName;

    @FXML
    private JFXTextField tfeuUserName;

    @FXML
    private JFXTextField tfeuPassoword;

    @FXML
    private JFXTextField tfeuEmail;

    @FXML
    private JFXTextField tfeuPhoneNumber;

    @FXML
    private JFXDatePicker dpeuBirthdate;

    @FXML
    private JFXTextArea taeuAdditionalInfo;


    @FXML
    private JFXComboBox<?> cbeuSkill;

    @FXML
    private JFXComboBox<?> cbeuLevel;

    @FXML
    private JFXButton btneuSaveChanges;

    @FXML
    private JFXButton btneuDeleteUser;
    @FXML
    
    private JFXButton btneuPrint;

    @FXML
    private JFXButton btneuPrintAll;
    
    @FXML
    private JFXCheckBox checkboxeuMale;

    @FXML
    private JFXCheckBox checkboxeuFemale;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        //filling the Combobox      
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");      
        ObservableList obList = FXCollections.observableList(list);
        this.cbauLevel.getItems().clear();
        this.cbauLevel.setItems(obList);
        this.cbeuLevel.setItems(obList);
        List<String> listskill = new ArrayList<String>();
        listskill.add("Vocals");
        listskill.add("Piano");
        listskill.add("Guitar");
        listskill.add("Oud");
        listskill.add("Violin");
        listskill.add("Cello");
        listskill.add("Viola");
        listskill.add("Double Bass");
        listskill.add("Percussion"); 
        listskill.add("Saxophone");
        listskill.add("Clarinet");
        listskill.add("Qanun");
        listskill.add("Harp");
        ObservableList obListskill = FXCollections.observableList(listskill);
        this.cbauSkill.setItems(obListskill);
        this.cbeuSkill.setItems(obListskill);
        List<String> listrank = new ArrayList<String>();
        listrank.add("Student");
        listrank.add("Teacher");
        listrank.add("Administrator");   
        ObservableList obListrank = FXCollections.observableList(listrank);
        this.cbauRank.setItems(obListrank);

    }    
     @FXML
    void clearfields(ActionEvent event) {
        this.tfauEmail.clear();
        this.tfauFirstName.clear();
        this.tfauLastName.clear();
        this.tfauPhoneNumber.clear();
        this.checkboxauFemale.setSelected(false);
        this.checkboxauMale.setSelected(false);
        this.tfauSSN.clear();
        this.dpauBirthdate.setValue(null);
        this.tfauUsername.clear();
        this.tfauPassword.clear();
        this.cbauSkill.setValue(null);
        this.cbauLevel.setValue(null);
       this.cbauRank.setValue(null);
       this.taauAdditionalInfo.clear();
       
    }
    @FXML
    void GenderSelection(ActionEvent event) {
        if(this.checkboxauFemale.isSelected()&&event.getSource().equals(this.checkboxauFemale))
        {if(this.checkboxauMale.isSelected()){
            this.checkboxauMale.setSelected(false);
        }}
        else if(this.checkboxauMale.isSelected()&&event.getSource().equals(this.checkboxauMale))
        {if(this.checkboxauFemale.isSelected()){
            this.checkboxauFemale.setSelected(false);
        }

    }
        if(this.checkboxeuFemale.isSelected()&&event.getSource().equals(this.checkboxeuFemale))
        {if(this.checkboxeuMale.isSelected()){
            this.checkboxeuMale.setSelected(false);
        }}
        else if(this.checkboxauMale.isSelected()&&event.getSource().equals(this.checkboxeuMale))
        {if(this.checkboxeuFemale.isSelected()){
            this.checkboxeuFemale.setSelected(false);
        }

    }
    }
/*
        String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
String username = "hr";
String password = "hr";
 
try {
 
    Connection conn = DriverManager.getConnection(dbURL, username, password);
    String sql = "SELECT NAME FROM SKILLS";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            String name = result.getString("NAME");
            System.out.printf(name);
        }
 
    
} catch (SQLException ex) {
}


    */
    
    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void saveChanges(ActionEvent event) {

    }
    @FXML 
    void addUser(ActionEvent event)
    {
        
    }

        
        
        
        
        
        
        
        
        

    }
        
  