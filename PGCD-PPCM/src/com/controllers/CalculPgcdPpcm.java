package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Pgcd;
import com.models.Ppcm;


/**
 * Servlet implementation class CalculPgcdPpcm
 */
@WebServlet("/CalculPgcdPpcm")
public class CalculPgcdPpcm extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("entier1").equals("") || request.getParameter("entier2").equals("")) {
			request.setAttribute("message", "slv entrer 2 numéros non null");
			doGet(request, response);
		} else if (Long.parseLong(request.getParameter("entier1").toString()) < 0
				|| Long.parseLong(request.getParameter("entier2").toString()) < 0) {
			request.setAttribute("message", "slv entrer 2 numéros strictument possitifs");
			doGet(request, response);
		} else {
			Pgcd pgcd = new Pgcd();
            pgcd.setEntier1(Integer.parseInt((String) request.getParameter("entier1")));
            pgcd.setEntier2(Integer.parseInt(request.getParameter("entier2").toString()));
            Ppcm ppcm = new Ppcm();
            ppcm.setEntier1(Integer.parseInt((String) request.getParameter("entier1")));
            ppcm.setEntier2(Integer.parseInt(request.getParameter("entier2").toString()));
            request.setAttribute("pgcd", pgcd);
            request.setAttribute("ppcm", ppcm);
            request.getRequestDispatcher("Resultat.jsp").forward(request, response);
		}
	}

}
