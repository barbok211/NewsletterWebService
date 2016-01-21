/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.i4.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author mehdi
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(fr.epsi.i4.ws.CampaignFacadeREST.class);
        resources.add(fr.epsi.i4.ws.ContentFacadeREST.class);
        resources.add(fr.epsi.i4.ws.MailingGroupFacadeREST.class);
        resources.add(fr.epsi.i4.ws.NewsletterFacadeREST.class);
        resources.add(fr.epsi.i4.ws.NewsletterResource.class);
        resources.add(fr.epsi.i4.ws.ReceiverFacadeREST.class);
        resources.add(fr.epsi.i4.ws.UserFacadeREST.class);
    }
    
}
