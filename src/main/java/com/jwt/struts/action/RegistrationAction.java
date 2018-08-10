package com.jwt.struts.action;


import java.sql.CallableStatement;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jwt.struts.form.RegistrationForm;

import db.components.*;

public class RegistrationAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		RegistrationForm regForm = (RegistrationForm) form;

		String un= regForm.getUserName();
		String email= regForm.getEmail();
		String pw= regForm.getPassword();

		try {
			
		 
	        Connection c = DbConnection.getConnect();
			
			if  (c!=null)
			{
				CallableStatement cs = c.prepareCall("{call sp_createUser(?,?,?)}") ;
 				cs.setString(1, un);
				cs.setString(2, email);
				cs.setString(3, pw);
				cs.executeQuery();
				return mapping.findForward("success");
			}
			else
				return mapping.findForward("dbfailure");
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mapping.findForward("failure");
		}
		//return mapping.findForward("failure");
	}

}
