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
 * @author Phantom
 */
@Entity
@Table(name = "Newsletter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Newsletter.findAll", query = "SELECT n FROM Newsletter n"),
    @NamedQuery(name = "Newsletter.findByNewsletterId", query = "SELECT n FROM Newsletter n WHERE n.newsletterId = :newsletterId"),
    @NamedQuery(name = "Newsletter.findByNewsletterTitle", query = "SELECT n FROM Newsletter n WHERE n.newsletterTitle = :newsletterTitle"),
    @NamedQuery(name = "Newsletter.findByNewsletterContent", query = "SELECT n FROM Newsletter n WHERE n.newsletterContent = :newsletterContent")})
public class Newsletter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "newsletterId")
    private Integer newsletterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "newsletterTitle")
    private String newsletterTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "newsletterContent")
    private int newsletterContent;
    @ManyToMany(mappedBy = "newsletterSet")
    private Set<Campaign> campaignSet;
    @ManyToMany(mappedBy = "newsletterSet")
    private Set<Receiver> receiverSet;

    public Newsletter() {
    }

    public Newsletter(Integer newsletterId) {
        this.newsletterId = newsletterId;
    }

    public Newsletter(Integer newsletterId, String newsletterTitle, int newsletterContent) {
        this.newsletterId = newsletterId;
        this.newsletterTitle = newsletterTitle;
        this.newsletterContent = newsletterContent;
    }

    public Integer getNewsletterId() {
        return newsletterId;
    }

    public void setNewsletterId(Integer newsletterId) {
        this.newsletterId = newsletterId;
    }

    public String getNewsletterTitle() {
        return newsletterTitle;
    }

    public void setNewsletterTitle(String newsletterTitle) {
        this.newsletterTitle = newsletterTitle;
    }

    public int getNewsletterContent() {
        return newsletterContent;
    }

    public void setNewsletterContent(int newsletterContent) {
        this.newsletterContent = newsletterContent;
    }

    @XmlTransient
    public Set<Campaign> getCampaignSet() {
        return campaignSet;
    }

    public void setCampaignSet(Set<Campaign> campaignSet) {
        this.campaignSet = campaignSet;
    }

    @XmlTransient
    public Set<Receiver> getReceiverSet() {
        return receiverSet;
    }

    public void setReceiverSet(Set<Receiver> receiverSet) {
        this.receiverSet = receiverSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsletterId != null ? newsletterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newsletter)) {
            return false;
        }
        Newsletter other = (Newsletter) object;
        if ((this.newsletterId == null && other.newsletterId != null) || (this.newsletterId != null && !this.newsletterId.equals(other.newsletterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.i4.models.Newsletter[ newsletterId=" + newsletterId + " ]";
    }
    
}
