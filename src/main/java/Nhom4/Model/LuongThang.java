package Nhom4.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LuongThang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	int thang;
	int nam;
	float thuong;
	float tongLuong;
	@OneToMany(mappedBy = "luongThang",cascade = CascadeType.ALL)
	private Set<NgayCong> listNgayCong;
	@ManyToOne
	@JoinColumn(name="nhanVienId")
	private NhanVien nhanVien;
	public LuongThang() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public float getThuong() {
		return thuong;
	}
	public void setThuong(float thuong) {
		this.thuong = thuong;
	}
	public float getTongLuong() {
		return tongLuong;
	}
	public void setTongLuong(float tongLuong) {
		this.tongLuong = tongLuong;
	}
	public Set<NgayCong> getListNgayCong() {
		return listNgayCong;
	}
	public void setListNgayCong(Set<NgayCong> listNgayCong) {
		this.listNgayCong = listNgayCong;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
}
