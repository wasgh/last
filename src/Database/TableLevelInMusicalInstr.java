/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "TABLE_LEVEL_IN_MUSICAL_INSTR", catalog = "", schema = "HR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableLevelInMusicalInstr.findAll", query = "SELECT t FROM TableLevelInMusicalInstr t")
    , @NamedQuery(name = "TableLevelInMusicalInstr.findById", query = "SELECT t FROM TableLevelInMusicalInstr t WHERE t.id = :id")
    , @NamedQuery(name = "TableLevelInMusicalInstr.findByLevelName", query = "SELECT t FROM TableLevelInMusicalInstr t WHERE t.levelName = :levelName")
    , @NamedQuery(name = "TableLevelInMusicalInstr.findByIdMusicalInstr", query = "SELECT t FROM TableLevelInMusicalInstr t WHERE t.idMusicalInstr = :idMusicalInstr")
    , @NamedQuery(name = "TableLevelInMusicalInstr.findByIdStudentMusicalInstr", query = "SELECT t FROM TableLevelInMusicalInstr t WHERE t.idStudentMusicalInstr = :idStudentMusicalInstr")})
public class TableLevelInMusicalInstr implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false, precision = 22)
    private BigDecimal id;
    @Column(name = "LEVEL_NAME", length = 20)
    private String levelName;
    @Basic(optional = false)
    @Column(name = "ID_MUSICAL_INSTR", nullable = false)
    private BigInteger idMusicalInstr;
    @Basic(optional = false)
    @Column(name = "ID_STUDENT_MUSICAL_INSTR", nullable = false)
    private BigInteger idStudentMusicalInstr;
    @JoinColumn(name = "ID", referencedColumnName = "USERNAME_ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TableUsername tableUsername;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tableLevelInMusicalInstr")
    private TableMusicalInstrument tableMusicalInstrument;

    public TableLevelInMusicalInstr() {
    }

    public TableLevelInMusicalInstr(BigDecimal id) {
        this.id = id;
    }

    public TableLevelInMusicalInstr(BigDecimal id, BigInteger idMusicalInstr, BigInteger idStudentMusicalInstr) {
        this.id = id;
        this.idMusicalInstr = idMusicalInstr;
        this.idStudentMusicalInstr = idStudentMusicalInstr;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public BigInteger getIdMusicalInstr() {
        return idMusicalInstr;
    }

    public void setIdMusicalInstr(BigInteger idMusicalInstr) {
        this.idMusicalInstr = idMusicalInstr;
    }

    public BigInteger getIdStudentMusicalInstr() {
        return idStudentMusicalInstr;
    }

    public void setIdStudentMusicalInstr(BigInteger idStudentMusicalInstr) {
        this.idStudentMusicalInstr = idStudentMusicalInstr;
    }

    public TableUsername getTableUsername() {
        return tableUsername;
    }

    public void setTableUsername(TableUsername tableUsername) {
        this.tableUsername = tableUsername;
    }

    public TableMusicalInstrument getTableMusicalInstrument() {
        return tableMusicalInstrument;
    }

    public void setTableMusicalInstrument(TableMusicalInstrument tableMusicalInstrument) {
        this.tableMusicalInstrument = tableMusicalInstrument;
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
        if (!(object instanceof TableLevelInMusicalInstr)) {
            return false;
        }
        TableLevelInMusicalInstr other = (TableLevelInMusicalInstr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.TableLevelInMusicalInstr[ id=" + id + " ]";
    }
    
}
