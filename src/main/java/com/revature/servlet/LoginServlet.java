package com.revature.servlet;

import com.revature.model.BankUser;
import com.revature.service.AppService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("login")
public class LoginServlet extends HttpServlet{
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
//		System.out.println("Login Servlet -POST");
//		
//		BankUser clientUser = new BankUser();
//		
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		
//		clientUser.setUsername(username);
//		clientUser.setPassword(password);
//		
//		//validate the credentials of the client user, returns null if credentials don't mach
//		clientUser = new AppService().validateUser(clientUser);
//		
//		if(clientUser!=null){
//			HttpSession Session = req.getSession();
//			session.setAttribute("user", clientUser);
//			req.getRequestDispatcher("app.html").forward(req, resp);
//		}else{
//			resp.sendRedirect("login.html");
//		}
//		
//	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("Login Servlet -POST");
	
	BankUser clientUser = new BankUser();
	
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	
	clientUser.setUsername(username);
	clientUser.setPassword(password);
	
	//validate the credentials of the client user, returns null if credentials don't mach
	clientUser = new AppService().validateUser(clientUser);
	
	if(clientUser!=null){
		HttpSession session = req.getSession();
		session.setAttribute("user", clientUser);
		req.getRequestDispatcher("app.html").forward(req, resp);
	}else{
		resp.sendRedirect("login.html");
	}
}
	
	
}
