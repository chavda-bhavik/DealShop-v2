/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.AdminBeanLocal;
import beans.CommonBeanLocal;
import entity.Businesscategorytb;
import entity.Businesstypetb;
import entity.Citytb;
import entity.Dealscategorytb;
import entity.Informationtb;
import entity.Linkstb;
import entity.Offertb;
import entity.Statetb;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author bhavik
 */
@Path("admin")
public class AdminResource {
    @EJB AdminBeanLocal admin;
    @EJB CommonBeanLocal common;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminResource
     */
    public AdminResource() {
    }

//    State
    @GET
    @Path("/state")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Statetb> getAllStates() {
        return common.getAllState();
    }
    @POST
    @Path("/state")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addState(Statetb state) {
        admin.addState(state.getName());
    }
    @PUT
    @Path("/state/{stateId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editState(@PathParam("stateId") int StateId, Statetb state) {
        admin.editState(StateId, state.getName());
    }
    @DELETE
    @Path("/state/{stateId}")
    public void removeState(@PathParam("stateId") int StateId) {
        admin.removeState(StateId);
    }
    
//    City
    @GET
    @Path("/city")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Statetb> getAllCities() {
        return common.getAllState();
    }
    @POST
    @Path("/city")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCity(Citytb city) {
        admin.addCity(city.getName(), city.getStateID().getStateID());
    }
    @PUT
    @Path("/city/{cityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editCity(@PathParam("cityId") int CityId, Citytb city) {
        admin.editCity(CityId, city.getName(), city.getStateID().getStateID());
    }
    @DELETE
    @Path("/city/{cityId}")
    public void removeCity(@PathParam("cityId") String CityId) {
        admin.removeCity(Integer.parseInt(CityId));
    }
    
//  Deals Category
    @GET
    @Path("/dealsCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Dealscategorytb> getAllDealsCategory() {
        return common.getDealsCategoryList();
    }
    @POST
    @Path("/dealsCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDealsCategory(Dealscategorytb category) {
        admin.addDealsCategory(category.getName(), category.getImage());
    }
    @PUT
    @Path("/dealsCategory/{dcId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editDealsCategory(@PathParam("dcId") int DealCategoryId, Dealscategorytb category) {
        admin.editDealsCategory(DealCategoryId, category.getName(), category.getImage());
    }
    @DELETE
    @Path("/dealsCategory/{dcId}")
    public void removeDealsCategory(@PathParam("dcId") int DealCategoryId) {
        admin.removeDealsCategory(DealCategoryId);
    }
    
//  Offer
    @GET
    @Path("/offer")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Offertb> getAllOffers() {
        return common.getAllOffers();
    }
    @POST
    @Path("/offer")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addOffer(Offertb offer) {
        admin.addOffer(offer.getName(), offer.getCode(), offer.getTermsConditions(), offer.getIssueDate(), offer.getDueDate(), offer.getBannerImage(), offer.getOfferImage());
    }
    @PUT
    @Path("/offer/{oId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editOffer(@PathParam("oId") int id, Offertb offer) {
        admin.editOffer(id, offer.getName(), offer.getCode(), offer.getTermsConditions(), offer.getIssueDate(), offer.getDueDate(), offer.getBannerImage(), offer.getOfferImage());
    }
    @DELETE
    @Path("/offer/{oId}")
    public void removeOffer(@PathParam("oId") int id) {
        admin.removeOffer(id);
    }
    
    //  Links
    @GET
    @Path("/businessLinks")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Linkstb> getAllLinks() {
        return common.getLinksList();
    }
    @POST
    @Path("/businessLinks")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLink(Linkstb link) {
        admin.addLink(link.getName(), link.getLogo());
    }
    @PUT
    @Path("/businessLinks/{linkId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editLink(@PathParam("linkId") int id, Linkstb link) {
        admin.editLink(id, link.getName(), link.getLogo());
    }
    @DELETE
    @Path("/businessLinks/{linkId}")
    public void removeLink(@PathParam("linkId") int id) {
        admin.removeLink(id);
    }
    
    //  Business Category
    @GET
    @Path("/businessCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Businesscategorytb> getBusinessCategory() {
        return common.getAllBusinessCategories();
    }
    @POST
    @Path("/businessCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBusinessCategory(Businesscategorytb bCategory) {
        admin.addBussinessCategory(bCategory.getName(), bCategory.getImage());
    }
    @PUT
    @Path("/businessCategory/{bcId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editBusinessCategory(@PathParam("bcId") int id, Businesscategorytb bCategory) {
        admin.editBussinessCategory(id, bCategory.getName(), bCategory.getImage());
    }
    @DELETE
    @Path("/businessCategory/{bcId}")
    public void removeBusinessCategory(@PathParam("bcId") int id) {
        admin.removeBussinessCategory(id);
    }
    
    //  Business Type
    @GET
    @Path("/businessTypes")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Businesstypetb> getAllBusinessTypes() {
        return common.getAllBusinessTypes();
    }
    @POST
    @Path("/businessTypes")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBusinessType(Businesstypetb bType) {
        admin.addBussinessType(bType.getName(), bType.getBusinessCategoryID().getCategoryID(), bType.getImage());
    }
    @PUT
    @Path("/businessTypes/{btId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editBusinessType(@PathParam("btId") int id, Businesstypetb bType) {
        admin.editBussinessType(id, bType.getName(), bType.getBusinessCategoryID().getCategoryID(), bType.getImage());
    }
    @DELETE
    @Path("/businessTypes/{btId}")
    public void removeBusinessType(@PathParam("btId") int id) {
        admin.removeBussinessType(id);
    }
    
    //  Information List
    @GET
    @Path("/businessInfo")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Informationtb> getBusinessInfoList() {
        return common.getInformationList();
    }
    @POST
    @Path("/businessInfo")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addInformation(Informationtb bInfo) {
        admin.addInformation(bInfo.getTitle());
    }
    @PUT
    @Path("/businessInfo/{biId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editInformation(@PathParam("biId") int id, Informationtb bInfo) {
        admin.editInformation(id, bInfo.getTitle());
    }
    @DELETE
    @Path("/businessInfo/{biId}")
    public void removeInformation(@PathParam("biId") int id) {
        admin.removeInformation(id);
    }
}
