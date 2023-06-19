package model;

import java.util.Objects;

public class Shop {
	private String shopId;
	private String shopName;
	private String shopAddress;
	private float shopSale;
	
	public Shop() {
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(shopAddress, shopId, shopName, shopSale);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		return Objects.equals(shopAddress, other.shopAddress) && Objects.equals(shopId, other.shopId)
				&& Objects.equals(shopName, other.shopName)
				&& Float.floatToIntBits(shopSale) == Float.floatToIntBits(other.shopSale);
	}
	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", shopAddress=" + shopAddress + ", shopSale="
				+ shopSale + "]";
	}
	public Shop(String shopId, String shopName, String shopAddress, float shopSale) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopSale = shopSale;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public float getShopSale() {
		return shopSale;
	}
	public void setShopSale(float shopSale) {
		this.shopSale = shopSale;
	}
	
	
}
