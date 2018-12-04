/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageUsers;

import Database.EntityClass;
import Database.TableManager;
import Database.TableStudent;
import Database.TableTeacher;
import Database.TableUsername;
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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author ai-19
 */
public class ManageUsersController implements Initializable {

    public String persistenceUnitName = "schoolMusicFxPU";

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
    private TableView<TableUsername> tvMainTable;
    @FXML
    private TableColumn<TableUsername, String> name;

    @FXML
    private TableColumn<TableUsername, String> firstNameColumn;

    @FXML
    private TableColumn<TableUsername, String> lastNameColumn;

    @FXML
    private TableColumn<TableUsername, String> usernameColumn;

    boolean iscbauRankComboBoxEmpty;
    private boolean iscbauSkil1ComboBoxEmpty;

    private EntityClass entityClass;

    @FXML

    private TableColumn<TableUsername, String> rankColumn;
    @FXML

    private TableColumn<TableUsername, String> skillColumn;
    @FXML

    private TableColumn<TableUsername, String> phoneNumberColumn;
    @FXML

    private TableColumn<TableUsername, String> dataAddedColumn;
    @FXML

    private TableColumn<TableUsername, String> emailColumn;

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
    private JFXComboBox<?> cbeuRank;

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

    TableUsername usernameEdit;
    ObservableList<TableUsername> dataUsernames;

