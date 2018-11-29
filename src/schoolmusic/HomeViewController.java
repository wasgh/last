/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmusic;

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
import java.sql.DriverManager;
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
  public void GetData(String stringUsername, String stringPassword) {
         Connection c = null;
        Statement stmt = null;
         try {
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sTeacher ="Select count(*)AS rowcount FROM table_teacher,table_username Where table_username.username_id=table_teacher.id_teacher and table_username.username="+"'" + stringUsername + "'"+" and table_username.password="+"'" + stringPassword + "'"; 
          String sSTUDENT ="Select count(*)AS rowcount FROM TABLE_STUDENT,table_username Where table_username.username_id=TABLE_STUDENT.ID_STUDENT and table_username.username="+"'" + stringUsername + "'"+" and table_username.password="+"'" + stringPassword + "'";
  String sMANAGER ="Select count(*)AS rowcount FROM TABLE_MANAGER,table_username Where table_username.username_id=TABLE_MANAGER.ID_MANAGER and table_username.username="+"'" + stringUsername + "'"+" and table_username.password="+"'" + stringPassword + "'";

            ResultSet rs = stmt.executeQuery(sMANAGER);
            rs.next();
            int count = rs.getInt("rowcount");
           System.out.println("MyTable has " + count + " row(s).");
 if (count>0) {
                                     fxmlDrawer = "Drawer";   
        System.out.println("Drawer has " + count + " row(s).");
      
 }
 
 
    rs = stmt.executeQuery(sSTUDENT);
            rs.next();
             count = rs.getInt("rowcount");
           System.out.println("MyTable has " + count + " row(s).");
 if (count>0) {
                                     fxmlDrawer = "DrawerStudent";      
                                                                                     System.out.println("DrawerStudent has " + count + " row(s).");

 }
    rs = stmt.executeQuery(sTeacher);
            rs.next();
             count = rs.getInt("rowcount");
 if (count>0) {
                                     fxmlDrawer = "DrawerTeacher";     
                                                System.out.println("DrawerTeacher has " + count + " row(s).");

 }
 
            rs.close();
            stmt.close();
            c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );

            }
 
   try {
                                        

            VBox sidePane = FXMLLoader.load(getClass().getResource("/schoolmusic/"+fxmlDrawer+".fxml"));
            
            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
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
                AnchorPane login = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));
                AnchorPane ManageUsers=FXMLLoader.load(getClass().getResource(Routes.MANAGEUSERS));
                AnchorPane Profileview=FXMLLoader.load(getClass().getResource(Routes.PROFILEVIEW));
                AnchorPane contactus = FXMLLoader.load(getClass().getResource(Routes.CONTACTUS));
                
                AnchorPane welcome = FXMLLoader.load(getClass().getResource(Routes.WELCOMEVIEW));
                setNode(welcome);
                drawer.setSidePane(sidePane);
                
                for (Node node : sidePane.getChildren()) {
                    if (node.getAccessibleText() != null) {
                        node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                            switch (node.getAccessibleText()) {
                                case "homeMenu":
                                    drawer.close();
                                    setNode(welcome);
                                    break;
                                    
                                case "profileMenu":
                                    drawer.close();
                                    setNode(Profileview);
                                    break;
                                case "contactusMenu":
                                    drawer.close();
                                    setNode(contactus);
                                    break;
                                    
                                case "manageusersMenu":
                                    drawer.close();
                                    setNode(ManageUsers);
                                    break;
                                    
                            
                            }
                        });
                    }
                    
                }

            } catch (IOException ex) {
                Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    

     
    }


    

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }


}
