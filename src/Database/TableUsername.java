/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wasim
 */
@Entity
@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "USERNAME_ID_SEQUENCE", allocationSize = 1)
@Table(name = "TABLE_USERNAME", catalog = "", schema = "HR", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"USERNAME"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableUsername.findAll", query = "SELECT t FROM TableUsername t")
    , @NamedQuery(name = "TableUsername.findByUsernameId", query = "SELECT t FROM TableUsername t WHERE t.usernameId = :usernameId")
    , @NamedQuery(name = "TableUsername.findByUsername", query = "SELECT t FROM TableUsername t WHERE t.username = :username")
    , @NamedQuery(name = "TableUsername.findByPassword", query = "SELECT t FROM TableUsername t WHERE t.password = :password")
    , @NamedQuery(name = "TableUsername.findBySex", query = "SELECT t FROM TableUsername t WHERE t.sex = :sex")
    , @NamedQuery(name = "TableUsername.findByAdditionalInfo", query = "SELECT t FROM TableUsername t WHERE t.additionalInfo = :additionalInfo")
    , @NamedQuery(name = "TableUsername.findByEmailAddress", query = "SELECT t FROM TableUsername t WHERE t.emailAddress = :emailAddress")
    , @NamedQuery(name = "TableUsername.findBySsn", query = "SELECT t FROM TableUsername t WHERE t.ssn = :ssn")
    , @NamedQuery(name = "TableUsername.findByDataadded", query = "SELECT t FROM TableUsername t WHERE t.dataadded = :dataadded")
    , @NamedQuery(name = "TableUsername.findByFirstName", query = "SELECT t FROM TableUsername t WHERE t.firstName = :firstName")
    , @NamedQuery(name = "TableUsername.findByLastName", query = "SELECT t FROM TableUsername t WHERE t.lastName = :lastName")
    , @NamedQuery(name = "TableUsername.findByBirthdate", query = "SELECT t FROM TableUsername t WHERE t.birthdate = :birthdate")
    , @NamedQuery(name = "TableUsername.findByPhoneNumber", query = "SELECT t FROM TableUsername t WHERE t.phoneNumber = :phoneNumber")})
public class TableUsername implements Serializable {

    public TableUsername(BigDecimal usernameId, String username, String password, String sex, String additionalInfo, String emailAddress, String ssn, Date dataadded, String firstName, String lastName, Date birthdate, String phoneNumber, TableLevelInMusicalInstr tableLevelInMusicalInstr, Collection<TableMessage> tableMessageCollection, Collection<TableMessage> tableMessageCollection1, TableStudent tableStudent, TableTeacher tableTeacher) {
        this.usernameId = usernameId;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.additionalInfo = additionalInfo;
        this.emailAddress = emailAddress;
        this.ssn = ssn;
        this.dataadded = dataadded;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.tableLevelInMusicalInstr = tableLevelInMusicalInstr;
        this.tableMessageCollection = tableMessageCollection;
        this.tableMessageCollection1 = tableMessageCollection1;
        this.tableStudent = tableStudent;
        this.tableTeacher = tableTeacher;
    }

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(generator = "SequenceIdGenerator")
    @Basic(optional = false)
    @Column(name = "USERNAME_ID", nullable = false, precision = 22, scale = 0)
    private BigDecimal usernameId;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String username;
    @Basic(optional = false)
    @Column(nullable = false, length = 25)
    private String password;
    @Column(length = 1)
    private String sex;
    @Column(name = "ADDITIONAL_INFO", length = 20)
    private String additionalInfo;
    @Column(name = "EMAIL_ADDRESS", length = 200)
    private String emailAddress;
    @Column(length = 20)
    private String ssn;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataadded;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tableUsername")
    private TableLevelInMusicalInstr tableLevelInMusicalInstr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromUserId")
    private Collection<TableMessage> tableMessageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toUserId")
    private Collection<TableMessage> tableMessageCollection1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tableUsername")
    private TableStudent tableStudent;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tableUsername")
    private TableTeacher tableTeacher;

    public TableUsername() {
    }

    public TableUsername(BigDecimal usernameId) {
        this.usernameId = usernameId;
    }

 

    public BigDecimal getUsernameId() {
        return usernameId;
    }

    public void setUsernameId(BigDecimal usernameId) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDataadded() {
        return dataadded;
    }

    public void setDataadded(Date dataadded) {
        this.dataadded = dataadded;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TableLevelInMusicalInstr getTableLevelInMusicalInstr() {
        return tableLevelInMusicalInstr;
    }

    public void setTableLevelInMusicalInstr(TableLevelInMusicalInstr tableLevelInMusicalInstr) {
        this.tableLevelInMusicalInstr = tableLevelInMusicalInstr;
    }

    @XmlTransient
    public Collection<TableMessage> getTableMessageCollection() {
        return tableMessageCollection;
    }

    public void setTableMessageCollection(Collection<TableMessage> tableMessageCollection) {
        this.tableMessageCollection = tableMessageCollection;
    }

    @XmlTransient
    public Collection<TableMessage> getTableMessageCollection1() {
        return tableMessageCollection1;
    }

    public void setTableMessageCollection1(Collection<TableMessage> tableMessageCollection1) {
        this.tableMessageCollection1 = tableMessageCollection1;
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
        return "Database.TableUsername[ usernameId=" + usernameId + " ]";
    }
    
}
