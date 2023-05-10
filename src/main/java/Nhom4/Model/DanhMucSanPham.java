package Nhom4.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DanhMucSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String ten;
	String moTa;
	
	@OneToMany(mappedBy = "danhMucSanPham",cascade = CascadeType.ALL)
	private Set<SanPham> products;

	public DanhMucSanPham() {
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

	public Set<SanPham> getProducts() {
		return products;
	}

	public void setProducts(Set<SanPham> products) {
		this.products = products;
	}
	
}
