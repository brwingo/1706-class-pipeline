package com.revature.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.BankTx;
import com.revature.model.BankUser;

/**
 * Servlet implementation class AjaxProcessTx
 */

@WebServlet("ajaxProcessTx")
public class AjaxProcessTx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxProcessTx() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//what is the objective???
			//recieve the json object with the tx data and persist it to the db
		System.err.println("AjaxProcessTxServlet -POST");
		
		//Grab all parameters, in this case only 1 JSON String
		Map<String, String[]> myMap = request.getParameterMap();
		
		//get the key set from the map, returns a set
		Set<String> txObject = myMap.keySet();		
		
		//API for converting JSON into a JavaObject
		ObjectMapper jackson = new ObjectMapper();
		
		//convert the key set into an array and get the first element (index 0 )from that set
		Object obj = txObject.toArray()[0];
		
		//convert the JSON String into the class specified in the second argument
		BankTx tx = (BankTx) jackson.readValue(((String)obj), BankTx.class);
		System.out.println(tx);
		
		HttpSession session = request.getSession();
		BankUser user = (BankUser) session.getAttribute("user"); //the var we used when the user logged in
		System.out.println("the users's id is " + user.getId());
		
		/*
		 * use services class to process the transaction
		 */
	}

}
