package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.UserDAO;
import model.User;
import util.encode;

import java.io.IOException;
import java.sql.Date;




/**
 * Servlet implementation class Register
 */
@WebServlet(name = "Register", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String role = "customer";
		
		request.setAttribute("fullname", fullname);		
		request.setAttribute("email", email);
		request.setAttribute("phone", phone);
		request.setAttribute("phone", pass);
		request.setAttribute("gender", gender);
		request.setAttribute("birthday", birthday);
		request.setAttribute("address", address);
		request.setAttribute("role", role);
		
		String url = "";
		String error = "";
		
		UserDAO khachHangDAO = new UserDAO();

		if(khachHangDAO.checkLogin(email)) {
			error +="Email already exists, please choose another email.<br/>";
		}
		
		if(!pass.equals(repass)) {
			error +="Password is not correct.<br/>";
		}
		
		else {
			pass = encode.toSHA1(pass);
		}
		request.setAttribute("error", error);
		
		
		if(error.length()>0) {
			url = "/register.jsp";
		}else {
			String userId = "U"+System.currentTimeMillis();
			User kh = new User(userId, fullname, email, pass,phone, gender,Date.valueOf(birthday) ,address, role);
			khachHangDAO.insert(kh);
			url = "/successful.jsp";
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
public static void main(String[] args) {
	String fullname = ("fullname");
	String email = ("email");
	String pass = ("pass");
	String repass = ("repass");
	String phone = ("phone");
	String gender = ("gender");
	String birthday = "2003-10-02";
	String address = ("address");
	String role = "customer";
	UserDAO khachHangDAO = new UserDAO();
	String userId = "U"+System.currentTimeMillis();
	User kh = new User(userId, fullname, email, pass,phone, gender,Date.valueOf(birthday) ,address, role);
	khachHangDAO.insert(kh);
	
	khachHangDAO.selectAll();
}
}
