# JAVA-PGCD-PPCM
// class PGCD (model)
public class Pgcd {
	private int entier1 ;
	private int entier2 ;
	
	public Pgcd() {
	    this.entier1=0;
	    this.entier2=0;	
	}

	public Pgcd(int entier1, int entier2) {
		super();
		this.entier1 = entier1;
		this.entier2 = entier2;
	}

	public int getEntier1() {
		return entier1;
	}
	
	public void setEntier1(int entier1) {
		this.entier1 = entier1;
	}
	
	public int getEntier2() {
		return entier2;
	}
	
	public void setEntier2(int entier2) {
		this.entier2 = entier2;
	}

	public int calculatePgcd(int a, int b)

	{
		int m = a;
		int n = b;

		while (m != n)

		{

			if (m > n) {

				m = m - n;
			} else {

				n = n - m;

			}
		}
		return m;
	}
	
	

 }
/********************************************************************************************************************/
//class PPCM (model)
public class Ppcm {
	
	private int entier1;
	private int entier2;
	
	
	
	public Ppcm() {
	  this.entier1=0;
	  this.entier2=0;
	}
	
	public Ppcm(int entier1, int entier2) {
		this.entier1 = entier1;
		this.entier2 = entier2;
	}
	
	public int getEntier1() {
		return entier1;
	}
	
	public void setEntier1(int entier1) {
		this.entier1 = entier1;
	}
	
	public int getEntier2() {
		return entier2;
	}
	
	public void setEntier2(int entier2) {
		this.entier2 = entier2;
	}
	
	public int calculatePpcm(int a, int b) {

		int m = a;

		int n = b;

		int prod, reste, res;

		prod = n * m;

		reste = n % m;

		while (reste != 0) {

			n = m;

			m = reste;

			reste = n % m;

		}

		res = prod / m;

		return (res);

	}
/********************************************************************************************************************/
//servlet CalculPgcdPpcm
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
/********************************************************************************************************************/
//Servlet  Resultat


@WebServlet("/Resultat")
public class Resultat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Resultat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

/*************************************************************************************************************************/
//index.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="CalculPgcdPpcm" method="post">  
<h1> Calcul PGCD et PPCM</h1>
<h5>${message}</h5>
entier1 :<input type="text" name="entier1" id="entier1"> <br>
entier2 :<input type="text" name="entier2" id="entier2"><br>  
<input type="submit" value="Calculer"><br/>  
<input type="reset" value="Annuler"><br/>  
</form>
</body>
</html>

/************************************************************************************************************************/
//Resultat.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>PGCD : ${pgcd.calculatePgcd(pgcd.getEntier1(),pgcd.getEntier2())} </h5>
<h5>PPCM : ${ppcm.calculatePpcm(pgcd.getEntier1(),pgcd.getEntier2())} </h5> 
Entrées  : <p>${pgcd.getEntier1()} , ${pgcd.getEntier2()}<p>
</body>
</html>











