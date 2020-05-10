/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.Businesscategorytb;
import entity.Businessinfotb;
import entity.Businessphotostb;
import entity.Businesstb;
import entity.Businesstypetb;
import entity.Citytb;
import entity.Dealscategorytb;
import entity.Dealsdetailstb;
import entity.Dealsmenutb;
import entity.Dealstb;
import entity.Informationtb;
import entity.Linkstb;
import entity.Offertb;
import entity.Reviewtb;
import entity.Statetb;
import entity.Usertb;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bhavik
 */
@Stateless
public class CommonBean implements CommonBeanLocal {
    @PersistenceContext(unitName="DealShopPU")
    EntityManager em;
    
    @Override
    public Collection<Businesscategorytb> getAllBusinessCategories() {
        return em.createNamedQuery("Businesscategorytb.findAll").getResultList();
    }

    @Override
    public Collection<Businesstypetb> getAllBusinessTypes() {
        return em.createNamedQuery("Businesstypetb.findAll").getResultList();
    }

    @Override
    public Collection<Businesstb> getAllBusiness() {
        return em.createNamedQuery("Businesstb.findAll").getResultList();
    }

    @Override
    public Collection<Businesstb> getAllBusinessByCity(int CityID) {
        Citytb city = em.find(Citytb.class, CityID);
        return city.getBusinesstbCollection();
    }

    @Override
    public Collection<Businesstb> getAllBusinessByState(int StateID) {
        Statetb state = em.find(Statetb.class, StateID);
        return state.getBusinesstbCollection();
    }

    @Override
    public Collection<Businesstb> getAllBusinessByCategory(int CategoryID) {
        Businesscategorytb category = em.find(Businesscategorytb.class, CategoryID);
        return category.getBusinesstbCollection();
    }

    @Override
    public Businesstb getBusiness(int BusinessID) {
        Businesstb business = em.find(Businesstb.class, BusinessID);
        return business;
    }

    @Override
    public Collection<Businessphotostb> getBusinessPhotos(int BusinessID) {
        Businesstb business = em.find(Businesstb.class, BusinessID);
        return business.getBusinessphotostbCollection();
    }

    @Override
    public Collection<Reviewtb> getBusinessReviews(int BusinessID) {
        Businesstb business = em.find(Businesstb.class, BusinessID);
        return business.getReviewtbCollection();
    }

    @Override
    public Collection<Informationtb> getInformationList() {
        Collection<Informationtb> informations = em.createNamedQuery("Informationtb.findAll").getResultList();
        return informations;
    }

    @Override
    public Collection<Informationtb> getBussinessInformation(int BusinessID) {
        Businesstb business = (Businesstb) em.createNamedQuery("Businesstb.findByBusinessID").setParameter("businessID", BusinessID).getSingleResult();
        Collection<Businessinfotb> businessInfos = business.getBusinessinfotbCollection();
        Collection<Informationtb> infos = new ArrayList<Informationtb>();
        for (Businessinfotb businessInfo : businessInfos) {
            infos.add(businessInfo.getInformationID());
        }
        return infos;
    }

    @Override
    public Collection<Statetb> getAllState() {
        Collection<Statetb> states = em.createNamedQuery("Statetb.findAll").getResultList();
        return states;
    }

    @Override
    public Collection<Citytb> getAllCity() {
        Collection<Citytb> cities = em.createNamedQuery("Citytb.findAll").getResultList();
        return cities;
    }

    @Override
    public Collection<Linkstb> getLinksList() {
        Collection<Linkstb> links = em.createNamedQuery("Linkstb.findAll").getResultList();
        return links;
    }

    @Override
    public Collection<Linkstb> getBussinessLinks(int BusinessID) {
//        Businesstb business = em.find(Businesstb.class, BusinessID);
//        return business.get
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Dealscategorytb> getDealsCategoryList() {
        Collection<Dealscategorytb> categories = em.createNamedQuery("Dealscategorytb.findAll").getResultList();
        return categories;
    }

    @Override
    public Dealstb getSingleDeal(int DealID) {
        Dealstb deal = (Dealstb) em.createNamedQuery("Dealstb.findByDealID").setParameter("dealID", DealID).getSingleResult();
        return deal;
    }

    @Override
    public Collection<Dealstb> getBusinessDeals(int BusinessID) {
        Businesstb business = em.find(Businesstb.class, BusinessID);
        Collection<Dealstb> bDeals = em.createNamedQuery("Dealstb.findByBusinessID").setParameter("businessID", business).getResultList();
        return bDeals;
    }

    @Override
    public Collection<Dealstb> getDealsByCategory(int DealCategoryID) {
        Dealscategorytb dCategory = em.find(Dealscategorytb.class, DealCategoryID);
        return dCategory.getDealstbCollection();
    }

    @Override
    public Collection<Dealstb> getDealsByMaxSoldNo(int limit) {
        //return em.createNamedQuery("Dealstb.getByMaxSoldNo").setParameter("limit", limit).getResultList();
        return em.createQuery("SELECT d FROM Dealstb d ORDER BY d.soldNo DESC", Dealstb.class).setMaxResults(limit).getResultList();
    }
    
    @Override
    public Dealsdetailstb getDealDetails(int DealID) {
        Dealstb deal = em.find(Dealstb.class, DealID);
        return deal.getDealsdetailstbCollection().iterator().next();
    }

    @Override
    public Dealsmenutb getDealMenu(int DealID) {
        Dealstb deal = em.find(Dealstb.class, DealID);
        return deal.getDealsmenutbCollection().iterator().next();
    }

    @Override
    public Collection<Offertb> getAllOffers() {
        Collection<Offertb> offers = em.createNamedQuery("Offertb.findAll").getResultList();
        return offers;
    }

    @Override
    public Offertb getOfferByID(int OfferID) {
        Offertb offer = em.find(Offertb.class, OfferID);
        return offer;
    }

    @Override
    public Offertb getOfferByCode(String Code) {
        Object offer = em.createNamedQuery("Offertb.findByCode").setParameter("code", Code).getSingleResult();
        if(offer != null) {
            return (Offertb)offer;
        } else {
            Offertb tempOffer = new Offertb();
            tempOffer.setName("Invalid");
            return tempOffer;
        }
    }

    @Override
    public Boolean isOfferExists(String Code) {
        try {
            Object offer = em.createNamedQuery("Offertb.findByCode").setParameter("code", Code).getSingleResult();
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    //---Login---
    @Override
    public Usertb login(String Email, String Password) {
        int i = em.createQuery("SELECT u from Usertb u where u.email='"+Email+"' and u.password='"+Password+"'").getResultList().size();
        Usertb user = new Usertb();
        if(i>0) {
            user = (Usertb) em.createQuery("SELECT u from Usertb u where u.email='"+Email+"' and u.password='"+Password+"'").getSingleResult();
        }
        return user;
    }

    @Override
    public Usertb getLoginUser(String Email) {
        Usertb user = (Usertb) em.createNamedQuery("Usertb.findByEmail").setParameter("email", Email).getSingleResult();
        return user;
    }
}
