package database;


import java.util.ArrayList;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Category;
import model.Product;
import model.Shop;

public class ProductDAO implements DAOInterface<Product>{

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> ketQua = new ArrayList<Product>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String proId = rs.getString("proId");
				String proName = rs.getString("proName");
				String proCategory = rs.getString("proCategory");
				float proPrice = rs.getFloat("proPrice");
				int proQuantity= rs.getInt("proQuantity");
				String shopId = rs.getString("shopId");
				String image = rs.getString("image");
				
//				Shop sh = (new ShopDAO().selectById(new Shop("ABC1001","","",0)));
//				Category c = (new CategoryDAO().selectById(new Category("CATE1001","")));
				
				
				Product s = new Product(proId, proName, proCategory, proPrice, proQuantity, shopId, image);
				ketQua.add(s);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public Product selectById(Product t) {
		Product ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE proId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String proId = rs.getString("proId");
				String proName = rs.getString("proName");
				String proCategory = rs.getString("proCategory");
				float proPrice = rs.getFloat("proPrice");
				int proQuantity= rs.getInt("proQuantity");
				String shopId = rs.getString("shopId");
				String image = rs.getString("image");
				
				ketQua =  new Product(proId, proName, proCategory, proPrice, proQuantity, shopId, image);
				break;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	
	
	public Product selectByIdAndShopId(Product t) {
		Product ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM product WHERE proId = ? and shopId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProId());
			st.setString(2, t.getShopId());
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String proId = rs.getString("proId");
				String proName = rs.getString("proName");
				String proCategory = rs.getString("proCategory");
				float proPrice = rs.getFloat("proPrice");
				int proQuantity= rs.getInt("proQuantity");
				String shopId = rs.getString("shopId");
				String image = rs.getString("image");
				
				ketQua =  new Product(proId, proName, proCategory, proPrice, proQuantity, shopId, image);
				break;
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insert(Product t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO product (proId, proName, proCategory, proPrice, proQuantity, shopId, image) "+
					" VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProId());
			st.setString(2, t.getProName());
			st.setString(3, t.getProCategory());
			st.setFloat(4, t.getProPrice());
			st.setInt(4, t.getProQuantity());
			st.setString(4, t.getShopId());
			st.setString(4, t.getImage());
			
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("You execute: ");
			System.out.println("Have "+ ketQua+" line been changed!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	public int updateImage(Product t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE product " + " SET " + " image=?"  +  " WHERE proId=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getImage());
			st.setString(2, t.getProId());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("You have execute: " + sql);
			System.out.println("Have " + ketQua + " line changed!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
	@Override
	public int insertAll(ArrayList<Product> arr) {
		int dem=0;
		for(Product shop: arr) {
			dem+=this.insert(shop);
		}
		return dem;
	}

	@Override
	public int delete(Product t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from product "+
					 " WHERE proId=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("You execute: "+ sql);
			System.out.println("Have "+ ketQua+" line been changed!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<Product> arr) {
		int dem = 0;
		for (Product product : arr) {
			dem+=this.delete(product);
		}
		return dem;
	}

	@Override
	public int update(Product t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE product "+
					 " SET " +
					 " proName=?"+
					 ", proCategory=?"+
					 ", proPrice=?"+
					 ", proQuantity=?"+
					 ", shopId=?"+
					 ", image=?"+
					 " WHERE proId=?";
		
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getProName());
			st.setString(2, t.getProCategory());
			st.setFloat(3, t.getProPrice());
			st.setInt(4, t.getProQuantity());
			st.setString(5, t.getShopId());
			st.setString(6, t.getImage());
			st.setString(7, t.getProId());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			// Bước 4:
			System.out.println("You execute: "+ sql);
			System.out.println("Have "+ ketQua+" line been changed!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	public static void main(String[] args) {
		ProductDAO sd = new ProductDAO();
//		ArrayList<Shop> kq = sd.selectAll();
//		for (Shop shop : kq) {
//			System.out.println(shop.toString());
//		}
		
//		Shop s = sd.selectById(new Shop("ABC1002","","",0));
//		System.out.println(s);
		
		System.out.println("++++++++");
//		Shop th_new = new Shop("ABC1010","ATN Toy", "Ha Noi",0);
//		sd.insert(th_new);
		
//		Shop th_new = new Shop("ABC1010","ATN Toy", "Ha Noi",0);
//		sd.delete(th_new);
//		sd.insert(th_new);
//		th_new.setShopAddress("Da Nang");
//		sd.update(th_new);
//		sd.deleteAll();
	}
	

}
