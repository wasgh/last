/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfilePage;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ai-19
 */
public class ProfilepageController implements Initializable {
    
    @FXML
    private Label labelprofileUsername;

    @FXML
    private Label labelprofileName;

    @FXML
    private Label labelprofileRank;

    @FXML
    private Label labelprofileSkill;

    @FXML
    private Label labelprofileEmail;

    @FXML
    private Label labelprofilePhonenumber;

    @FXML
    private Label labelprofileBirthdate;

    @FXML
    private Button btnprofileHomePage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
