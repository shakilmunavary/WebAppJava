package com.jwt.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class RegistrationForm extends ActionForm {
	 
    private static final long serialVersionUID = 1L;
    private String userName = null;
    private String password = null;
    private String email = null;
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.password = null;
    }
 
}
