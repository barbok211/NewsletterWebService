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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phantom
 */
@Entity
@Table(name = "Receiver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receiver.findAll", query = "SELECT r FROM Receiver r"),
    @NamedQuery(name = "Receiver.findByReceiverId", query = "SELECT r FROM Receiver r WHERE r.receiverId = :receiverId")})
public class Receiver implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "receiverId")
    private Integer receiverId;
    @ManyToMany(mappedBy = "receiverSet")
    private Set<Campaign> campaignSet;
    @JoinTable(name = "NewsletterReceivers", joinColumns = {
        @JoinColumn(name = "receiverId", referencedColumnName = "receiverId")}, inverseJoinColumns = {
        @JoinColumn(name = "newsletterId", referencedColumnName = "newsletterId")})
    @ManyToMany
    private Set<Newsletter> newsletterSet;
    @OneToMany(mappedBy = "receiverId")
    private Set<User> userSet;
    @OneToMany(mappedBy = "receiverId")
    private Set<MailingGroup> mailingGroupSet;

    public Receiver() {
    }

    public Receiver(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    @XmlTransient
    public Set<Campaign> getCampaignSet() {
        return campaignSet;
    }

    public void setCampaignSet(Set<Campaign> campaignSet) {
        this.campaignSet = campaignSet;
    }

    @XmlTransient
    public Set<Newsletter> getNewsletterSet() {
        return newsletterSet;
    }

    public void setNewsletterSet(Set<Newsletter> newsletterSet) {
        this.newsletterSet = newsletterSet;
    }

    @XmlTransient
    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @XmlTransient
    public Set<MailingGroup> getMailingGroupSet() {
        return mailingGroupSet;
    }

    public void setMailingGroupSet(Set<MailingGroup> mailingGroupSet) {
        this.mailingGroupSet = mailingGroupSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiverId != null ? receiverId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receiver)) {
            return false;
        }
        Receiver other = (Receiver) object;
        if ((this.receiverId == null && other.receiverId != null) || (this.receiverId != null && !this.receiverId.equals(other.receiverId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.i4.models.Receiver[ receiverId=" + receiverId + " ]";
    }
    
}
