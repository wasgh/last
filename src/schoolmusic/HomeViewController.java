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
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import helpers.Routes;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.VBox;
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
    
          private StringProperty PasswordString = new SimpleStringProperty();
    private StringProperty UsernameString = new SimpleStringProperty();
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private Label txtCurrentWindow;
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
        // TODO
        // TableUsername username ;
          
        //    username=new TableUsername();
            
      //setStringPassword(stringPassword);
       // setStringUsername(stringUsername);
       // Drawer =  GetTypeUserName(stringUsername,stringPassword);
        
/*         emf = Persistence.createEntityManagerFactory("schoolMusicFxPU");
              em= emf.createEntityManager();
            Query q =em.createQuery("SELECT t.typeUsername FROM TableUsername t WHERE  t.username = :username AND t.password = :password",String.class);
          q.setParameter("username",stringUsername);
                   q.setParameter("password", stringPassword);

           Drawer=  q.getSingleResult().toString();
                    txtCurrentWindow.setText(stringUsername+stringPassword+Drawer);*/
   try {
         //   System.out.println("TypeUserName : "+GetTypeUserName(stringUsername,stringPassword));
            // Drawer = "DrawerStudent";
          //  Drawer = "Student";
         // Drawer = "Student";
          //GetTypeUserName(getStringUsername(),getStringPassword())
            switch(Drawer){
                case "Student":  fxmlDrawer = "DrawerStudent";
                break;
                
     
                case "Manager":
                     fxmlDrawer = "DrawerManager";
                    break;
                    
               
                case "Teacher":
                     fxmlDrawer = "DrawerTeacher";
                    break;     
            }
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
                AnchorPane appointment = FXMLLoader.load(getClass().getResource(Routes.APPOINTMENTSVIEW));
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
                                    
                                case "appointmentMenu":
                                    drawer.close();
                                    setNode(appointment);
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
 static public void setStringDrawer(String StringDrawer) {
        HomeViewController.StringDrawer = StringDrawer;
    }
/*
  public String getStringDrawer() {
        return StringDrawer;
    }*/
      /*  public void initData(TableUsername tableUsername) 
                
        {  emf = Persistence.createEntityManagerFactory("schoolMusicFxPU");
              em= emf.createEntityManager();
            Query q =em.createQuery("SELECT t.typeUsername FROM TableUsername t WHERE  t.username = :username AND t.password = :password",String.class);
          q.setParameter("username",tableUsername.getUsername());
                    q.setParameter("password", tableUsername.getPassword());

          Drawer = q.getSingleResult().toString();
            
        }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     

    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }



}
