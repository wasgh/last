/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmusic;

import Database.OracleConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXToolbar;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import helpers.Routes;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import login.LoginController;
import models.User;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class HomeViewController implements Initializable {
   static public String stringUsername;
   static   public  String stringPassword;

  
  

    public static void setStringPassword() {
    }
   // private final LoginController aThis;
    /*  public HomeViewController(LoginController aThis) {
       this. aThis=(LoginController)aThis;
    }*/
    
//          private StringProperty PasswordString = new SimpleStringProperty();
//    private StringProperty UsernameString = new SimpleStringProperty();
    private ResultSet result = null;
    public Connection conn;
    
    @FXML
    private JFXHamburger hamburger;
    HamburgerBackArrowBasicTransition transition;
    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private Label txtCurrentWindow;    
    @FXML
    private JFXToolbar toolbar;
EntityManagerFactory emf ;
   EntityManager em;
   static private String StringDrawer;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */

    
      static public void setStringUsername(String stringUsername) {
        HomeViewController.stringUsername = stringUsername;

        }

   static public String getStringUsername() {
        return stringUsername;
    }

  static  public void setStringPassword(String stringPassword) {
        HomeViewController.stringPassword = stringPassword;
    }

  static  public String getStringPassword() {
        return stringPassword;
    }
    private String Drawer;
    private String fxmlDrawer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isOpened()) {
                drawer.close();
            } else {
                drawer.open();
            }
            
            
        });
        try {
            
            VBox sidePane = FXMLLoader.load(getClass().getResource("/schoolmusic/Drawer.fxml"));
            AnchorPane login = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));
                AnchorPane ManageUsers=FXMLLoader.load(getClass().getResource(Routes.MANAGEUSERS));
                AnchorPane Profileview=FXMLLoader.load(getClass().getResource(Routes.PROFILEVIEW));
                AnchorPane contactus = FXMLLoader.load(getClass().getResource(Routes.CONTACTUS));
                AnchorPane welcome = FXMLLoader.load(getClass().getResource(Routes.WELCOMEVIEW));
                AnchorPane contactusers=FXMLLoader.load(getClass().getResource(Routes.CONTACTUSERS));
               setNode(welcome);
            drawer.setSidePane(sidePane);

            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                             case "homeMenu":
                                    drawer.close();
                                    setNode(welcome);
                                    this.txtCurrentWindow.setText("Home Page");
                                    transition.setRate(transition.getRate() * -1);
                                    transition.play();
                                    break;
                                    
                                case "profileMenu":
                                    drawer.close();
                                    setNode(Profileview);
                                    this.txtCurrentWindow.setText("Profile Page");
                                     transition.setRate(transition.getRate() * -1);
                                     transition.play();                              
                                     break;
                                     
                                case "contactusMenu":
                                    drawer.close();
                                    setNode(contactus);
                                    transition.setRate(transition.getRate() * -1);
                                    transition.play();   
                                    break;
                                    
                                case "contactusersMenu":
                                    drawer.close();
                                    setNode(contactusers);
                                    this.txtCurrentWindow.setText("Contact Users");
                                    transition.setRate(transition.getRate() * -1);
                                    transition.play();   
                                    break;
                                    
                                case "manageusersMenu":
                                    drawer.close();
                                    setNode(ManageUsers);
                                    this.txtCurrentWindow.setText("Manage Users");
                                    transition.setRate(transition.getRate() * -1);
                                    transition.play();   
                                    break;
                                    
                                               
                        }
                    });
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }

        


}
