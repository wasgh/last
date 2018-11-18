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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TABLE_STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableStudent.findAll", query = "SELECT t FROM TableStudent t")
    , @NamedQuery(name = "TableStudent.findByIdStudent", query = "SELECT t FROM TableStudent t WHERE t.idStudent = :idStudent")
    , @NamedQuery(name = "TableStudent.findByStudentFirstName", query = "SELECT t FROM TableStudent t WHERE t.studentFirstName = :studentFirstName")
    , @NamedQuery(name = "TableStudent.findByStudentLastName", query = "SELECT t FROM TableStudent t WHERE t.studentLastName = :studentLastName")
    , @NamedQuery(name = "TableStudent.findByHomePhone", query = "SELECT t FROM TableStudent t WHERE t.homePhone = :homePhone")
    , @NamedQuery(name = "TableStudent.findByWorkPhone", query = "SELECT t FROM TableStudent t WHERE t.workPhone = :workPhone")})
public class TableStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_STUDENT")
    private String idStudent;
    @Column(name = "STUDENT_FIRST_NAME")
    private String studentFirstName;
    @Column(name = "STUDENT_LAST_NAME")
    private String studentLastName;
    @Column(name = "HOME_PHONE")
    private String homePhone;
    @Column(name = "WORK_PHONE")
    private String workPhone;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tableStudent")
    private TableLevelInMusicalInstr tableLevelInMusicalInstr;
    @JoinColumn(name = "ID_TEACHER", referencedColumnName = "ID_TEACHER")
    @ManyToOne(optional = false)
    private TableTeacher idTeacher;
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "USERNAME_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TableUsername tableUsername;

    public TableStudent() {
    }

    public TableStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public TableLevelInMusicalInstr getTableLevelInMusicalInstr() {
        return tableLevelInMusicalInstr;
    }

    public void setTableLevelInMusicalInstr(TableLevelInMusicalInstr tableLevelInMusicalInstr) {
        this.tableLevelInMusicalInstr = tableLevelInMusicalInstr;
    }

    public TableTeacher getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(TableTeacher idTeacher) {
        this.idTeacher = idTeacher;
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
        hash += (idStudent != null ? idStudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableStudent)) {
            return false;
        }
        TableStudent other = (TableStudent) object;
        if ((this.idStudent == null && other.idStudent != null) || (this.idStudent != null && !this.idStudent.equals(other.idStudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TableStudent[ idStudent=" + idStudent + " ]";
    }
    
}
