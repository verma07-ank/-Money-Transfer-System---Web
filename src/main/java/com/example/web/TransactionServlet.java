package com.example.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;


@WebServlet(urlPatterns = {"/new-transaction"})
public class TransactionServlet extends HttpServlet{
	
	TxrService txrService = new TxrServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fromAccount = req.getParameter("fromAccount");
		String toAccount = req.getParameter("toAccount");
		double amount = Double.parseDouble(req.getParameter("amount"));
		
		txrService.transfer(fromAccount, toAccount, amount);
		
		resp.sendRedirect("transfer.html");
	}
}

