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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "MailingGroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MailingGroup.findAll", query = "SELECT m FROM MailingGroup m"),
    @NamedQuery(name = "MailingGroup.findByGroupName", query = "SELECT m FROM MailingGroup m WHERE m.groupName = :groupName"),
    @NamedQuery(name = "MailingGroup.findByGroupId", query = "SELECT m FROM MailingGroup m WHERE m.groupId = :groupId")})
public class MailingGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "groupName")
    private String groupName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupId")
    private Integer groupId;
    @JoinTable(name = "MailingGroupUsers", joinColumns = {
        @JoinColumn(name = "groupId", referencedColumnName = "groupId")}, inverseJoinColumns = {
        @JoinColumn(name = "userMail", referencedColumnName = "userMail")})
    @ManyToMany
    private Set<User> userSet;
    @JoinColumn(name = "receiverId", referencedColumnName = "receiverId")
    @ManyToOne
    private Receiver receiverId;

    public MailingGroup() {
    }

    public MailingGroup(Integer groupId) {
        this.groupId = groupId;
    }

    public MailingGroup(Integer groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @XmlTransient
    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
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
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MailingGroup)) {
            return false;
        }
        MailingGroup other = (MailingGroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.i4.models.MailingGroup[ groupId=" + groupId + " ]";
    }
    
}
