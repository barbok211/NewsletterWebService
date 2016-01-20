/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.i4;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mehdi
 */
@Path("newsletter")
public class NewsletterResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NewsletterResource
     */
    public NewsletterResource() {
    }

    /* GET */
    
    /**
     * Retrieves representation of an instance of fr.epsi.i4.NewsletterResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserById(@PathParam("id") int id) {
        return WSRestNewsletter.getUserById(id);
    }
    
    /**
     * Retrieves representation of an instance of fr.epsi.i4.NewsletterResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/receivers/newsletter/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getReceiversByNewsletterId(@PathParam("id") int id) {
        return WSRestNewsletter.getReceiversByNewsletterId(id);
    }
    
    /**
     * Retrieves representation of an instance of fr.epsi.i4.NewsletterResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/newsletter/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNewsLetterById(@PathParam("id") int id) {
        return WSRestNewsletter.getNewsLetterById(id);
    }
    
    /**
     * Retrieves representation of an instance of fr.epsi.i4.NewsletterResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/newsletters/receiver/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNewslettersByReceiverId(@PathParam("id") int id) {
        return WSRestNewsletter.getNewslettersByReceiverId(id);
    }

    /* END GET */
    
    /* PUT */
    
    /**
     * PUT method for updating or creating an instance of StudentsResource
     * @param id
     * @param title
     * @param content representation for the resource
     */
    @PUT
    @Path("/newsletter/{id}")
    public void updateNewsletterById(@PathParam("id") int id,
            @QueryParam("title") String title,
            @QueryParam("content") String content){
        WSRestNewsletter.updateNewsletterById(id, title, content);
    }
    
    /**
     * PUT method for updating or creating an instance of StudentsResource
     * @param id
     * @param userName
     * @param userMail
     * @param password
     */
    @PUT
    @Path("/user/{id}")
    public void updateUserById(@PathParam("id") int id,
            @QueryParam("userName") String userName,
            @QueryParam("userMail") String userMail,
            @QueryParam("password") String password){
        WSRestNewsletter.updateUserById(id, userName, userMail, password);
    }
    
    /**
     * PUT method for updating or creating an instance of StudentsResource
     * @param id
     * @param contentText
     */
    @PUT
    @Path("/content/{id}")
    public void updateContent(@PathParam("id") int id,
            @QueryParam("contentText") String contentText){
        WSRestNewsletter.updateContentById(id, contentText);
    }
    
    @PUT
    @Path("/campaign/{id}")
    public void updateCampaignById(@PathParam("id") int id,
            @QueryParam("campaignName") String campaignName){
        WSRestNewsletter.updateCampaignById(id, campaignName);
    }
    
    @PUT
    @Path("/mailingGroup/{id}")
    public void updateMailingGroupById(@PathParam("id") int id,
            @QueryParam("groupName") String groupName){
        WSRestNewsletter.updateMailingGroupById(id, groupName);
    }
    
    /* END PUT */
    
    /* POST */
    
    @POST
    @Path("/user")
    public void createUser(@QueryParam("userName") String userName, 
            @QueryParam("userMail") String userMail,
            @QueryParam("password") String password) {
        WSRestNewsletter.createUser(userName, userMail, password);
    }
    
    @POST
    @Path("/newsletter")
    public void createNewsletter(@QueryParam("title") String title, 
            @QueryParam("contentId") int contentId) {
        WSRestNewsletter.createNewsletter(title, contentId);
    }
    
    @POST
    @Path("/receiver")
    public void createReceiver(@QueryParam("userId") int userId){
        WSRestNewsletter.createReceiver(userId);
    }
    
    @POST
    @Path("/newsletterReceiver")
    public void createNewsletterReceiver(@QueryParam("newsletterId") int newsletterId, 
            @QueryParam("receiverId") int receiverId){
        WSRestNewsletter.createNewsletterReceiver(newsletterId, receiverId);
    }
    
    @POST
    @Path("/mailingGroup")
    public void createMailingGroup(@QueryParam("groupName") String groupName){
        WSRestNewsletter.createMailingGroup(groupName);
    }
    
    /**
     *
     * @param groupName
     * @param userMail
     */
    @POST
    @Path("/mailingGroupUsers")
    public void createMailingGroupUsers(@QueryParam("groupName") String groupName,
            @QueryParam("userMail") String userMail){
        WSRestNewsletter.createMailingGroupUsers(groupName, userMail);
    }
    
    @POST
    @Path("/content")
    public void createContent(@QueryParam("content") String content){
        WSRestNewsletter.createContent(content);
    }
    
    @POST
    @Path("/campaign")
    public void createCampaign(@QueryParam("campaignName") String campaignName){
        WSRestNewsletter.createCampaign(campaignName);
    }
    
    @POST
    @Path("/campaignNewsletters")
    public void createCampaignNewsletters(@QueryParam("campaignName") String campaignName,
            @QueryParam("newsletterId") String newsletterId){
        WSRestNewsletter.createCampaignNewsletters(campaignName, newsletterId);
    }
    
    /**
     *
     * @param campaignName
     * @param receiverId
     */
    @POST
    @Path("/campaignReceivers")
    public void createCampaignReceivers(@QueryParam("campaignName") String campaignName,
            @QueryParam("receiverId") String receiverId){
        WSRestNewsletter.createCampaignReceivers(campaignName, receiverId);
    }
    
    /* END POST */
    
    /* DELETE */

    /**
     *
     * @param userMail
     */
    @DELETE
    @Path("/user")
    public void removeUser(@QueryParam("userName") String userMail) {
        WSRestNewsletter.removeUser(userMail);
    }
    
    /**
     *
     * @param title
     * @param contentId
     */
    @POST
    @Path("/newsletter")
    public void removeNewsletter(@QueryParam("title") String title, 
            @QueryParam("contentId") int contentId) {
        WSRestNewsletter.removeNewsletter(title, contentId);
    }
    
    /**
     *
     * @param userId
     */
    @POST
    @Path("/receiver")
    public void removeReceiver(@QueryParam("userId") int userId){
        WSRestNewsletter.removeReceiver(userId);
    }
    
    /**
     *
     * @param newsletterId
     * @param receiverId
     */
    @POST
    @Path("/newsletterReceiver")
    public void removeNewsletterReceiver(@QueryParam("newsletterId") int newsletterId, 
            @QueryParam("receiverId") int receiverId){
        WSRestNewsletter.removeNewsletterReceiver(newsletterId, receiverId);
    }
    
    /**
     *
     * @param groupName
     */
    @POST
    @Path("/mailingGroup")
    public void removeMailingGroup(@QueryParam("groupName") String groupName){
        WSRestNewsletter.removeMailingGroup(groupName);
    }
    
    /**
     *
     * @param groupName
     * @param userMail
     */
    @POST
    @Path("/mailingGroupUsers")
    public void removeMailingGroupUsers(@QueryParam("groupName") String groupName,
            @QueryParam("userMail") String userMail){
        WSRestNewsletter.removeMailingGroupUsers(groupName, userMail);
    }
    
    /**
     *
     * @param contentId
     */
    @POST
    @Path("/content")
    public void removeContent(@QueryParam("contentId") int contentId){
        WSRestNewsletter.removeContent(contentId);
    }
    
    /**
     *
     * @param campaignName
     */
    @POST
    @Path("/campaign")
    public void removeCampaign(@QueryParam("campaignName") String campaignName){
        WSRestNewsletter.removeCampaign(campaignName);
    }
    
    /**
     *
     * @param campaignName
     * @param newsletterId
     */
    @POST
    @Path("/campaignNewsletters")
    public void removeCampaignNewsletters(@QueryParam("campaignName") String campaignName,
            @QueryParam("newsletterId") String newsletterId){
        WSRestNewsletter.removeCampaignNewsletters(campaignName, newsletterId);
    }
    
    /**
     *
     * @param campaignName
     * @param receiverId
     */
    @POST
    @Path("/campaignReceivers")
    public void removeCampaignReceivers(@QueryParam("campaignName") String campaignName,
            @QueryParam("receiverId") int receiverId){
        WSRestNewsletter.removeCampaignReceivers(campaignName, receiverId);
    }
    
    /* END DELETE */
}
