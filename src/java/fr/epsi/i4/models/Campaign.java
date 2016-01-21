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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mehdi
 */
@Entity
@Table(name = "Campaign")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campaign.findAll", query = "SELECT c FROM Campaign c"),
    @NamedQuery(name = "Campaign.findByCampaignName", query = "SELECT c FROM Campaign c WHERE c.campaignName = :campaignName"),
    @NamedQuery(name = "Campaign.findByCampaignId", query = "SELECT c FROM Campaign c WHERE c.campaignId = :campaignId")})
public class Campaign implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "campaignName")
    private String campaignName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "campaignId")
    private Integer campaignId;
    @JoinTable(name = "CampaignReceivers", joinColumns = {
        @JoinColumn(name = "campaignId", referencedColumnName = "campaignId")}, inverseJoinColumns = {
        @JoinColumn(name = "receiverId", referencedColumnName = "receiverId")})
    @ManyToMany
    private Set<Receiver> receiverSet;
    @JoinTable(name = "CampaignNewsletters", joinColumns = {
        @JoinColumn(name = "campaignId", referencedColumnName = "campaignId")}, inverseJoinColumns = {
        @JoinColumn(name = "newsletterId", referencedColumnName = "newsletterId")})
    @ManyToMany
    private Set<Newsletter> newsletterSet;

    public Campaign() {
    }

    public Campaign(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Campaign(Integer campaignId, String campaignName) {
        this.campaignId = campaignId;
        this.campaignName = campaignName;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    @XmlTransient
    public Set<Receiver> getReceiverSet() {
        return receiverSet;
    }

    public void setReceiverSet(Set<Receiver> receiverSet) {
        this.receiverSet = receiverSet;
    }

    @XmlTransient
    public Set<Newsletter> getNewsletterSet() {
        return newsletterSet;
    }

    public void setNewsletterSet(Set<Newsletter> newsletterSet) {
        this.newsletterSet = newsletterSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campaignId != null ? campaignId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campaign)) {
            return false;
        }
        Campaign other = (Campaign) object;
        if ((this.campaignId == null && other.campaignId != null) || (this.campaignId != null && !this.campaignId.equals(other.campaignId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.i4.models.Campaign[ campaignId=" + campaignId + " ]";
    }
    
}
