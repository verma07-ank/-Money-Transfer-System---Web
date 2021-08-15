package com.example.web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.example.entity.Txn;
import com.example.repository.TransactionRepository;
import com.example.repository.TransactionRepositoryImpl;



@WebServlet(urlPatterns= {"/history"})
public class HistoryServlet extends HttpServlet {

	TransactionRepository transactionRepository = new TransactionRepositoryImpl();
		
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Txn> txns = transactionRepository.getTransactions();
		req.setAttribute("txns", txns);
		req.getRequestDispatcher("history.html").forward(req, resp);
	}
}
