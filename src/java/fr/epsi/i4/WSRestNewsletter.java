/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.i4;

import java.util.List;

/**
 *
 * @author mehdi
 */
public class WSRestNewsletter {

    public static String getUserById(int id) {
        return "";
    }
    
    public static String getReceiversByNewsletterId(int id){
        return "";
    }
    
    public static String getNewsLetterById(int id){
        return "";
    }
    
    public static String getNewslettersByReceiverId(int id){
        return "";
    }
    
    public static void updateNewsletterById(int id, String title, String content){
        
    }
    
    public static void updateUserById(int id, String userName, String email, String password){
        
    }
    
    public static void updateContentById(int id, String contentText){
        
    }
    
    public static void updateCampaignById(int id, String campaignName){
        
    }
    
    public static void updateMailingGroupById(int id, String groupName){
        
    }
    
    public static void createUser(String userName, String email, String password){
        
    }
    
    public static void createNewsletter(String title, int contentId){
        
    }
    
    public static void createReceiver(int id){
        
    }
    
    public static void createNewsletterReceiver(int newsletterId, int receiverId){

    }

    public static void createMailingGroup(String groupName){
        
    }
    
    public static void createMailingGroupUsers(String groupName, String userMail){
        
    }
    
    public static void createContent(String content){
        
    }
    
    public static void createCampaign(String campaignName){
        
    }
    
    public static void createCampaignNewsletters(String campaignName, String newsletterId){
        
    }
        
    public static void createCampaignReceivers(String campaignName, String receiverId){
        
    }
    
    public static void removeUser(String userMail){
        
    }
    
    public static void removeNewsletter(String title, int contentId){
        
    }
    
    public static void removeReceiver(int id){
        
    }
    
    public static void removeNewsletterReceiver(int newsletterId, int receiverId){

    }

    public static void removeMailingGroup(String groupName){
        
    }
    
    public static void removeMailingGroupUsers(String groupName, String userMail){
        
    }
    
    public static void removeContent(int contentId){
        
    }
    
    public static void removeCampaign(String campaignName){
        
    }
    
    public static void removeCampaignNewsletters(String campaignName, String newsletterId){
        
    }
        
    public static void removeCampaignReceivers(String campaignName, int receiverId){
        
    }
    

}
