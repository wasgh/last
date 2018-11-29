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
@Table(name = "TABLE_MUSICAL_INSTRUMENT", catalog = "", schema = "HR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableMusicalInstrument.findAll", query = "SELECT t FROM TableMusicalInstrument t")
    , @NamedQuery(name = "TableMusicalInstrument.findById", query = "SELECT t FROM TableMusicalInstrument t WHERE t.id = :id")
    , @NamedQuery(name = "TableMusicalInstrument.findByNameMusicalInstrument", query = "SELECT t FROM TableMusicalInstrument t WHERE t.nameMusicalInstrument = :nameMusicalInstrument")})
public class TableMusicalInstrument implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false, precision = 22)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME_MUSICAL_INSTRUMENT", nullable = false, length = 20)
    private String nameMusicalInstrument;
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TableLevelInMusicalInstr tableLevelInMusicalInstr;

    public TableMusicalInstrument() {
    }

    public TableMusicalInstrument(BigDecimal id) {
        this.id = id;
    }

    public TableMusicalInstrument(BigDecimal id, String nameMusicalInstrument) {
        this.id = id;
        this.nameMusicalInstrument = nameMusicalInstrument;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNameMusicalInstrument() {
        return nameMusicalInstrument;
    }

    public void setNameMusicalInstrument(String nameMusicalInstrument) {
        this.nameMusicalInstrument = nameMusicalInstrument;
    }

    public TableLevelInMusicalInstr getTableLevelInMusicalInstr() {
        return tableLevelInMusicalInstr;
    }

    public void setTableLevelInMusicalInstr(TableLevelInMusicalInstr tableLevelInMusicalInstr) {
        this.tableLevelInMusicalInstr = tableLevelInMusicalInstr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableMusicalInstrument)) {
            return false;
        }
        TableMusicalInstrument other = (TableMusicalInstrument) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.TableMusicalInstrument[ id=" + id + " ]";
    }
    
}
