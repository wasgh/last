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
@Table(name = "TABLE_TEACHER", catalog = "", schema = "HR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableTeacher.findAll", query = "SELECT t FROM TableTeacher t")
    , @NamedQuery(name = "TableTeacher.findByIdTeacher", query = "SELECT t FROM TableTeacher t WHERE t.idTeacher = :idTeacher")})
public class TableTeacher implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TEACHER", nullable = false, precision = 22)
    private BigDecimal idTeacher;
    @JoinColumn(name = "ID_TEACHER", referencedColumnName = "USERNAME_ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TableUsername tableUsername;

    public TableTeacher() {
    }

    public TableTeacher(BigDecimal idTeacher) {
        this.idTeacher = idTeacher;
    }

    public BigDecimal getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(BigDecimal idTeacher) {
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
        return "Database.TableTeacher[ idTeacher=" + idTeacher + " ]";
    }
    
}
