package controller;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import database.ProductDAO;
import model.Product;


/**
 * Servlet implementation class InsertProduct
 */
@WebServlet(name = "InsertProduct",urlPatterns="/insertProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId = request.getParameter("proId");
		String proName = request.getParameter("proName");
		String proCategory = request.getParameter("proCategory");
		String proPrice = request.getParameter("proPrice");
		String proQuantity = request.getParameter("proQuantity");
		String shopId = request.getParameter("shopId");
		String image = request.getParameter("image");
		
		float proPrice1=Float.parseFloat(proPrice);
		
		int proQuantity1 = Integer.parseInt(proQuantity);
		
		request.setAttribute("proId", proId);		
		request.setAttribute("proName", proName);
		request.setAttribute("proCategory", proCategory);
		request.setAttribute("proPrice", proPrice1);
		request.setAttribute("proQuantity", proQuantity1);
		request.setAttribute("shopId", shopId);
		request.setAttribute("image", image);
	
		String error = "";
		String url="";
		
		ProductDAO proDAO = new ProductDAO();
		
		Product p = new Product();
		p.setProId(proId);
		p.setShopId(shopId);
		
		Product pro = proDAO.selectByIdAndShopId(p);
		
		
		if(pro!=null) {
			request.setAttribute("error", "Product have exist!");
			url = "/insertProduct.jsp";
		}
		if(error.length()>0) {
			url = "/insertProduct.jsp";
		}else {
			Product product = new Product(proId, proName, proCategory,proPrice1, proQuantity1,shopId ,image);
			proDAO.insert(product);
			request.setAttribute("error", "Successfully!");
			url = "/insertProduct.jsp";
		}
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
