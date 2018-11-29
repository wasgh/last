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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wasim
 */
@Entity
@Table(name = "TABLE_MANAGER", catalog = "", schema = "HR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableManager.findAll", query = "SELECT t FROM TableManager t")
    , @NamedQuery(name = "TableManager.findByIdManager", query = "SELECT t FROM TableManager t WHERE t.idManager = :idManager")})
public class TableManager implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MANAGER", nullable = false, precision = 22)
    private BigDecimal idManager;

    public TableManager() {
    }

    public TableManager(BigDecimal idManager) {
        this.idManager = idManager;
    }

    public BigDecimal getIdManager() {
        return idManager;
    }

    public void setIdManager(BigDecimal idManager) {
        this.idManager = idManager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManager != null ? idManager.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableManager)) {
            return false;
        }
        TableManager other = (TableManager) object;
        if ((this.idManager == null && other.idManager != null) || (this.idManager != null && !this.idManager.equals(other.idManager))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.TableManager[ idManager=" + idManager + " ]";
    }
    
}
