package model;

import java.sql.Date;

public class User {
	private String userId; 
	private String fullname;
	private String email;
	private String pass;
	private String phone;
	private String gender;
	private Date birthday;
	private String address;
	private String role;
	
	public User()
	{
		
	}

	public User(String userId, String fullname, String email, String pass, String phone, String gender, Date birthday,
			String address, String role) {
		
		this.userId = userId;
		this.fullname = fullname;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.role = role;
	}
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullname=" + fullname + ", email=" + email + ", pass=" + pass + ", phone="
				+ phone + ", gender=" + gender + ", birthday=" + birthday + ", address=" + address + ", role=" + role
				+ "]";
	}
	
	
	
}
