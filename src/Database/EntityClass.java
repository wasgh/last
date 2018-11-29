/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import ManageUsers.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author wasim
 */

    
public class EntityClass { 

    private String persistenceUnitName="schoolMusicFxPU";

    public EntityClass() {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
    em = emf.createEntityManager(); 
    }
    private EntityManagerFactory emf ; 
    private EntityManager em;
   
    public List<Person>getPersons() {
        TypedQuery<Person> qry =em.createQuery("",Person.class);
        return qry.getResultList();
    }
      public boolean savePerson(Person person) {
          try {
              em.getTransaction().begin();
              em.persist(person);
              em.getTransaction().commit();
              return true;
          } catch (Exception e) {
              return false;
          }
    }
}
