/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "TABLE_STUDENT", catalog = "", schema = "HR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableStudent.findAll", query = "SELECT t FROM TableStudent t")
    , @NamedQuery(name = "TableStudent.findByIdStudent", query = "SELECT t FROM TableStudent t WHERE t.idStudent = :idStudent")
    , @NamedQuery(name = "TableStudent.findByIdTeacher", query = "SELECT t FROM TableStudent t WHERE t.idTeacher = :idTeacher")})
public class TableStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_STUDENT", nullable = false, precision = 22)
    private BigDecimal idStudent;
    @Column(name = "ID_TEACHER", length = 20)
    private String idTeacher;
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "USERNAME_ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TableUsername tableUsername;

    public TableStudent() {
    }

    public TableStudent(BigDecimal idStudent) {
        this.idStudent = idStudent;
    }

    public BigDecimal getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(BigDecimal idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
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
        return "Database.TableStudent[ idStudent=" + idStudent + " ]";
    }
    
}
