package database;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Shop;
import model.User;
public class UserDAO implements DAOInterface<User>{
	public ArrayList<User> data = new ArrayList<>();

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM user";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				
				String userId = rs.getString("userId");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String pass = rs.getString("pass");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				Date birthday = rs.getDate("birthday");
				String phone = rs.getString("phone");
				String role = rs.getString("role");
				

				User u = new User(userId, fullname, email, pass, phone,
						gender, birthday, address, role);
				ketQua.add(u);
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
	public User selectById(User t) {
		User ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM user WHERE userId=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUserId());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String userId = rs.getString("userId");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String pass = rs.getString("pass");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				Date birthday = rs.getDate("birthday");
				String phone = rs.getString("phone");
				String role = rs.getString("role");
				
				ketQua = new User(userId, fullname, email, pass, phone,
						gender, birthday, address, role);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	public User selectByEmailAndPassWord(User t) {
		User ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM user WHERE email=? and pass=?";
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(t.getEmail()+"/"+t.getPass());
			st.setString(1, t.getEmail());
			st.setString(2, t.getPass());
			

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String userId = rs.getString("userId");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				String pass = rs.getString("pass");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				Date birthday = rs.getDate("birthday");
				String phone = rs.getString("phone");
				String role = rs.getString("role");
				
			
				ketQua = new User(userId, fullname, email, pass, phone,
						gender,birthday, address,role);
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
	public int insert(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO user (userId, fullname, email, pass, phone, gender, birthday, address, role) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUserId());
			st.setString(2, t.getFullname());
			st.setString(3, t.getEmail());
			st.setString(4, t.getPass());
			st.setString(5, t.getPhone());
			st.setString(6, t.getGender());
			st.setDate(7, t.getBirthday());
			st.setString(8, t.getAddress());
			st.setString(9, t.getRole());
			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("You execute: " + sql);
			System.out.println("Have " + ketQua + "line changed!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<User> arr) {
		int dem = 0;
		for (User user : arr) {
			dem += this.insert(user);
		}
		return dem;
	}

	@Override
	public int delete(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from user " + " WHERE userId=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUserId());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("You execute: " + sql);
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
	public int deleteAll(ArrayList<User> arr) {
		int dem = 0;
		for (User user : arr) {
			dem += this.delete(user);
		}
		return dem;
	}

	@Override
	public int update(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE user " + " SET " + " fullname=?" + ", email=?" + ", pass=?" + ", gender=?"
					+ ", address=?" + ", birthday=?" + ", phone=?" + " WHERE userId=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getFullname());
			st.setString(2, t.getEmail());
			st.setString(3, t.getPass());
			st.setString(4, t.getGender());
			st.setString(5, t.getAddress());
			st.setDate(6, t.getBirthday());
			st.setString(7, t.getPhone());
			st.setString(8, t.getUserId());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("You execute: " + sql);
			System.out.println("Have " + ketQua + " line changed!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public boolean checkLogin(String email) {
		boolean ketQua = false;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM user WHERE email=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				ketQua = true;
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
public static void main(String[] args) {
	UserDAO sd = new UserDAO();
	ArrayList<User> kq = sd.selectAll();
	for (User user : kq) {
		System.out.println(user.toString());
	}
	
	System.out.println("+++++++");
//	sd.selectByEmailAndPassWord("","","nghia@gmail.com","123","","",2003-10-07,"","");
	User s = sd.selectById(new User("U1001","","","","","",null,"",""));
	System.out.println(s);
	
	
}
}
