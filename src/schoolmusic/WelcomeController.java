/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmusic;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.User;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class WelcomeController implements Initializable {
    @FXML
        private TitledPane instrumentsForSaleTitledPane;

  @FXML
        private TitledPane eventsFestivalsTitledPane;

  @FXML
        private TitledPane announcementsTitledPane;


    @FXML
    private JFXButton btnLogOut;
    @FXML
    private TextField txtLoggedUser;
    @FXML
    private MediaPlayer player;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // display logged user
        
    }    

    @FXML
    private void logOut(ActionEvent event) {
    }
    
    
    
    @FXML
    void PlayNote(MouseEvent  event) {

        JFXButton note;
        note = (JFXButton) event.getSource();
    
    String uriString;
   uriString = new File("D:\\WorkSpace\\NetBeansProjects\\musicschool\\src\\sounds\\piano\\"+note.getAccessibleText()+".mp3").toURI().toString();
    //uriString = new File("\\"+note.getAccessibleText()+".mp3").toURI().toString();
    player = new MediaPlayer( new Media(uriString));
    player.play();
     
        
  
        
        
        
    }
       @FXML
    void StopNote(MouseEvent event) {
        ;
    }

    
}
