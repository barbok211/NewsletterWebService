/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.i4.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phantom
 */
@Entity
@Table(name = "User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByUserMail", query = "SELECT u FROM User u WHERE u.userMail = :userMail"),
    @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.userPassword = :userPassword")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userName")
    private String userName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userMail")
    private String userMail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userPassword")
    private String userPassword;
    @ManyToMany(mappedBy = "userSet")
    private Set<MailingGroup> mailingGroupSet;
    @JoinColumn(name = "receiverId", referencedColumnName = "receiverId")
    @ManyToOne
    private Receiver receiverId;

    public User() {
    }

    public User(String userMail) {
        this.userMail = userMail;
    }

    public User(String userMail, String userName, String userPassword) {
        this.userMail = userMail;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @XmlTransient
    public Set<MailingGroup> getMailingGroupSet() {
        return mailingGroupSet;
    }

    public void setMailingGroupSet(Set<MailingGroup> mailingGroupSet) {
        this.mailingGroupSet = mailingGroupSet;
    }

    public Receiver getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Receiver receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userMail != null ? userMail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userMail == null && other.userMail != null) || (this.userMail != null && !this.userMail.equals(other.userMail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.i4.models.User[ userMail=" + userMail + " ]";
    }
    
}
