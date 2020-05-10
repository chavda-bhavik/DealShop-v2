/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:BusinessResource
 * [business]<br>
 * USAGE:
 * <pre>
 *        BusinessClient client = new BusinessClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author bhavik
 */
public class BusinessClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/DealShop-war/webresources";

    public BusinessClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("business");
    }

    public void addDealDetails(Object requestEntity, String did) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("dealDetails/{0}", new Object[]{did})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void editDeal(Object requestEntity) throws ClientErrorException {
        webTarget.path("deals").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removeDeal(String did) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deals/{0}", new Object[]{did})).request().delete();
    }

    public void setBusinessLinks(Object requestEntity, String bid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("links/{0}", new Object[]{bid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void editBusiness(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void setBusinessPhotos(Object requestEntity, String bid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("photos/{0}", new Object[]{bid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removeDealDetails(String did) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("dealDetails/{0}", new Object[]{did})).request().delete();
    }

    public void editDealDetails(Object requestEntity, String did) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("dealDetails/{0}", new Object[]{did})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void setBusinessInfo(Object requestEntity, String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("info/{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removeDealMenu(String menuid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("dealMenu/{0}", new Object[]{menuid})).request().delete();
    }

    public void addBusinessDeal(Object requestEntity, String bid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deals/{0}", new Object[]{bid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getDealsPayments(Class<T> responseType, String did) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("dealsPayments/{0}", new Object[]{did}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeBusinessPhoto(String bid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("photos/{0}", new Object[]{bid})).request().delete();
    }

    public void addDealMenu(Object requestEntity, String dealid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("dealMenu/{0}", new Object[]{dealid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllDeals(Class<T> responseType, String businessid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("deals/{0}", new Object[]{businessid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void editDealMenu(Object requestEntity) throws ClientErrorException {
        webTarget.path("dealMenu").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void registerBusiness(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void changeDealUsage(String dealid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("dealUsage/{0}", new Object[]{dealid})).request().post(null);
    }

    public void removeBusiness(String bid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{bid})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
