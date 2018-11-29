/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageUsers;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author AMIT
 */
public class Person {    
 private String id ; 

        private SimpleStringProperty name;
        private SimpleStringProperty username;
                private SimpleStringProperty password;

        private  SimpleStringProperty email;
        private SimpleStringProperty rank;
        private final SimpleStringProperty skill;
        private SimpleStringProperty phoneNumber;
        private SimpleStringProperty dataAdded;
    private SimpleStringProperty birthdate;
        private SimpleStringProperty additionalInfo;

  
       Person( String name,String username, String email, String rank, String skill, String phoneNumber, String dataAdded) {

            this.username = new SimpleStringProperty(username);
            this.name = new SimpleStringProperty(name);
            this.email = new SimpleStringProperty(email);
            this.rank = new SimpleStringProperty(rank);
            this.skill = new SimpleStringProperty(skill);
            this.phoneNumber = new SimpleStringProperty(phoneNumber);
            this.dataAdded = new SimpleStringProperty(dataAdded);

        }
 
        Person( String name,String username, String email, String rank, String skill, String phoneNumber,String dataAdded, String password) {
            
            this.username = new SimpleStringProperty(username);
                        this.name = new SimpleStringProperty(name);

            this.email = new SimpleStringProperty(email);
            this.rank = new SimpleStringProperty(rank);
            this.skill = new SimpleStringProperty(skill);
            this.phoneNumber = new SimpleStringProperty(phoneNumber);
            this.dataAdded = new SimpleStringProperty(dataAdded);
            this.password = new SimpleStringProperty(password);

        }

    Person(String name, String username, String email, String rank, String skill, String phoneNumber, String dataAdded, String birthdate, String password, String additionalInfo) {
        this.username = new SimpleStringProperty(username);
            this.name = new SimpleStringProperty(name);
            this.email = new SimpleStringProperty(email);
            this.rank = new SimpleStringProperty(rank);
            this.skill = new SimpleStringProperty(skill);
            this.phoneNumber = new SimpleStringProperty(phoneNumber);
            this.dataAdded = new SimpleStringProperty(dataAdded);
            this.password = new SimpleStringProperty(password);
            this.birthdate = new SimpleStringProperty(birthdate);
            this.additionalInfo = new SimpleStringProperty(additionalInfo);

    }

   

   
    

 
        
        /**
     * @return the id
     */
    public String getUsername() {
        return username.get();
    }

    /**
     * @param id the id to set
     */
    public void setUsername(String username) {
        this.username.set(username);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name.get();
    }
  
  
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name.set(name);
    }
 

    /**
     * @return the age
     */
    public String getRank() {
        return rank.get();
    }

    /**
     * @param age the age to set
     */
    public void setRank(String rank) {
        this.rank.set(rank);
    }
          
    public String getSkill() {
        return skill.get();
    }

    /**
     * @param age the age to set
     */
    public void setSkill(String rank) {
        this.skill.set(rank);
    }
      public String getPhoneNumber() {
        return phoneNumber.get();
    }

    /**
     * @param age the age to set
     */
    public void setPhoneNumber(String rank) {
        this.phoneNumber.set(rank);
    }
    
        public String getDataAdded() {
        return dataAdded.get();
    }

    /**
     * @param age the age to set
     */
    public void setDataAdded(String dataAdded) {
        this.dataAdded.set(dataAdded);
    }
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String email) {
            this.email.set(email);
        }
             public String getPassword() {
            return password.get();
        }
 
        public void setPassword(String password) {
            this.password.set(password);
        }

   public String getBirthdate() {
return birthdate.get();
        }
      public void setBirthdate(String birthdate) {
            this.birthdate.set(birthdate);
        }
 public String getAdditionalInfo() {
            return additionalInfo.get();
    }
      public void setAdditionalInfo(String additionalInfo) {
            this.additionalInfo.set(additionalInfo);
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
  
    }
