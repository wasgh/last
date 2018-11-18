/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wasim
 */
@Entity
@Table(name = "TABLE_USERNAME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableUsername.findAll", query = "SELECT t FROM TableUsername t")
    , @NamedQuery(name = "TableUsername.findByUsernameId", query = "SELECT t FROM TableUsername t WHERE t.usernameId = :usernameId")
    , @NamedQuery(name = "TableUsername.findByUsername", query = "SELECT t FROM TableUsername t WHERE t.username = :username")
    , @NamedQuery(name = "TableUsername.findByPassword", query = "SELECT t FROM TableUsername t WHERE t.password = :password")
    , @NamedQuery(name = "TableUsername.findByTypeUsername", query = "SELECT t FROM TableUsername t WHERE t.typeUsername = :typeUsername")
    , @NamedQuery(name = "TableUsername.findByTypeUsernameDependingUsernamePassword", query = "SELECT t.typeUsername FROM TableUsername t WHERE  t.username = :username AND t.password = :password")})

public class TableUsername implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME_ID")
    private String usernameId;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "TYPE_USERNAME")
    private String typeUsername;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tableUsername")
    private TableStudent tableStudent;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tableUsername")
    private TableTeacher tableTeacher;

    public TableUsername() {
    }

    public TableUsername(String usernameId) {
        this.usernameId = usernameId;
    }

    public TableUsername(String usernameId, String username, String password, String typeUsername) {
        this.usernameId = usernameId;
        this.username = username;
        this.password = password;
        this.typeUsername = typeUsername;
    }

    public String getUsernameId() {
        return usernameId;
    }

    public void setUsernameId(String usernameId) {
        this.usernameId = usernameId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUsername() {
        return typeUsername;
    }

    public void setTypeUsername(String typeUsername) {
        this.typeUsername = typeUsername;
    }

    public TableStudent getTableStudent() {
        return tableStudent;
    }

    public void setTableStudent(TableStudent tableStudent) {
        this.tableStudent = tableStudent;
    }

    public TableTeacher getTableTeacher() {
        return tableTeacher;
    }

    public void setTableTeacher(TableTeacher tableTeacher) {
        this.tableTeacher = tableTeacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usernameId != null ? usernameId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableUsername)) {
            return false;
        }
        TableUsername other = (TableUsername) object;
        if ((this.usernameId == null && other.usernameId != null) || (this.usernameId != null && !this.usernameId.equals(other.usernameId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TableUsername[ usernameId=" + usernameId + " ]";
    }
    
}
