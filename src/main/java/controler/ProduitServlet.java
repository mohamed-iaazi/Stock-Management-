package controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProduitDao;
import model.Produit;

@WebServlet("/")
public class ProduitServlet extends HttpServlet {
    private static final long serialVersionUID = 1 ;
    private ProduitDao produitDAO;

    public void init() {
        produitDAO = new ProduitDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.print("act"+action);
        if (action == null || action.equals("")) {
            action = "/"; // Ensures the default action is called
        }

        try {
            switch (action) {
             
                case "/insert":
                    insertProduit(request, response);
                    listProduit(request, response);

                    break;
                case "/delete":
                    break;
                case "/edit":
                	
                    break;
                case "/update":
                    break;
                    
               
           
                default:
                    listProduit(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listProduit(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
       
		List < Produit > listProduit = ProduitDao.selectAllProduits();
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("list", listProduit);
        dispatcher.forward(request, response);

       
    }

  
    private void insertProduit(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int price = Integer.parseInt(request.getParameter("price"));
        String category = request.getParameter("category");
        Produit produit = new Produit(name, description, quantity,price,category);
        ProduitDao.insertProduit(produit);
    }

  
}