package model;

public class Product {
	private String proId;
	private String proName;
	private String proCategory;
	private float proPrice;
	private int proQuantity;
	private String shopId;
	private String image;
	


	public Product(String proId, String proName, String proCategory, float proPrice, int proQuantity, String shopId, String image) {
		this.proId = proId;
		this.proName = proName;
		this.proCategory = proCategory;
		this.proPrice = proPrice;
		this.proQuantity = proQuantity;
		this.shopId = shopId;
		this.image = image;
	}
	
	public Product() {
		
	}
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProCategory() {
		return proCategory;
	}

	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}

	public float getProPrice() {
		return proPrice;
	}

	public void setProPrice(float proPrice) {
		this.proPrice = proPrice;
	}

	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", proCategory=" + proCategory + ", proPrice="
				+ proPrice + ", proQuantity=" + proQuantity + ", shopId=" + shopId + ", image=" + image + "]";
	}

	public int getProQuantity() {
		return proQuantity;
	}

	public void setProQuantity(int proQuantity) {
		this.proQuantity = proQuantity;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	
	
}
