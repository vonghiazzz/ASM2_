package model;

public class Category {
	private String idCategory;
	private String nameCategory;
	
	
	public Category(String idCategory, String nameCategory) {
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}
	public Category() {

	}
	public String getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", nameCategory=" + nameCategory + "]";
	}
	
	
	
}