    @FXML
    void btnauAddUserAction(ActionEvent event) {
    CountType();

        TableUsername username = new TableUsername();
        //   DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String uri = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "hr";
        String password = "hr";
        //   Connection connection = DriverManager.getConnection(uri,user,password);
        //   Statement statement = connection.createStatement();

        DateTimeFormatter dataAdded = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // LocalDateTime now = LocalDateTime.now();
        Date dateNow = Date.valueOf(LocalDate.now());
        String EmailString = tfauEmail.getText();
        String UsernameString = tfauUsername.getText();
        String PasswordString = tfauPassword.getText();
        String PhoneNumberString = tfauPhoneNumber.getText();
        String AdditionalInfoString = taauAdditionalInfo.getText();
        String FirstNameString = tfauFirstName.getText();
        String LastNameString = tfauLastName.getText();
        username.setUsername(UsernameString);
        String SnnString = tfauSSN.getText();
        String dpauBirthdateString = (dpauBirthdate.getValue() != null ? dpauBirthdate.getValue().toString() : "");
        String RankString = (cbauRank.getValue() != null ? cbauRank.getSelectionModel().getSelectedItem().toString() : "");
        String LevelString = (cbauLevel.getValue() != null ? cbauLevel.getSelectionModel().getSelectedItem().toString() : "");
        String SexString = (aucheckFemaleORMale() != null ? aucheckFemaleORMale() : "");
        //  LocalDate localDate = dpauBirthdate.getValue();
//        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));

        //java.util.Date dateBirthdate = Date.from(instant);
        if (!tfauFirstName.equals("") && !tfauLastName.equals("") && !tfauEmail.equals("") && !tfauUsername.equals("") && !tfauPassword.equals("") && !tfauSSN.equals("") && !RankString.equals("") && !dpauBirthdateString.equals("") && !LevelString.equals("")) {
            LocalDate localDatedpauBirthdate = dpauBirthdate.getValue();
            Date dateBirthdate = Date.valueOf(localDatedpauBirthdate);
            if (!checkByUsername(UsernameString)) {
                new Alert(Alert.AlertType.WARNING, "must onther username").show();
                System.out.println("Not Entity saved.");

            } else {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolMusicFxPU");

                System.out.println(RankString);

                switch (RankString) {
                    case "Teacher":
                        EntityManager entityUsername = emf.createEntityManager();
                        entityUsername.getTransaction().begin();
                        username.setAdditionalInfo(AdditionalInfoString);
                        username.setPassword(PasswordString);
                        username.setPhoneNumber(PhoneNumberString);
                        username.setSsn(SnnString);
                        username.setSex(SexString);
                        username.setFirstName(FirstNameString);
                        username.setLastName(LastNameString);
                        username.setEmailAddress(EmailString);
                        username.setDataadded(dateNow);
                        username.setBirthdate(dateBirthdate);
                        TableTeacher tableTeacher = new TableTeacher();
                                                tableTeacher.setIdTeacher(username.getUsernameId());

                        username.setTableTeacher(tableTeacher);
                        entityUsername.persist(username);
                        entityUsername.getTransaction().commit();
                        entityUsername.close();
                       /*
                        EntityManager entityTeacher = emf.createEntityManager();
                        entityTeacher.getTransaction().begin();
                        TableTeacher tableTeacher = new TableTeacher();
                        tableTeacher.setIdTeacher(username.getUsernameId());

                        entityTeacher.persist(tableTeacher);
                        entityTeacher.getTransaction().commit();
                        entityTeacher.close();
*/
                        break;
                    case "Student":
                        entityUsername = emf.createEntityManager();
                        entityUsername.getTransaction().begin();
                        username.setAdditionalInfo(AdditionalInfoString);
                        username.setPassword(PasswordString);
                        username.setPhoneNumber(PhoneNumberString);
                        username.setSsn(SnnString);
                        username.setSex(SexString);
                        username.setFirstName(FirstNameString);
                        username.setLastName(LastNameString);
                        username.setEmailAddress(EmailString);
                        username.setDataadded(dateNow);
                        username.setBirthdate(dateBirthdate);
                         TableStudent tableStudent = new TableStudent();
                                                 tableStudent.setIdStudent(username.getUsernameId());

                         username.setTableStudent(tableStudent);
                        entityUsername.persist(username);
                        entityUsername.getTransaction().commit();
                        entityUsername.close();
                    /*  
                        EntityManager entityStudent = emf.createEntityManager();
                        entityStudent.getTransaction().begin();
                        TableStudent tableStudent = new TableStudent();
                        tableStudent.setIdStudent(username.getUsernameId());

                        entityStudent.persist(tableStudent);
                        entityStudent.getTransaction().commit();
                        entityStudent.close();
                        */
                        break;
                    case "Administrator":
                        entityUsername = emf.createEntityManager();
                        entityUsername.getTransaction().begin();
                        username.setAdditionalInfo(AdditionalInfoString);
                        username.setPassword(PasswordString);
                        username.setPhoneNumber(PhoneNumberString);
                        username.setSsn(SnnString);
                        username.setSex(SexString);
                        username.setFirstName(FirstNameString);
                        username.setLastName(LastNameString);
                        username.setEmailAddress(EmailString);
                        username.setDataadded(dateNow);
                        username.setBirthdate(dateBirthdate);
//TableManager tableManager = new TableManager();
//username.set
                        entityUsername.persist(username);
                        entityUsername.getTransaction().commit();
                        entityUsername.close();
                        EntityManager entityManager = emf.createEntityManager();
                        entityManager.getTransaction().begin();
                       /*
                        TableManager tableManager = new TableManager();
                        tableManager.setIdManager(username.getUsernameId());
                        entityManager.persist(tableManager);
                        entityManager.getTransaction().commit();
                        entityManager.close();
*/
                        break;

                }
                //       cbauRank.setItems(FXCollections.observableArrayList(usersRank));
                //            cbauSkill.setItems(FXCollections.observableArrayList(usersSkill));
                //  EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolMusicFxPU");
                EntityManager entityManager = emf.createEntityManager();
                TypedQuery<TableUsername> query = entityManager.createNamedQuery("TableUsername.findAll", TableUsername.class);
                List<TableUsername> listUsernames = query.getResultList();

//List<TableUsername>listUsernames = entityManager.createQuery("TableUsername.findAll").getResultList();
                dataUsernames = FXCollections.observableArrayList();
                for (TableUsername row : listUsernames) {
                    dataUsernames.add(new TableUsername(row.getUsernameId(), row.getUsername(), row.getPassword(), row.getSex(), row.getAdditionalInfo(), row.getEmailAddress(), row.getSsn(), row.getDataadded(), row.getFirstName(), row.getLastName(), row.getBirthdate(), row.getPhoneNumber(), row.getTableLevelInMusicalInstr(), row.getTableMessageCollection(), row.getTableMessageCollection1(), row.getTableStudent(), row.getTableTeacher()));
                }
                tvMainTable.setItems(dataUsernames);

                System.out.println("Entity saved.");
            }
            clearFields();

        } else {
            new Alert(Alert.AlertType.WARNING, "FirstName ,LastName ,Username and Email fields cannot be empty!").show();
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //       cbauRank.setItems(FXCollections.observableArrayList(usersRank));
        //            cbauSkill.setItems(FXCollections.observableArrayList(usersSkill));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolMusicFxPU");
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<TableUsername> query = entityManager.createNamedQuery("TableUsername.findAll", TableUsername.class);
        List<TableUsername> listUsernames = query.getResultList();

//List<TableUsername>listUsernames = entityManager.createQuery("TableUsername.findAll").getResultList();
        dataUsernames = FXCollections.observableArrayList();
        for (TableUsername row : listUsernames) {
            dataUsernames.add(new TableUsername(row.getUsernameId(), row.getUsername(), row.getPassword(), row.getSex(), row.getAdditionalInfo(), row.getEmailAddress(), row.getSsn(), row.getDataadded(), row.getFirstName(), row.getLastName(), row.getBirthdate(), row.getPhoneNumber(), row.getTableLevelInMusicalInstr(), row.getTableMessageCollection(), row.getTableMessageCollection1(), row.getTableStudent(), row.getTableTeacher()));
        }
        tvMainTable.setItems(dataUsernames);

        //Query query = entityManager.createQuery("SELECT c FROM Country c");
        //List results = query.getResultList();
        iscbauRankComboBoxEmpty = cbauRank.getSelectionModel().isEmpty();
        iscbauSkil1ComboBoxEmpty = cbauSkill.getSelectionModel().isEmpty();

        // مختاراً بشكل افتراضي choiceBoxRole هنا قمنا بجعل العنصر الأول في الـ
        cbauRank.getSelectionModel().clearSelection();
        cbauSkill.getSelectionModel().clearSelection();

        initColumns();
        CountType();

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
            this.cbeuLevel.getItems().clear();
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
            this.cbeuRank.setItems(obListrank);

     
    }

    private void clearFields() {
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
        tfauFirstName.setText("");
        tfauLastName.setText("");
        tfauEmail.setText("");
        tfauUsername.setText("");
        tfauPassword.setText("");
        tfauPhoneNumber.setText("");
        taauAdditionalInfo.setText("");
        dpauBirthdate.getEditor().setText("");
        this.cbauLevel.setValue(null);
        this.cbauSkill.setValue(null);
        this.cbauRank.setValue(null);
        tfauSSN.setText("");
        //this.cbauLevel.getItems().clear();
    }

    @FXML
    void GenderSelection(ActionEvent event) {
        if (this.checkboxauFemale.isSelected() && event.getSource().equals(this.checkboxauFemale)) {
            if (this.checkboxauMale.isSelected()) {
                this.checkboxauMale.setSelected(false);
            }
        } else if (this.checkboxauMale.isSelected() && event.getSource().equals(this.checkboxauMale)) {
            if (this.checkboxauFemale.isSelected()) {
                this.checkboxauFemale.setSelected(false);
            }

        }
        if (this.checkboxeuFemale.isSelected() && event.getSource().equals(this.checkboxeuFemale)) {
            if (this.checkboxeuMale.isSelected()) {
                this.checkboxeuMale.setSelected(false);
            }
        } else if (this.checkboxauMale.isSelected() && event.getSource().equals(this.checkboxeuMale)) {
            if (this.checkboxeuFemale.isSelected()) {
                this.checkboxeuFemale.setSelected(false);
            }

        }
    }

    public boolean checkByUsername(String username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolMusicFxPU");
        EntityManager entityManager = emf.createEntityManager();

        TableUsername tableUsername = null;
        try {

            tableUsername = (TableUsername) entityManager.createNamedQuery("TableUsername.findByUsername").setParameter("username", username).getSingleResult();
            entityManager.close();
        } catch (Exception ex) {
            tableUsername = null;
            entityManager.close();
        }
        if (tableUsername == null) {
            return true;
        } else {
            return false;
        }

    }

    @FXML
    void displaySelected(MouseEvent event) {
        int selectedIndex = tvMainTable.getSelectionModel().getSelectedIndex();
        System.out.println(selectedIndex);
        if (selectedIndex >= 0) {
            usernameEdit = (TableUsername) tvMainTable.getItems().get(selectedIndex);
            if (usernameEdit != null) {

                tfeuFirstName.setText(usernameEdit.getFirstName());
                tfeuLastName.setText(usernameEdit.getLastName());
                tfeuEmail.setText(usernameEdit.getEmailAddress());
                tfeuUserName.setText(usernameEdit.getUsername());
                tfeuPassoword.setText(usernameEdit.getPassword());
                taeuAdditionalInfo.setText(usernameEdit.getAdditionalInfo());
                tfeuPhoneNumber.setText(usernameEdit.getPhoneNumber());

                //       dpeuBirthdate.getEditor().setText(username.getBirthdate().toString());
                tfeuPhoneNumber.setText(usernameEdit.getPhoneNumber());
            }
        }
    }

    public void initColumns() {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<TableUsername, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<TableUsername, String>("lastName"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<TableUsername, String>("username"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<TableUsername, String>("emailAddress"));
        rankColumn.setCellValueFactory(new PropertyValueFactory<TableUsername, String>("rank"));
        skillColumn.setCellValueFactory(new PropertyValueFactory<TableUsername, String>("skill"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<TableUsername, String>("phoneNumber"));
        dataAddedColumn.setCellValueFactory(new PropertyValueFactory<TableUsername, String>("dataadded"));

    }

    /* public ObservableList<Person> getPersonsData() {
        entityClass = new EntityClass();
        dataUsernames = FXCollections.observableArrayList(entityClass.getPersons());
        if (dataUsernames == null) {
            return FXCollections.observableArrayList();
        } else {
            return dataUsernames;
        }

    }*/
    private String aucheckFemaleORMale() {
        if (this.checkboxauMale.isSelected()) {
            return "M";
        } else if (this.checkboxauFemale.isSelected()) {
            return "F";
        }
        return null;

    }

    private String eucheckFemaleORMale() {
        if (this.checkboxauMale.isSelected()) {
            return "M";
        } else if (this.checkboxauFemale.isSelected()) {
            return "F";
        }
        return null;

    }

    @FXML
    void btneuSaveChangesAction(ActionEvent event) {
        String dpauBirthdateString = (dpeuBirthdate.getValue() != null ? dpauBirthdate.getValue().toString() : "");
        String RankString = (cbeuRank.getValue() != null ? cbeuRank.getSelectionModel().getSelectedItem().toString() : "");
        String LevelString = (cbeuLevel.getValue() != null ? cbeuLevel.getSelectionModel().getSelectedItem().toString() : "");
        String SexString = (eucheckFemaleORMale() != null ? eucheckFemaleORMale() : "");
        usernameEdit.setFirstName(tfeuFirstName.getText());
        usernameEdit.setLastName(tfeuLastName.getText());
        usernameEdit.setAdditionalInfo(taeuAdditionalInfo.getText());
        //     usernameEdit.setBirthdate(dpauBirthdateString);
        //  usernameEdit.setDataadded();
        usernameEdit.setSex(SexString);
        usernameEdit.setPassword(tfauPassword.getText());
        usernameEdit.setEmailAddress(tfeuEmail.getText());
        usernameEdit.setPhoneNumber(tfeuPhoneNumber.getText());
        usernameEdit.setUsername(tfeuUserName.getText());
        if (updateUsername(usernameEdit, usernameEdit.getUsernameId())) {
            new Alert(Alert.AlertType.CONFIRMATION, "User has been updated", ButtonType.CLOSE).show();
            dataUsernames.set(tvMainTable.getSelectionModel().getFocusedIndex(), usernameEdit);
            clearFields();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "updating User was failed", ButtonType.CLOSE).show();

        }
    }

    @FXML
    void btneuDeleteUserAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure to delete " + usernameEdit.getFirstName() + " " + usernameEdit.getLastName(), ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> btnTypr = alert.showAndWait();
        if (btnTypr.get() == ButtonType.YES) {
            if (removeUsername(usernameEdit.getUsernameId())) {
                new Alert(Alert.AlertType.CONFIRMATION, " User " + usernameEdit.getFirstName() + " " + usernameEdit.getLastName() + "has been deleted", ButtonType.CLOSE).show();
                dataUsernames.remove(usernameEdit);
                clearFields();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleting User was failed", ButtonType.CLOSE).show();

            }
        } else if (btnTypr.get() == ButtonType.NO) {
            new Alert(Alert.AlertType.INFORMATION, "Deleting User canceled", ButtonType.CLOSE).show();

        }
    }

    public boolean updateUsername(TableUsername tableUsername, BigDecimal usernameID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolMusicFxPU");
        EntityManager entityUsername = emf.createEntityManager();

        try {
            entityUsername.getTransaction().begin();;
            TableUsername un = entityUsername.find(TableUsername.class, usernameID);
            un.setFirstName(tableUsername.getFirstName());
            un.setLastName(tableUsername.getLastName());
            un.setBirthdate(tableUsername.getBirthdate());
            un.setSsn(tableUsername.getSsn());
            un.setUsername(tableUsername.getUsername());
            un.setPassword(tableUsername.getPassword());
            un.setDataadded(tableUsername.getDataadded());
            un.setEmailAddress(tableUsername.getEmailAddress());
            un.setSex(tableUsername.getSex());
            un.setPhoneNumber(tableUsername.getPhoneNumber());

            entityUsername.merge(tableUsername);
            entityUsername.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    public boolean removeUsername(BigDecimal usernameID) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("schoolMusicFxPU");
        EntityManager entityUsername = emf.createEntityManager();

        try {
            entityUsername.getTransaction().begin();;
            TableUsername un = entityUsername.find(TableUsername.class, usernameID);

            entityUsername.remove(un);
            entityUsername.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;

        }

    }
  private void CountType(){
       String sTeacher = "Select count(*)AS rowcount FROM table_teacher,table_username Where table_username.username_id=table_teacher.id_teacher ";
    String sSTUDENT = "Select count(*)AS rowcount FROM TABLE_STUDENT,table_username Where table_username.username_id=TABLE_STUDENT.ID_STUDENT";
    String sMANAGER = "Select count(*)AS rowcount FROM TABLE_MANAGER,table_username Where table_username.username_id=TABLE_MANAGER.ID_MANAGER";
                   Connection c = null;
                Statement stmt = null;
                try {
                    c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
                    c.setAutoCommit(false);

                    System.out.println("Opened database successfully");
                    stmt = c.createStatement();

                    ResultSet rs = stmt.executeQuery(sMANAGER);
                    rs.next();
                    int count = rs.getInt("rowcount");
                    System.out.println("MyTable has " + count + " row(s).");
                    if (count >= 0) {
                        System.out.println("Drawer has " + count + " row(s).");
                        labelAdministrators.setText(String.valueOf(count));
                    }

                    rs = stmt.executeQuery(sSTUDENT);
                    rs.next();
                    count = rs.getInt("rowcount");
                    System.out.println("MyTable has " + count + " row(s).");
                    if (count >= 0) {
                        System.out.println("DrawerStudent has " + count + " row(s).");
                        labelRegisteredStudents.setText(String.valueOf(count));
                    }
                    rs = stmt.executeQuery(sTeacher);
                    rs.next();
                    count = rs.getInt("rowcount");
                    if (count >= 0) {
                        System.out.println("DrawerTeacher has " + count + " row(s).");
                        labelRegisteredTeachers.setText(String.valueOf(count));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ManageUsersController.class.getName()).log(Level.SEVERE, null, ex);
                }

    }
}
