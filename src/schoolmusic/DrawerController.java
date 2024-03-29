/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmusic;
import javafx.scene.media.*;
import javafx.application.Application;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class DrawerController implements Initializable {

    @FXML
    private JFXButton homeBtn;

    @FXML
    private JFXButton myprofileBtn;


    @FXML
    private JFXButton editcontactBtn;

    @FXML
    private JFXButton manageusersBtn;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private JFXButton exitBtn;

    @FXML
    public MediaPlayer player;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logOut(ActionEvent event) {
        try {
            Stage window=(Stage) exitBtn.getScene().getWindow();
            SchoolMusic schoolmusic=new SchoolMusic();
            schoolmusic.start(new Stage());
            window.close();
        } catch (Exception ex) {
            Logger.getLogger(DrawerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }
    
    @FXML
    void PlayMusic(MouseEvent event) {
        
    String uriString;
    uriString = new File("D:\\WorkSpace\\NetBeansProjects\\musicschool\\src\\sounds\\longa_riad.mp3").toURI().toString();
    player = new MediaPlayer( new Media(uriString));
    player.play();
    
    }

    @FXML
    void StopMusic(MouseEvent event) {
        player.stop();
    }

    
}
