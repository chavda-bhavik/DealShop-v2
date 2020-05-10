/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.CommonClient;
import client.UserClient;
import entity.Carttb;
import entity.Offertb;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author bhavik
 */
@Named(value = "userDealsBean")
@RequestScoped
public class UserDealsBean {

    FacesContext facesContext = FacesContext.getCurrentInstance();
    Map<String,String> params = facesContext.getExternalContext().getRequestParameterMap();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    
    UserClient userClient;
    CommonClient commonClient;
    
    Response res;
    GenericType<Collection<Carttb>> gUserCart;
    Collection<Carttb> userCart;

    private double totalPrice;
    
    private String offerCode;
    private String OfferButtonText = "Apply Offer";
    private String OfferMessage = "";
    GenericType<Offertb> gOffer;
    Offertb offer;
    
    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOfferMessage() {
        return OfferMessage;
    }

    public void setOfferMessage(String OfferMessage) {
        this.OfferMessage = OfferMessage;
    }

    public String getOfferButtonText() {
        return OfferButtonText;
    }

    public void setOfferButtonText(String OfferButtonText) {
        this.OfferButtonText = OfferButtonText;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }
    
    public Collection<Carttb> getUserCart() {
        String userId = session.getAttribute("userid").toString();
        res = userClient.getUserCartDeals(Response.class, userId);
        userCart = res.readEntity(gUserCart);
        return userCart;
    }

    public void setUserCart(Collection<Carttb> userCart) {
        this.userCart = userCart;
    }
    
    public void removeDealFromCart(int cartId) {
        userClient.removeDealFromCart(String.valueOf(cartId));
        this.fetchUserDeals();
    }
    
    public void checkLoginAndRedirect() throws IOException {
        Object h = session.getAttribute("userid");
        if(h==null) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/user/Home.jsf");
        }
    }
    
    public void fetchUserDeals() {
        String userId = session.getAttribute("userid").toString();
        res = userClient.getUserCartDeals(Response.class, userId);
        userCart = res.readEntity(gUserCart);
        this.setTotalPrice();
    }
    public void setTotalPrice() {
        for (Carttb carttb : userCart) {
            totalPrice += carttb.getDealID().getAverageCost();
        }
        if(offer != null) {
            totalPrice = totalPrice - (totalPrice*offer.getPercentOff()) / 100;
            totalPrice = totalPrice - offer.getDollarsOff();
            totalPrice = totalPrice + (totalPrice*10) / 100;
            //totalPrice -= totalPrice*offer
        }
        session.setAttribute("totalPrice", totalPrice);
    }
    
    public void applyOfferCode() {
        res = commonClient.isOfferExists(Response.class, offerCode);
        Boolean offerAvailable = Boolean.valueOf(res.readEntity(String.class));
        if(offerAvailable) {
            res = commonClient.getOfferByCode(Response.class, offerCode);
            offer = res.readEntity(gOffer);
            this.setTotalPrice();
            this.setOfferMessage("");
            this.setOfferButtonText("Offer Applied");
            session.setAttribute("offer", offerCode);
            session.setAttribute("offerid", offer.getOfferID());
        } else {
            offer = null;
            session.setAttribute("offer", "");
            this.setOfferMessage("Invalid Code! Try with some different One.");
        }
    }
    
    public UserDealsBean() {
        userClient = new UserClient();
        commonClient = new CommonClient();
        gUserCart = new GenericType<Collection<Carttb>>(){};
        gOffer = new GenericType<Offertb>(){};
        offer = null;
    }
}
