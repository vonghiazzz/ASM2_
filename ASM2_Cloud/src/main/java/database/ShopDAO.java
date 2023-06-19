package database;

import java.util.ArrayList;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Shop;
public class ShopDAO implements DAOInterface<Shop> {

	@Override
	public ArrayList<Shop> selectAll() {
		ArrayList<Shop> ketQua = new ArrayList<Shop>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM shop";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String shopId = rs.getString("shopId");
				String shopName = rs.getString("shopName");
				String shopAddress = rs.getString("shopAddress");
				float shopSale = rs.getFloat("shopSale");
				
				Shop s = new Shop(shopId, shopName, shopAddress, shopSale);
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
	public Shop selectById(Shop t) {
		Shop ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM shop WHERE shopId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getShopId());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String shopId = rs.getString("shopId");
				String shopName = rs.getString("shopName");
				String shopAddress = rs.getString("shopAddress");
				float shopSale = rs.getFloat("shopSale");
				
				ketQua = new Shop(shopId, shopName, shopAddress, shopSale);
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
	public int insert(Shop t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO shop (shopId, shopName, shopAddress, shopSale) "+
					" VALUES (?,?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getShopId());
			st.setString(2, t.getShopName());
			st.setString(3, t.getShopAddress());
			st.setFloat(4, t.getShopSale());
			
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

	@Override
	public int insertAll(ArrayList<Shop> arr) {
		int dem=0;
		for(Shop shop: arr) {
			dem+=this.insert(shop);
		}
		return dem;
	}

	@Override
	public int delete(Shop t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from shop "+
					 " WHERE shopId=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getShopId());
			
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
	public int deleteAll(ArrayList<Shop> arr) {
		int dem = 0;
		for (Shop shop : arr) {
			dem+=this.delete(shop);
		}
		return dem;
	}

	@Override
	public int update(Shop t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE shop "+
					 " SET " +
					 " shopName=?"+
					 ", shopAddress=?"+
					 ", shopSale=?"+
					 " WHERE shopId=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getShopName());
			st.setString(2, t.getShopAddress());
			st.setFloat(3, t.getShopSale());
			st.setString(4, t.getShopId());
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
		ShopDAO sd = new ShopDAO();
//		ArrayList<Shop> kq = sd.selectAll();
//		for (Shop shop : kq) {
//			System.out.println(shop.toString());
//		}
		
		Shop s = sd.selectById(new Shop("ABC1002","","",0));
		System.out.println(s);
		
		System.out.println("++++++++");
//		Shop th_new = new Shop("ABC1010","ATN Toy", "Ha Noi",0);
//		sd.insert(th_new);
		
//		Shop th_new = new Shop("ABC1010","ATN Toy", "Da Nang",0);
//		sd.delete(th_new);
//		sd.insert(th_new);
//		th_new.setShopAddress("Ha Noi");
//		sd.update(th_new);
//		sd.deleteAll();
	}
	 
}
