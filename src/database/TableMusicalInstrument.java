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
@Table(name = "TABLE_MUSICAL_INSTRUMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableMusicalInstrument.findAll", query = "SELECT t FROM TableMusicalInstrument t")
    , @NamedQuery(name = "TableMusicalInstrument.findById", query = "SELECT t FROM TableMusicalInstrument t WHERE t.id = :id")
    , @NamedQuery(name = "TableMusicalInstrument.findByNameMusicalInstrument", query = "SELECT t FROM TableMusicalInstrument t WHERE t.nameMusicalInstrument = :nameMusicalInstrument")})
public class TableMusicalInstrument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME_MUSICAL_INSTRUMENT")
    private String nameMusicalInstrument;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tableMusicalInstrument")
    private TableLevelInMusicalInstr tableLevelInMusicalInstr;

    public TableMusicalInstrument() {
    }

    public TableMusicalInstrument(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "database.TableMusicalInstrument[ id=" + id + " ]";
    }
    
}
