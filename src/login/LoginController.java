




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import models.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import helpers.Routes;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import schoolmusic.HomeViewController;
import schoolmusic.SchoolMusic;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author wasim
 */
public class LoginController implements Initializable {
//public String  username ;
 //public  String password; 
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXSpinner loggingProgress;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnQuickAccessTools;
     @FXML
    private Label  invalid_label;
    @FXML
    private Hyperlink forgotpw;
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private StringProperty PasswordString = new SimpleStringProperty();
    private StringProperty UsernameString = new SimpleStringProperty();
    public String username;
    public String password;
    //HomeViewController aThis;
//HomeViewController omeViewController =new HomeViewController(this);

 

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loggingProgress.setVisible(false);

    }
       /**
     * Accepts the firstName, lastName and stores them to specific instance variables
     * 
     * @param firstName
     * @param lastName
     */

 @FXML
    private void loginAction(ActionEvent event) throws IOException {
        loggingProgress.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(5));
        pauseTransition.setOnFinished(ev -> {
            try {
                System.out.println("Complete one");
                // completeLogin();
                System.out.println("DO IT");
                FXMLLoader loader = new FXMLLoader(getClass().getResource(Routes.MAINVIEW));
                Parent root =(Parent)loader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                 // FXMLLoader  loader =new FXMLLoader(getClass().getResource(Routes.MAINVIEW));
               //    HomeViewController controller = new HomeViewController(txtUsername.getText(), txtPassword.getText());

                scene.getStylesheets().add(SchoolMusic.class.getResource("/styles/styles.css").toExternalForm());
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                
                if (isValidInput())
                { completeLogin();
/*                *///    TableUsername tableUsername = new TableUsername ();
                 //   // HomeViewController homeViewController =  (HomeViewController)loader.getController();
                 //      HomeViewController homeViewController =  (HomeViewController)loader.getController();
                   //  homeViewController.GetData(txtUsername.getText(), txtPassword.getText());
                  //   tableUsername.setUsername(txtUsername.getText().toString());
                 //    tableUsername.setPassword(txtPassword.getText().toString());
                  //   homeViewController.initData(tableUsername);
                 //    homeViewController.initData(txtUsername.getText(), txtPassword.getText().toString());
                    // homeViewController.setStringPassword(txtPassword.getText());
                  //     homeViewController.setStringUsername(txtUsername.getText().toString());
//
                    stage.hide(); //optional
                    stage.setScene(scene);
                    stage.show();  
                                    btnLogin.getScene().getWindow().hide();

                }
                else
                {
                    txtUsername.clear();
                    txtPassword.clear();
                    invalid_label.setText("Sorry, invalid credentials");
                }
                System.out.println("Complete two");
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        pauseTransition.play();

      
    }
        @FXML
    void forgotpw(ActionEvent event) {
        try {
                
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource(Routes.FORGOTPW));
                root.getStylesheets().add(SchoolMusic.class.getResource("/styles/styles.css").toExternalForm());
                Scene scene = new Scene(root);
                scene.getStylesheets().add(SchoolMusic.class.getResource("/styles/styles.css").toExternalForm());
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);

                stage.setIconified(false);
                stage.show();
                //Hide login window
              
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            
            }
    }
      @FXML
    void QuickAccessAction(ActionEvent event) {
         try {
                
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource(Routes.QUICKTOOLS));
                root.getStylesheets().add(SchoolMusic.class.getResource("/styles/styles.css").toExternalForm());
                Scene scene = new Scene(root);
                scene.getStylesheets().add(SchoolMusic.class.getResource("/styles/styles.css").toExternalForm());
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);

                stage.setIconified(false);
                stage.show();
                //Hide login window
                btnLogin.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            
    }}
       
    private boolean isValidInput() {
        return (txtUsername.getText().trim().length() > 0) && (txtPassword.getText().trim().length() > 0);
    }

    private void completeLogin() {
        loggingProgress.setVisible(false);
        if (isValidInput()) {
            try {
                User user=new User();
                user.setUsername(txtUsername.getText());
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource(Routes.MAINVIEW));
             //   JFXDecorator decorator = new JFXDecorator(stage, root, false, false, true);
             //   decorator.setCustomMaximize(false);
             //   decorator.setBorder(Border.EMPTY);

                Scene scene = new Scene(root);
                scene.getStylesheets().add(SchoolMusic.class.getResource("/styles/styles.css").toExternalForm());
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);

                stage.setIconified(false);
                stage.show();
                //Hide login window
                btnLogin.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
   /* private boolean isValidCredentials()
    {
        boolean let_in = false;
        System.out.println( "SELECT * FROM TABLE_USERNAME WHERE USERNAME= " + "'" + txtUsername.getText() + "'" 
            + " AND PASSWORD= " + "'" + txtPassword.getText() + "'" );
    
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery( "SELECT * FROM TABLE_USERNAME WHERE USERNAME= " + "'" + txtUsername.getText() + "'" 
            + " AND PASSWORD= " + "'" + txtPassword.getText() + "'");
            
            while ( rs.next() ) {
                 if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) { 
                       username = rs.getString("USERNAME");
                     System.out.println( "USERNAME = " + txtUsername.getText() );
                      password = rs.getString("PASSWORD");
                     System.out.println("PASSWORD = " + txtPassword.getText());
                    
                     let_in = true;
                 }  
            }
            rs.close();
            stmt.close();
            c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Operation done successfully");
            System.out.println(let_in);

            return let_in;
        
    }
*/
}
