/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.CommonClient;
import client.UserClient;
import entity.Usertb;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author bhavik
 */
@Named(value = "userCDIBean")
@RequestScoped
public class UserCDIBean {

    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    ExternalContext externalContext = facesContext.getExternalContext();
    
    UserClient userClient;
    CommonClient commonClient;
    Response res;
    Pbkdf2PasswordHashImpl pbkd;
    
    Boolean isUserAuthenticated=false;
    String UserActionMessage="";
    
    GenericType<Usertb> gUser;
    Usertb loginUser;
    
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public Boolean getIsUserAuthenticated() {
        return isUserAuthenticated;
    }

    public String getUserActionMessage() {
        return UserActionMessage;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
        String returnPage = "/user/Login.jsf";
        Usertb ur = new Usertb();
        ur.setEmail(email);
        ur.setName(username);
        ur.setPassword(password);
        res = commonClient.login(ur, Response.class);
        loginUser = res.readEntity(gUser);
        if(loginUser.getEmail() == null) {
            isUserAuthenticated = false;
            UserActionMessage = "Email / Password are Invalid!";
        } else {
            session.setAttribute("useremail", loginUser.getEmail());
            session.setAttribute("role", loginUser.getUserCategoryID().getName());
            session.setAttribute("userid", loginUser.getUserID());
            session.setAttribute("username", loginUser.getName());
            if(loginUser.getUserCategoryID().getName().equals("Business")) {
                returnPage = "/business/Home.jsf?faces-redirect=true";
            }
            if(loginUser.getUserCategoryID().getName().equals("Admin")) {
                returnPage = "/admin/Home.jsf?faces-redirect=true";
            }
            if(loginUser.getUserCategoryID().getName().equals("User")) {
                returnPage = "/user/Home.jsf?faces-redirect=true";
            }
        }
        return returnPage;
    }
    public String register() {
        Usertb ur = new Usertb();
        ur.setEmail(email);
        ur.setName(username);
        ur.setPassword(password);
        userClient.addUser(ur);
        return "/user/Register.jsf";
    }
    public String goToLogin() {
        String page = "/user/Login.jsf";
        if(this.isUserAuthenticated) {
            page = this.goToHomePage();
        }
        return page;
    }
    public String goToRegister() {
        return "/user/Register.jsf";
    }
    public String logout() {
        session.removeAttribute("useremail");
        session.removeAttribute("role");
        session.removeAttribute("userid");
        session.removeAttribute("username");
        return "/user/Login.jsf?faces-redirec=true";
    }
    public Boolean isUserLoggedIn() {
        return session.getAttribute("role") == null ? false : true;
    }
    public String getLoginUserName() {
        return session.getAttribute("username").toString();
    }
    public String getLoginUserEmail() {
        return session.getAttribute("useremail").toString();
    }
    public int getLoginUserId() {
        return Integer.valueOf(session.getAttribute("userid").toString());
    }
    public String goToHomePage() {
        String homepage = "/user/Home.jsf";
        if(session.getAttribute("role") == "Business") {
            homepage = "/business/Home.jsf";
        } else if(session.getAttribute("role") == "Admin") {
            homepage = "/admin/Home.jsf";
        } else {
            homepage = "/user/Home.jsf";
        }
        return homepage;
    }
    public Usertb getLoginUser() {
        res = commonClient.getLoginUser(Response.class);
        loginUser = res.readEntity(gUser);
        return loginUser;
    }
    public void checkLoginAndRedirect() throws IOException {
        Object h = session.getAttribute("userid");
        if(h==null) {
            externalContext.redirect(externalContext.getRequestContextPath() + "/user/Home.jsf");
        }
    }
    public UserCDIBean() {
        userClient = new UserClient();
        commonClient = new CommonClient();
        pbkd = new Pbkdf2PasswordHashImpl();
        gUser = new GenericType<Usertb>(){};
        UserActionMessage = "";
    }
    
}
