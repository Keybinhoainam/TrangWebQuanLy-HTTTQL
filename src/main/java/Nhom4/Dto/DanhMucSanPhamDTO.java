package Nhom4.Dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class DanhMucSanPhamDTO {
	Long id;
	String ten;
	String moTa;
	Boolean isEdit=false;
	private Set<SanPhamDTO> products;

	public DanhMucSanPhamDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Set<SanPhamDTO> getProducts() {
		return products;
	}

	public void setProducts(Set<SanPhamDTO> products) {
		this.products = products;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	
}
