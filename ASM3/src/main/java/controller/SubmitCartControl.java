package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import model.Account;
import model.Cart;
import model.Order;
import model.Product;
import model.ProductOrders;

/**
 * Servlet implementation class SubmitCartControl
 */
@WebServlet("/SubmitCartControl")
public class SubmitCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitCartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		 Cart cart=(Cart)session.getAttribute("cart");
		 String usrString = request.getParameter("idu");
		 if (usrString.equals("")) {
			 request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		 else {
			 List<Product> listProducts=cart.getCartItems();
				List<ProductOrders> productOrders=new ArrayList<ProductOrders>();
				OrderDAO orderDAO=new OrderDAO();
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis());//lay ngay hien tai trong sql
				Account account=orderDAO.getAccount(usrString);
				int orderId=orderDAO.getLastOrderID()+1;
				for(Product p:listProducts) {
//					for(int i=1;i<=p.getNumber();i++) {
						int priceProduct=(int) p.getPrice();
						productOrders.add(new ProductOrders(orderId, p.getId(), p.getNumber(),priceProduct) );
//					}
				}
//				Order order=new Order(orderId,float(cart.getAmount()), "xac nhan", java.time.LocalDate.now(),
//						account.getAddress(), account.getPhone(), productOrders, usrString, java.time.LocalDate.now(), "freeship");
				Order order=new Order(orderId, Float.parseFloat(""+cart.getAmount()),1, date, 
						account.getAddress(), account.getPhone(), productOrders, usrString, date, "freeShip");
				
				orderDAO.insertOrderDetail(order);
				orderDAO.insertCartDetail(order);
				
				session.removeAttribute("cart");
				response.sendRedirect("ListController");
		}
		
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
