package database;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Category;
import model.Shop;


public class CategoryDAO implements DAOInterface<Category>{
	@Override
	public ArrayList<Category> selectAll() {
		ArrayList<Category> ketQua = new ArrayList<Category>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM category";
			PreparedStatement st = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String categoryId = rs.getString("categoryId");
				String categoryName = rs.getString("categoryName");
				
				Category s = new Category(categoryId, categoryName);
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
	public Category selectById(Category t) {
		Category ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM category WHERE categoryId = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdCategory());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String categoryId = rs.getString("categoryId");
				String categoryName = rs.getString("categoryName");
				
				ketQua = new Category(categoryId,categoryName );
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
	public int insert(Category t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO category (categoryId,categoryName) "+
					" VALUES (?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdCategory());
			st.setString(2, t.getNameCategory());
			
			
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
	public int insertAll(ArrayList<Category> arr) {
		int dem=0;
		for(Category shop: arr) {
			dem+=this.insert(shop);
		}
		return dem;
	}

	@Override
	public int delete(Category t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from category "+
					 " WHERE categoryId=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getIdCategory());
			
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
	public int deleteAll(ArrayList<Category> arr) {
		int dem = 0;
		for (Category shop : arr) {
			dem+=this.delete(shop);
		}
		return dem;
	}

	@Override
	public int update(Category t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE category "+
					 " SET " +
					 " categoryName=?"+		 
					 " WHERE categoryId=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getNameCategory());
			st.setString(2, t.getIdCategory());
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
		CategoryDAO sd = new CategoryDAO();
		//select all
//		ArrayList<Category> kq = sd.selectAll();
//		for (Category category : kq) {
//			System.out.println(category.toString());
//		}
		
		//select by id
//		Category s = sd.selectById(new Category("CATE1001",""));
//		System.out.println(s);
		
		System.out.println("++++++++");
		
//		insert
		Category th_new = new Category("CATE1004","ATN Toy");
//		sd.insert(th_new);
//		
		
		//delete
//		Category th_new = (new Category("CATE1004","")); 
//		sd.delete(th_new);
		
		
		//delete all
//		sd.deleteAll();
		
		//update
//		th_new.setNameCategory("Da Nang");
//		sd.update(th_new);

	}
}
