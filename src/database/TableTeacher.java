/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wasim
 */
@Entity
@Table(name = "TABLE_TEACHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableTeacher.findAll", query = "SELECT t FROM TableTeacher t")
    , @NamedQuery(name = "TableTeacher.findByIdTeacher", query = "SELECT t FROM TableTeacher t WHERE t.idTeacher = :idTeacher")
    , @NamedQuery(name = "TableTeacher.findByNameTeacher", query = "SELECT t FROM TableTeacher t WHERE t.nameTeacher = :nameTeacher")
    , @NamedQuery(name = "TableTeacher.findByFirstName", query = "SELECT t FROM TableTeacher t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "TableTeacher.findByLastName", query = "SELECT t FROM TableTeacher t WHERE t.lastName = :lastName")})
public class TableTeacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TEACHER")
    private String idTeacher;
    @Column(name = "NAME_TEACHER")
    private String nameTeacher;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeacher")
    private Collection<TableStudent> tableStudentCollection;
    @JoinColumn(name = "ID_TEACHER", referencedColumnName = "USERNAME_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TableUsername tableUsername;

    public TableTeacher() {
    }

    public TableTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public Collection<TableStudent> getTableStudentCollection() {
        return tableStudentCollection;
    }

    public void setTableStudentCollection(Collection<TableStudent> tableStudentCollection) {
        this.tableStudentCollection = tableStudentCollection;
    }

    public TableUsername getTableUsername() {
        return tableUsername;
    }

    public void setTableUsername(TableUsername tableUsername) {
        this.tableUsername = tableUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTeacher != null ? idTeacher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableTeacher)) {
            return false;
        }
        TableTeacher other = (TableTeacher) object;
        if ((this.idTeacher == null && other.idTeacher != null) || (this.idTeacher != null && !this.idTeacher.equals(other.idTeacher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TableTeacher[ idTeacher=" + idTeacher + " ]";
    }
    
}
