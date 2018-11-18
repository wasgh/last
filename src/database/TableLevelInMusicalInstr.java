/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
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
@Table(name = "TABLE_LEVEL_IN_MUSICAL_INSTR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableLevelInMusicalInstr.findAll", query = "SELECT t FROM TableLevelInMusicalInstr t")
    , @NamedQuery(name = "TableLevelInMusicalInstr.findById", query = "SELECT t FROM TableLevelInMusicalInstr t WHERE t.id = :id")
    , @NamedQuery(name = "TableLevelInMusicalInstr.findByLevelName", query = "SELECT t FROM TableLevelInMusicalInstr t WHERE t.levelName = :levelName")
    , @NamedQuery(name = "TableLevelInMusicalInstr.findByIdMusicalInstr", query = "SELECT t FROM TableLevelInMusicalInstr t WHERE t.idMusicalInstr = :idMusicalInstr")
    , @NamedQuery(name = "TableLevelInMusicalInstr.findByIdStudentMusicalInstr", query = "SELECT t FROM TableLevelInMusicalInstr t WHERE t.idStudentMusicalInstr = :idStudentMusicalInstr")})
public class TableLevelInMusicalInstr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "LEVEL_NAME")
    private String levelName;
    @Column(name = "ID_MUSICAL_INSTR")
    private String idMusicalInstr;
    @Column(name = "ID_STUDENT_MUSICAL_INSTR")
    private String idStudentMusicalInstr;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TableMusicalInstrument tableMusicalInstrument;
    @JoinColumn(name = "ID", referencedColumnName = "ID_STUDENT", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TableStudent tableStudent;

    public TableLevelInMusicalInstr() {
    }

    public TableLevelInMusicalInstr(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getIdMusicalInstr() {
        return idMusicalInstr;
    }

    public void setIdMusicalInstr(String idMusicalInstr) {
        this.idMusicalInstr = idMusicalInstr;
    }

    public String getIdStudentMusicalInstr() {
        return idStudentMusicalInstr;
    }

    public void setIdStudentMusicalInstr(String idStudentMusicalInstr) {
        this.idStudentMusicalInstr = idStudentMusicalInstr;
    }

    public TableMusicalInstrument getTableMusicalInstrument() {
        return tableMusicalInstrument;
    }

    public void setTableMusicalInstrument(TableMusicalInstrument tableMusicalInstrument) {
        this.tableMusicalInstrument = tableMusicalInstrument;
    }

    public TableStudent getTableStudent() {
        return tableStudent;
    }

    public void setTableStudent(TableStudent tableStudent) {
        this.tableStudent = tableStudent;
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
        return "database.TableLevelInMusicalInstr[ id=" + id + " ]";
    }
    
}
