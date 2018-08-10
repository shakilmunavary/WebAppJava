package com.jwt.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jwt.struts.form.LoginForm;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		LoginForm loginForm = (LoginForm) form;

		//		if (loginForm.getUserName() == null || loginForm.getPassword() == null
		//				|| !loginForm.getUserName().equalsIgnoreCase("Mukesh")
		//				|| !loginForm.getPassword().equals("kumar")) {
		//			return mapping.findForward("failure");
		//		} else
		//			return mapping.findForward("success");


		String un=loginForm.getUserName();
		String pw=loginForm.getPassword();

		// Connect to mysql and verify username password

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root"); // gets a new connection

			PreparedStatement ps = c.prepareStatement("select userName,pass from student where userName=? and pass=?");
			ps.setString(1, un);
			ps.setString(2, pw);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return mapping.findForward("success");
			}
			return mapping.findForward("failure");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapping.findForward("failure");
	}

}
