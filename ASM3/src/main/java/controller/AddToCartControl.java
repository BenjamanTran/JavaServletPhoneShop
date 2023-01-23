package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class AddToCartControl
 */
@WebServlet("/AddToCartControl")
public class AddToCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try {
			HttpSession session=request.getSession(true);
			String idd =request.getParameter("pid");
			String action=request.getParameter("action");
			if (session.getAttribute("cart")==null) {
				session.setAttribute("cart", new Cart());
			}
			Cart c=(Cart) session.getAttribute("cart");
			if (action!=null && action.equalsIgnoreCase("add")) {
				
				int id=Integer.parseInt(idd);
				Product product=new ListProductDAO().getProduct(""+id);
				
				c.add(new Product(product.getId(),product.getName(),product.getDescription(),product.getPrice()
						,product.getSrc(),product.getType(),product.getBrand(),1
						));
				System.out.println(product.toString());
				
				
			}else if (action!=null && action.equalsIgnoreCase("delete")) {
				int id=Integer.parseInt(idd);
				Cart cart=(Cart) session.getAttribute("cart");
				cart.remove(id);
				
				System.out.println("xoa san pham");
			}
			request.setAttribute("cart",c);
			response.sendRedirect("cartDetails.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().print(e);
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
