/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfilePage;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author ai-19
 */
public class ProfilepageController implements Initializable {
    
    @FXML
    private Label labelName;

    @FXML
    private HBox labelAge1;

    @FXML
    private Label labelUsername;

    @FXML
    private Label labelRank;

    @FXML
    private Label labelSkill;

    @FXML
    private Label labelLevel;

    @FXML
    private Label labelAge;

    @FXML
    private JFXTextField tfEmail;

    @FXML
    private JFXTextField tfPhoneNumber;

    @FXML
    private JFXTextField tfAdditionalInfo;

    @FXML
    private JFXButton btnSaveChanges;

    @FXML
    private JFXButton btnViolin;
    @FXML
    public MediaPlayer player;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    void PlayViolin (MouseEvent event) {
        
    String uriString;
    uriString = new File("D:\\WorkSpace\\NetBeansProjects\\musicschool\\src\\sounds\\springvivaldi.mp3").toURI().toString();
    player = new MediaPlayer( new Media(uriString));
    player.play();
    
    }

    @FXML
    void StopViolin(MouseEvent event) {
        player.stop();
    }

 }
    

